package Test.Kit.Actions_Class;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;

import Test.Kit.Locators_Class.Create_test_kit_Locators;
import Wrappers.WebButton;
import Wrappers.WebScrollView;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class Create_test_kit_Actions {

	public WebDriver driver;
	Create_test_kit_Locators create_test_kit_Locators;
	

	public Create_test_kit_Actions(WebDriver driver) {
		this.driver = driver;
		create_test_kit_Locators = new Create_test_kit_Locators(driver);
	}

	public void clickOn_Enable_Later() throws InterruptedException {

		WebWait.elementToBeClickable(driver, create_test_kit_Locators.Enable_Later(), Duration.ofSeconds(30));
		WebButton.JsclickButton(create_test_kit_Locators.Enable_Later(), driver);
		WebButton.clickButton(create_test_kit_Locators.Enable_Later());
	}

	public void clickOn_Barcode_batches() throws InterruptedException {
		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getBarcode_batches(), Duration.ofSeconds(50));
		WebScrollView.scrollToElement(driver, create_test_kit_Locators.getBarcode_batches());
		WebWait.elementToBeClickable(driver, create_test_kit_Locators.getBarcode_batches(), Duration.ofSeconds(50));
		WebButton.clickButton(create_test_kit_Locators.getBarcode_batches());
		ExtentManager.getTest().log(Status.PASS, "clicked On Barcode batch");
	}

	public void clickOn_Create_blood_batch() throws InterruptedException {
		WebWait.elementToBeClickable(driver, create_test_kit_Locators.getCreate_blood_batch(), Duration.ofSeconds(40));
		WebButton.clickButton(create_test_kit_Locators.getCreate_blood_batch());

	}

	public void Select_type() throws InterruptedException {
	    WebElement dropdown = create_test_kit_Locators.getType1();
	    Thread.sleep(1000);
	    Select select = new Select(dropdown);
	    select.selectByVisibleText("blood");  // Select option directly
	    System.out.println("Tpye selcted");
	}

	public void Select_Subtype() {
	    WebElement dropdown = create_test_kit_Locators.getSubtype1();
	    Select select = new Select(dropdown);
	    select.selectByVisibleText("phlebotomy gold");  // Select option directly
	    System.out.println("SubTpye selected");
	}
	
	
	public void Select_Count() throws InterruptedException {
		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getCount(), Duration.ofSeconds(30));
		WebTextBox.sendInput(create_test_kit_Locators.getCount(), "3");
		System.out.println("Count selected");
	}

	public void clickOn_Save() throws InterruptedException {
		WebWait.elementToBeClickable(driver, create_test_kit_Locators.Submit_blood_batch(), Duration.ofSeconds(40));
		WebButton.clickButton(create_test_kit_Locators.Submit_blood_batch());
		System.out.println("Blood batch created");

		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getBarcode01(),Duration.ofSeconds(30));
		String alert_expected = create_test_kit_Locators.getBarcode01().getText().trim();
		System.out.println("Verify Barcode Batch-" + alert_expected);
		String Alert = "Barcodes created";
		String ActualValue = Alert;
		//Thread.sleep(2000);
		assertEquals(ActualValue, alert_expected);
		ExtentManager.getTest().log(Status.PASS, "Verified the Barcode Batch");
		
	}
	
	public void Select_Barcode() throws InterruptedException {
		WebWait.visibilityOfElement(driver, create_test_kit_Locators.getBarcode(), Duration.ofSeconds(30));
		WebButton.clickButton(create_test_kit_Locators.getBarcode());
		System.out.println("Barcode");
	}
	
	

	public void Blood_Batch_Creation() throws InterruptedException {
		clickOn_Enable_Later();
		clickOn_Barcode_batches();
		clickOn_Create_blood_batch();
		Select_type();
		Select_Subtype();
		Select_Count();
		clickOn_Save();
	
	}

	
	public void Test_Kit_Creation() throws InterruptedException {
		clickOn_Enable_Later();
		clickOn_Barcode_batches();
		clickOn_Create_blood_batch();
		Select_type();
		Select_Subtype();
		Select_Count();
		clickOn_Save();
		Select_Barcode();
	}

}	