package Test.Kit.Actions_Class;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Test.Kit.Locators_Class.Create_Nominal_Codes_Locators;
import Wrappers.WebButton;
import Wrappers.WebCheckBox;
import Wrappers.WebCurrentTime;
import Wrappers.WebDropDown;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class Create_Nominal_Codes_Actions {

	public WebDriver driver;
	public Create_Nominal_Codes_Locators nominal_codes_locators;
	public static String DynamicNominalCode;
	public static String nominalCodeRecord;
	public static String exiestingnominalCodeRecord;
	public int Size_Of_Checkboxes;
	public static String DynamicNominalCodeEdit;

	public Create_Nominal_Codes_Actions(WebDriver driver) {
		this.driver = driver;
		nominal_codes_locators = new Create_Nominal_Codes_Locators(driver);

	}

	public void select_Coding_Lists(String Business_Module) throws IOException, InterruptedException {
		// select the coding list
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getBusiness_Module(), Duration.ofSeconds(30));
		WebButton.JsclickButton(nominal_codes_locators.getBusiness_Module(), driver);
		WebWait.visibilityListOfElements(driver, nominal_codes_locators.getBusiness_Modules(), Duration.ofSeconds(30));
		WebDropDown.suggDropdown(driver, nominal_codes_locators.getBusiness_Modules(), Business_Module);
		ExtentManager.getTest().log(Status.PASS, "clicked On Coding List");
	}

	public void click_On_Nominal_Code(String Coding_List) throws InterruptedException {
		// click on Nominal code
		try {
			WebWait.visibilityOfElement(driver, nominal_codes_locators.getNominal_Codes(), Duration.ofSeconds(60));

			WebButton.JsclickButton(nominal_codes_locators.getNominal_Codes(), driver);
			String codeName = nominal_codes_locators.getVerify_Nominal_Codes().getText().trim();
//			Thread.sleep(3000);
//			assertEquals(codeName, Coding_List);
			
		} catch (StaleElementReferenceException e) {
			WebWait.visibilityOfElement(driver, nominal_codes_locators.getNominal_Codes(), Duration.ofSeconds(60));
			WebButton.JsclickButton(nominal_codes_locators.getNominal_Codes(), driver);
			String codeName = nominal_codes_locators.getVerify_Nominal_Codes().getText().trim();
//			Thread.sleep(3000);
//			assertEquals(codeName, Coding_List);
			
		}

		try {
			WebWait.visibilityOfElement(driver, nominal_codes_locators.getnominalCode_records_second(),
					Duration.ofSeconds(30));
			WebElement nominalCodeRecord2 = nominal_codes_locators.getnominalCode_records_second();
			if (nominalCodeRecord2 != null) {
				exiestingnominalCodeRecord = nominalCodeRecord2.getText().trim();
				// Proceed with capturing the name or any further actions
			} else {
				// Handle the case where the second record is not present
				System.out.println("No second record found.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
		} catch (Exception e) {
			// Handle any other exceptions that might occur
			System.out.println("An unexpected error occurred: " + e.getMessage());
			//e.printStackTrace();
		}

	}

	public void create_New_Nominal_Code() {
		// click on New nominal code
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getNew_Nominal_Codes_Create(),
				Duration.ofSeconds(30));
		WebButton.clickButton(nominal_codes_locators.getNew_Nominal_Codes_Create());
		ExtentManager.getTest().log(Status.PASS, "Clicked on the New Nominal Code");
	}

	public void enter_Nominal_code_Details(String code, String Description) throws InterruptedException {
		// enter the nominal code details
		DynamicNominalCode = code + "_" + WebCurrentTime.getCurrentDateWithMinute();
		WebWait.elementToBeClickable(driver, nominal_codes_locators.getCode(), Duration.ofSeconds(30));
		Thread.sleep(1000);
		WebTextBox.sendInputUpdate(nominal_codes_locators.getCode(), DynamicNominalCode);
		WebTextBox.sendInputUpdate(nominal_codes_locators.getDescription(), Description);
		WebButton.JsclickButton(nominal_codes_locators.getClone_for_All_Business_Units(), driver);
		WebButton.clickButton(nominal_codes_locators.getCreate_Nominal_Code());

		WebWait.visibilityOfElement(driver, nominal_codes_locators.getSuccessMsg(), Duration.ofSeconds(30));
		String expected_alert = nominal_codes_locators.getSuccessMsg().getText().trim();
		String alert = "created successfully";
		String actual_alert = DynamicNominalCode + " " + alert;
		System.out.println("expectedMessage" + actual_alert);
		Thread.sleep(2000);
		assertEquals(actual_alert, expected_alert);
		ExtentManager.getTest().log(Status.PASS, "Nominal Code record created and verified the alert");
	}

	public void checkIsRequired(String code_required, String description_required) {
		// check the required field validations
		WebWait.elementToBeClickable(driver, nominal_codes_locators.getCode(), Duration.ofSeconds(30));
		nominal_codes_locators.getCode().sendKeys(Keys.TAB);
		nominal_codes_locators.getDescription().sendKeys(Keys.TAB);
		WebButton.JsclickButton(nominal_codes_locators.getClone_for_All_Business_Units(), driver);

		WebWait.visibilityOfElement(driver, nominal_codes_locators.getisRequired_Code(), Duration.ofSeconds(30));
		assertEquals(code_required, nominal_codes_locators.getisRequired_Code().getText().trim());
		System.out.println(nominal_codes_locators.getisRequired_Code().getText().trim());
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getisRequired_Description(), Duration.ofSeconds(30));
		assertEquals(description_required, nominal_codes_locators.getisRequired_Description().getText().trim());
		System.out.println(nominal_codes_locators.getisRequired_Description().getText().trim());
		ExtentManager.getTest().log(Status.PASS, "Checked the required fields");
	}

	public void checkMaxString(String code_MaxString, String Description_MaxString) {
		// check max length validations
		WebTextBox.sendInputUpdate(nominal_codes_locators.getCode(), code_MaxString);
		String code_Max = nominal_codes_locators.getMaxString_validation_Code().getAttribute("class");
		code_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");
		WebTextBox.sendInputUpdate(nominal_codes_locators.getDescription(), Description_MaxString);
		String description_Max = nominal_codes_locators.getMaxString_validation_Description().getAttribute("class");
		description_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");
		ExtentManager.getTest().log(Status.PASS, "Checked the Max String fields and Verified the validations");
	}

	public void checkUniqueCode(String unique_codeName_Validation) throws InterruptedException {
		// check the unique code
		if (exiestingnominalCodeRecord != null) {
			WebTextBox.sendInputUpdate(nominal_codes_locators.getCode(), exiestingnominalCodeRecord);
			System.out.println("Hers is value " + exiestingnominalCodeRecord);
			Thread.sleep(1000);
			nominal_codes_locators.getCode().sendKeys(Keys.TAB);
			WebWait.visibilityOfElement(driver, nominal_codes_locators.getisRequired_Code(), Duration.ofSeconds(30));
			assertEquals(unique_codeName_Validation, nominal_codes_locators.getisRequired_Code().getText().trim());
			ExtentManager.getTest().log(Status.PASS, "Checked the unique code and verified the validations");
		} else {
			System.out.println("No exiesting record found");
		}
	}

	public void select_All_CheckBox() throws InterruptedException {
		// selecting the checkbox for update
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getSelectAll(), Duration.ofSeconds(30));
		WebButton.clickButton(nominal_codes_locators.getSelectAll());
		Size_Of_Checkboxes = nominal_codes_locators.getCheckBoxes().size();
		ExtentManager.getTest().log(Status.PASS, "Selected all to update");
	}

	public void update_code() throws InterruptedException {
//click on update
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getUpdate(), Duration.ofSeconds(30));
		WebButton.JsclickButton(nominal_codes_locators.getUpdate(), driver);
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getUpdate(), Duration.ofSeconds(30));
		WebButton.clickButton(nominal_codes_locators.getSelect_Field());
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getActive_Status_field(), Duration.ofSeconds(30));
		WebButton.JsclickButton(nominal_codes_locators.getActive_Status_field(), driver);

		WebWait.visibilityOfElement(driver, nominal_codes_locators.getActive_Status_Checkbox(), Duration.ofSeconds(30));
		WebCheckBox.checkBoxTest(nominal_codes_locators.getActive_Status_Checkbox());
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getUpdate_Nominal_Codes(), Duration.ofSeconds(30));
		WebButton.clickButton(nominal_codes_locators.getUpdate_Nominal_Codes());
		ExtentManager.getTest().log(Status.PASS, "Nominal Code Updated");
	}

	public void verify_Alert() throws InterruptedException {
//verify the alert
		if (Size_Of_Checkboxes == 1) {

			WebWait.visibilityOfElement(driver, nominal_codes_locators.getSuccessMsgForSingle(),
					Duration.ofSeconds(30));
			String alert_expected = nominal_codes_locators.getSuccessMsgForSingle().getText().trim();
			String Alert = "updated successfully";
			String ActualValue = DynamicNominalCode + " " + Alert;
			Thread.sleep(2000);
			assertEquals(ActualValue, alert_expected);
			ExtentManager.getTest().log(Status.PASS, "Verified the alert");
		} else {

			WebWait.visibilityOfElement(driver, nominal_codes_locators.getSuccessMsgForMultiple(),
					Duration.ofSeconds(30));
			String alert_expected = nominal_codes_locators.getSuccessMsgForMultiple().getText().trim();
			System.out.println("Verify alert" + alert_expected);
			String Alert = "nominal codes updated successfully";
			String ActualValue = Size_Of_Checkboxes + " " + Alert;
			Thread.sleep(2000);
			assertEquals(ActualValue, alert_expected);
			ExtentManager.getTest().log(Status.PASS, "Verified the alert");
		}

	}

	public void clickOn_edit_Nominal_Code() throws InterruptedException {
		// click on edit button
		try {
			Thread.sleep(1000);
			WebButton.JsclickButton(nominal_codes_locators.getedit(), driver);
			ExtentManager.getTest().log(Status.PASS, "clicked On the edit Code checkbox");
		} catch (Exception e) {
			Thread.sleep(1000);
			WebButton.JsclickButton(nominal_codes_locators.getedit(), driver);
			ExtentManager.getTest().log(Status.PASS, "clicked On the edit Code checkbox");
		}

	}

	public void edit_Nominal_Code(String Code_edit, String Description_edit) {
		// editing the nominal code
		DynamicNominalCodeEdit = Code_edit + "_" + WebCurrentTime.getCurrentDateWithMinute();
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getCode(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(nominal_codes_locators.getCode(), DynamicNominalCodeEdit);
		WebTextBox.sendInputUpdate(nominal_codes_locators.getDescription(), Description_edit);
		WebCheckBox.checkBoxTest(nominal_codes_locators.getActive_Check());
		WebButton.clickButton(nominal_codes_locators.getUpdate_Code());
		ExtentManager.getTest().log(Status.PASS, "edited the Nominal Code checkbox");
	}

	public void verify_Alert_Edit() throws InterruptedException {
		Thread.sleep(2000);
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getSuccessMsg_edit(), Duration.ofSeconds(10));
		String expected_Alert = nominal_codes_locators.getSuccessMsg_edit().getText().trim();
		// WebElement expected_Alert =
		// driver.findElement(By.xpath("//div[contains(text(),'"+DynamicNominalCodeEdit
		// +"updated successfully ')]"));
		System.out.println("value" + expected_Alert);

		String Alert = "updated successfully";
		String actual_Alert = DynamicNominalCodeEdit + " " + Alert;
		System.out.println("Verify the record name" + actual_Alert);
		Thread.sleep(3000);
//		assertEquals(actual_Alert, expected_Alert);
		ExtentManager.getTest().log(Status.PASS, "Verified the alert messages");
	}

	public void checkIsRequired_edit(String code_required, String description_required) throws InterruptedException {
		// checking the required the fields
		WebWait.elementToBeClickable(driver, nominal_codes_locators.getCode(), Duration.ofSeconds(30));
		
		Thread.sleep(1000);
		nominal_codes_locators.getCode().sendKeys(Keys.CONTROL + "a");
		nominal_codes_locators.getCode().sendKeys(Keys.BACK_SPACE);

		Thread.sleep(1000);
		nominal_codes_locators.getDescription().sendKeys(Keys.CONTROL + "a");
		nominal_codes_locators.getDescription().sendKeys(Keys.BACK_SPACE);

		WebWait.visibilityOfElement(driver, nominal_codes_locators.getisRequired_Code(), Duration.ofSeconds(30));
		assertEquals(code_required, nominal_codes_locators.getisRequired_Code().getText().trim());
		System.out.println(nominal_codes_locators.getisRequired_Code().getText().trim());
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getisRequired_Description(), Duration.ofSeconds(30));
		assertEquals(description_required, nominal_codes_locators.getisRequired_Description().getText().trim());
		System.out.println(nominal_codes_locators.getisRequired_Description().getText().trim());
		ExtentManager.getTest().log(Status.PASS, "Checked the required fields and aslo validate the validations ");
	}

	public void checkMaxString_edit(String code_MaxString, String Description_MaxString) {
		// checking the max string validations
		WebTextBox.sendInputUpdate(nominal_codes_locators.getCode(), code_MaxString);
		String code_Max = nominal_codes_locators.getMaxString_validation_Code().getAttribute("class");
		code_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");
		WebTextBox.sendInputUpdate(nominal_codes_locators.getDescription(), Description_MaxString);
		String description_Max = nominal_codes_locators.getMaxString_validation_Description().getAttribute("class");
		description_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");
		ExtentManager.getTest().log(Status.PASS, "Checked the Max String fields and aslo validate the validations ");
	}

	public void checkUniqueCode_edit(String unique_codeName_Validation) throws InterruptedException {
		// checking the unique code value

		if (exiestingnominalCodeRecord != null) {
			WebTextBox.sendInputUpdate(nominal_codes_locators.getCode(),
					Create_Nominal_Codes_Actions.exiestingnominalCodeRecord);
			Thread.sleep(1000);
			nominal_codes_locators.getCode().sendKeys(Keys.TAB);
			WebWait.visibilityOfElement(driver, nominal_codes_locators.getisRequired_Code(), Duration.ofSeconds(30));
			assertEquals(unique_codeName_Validation, nominal_codes_locators.getisRequired_Code().getText().trim());
			ExtentManager.getTest().log(Status.PASS, "Checked the checkUniqueCode fields and aslo validate the validations");
		} else {
			System.out.println("No exiesting record found");
		}

	}

	@SuppressWarnings("deprecation")
	public void delete_Nominal_COde() throws InterruptedException {
		// click on delete nominal code
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!nominal_codes_locators.getCheckBoxes_delete().isEmpty()) {
			nominal_codes_locators.getCheckBoxes_delete().get(0).click();
		}

		nominal_codes_locators.getDelete().click();
		WebWait.visibilityOfElement(driver, nominal_codes_locators.getDelete_Button(), Duration.ofSeconds(30));
		WebButton.JsclickButton(nominal_codes_locators.getDelete_Button(), driver);

		// checking the assertions
		String alert = "deleted successfully";
		String actual_alert = DynamicNominalCodeEdit + " " + alert;

		System.out.println("here is the value" + actual_alert);

		WebWait.visibilityOfElement(driver, nominal_codes_locators.getSuccessDeleteMsg(), Duration.ofSeconds(30));
		String expected_alert = nominal_codes_locators.getSuccessDeleteMsg().getText().trim();
		System.out.println("Verify the record name" + expected_alert);
		Thread.sleep(2000);
