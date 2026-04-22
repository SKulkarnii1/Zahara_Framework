package initializer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import Wrappers.BrowserFactory2;
import Wrappers.ExtractHTMLTable;
import Wrappers.WebCommonPath;
import dataSources.PropertiesReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseClass2 {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static ThreadLocal<String> username = new ThreadLocal<>();
    public static ExtentReports report;
    protected static String environment;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {
        environment = context.getSuite().getParameter("env");
        if (environment == null) {
            environment = "QA";
        }
        System.out.println("Environment set in beforeSuite: " + environment);

        List<ViewName> viewOrder = Arrays.asList(ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY,
                ViewName.EXCEPTION, ViewName.AUTHOR, ViewName.DEVICE);

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(WebCommonPath.extentReportPath);
        sparkReporter.viewConfigurer().viewOrder().as(viewOrder).apply();
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Test Report");

        report = new ExtentReports();
        report.attachReporter(sparkReporter);
        report.setSystemInfo("User Name", "Atharva P");
        report.setSystemInfo("Environment", environment);

        // Add a shutdown hook to flush the report in case of an unexpected shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (report != null) {
                report.flush();
            }
        }));
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeEachMethod(Method testMethod, ITestContext context) throws IOException {
        String headlessParam = context.getSuite().getParameter("headless");
        boolean isHeadless = headlessParam != null && Boolean.parseBoolean(headlessParam);

        String browser = context.getCurrentXmlTest().getParameter("browser");
        if (browser == null) {
            browser = PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "browser");
        }
        
//        String user = context.getCurrentXmlTest().getParameter("username");
//        if (user.equals("atharva.pachpute@aressindia.net")) {
//            username.set(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "user1"));  // Set the username parameter from the TestNG XML
//        }
//        else{
//        	username.set(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID"));
//        }

        driver.set(BrowserFactory2.setBrowser(browser, isHeadless));

        String urlKey = determineUrlKey(environment);
        getDriver().get(urlKey);
        if(!isHeadless) {
        	getDriver().manage().window().maximize();
        }

        ExtentTest test = report.createTest(testMethod.getName()).assignAuthor(environment).assignDevice("Windows");
        extentTest.set(test);
        ExtentManager.setTest(test);

        String category = (String) context.getAttribute("category");
        if (category != null) {
            assignTestCategory(category);
        }
        ExtentManager.getTest().log(Status.INFO, "Browser Launched with URL: " + getDriver().getCurrentUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachMethod(ITestResult result) {
        WebDriver driverInstance = getDriver();
        ExtentTest logger = ExtentManager.getTest();
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                logger.log(Status.FAIL, "Test Case Failed: " + result.getName());
                logger.log(Status.FAIL, "Test Case Failed: " + result.getThrowable());

                String base64Screenshot = captureScreenshot(driverInstance);
                logger.addScreenCaptureFromBase64String(base64Screenshot, "Screenshot");
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                logger.log(Status.PASS, "Test Case Passed: " + result.getName());

                String base64Screenshot = captureScreenshot(driverInstance);
                logger.addScreenCaptureFromBase64String(base64Screenshot, "Screenshot");
            } else if (result.getStatus() == ITestResult.SKIP) {
                logger.log(Status.SKIP, "Test Case Skipped: " + result.getName());
            }
        } catch (Exception e) {
            logger.log(Status.WARNING, "Exception while capturing screenshot: " + e.getMessage());
        } finally {
            driverInstance.quit();
            driver.remove();
            extentTest.remove();
            // Flush the report after each test method to ensure results are saved
            report.flush();
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (report != null) {
            report.flush();
            ExtractHTMLTable.extractTestResultsTable(ExtractHTMLTable.GetReportPath(), WebCommonPath.HTMLOUTPUT_PATH);
        }
    }
    
//    public static String getUsername() {
//        return username.get();  // This will return the username for the current thread
//    }

    protected void assignTestCategory(String category) {
        ExtentManager.getTest().assignCategory(category);
    }

    private String captureScreenshot(WebDriver driver) {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            ExtentManager.getTest().log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
            return "";
        }
    }

    private String determineUrlKey(String environment) throws IOException {
        switch (environment) {
        case "PreLive":
            return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "PreLive_url");
        case "Maintenance":
            return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Maintenance_url");
        case "Live":
            return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Live_url");
        case "QA":
            return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "QA_url");
//        case "Main":
//            return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Main_url");
//        case "Short":
//            return PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Short_url");
        default:
            throw new IllegalArgumentException("Invalid environment specified: " + environment);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
}
