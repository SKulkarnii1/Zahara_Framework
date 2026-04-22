package Wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserFactory2 {

    public static WebDriver setBrowser(String browserName, boolean isHeadless) {

        WebDriver driver = null;

        // Execution mode: local or docker
        String runMode = System.getProperty("runMode", "local");

        // ✅ FIXED URL (Selenium Grid 4)
        String gridUrl = System.getProperty("gridUrl", "http://localhost:4444");

        try {
            if (runMode.equalsIgnoreCase("docker")) {

                System.out.println("Running on Docker Grid...");
                System.out.println("Grid URL: " + gridUrl);
                System.out.println("Browser: " + browserName);

                switch (browserName.toLowerCase()) {

                    case "chrome":
                        ChromeOptions chromeOptions = new ChromeOptions();

                        if (isHeadless) {
                            chromeOptions.addArguments("--headless=new");
                        }

                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-dev-shm-usage");

                        driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                        break;

                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();

                        if (isHeadless) {
                            firefoxOptions.addArguments("--headless");
                        }

                        driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                        break;

                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();

                        if (isHeadless) {
                            edgeOptions.addArguments("--headless");
                        }

                        driver = new RemoteWebDriver(new URL(gridUrl), edgeOptions);
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid browser for Docker");
                }

            } else {

                System.out.println("Running in LOCAL mode...");
                System.out.println("Browser: " + browserName);

                switch (browserName.toLowerCase()) {

                    case "chrome":
                        ChromeOptions chromeOptions = new ChromeOptions();

                        if (isHeadless) {
                            chromeOptions.addArguments("--headless");
                            chromeOptions.addArguments("--disable-gpu");
                            chromeOptions.addArguments("--window-size=1920,1080");
                        }

                        driver = new ChromeDriver(chromeOptions);
                        break;

                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();

                        if (isHeadless) {
                            firefoxOptions.addArguments("--headless");
                        }

                        driver = new FirefoxDriver(firefoxOptions);
                        break;

                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();

                        if (isHeadless) {
                            edgeOptions.addArguments("--headless");
                        }

                        driver = new org.openqa.selenium.edge.EdgeDriver(edgeOptions);
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid browser specified");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Driver initialization failed", e);
        }

        return driver;
    }
}