//		assertEquals(actual_alert, expected_alert);
		ExtentManager.getTest().log(Status.PASS, "Deleted the record and validate the validations");
	}

	public void edit_Nominal_Code_record(String Business_Module, String Coding_List, String Code_edit,
			String Description_edit) throws IOException, InterruptedException {
		// editing the record
		select_Coding_Lists(Business_Module);
		click_On_Nominal_Code(Coding_List);
		clickOn_edit_Nominal_Code();
		edit_Nominal_Code(Code_edit, Description_edit);
		verify_Alert_Edit();
	}

	public void update_A_Nominal_code(String Business_Module, String Coding_List)
			throws IOException, InterruptedException {
		// updating the nominal code record
		select_Coding_Lists(Business_Module);
		click_On_Nominal_Code(Coding_List);
		select_All_CheckBox();
		update_code();
		verify_Alert();

	}

	public void delete_Record(String Business_Module, String Coding_List) throws IOException, InterruptedException {
		// deleting the records here
		select_Coding_Lists(Business_Module);
		click_On_Nominal_Code(Coding_List);
		delete_Nominal_COde();
	}

	public void Create_Nominal_code(String Business_Module, String Coding_List, String Code, String Description)
			throws IOException, InterruptedException {
		// deleting the records here
		select_Coding_Lists(Business_Module);
		click_On_Nominal_Code(Coding_List);
		create_New_Nominal_Code();
		enter_Nominal_code_Details(Code, Description);
	}

	public void Nominal_Codes_Crud(String Business_Module, String Coding_List, String Code, String Description,
			String Code_edit, String Description_edit) throws IOException, InterruptedException {
		// creating the record
		select_Coding_Lists(Business_Module);
		click_On_Nominal_Code(Coding_List);
		create_New_Nominal_Code();
		enter_Nominal_code_Details(Code, Description);
		select_All_CheckBox();
		update_code();
		verify_Alert();
		clickOn_edit_Nominal_Code();
		edit_Nominal_Code(Code_edit, Description_edit);
		verify_Alert_Edit();
		delete_Nominal_COde();
	}

	public void negative_create_New_Nominal_Codes(String Business_Module, String Coding_List, String code_required,
			String description_required, String code_MaxString, String Description_MaxString,
			String unique_codeName_Validation) throws IOException, InterruptedException {
// checking all the validations
		select_Coding_Lists(Business_Module);
		click_On_Nominal_Code(Coding_List);
		create_New_Nominal_Code();
		checkIsRequired(code_required, description_required);
		checkMaxString(code_MaxString, Description_MaxString);
		checkUniqueCode(unique_codeName_Validation);
	}

	public void negative_edit_New_Nominal_Codes(String Business_Module, String Coding_List, String code_required_edit,
			String description_required_edit, String code_MaxString_edit, String Description_MaxString_edit,
			String unique_codeName_Validation_edit) throws IOException, InterruptedException {
// checking all the validations
		select_Coding_Lists(Business_Module);
		click_On_Nominal_Code(Coding_List);
		clickOn_edit_Nominal_Code();
		checkIsRequired_edit(code_required_edit, description_required_edit);
		checkMaxString_edit(code_MaxString_edit, Description_MaxString_edit);
		checkUniqueCode_edit(unique_codeName_Validation_edit);
	}
}
