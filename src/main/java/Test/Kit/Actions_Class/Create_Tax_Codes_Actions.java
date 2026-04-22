package Test.Kit.Actions_Class;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Test.Kit.Locators_Class.Create_Tax_Codes_Locators;
import Wrappers.WebButton;
import Wrappers.WebCheckBox;
import Wrappers.WebCurrentTime;
import Wrappers.WebDropDown;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class Create_Tax_Codes_Actions {

	public WebDriver driver;
	Create_Tax_Codes_Locators create_Tax_Codes_Locators;
	public static String DynamicTaxCode;
	public static String taxRecord;
	int Size_Of_Checkboxes;
	public static String DynamicTaxCode_edit;
	String exiestingtaxRecord;

	public Create_Tax_Codes_Actions(WebDriver driver) {
		this.driver = driver;
		create_Tax_Codes_Locators = new Create_Tax_Codes_Locators(driver);
	}

	public void clickOn_Business_Settings(String Coding_Lists) throws InterruptedException {

		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getBusiness_module(), Duration.ofSeconds(60));
		WebButton.JsclickButton(create_Tax_Codes_Locators.getBusiness_module(), driver);
		WebWait.ListOfelementsToBeClickable(driver, create_Tax_Codes_Locators.getBusiness_modules(),
				Duration.ofSeconds(30));
		WebDropDown.suggDropdown(driver, create_Tax_Codes_Locators.getBusiness_modules(), Coding_Lists);
		ExtentManager.getTest().log(Status.PASS, "clicked On Coding List");
	}

	public void clickOn_Tax_Codes(String Coding_List_Name) throws InterruptedException {

		try {
			Thread.sleep(100);
			WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.gettax_codes(), Duration.ofSeconds(30));
			Thread.sleep(1000);
			WebButton.clickButton(create_Tax_Codes_Locators.gettax_codes());
			String CodeName = create_Tax_Codes_Locators.getVerifytax_codes().getText().trim();
			assertEquals(CodeName, Coding_List_Name);
//			taxRecord = create_Tax_Codes_Locators.getTaxCodeRecord().getText().trim();
//			taxRecord2 = create_Tax_Codes_Locators.getTaxCodeRecord2().getText().trim();
			ExtentManager.getTest().log(Status.PASS, "clicked On the Tax Code");
		} catch (Exception e) {
			Thread.sleep(100);
			WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.gettax_codes(), Duration.ofSeconds(30));
			Thread.sleep(1000);
			WebButton.clickButton(create_Tax_Codes_Locators.gettax_codes());
			String CodeName = create_Tax_Codes_Locators.getVerifytax_codes().getText().trim();
			assertEquals(CodeName, Coding_List_Name);
//			taxRecord = create_Tax_Codes_Locators.getTaxCodeRecord().getText().trim();
//			taxRecord2 = create_Tax_Codes_Locators.getTaxCodeRecord2().getText().trim();
			ExtentManager.getTest().log(Status.PASS, "clicked On the Tax Code");
		}

		try {
			WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getTaxCodeRecord2(), Duration.ofSeconds(30));
			WebElement nominalCodeRecord2 = create_Tax_Codes_Locators.getTaxCodeRecord2();
			if (nominalCodeRecord2 != null) {
				exiestingtaxRecord = nominalCodeRecord2.getText().trim();
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

	public void clickOn_New_tax_code() {

		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getNew_tax_code(), Duration.ofSeconds(30));
		WebButton.clickButton(create_Tax_Codes_Locators.getNew_tax_code());
		ExtentManager.getTest().log(Status.PASS, "clicked On the New Tax Code");

	}

	public void create_New_Tax_Codes(String TaxCode, String TaxCodeName, String TaxPercentage)
			throws InterruptedException {
		DynamicTaxCode = TaxCode + "_" + WebCurrentTime.getCurrentDateWithMinute();
		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getCode(), Duration.ofSeconds(30));
		Thread.sleep(2000);
		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getCode(), DynamicTaxCode);
		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getTax_code_Name(), TaxCodeName);
		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getTax_code_Percentage(), TaxPercentage);
		ExtentManager.getTest().log(Status.PASS, "Filled the Tax Code Details");
	}

	public void clickOn_checkBox_Default() throws InterruptedException {

		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getchkDefault(), Duration.ofSeconds(30));
		WebButton.JsclickButton(create_Tax_Codes_Locators.getchkDefault(), driver);
		ExtentManager.getTest().log(Status.PASS, "Clicked on the default checkbox");
	}

	public void clickOn_checkBox_Active() throws InterruptedException {
		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getchkActive(), Duration.ofSeconds(20));
		WebCheckBox.checkBox_aria(create_Tax_Codes_Locators.getchkActive());
		ExtentManager.getTest().log(Status.PASS, "Clicked on the active checkbox");
	}

	public void clickOn_create_TaxCode() throws InterruptedException {
		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getCreate_tax_code(), Duration.ofSeconds(20));
		WebButton.clickButton(create_Tax_Codes_Locators.getCreate_tax_code());

		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getSuccessMsg(), Duration.ofSeconds(30));
		String expected_alert = create_Tax_Codes_Locators.getSuccessMsg().getText().trim();
		System.out.println("Verify the record name " + expected_alert);
		String alert = "created successfully";
		String actual_alert = DynamicTaxCode + " " + alert;
		Thread.sleep(2000);
		assertEquals(actual_alert, expected_alert);
		ExtentManager.getTest().log(Status.PASS, "Verified the alert Messages");
	}

	public void checkIsRequired(String code_required, String name_required, String percentage_required) {
		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getCode(), Duration.ofSeconds(30));
		WebButton.JsclickButton(create_Tax_Codes_Locators.getCode(), driver);
		WebButton.JsclickButton(create_Tax_Codes_Locators.getTax_code_Name(), driver);
		WebTextBox.sendInput(create_Tax_Codes_Locators.getTax_code_Percentage(), "1");
		create_Tax_Codes_Locators.getTax_code_Percentage().sendKeys(Keys.BACK_SPACE);
		assertEquals(code_required, create_Tax_Codes_Locators.getcode_Is_Required().getText().trim());
		System.out.println(create_Tax_Codes_Locators.getcode_Is_Required().getText().trim());
		assertEquals(name_required, create_Tax_Codes_Locators.getname_Is_Required().getText().trim());
		System.out.println(create_Tax_Codes_Locators.getname_Is_Required().getText().trim());
		assertEquals(percentage_required, create_Tax_Codes_Locators.getpercentage_Is_Required().getText().trim());
		System.out.println(create_Tax_Codes_Locators.getpercentage_Is_Required().getText().trim());
		ExtentManager.getTest().log(Status.PASS, "Checked the required fields and validate the validations");
	}

	public void checkMaxStringAndMinString(String MaxString_Code, String MaxString_Name, String MaxString_percentage,
			String MaxString_percentage_validation, String MinString_percentage_validation,
			String MinString_percentage) {
		// Changed
		String maxString = MaxString_Code + MaxString_Code + MaxString_Code;
		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getCode(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getCode(), maxString);
		String code_Max = create_Tax_Codes_Locators.getmax_string_validation_code().getAttribute("class");
		code_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");
		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getTax_code_Name(), MaxString_Name);
		String name_Max = create_Tax_Codes_Locators.getmax_string_validation_name().getAttribute("class");
		name_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");
		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getTax_code_Percentage(), MaxString_percentage);
		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getmax_string_validation_percentage(),
				Duration.ofSeconds(30));
		String percentage_max = create_Tax_Codes_Locators.getmax_string_validation_percentage().getText().trim();
		assertEquals(MaxString_percentage_validation, percentage_max);
		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getTax_code_Percentage(), MinString_percentage);
		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getmax_string_validation_percentage(),
				Duration.ofSeconds(30));
		assertEquals(MinString_percentage_validation, percentage_max);
		ExtentManager.getTest().log(Status.PASS, "Checked the Max String fields and validate the validations");
	}

	public void checkUniqueTaxCode(String uniqueValidation) throws InterruptedException {

		if (exiestingtaxRecord != null) {
			WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getCode(), Duration.ofSeconds(30));
			WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getCode(), exiestingtaxRecord);
			WebButton.JsclickButton(create_Tax_Codes_Locators.getTax_code_Name(), driver);
			Thread.sleep(2000);
			WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getTaxCodeUniqueValidation(),
					Duration.ofSeconds(30));
			assertEquals(uniqueValidation, create_Tax_Codes_Locators.getTaxCodeUniqueValidation().getText().trim());
			ExtentManager.getTest().log(Status.PASS, "Checked the unique tax code and validate the validations");
		} else {
			System.out.println("No exiesting record found");
		}
	}

	public void clickOn_Tick_Box() {
		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getchkCode(), Duration.ofSeconds(30));
		Size_Of_Checkboxes = create_Tax_Codes_Locators.getCheckBoxes().size();
		WebButton.clickButton(create_Tax_Codes_Locators.getchkCode());
		ExtentManager.getTest().log(Status.PASS, "Clicked on the edit checkBox");

	}

	public void clickOn_Update() {

		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.get_btnUpdate(), Duration.ofSeconds(30));
		WebButton.clickButton(create_Tax_Codes_Locators.get_btnUpdate());
		ExtentManager.getTest().log(Status.PASS, "Clicked on the update button");
	}

	public void Update_tax_code(String ddlfield_status, String txt_Percentage) throws InterruptedException {

		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getddl_Select_field_Active(),
				Duration.ofSeconds(20));
		WebButton.clickButton(create_Tax_Codes_Locators.getddl_Select_field_Active());
		WebDropDown.suggDropdown(driver, create_Tax_Codes_Locators.getddlList_Select_field(), ddlfield_status);
		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getchk_Active_status(), Duration.ofSeconds(20));
		WebCheckBox.checkBoxTest(create_Tax_Codes_Locators.getchk_Active_status());
		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getbtn_Add_field(), Duration.ofSeconds(20));
		WebButton.clickButton(create_Tax_Codes_Locators.getbtn_Add_field());
		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getddl_Select_field2(), Duration.ofSeconds(20));
		WebButton.clickButton(create_Tax_Codes_Locators.getddl_Select_field2());
		WebButton.clickButton(create_Tax_Codes_Locators.getddl_Select_field_Percentage());

		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.gettxt_Percentage(), Duration.ofSeconds(20));
		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.gettxt_Percentage(), txt_Percentage);
		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getbtn_update_tax_code(), Duration.ofSeconds(20));
		WebButton.clickButton(create_Tax_Codes_Locators.getbtn_update_tax_code());
		ExtentManager.getTest().log(Status.PASS, "Tax Code Updated");
	}

	public void Alert_message_verify() throws InterruptedException {

		if (Size_Of_Checkboxes == 1) {
			WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getSuccessMsgForSingle(),
					Duration.ofSeconds(30));

			String alert_expected = create_Tax_Codes_Locators.getSuccessMsgForSingle().getText().trim();
			System.out.println("Verify updated record " + alert_expected);
			String Alert = "updated successfully";
			String ActualValue = Create_Tax_Codes_Actions.DynamicTaxCode + " " + Alert;
			Thread.sleep(2000);
			assertEquals(ActualValue, alert_expected);
			ExtentManager.getTest().log(Status.PASS, "Verified the alert messages");

		} else {
			WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getSuccessMsgForMultiple(),
					Duration.ofSeconds(30));

			String alert_expected = create_Tax_Codes_Locators.getSuccessMsgForMultiple().getText().trim();
			System.out.println("Verify updated record " + alert_expected);
			String Alert = "tax codes updated successfully";
			String ActualValue = Size_Of_Checkboxes + " " + Alert;
			Thread.sleep(2000);
			assertEquals(ActualValue, alert_expected);
			ExtentManager.getTest().log(Status.PASS, "Verified the alert messages");
		}
	}

	public void edit_tax_code(String Taxcode, String TaxCodeName, String TaxPercentage) throws InterruptedException {

		DynamicTaxCode_edit = Taxcode + "_" + WebCurrentTime.getCurrentDateWithMinute();
		Thread.sleep(1000);
		WebButton.JsclickButton(create_Tax_Codes_Locators.geteditCode(), driver);
		create_New_Tax_Codes(Taxcode, TaxCodeName, TaxPercentage);
		clickOn_checkBox_Active();
		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getbtn_update_tax_code_edit(),
				Duration.ofSeconds(30));
		WebButton.clickButton(create_Tax_Codes_Locators.getbtn_update_tax_code_edit());

		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getSuccessMsg_edit(), Duration.ofSeconds(30));
		Thread.sleep(1000);
		String expected_alert = create_Tax_Codes_Locators.getSuccessMsg_edit().getText().trim();
		System.out.println("Verify the record name " + expected_alert);
		String alert = "updated successfully";
		String actual_alert = DynamicTaxCode_edit + " " + alert;
//		Thread.sleep(2000);
//		assertEquals(actual_alert, expected_alert);
		ExtentManager.getTest().log(Status.PASS, "Edited the Tax Code record");
	}

	public void checkIsRequired_edit(String code_required, String name_required, String percentage_required)
			throws InterruptedException {
		Thread.sleep(1000);
		WebButton.JsclickButton(create_Tax_Codes_Locators.geteditCode(), driver);
		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getCode(), Duration.ofSeconds(30));
		Thread.sleep(1000);
		create_Tax_Codes_Locators.getCode().sendKeys(Keys.CONTROL + "a");
		create_Tax_Codes_Locators.getCode().sendKeys(Keys.BACK_SPACE);

		Thread.sleep(1000);
		create_Tax_Codes_Locators.getTax_code_Name().sendKeys(Keys.CONTROL + "a");
		create_Tax_Codes_Locators.getTax_code_Name().sendKeys(Keys.BACK_SPACE);

		Thread.sleep(1000);
		create_Tax_Codes_Locators.getTax_code_Percentage().sendKeys(Keys.CONTROL + "a");
		create_Tax_Codes_Locators.getTax_code_Percentage().sendKeys(Keys.BACK_SPACE);

		assertEquals(code_required, create_Tax_Codes_Locators.getcode_Is_Required().getText().trim());
		System.out.println(create_Tax_Codes_Locators.getcode_Is_Required().getText().trim());
		assertEquals(name_required, create_Tax_Codes_Locators.getname_Is_Required().getText().trim());
		System.out.println(create_Tax_Codes_Locators.getname_Is_Required().getText().trim());
		assertEquals(percentage_required, create_Tax_Codes_Locators.getpercentage_Is_Required().getText().trim());
		System.out.println(create_Tax_Codes_Locators.getpercentage_Is_Required().getText().trim());
		ExtentManager.getTest().log(Status.PASS, "Checked the required fields and validate the validations");
	}

	public void checkMaxStringAndMinString_edit(String MaxString_Code, String MaxString_Name,
			String MaxString_percentage, String MaxString_percentage_validation, String MinString_percentage_validation,
			String MinString_percentage) {
		// Changed
		String maxString = MaxString_Code + MaxString_Code + MaxString_Code;
		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getCode(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getCode(), maxString);
		String code_Max = create_Tax_Codes_Locators.getmax_string_validation_code().getAttribute("class");
		code_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");

		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getTax_code_Name(), MaxString_Name);
		String name_Max = create_Tax_Codes_Locators.getmax_string_validation_name().getAttribute("class");
		name_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");

		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getTax_code_Percentage(), MaxString_percentage);
		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getmax_string_validation_percentage(),
				Duration.ofSeconds(30));
		String percentage_max = create_Tax_Codes_Locators.getmax_string_validation_percentage().getText().trim();
		assertEquals(MaxString_percentage_validation, percentage_max);
		WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getTax_code_Percentage(), MinString_percentage);
		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getmax_string_validation_percentage(),
				Duration.ofSeconds(30));
		assertEquals(MinString_percentage_validation, percentage_max);
		System.out.println(percentage_max);
		ExtentManager.getTest().log(Status.PASS, "Checked the required fields and validate the validations");
	}

	public void checkUniqueTaxCode_edit(String uniqueValidation) {
		if (exiestingtaxRecord != null) {
			WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getCode(), Duration.ofSeconds(30));
			WebTextBox.sendInputUpdate(create_Tax_Codes_Locators.getCode(), exiestingtaxRecord);
			WebButton.JsclickButton(create_Tax_Codes_Locators.getTax_code_Name(), driver);
			WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getTaxCodeUniqueValidation(),
					Duration.ofSeconds(60));
			assertEquals(uniqueValidation, create_Tax_Codes_Locators.getTaxCodeUniqueValidation().getText().trim());
			ExtentManager.getTest().log(Status.PASS,
					"Checked the checkUniqueTaxCode fields and validate the validations");
		} else {
			System.out.println("No exiesting record found");
		}
	}

	public void clickOn_Checkbox() {
		WebWait.ListOfelementsToBeClickable(driver, create_Tax_Codes_Locators.getCheckBoxes(), Duration.ofSeconds(30));
		if (!create_Tax_Codes_Locators.getCheckBoxes_delete().isEmpty()) {
			create_Tax_Codes_Locators.getCheckBoxes_delete().get(0).click();
		}

	}

	public void clickOn_Delete_Tax_code() throws InterruptedException {

		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getbtn_Tax_CodeDelete(), Duration.ofSeconds(20));
		WebButton.clickButton(create_Tax_Codes_Locators.getbtn_Tax_CodeDelete());
		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getConfirm_Delete_Tax_Code_Delete(),
				Duration.ofSeconds(20));
		WebButton.clickButton(create_Tax_Codes_Locators.getConfirm_Delete_Tax_Code_Delete());
		Thread.sleep(1000);
		WebWait.visibilityOfElement(driver, create_Tax_Codes_Locators.getSuccessDeleteMsg(), Duration.ofSeconds(40));
		String expected_alert = create_Tax_Codes_Locators.getSuccessDeleteMsg().getText().trim();
		System.out.println("Verify the record " + expected_alert);
		String alert = "deleted successfully";
		String actual_alert = DynamicTaxCode_edit + " " + alert;
		Thread.sleep(2000);
		assertEquals(actual_alert, expected_alert);
		ExtentManager.getTest().log(Status.PASS, "click On Delete Tax code");
	}

	public void Tax_code(String Coding_Lists, String Coding_List_Name, String TaxCode, String TaxCodeName,
			String TaxPercentage, String ddlfield_status, String txt_Percentage, String Taxcode_edit,
			String TaxCodeName_edit, String TaxPercentage_edit) throws InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_Tax_Codes(Coding_List_Name);
		clickOn_New_tax_code();
		create_New_Tax_Codes(TaxCode, TaxCodeName, TaxPercentage);
		clickOn_checkBox_Active();
		clickOn_create_TaxCode();
		clickOn_Tick_Box();
		clickOn_Update();
		Update_tax_code(ddlfield_status, txt_Percentage);
		Alert_message_verify();
		edit_tax_code(Taxcode_edit, TaxCodeName_edit, TaxPercentage_edit);
		clickOn_Checkbox();
		clickOn_Delete_Tax_code();

	}

	public void create_TaxCode(String Coding_Lists, String Coding_List_Name, String TaxCode, String TaxCodeName,
			String TaxPercentage) throws InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_Tax_Codes(Coding_List_Name);
		clickOn_New_tax_code();
		create_New_Tax_Codes(TaxCode, TaxCodeName, TaxPercentage);
		clickOn_checkBox_Active();
		clickOn_create_TaxCode();
	}

	public void update_TaxCode(String Coding_Lists, String Coding_List_Name, String ddlfield_status,
			String txt_Percentage) throws InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_Tax_Codes(Coding_List_Name);
		clickOn_Tick_Box();
		clickOn_Update();
		Update_tax_code(ddlfield_status, txt_Percentage);
		Alert_message_verify();

	}

	public void edit_TaxCode(String Coding_Lists, String Coding_List_Name, String Taxcode_edit, String TaxCodeName_edit,
			String TaxPercentage_edit) throws InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_Tax_Codes(Coding_List_Name);
		edit_tax_code(Taxcode_edit, TaxCodeName_edit, TaxPercentage_edit);
	}

	public void delete_TaxCode(String Coding_Lists, String Coding_List_Name) throws InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_Tax_Codes(Coding_List_Name);
		clickOn_Checkbox();
		clickOn_Delete_Tax_code();
	}

	public void Create_Tax_code_negative(String Coding_Lists, String Coding_List_Name, String code_required,
			String name_required, String percentage_required, String MaxString_Code, String MaxString_Name,
			String MaxString_percentage, String MaxString_percentage_validation, String MinString_percentage_validation,
			String MinString_percentage, String uniqueValidation) throws InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_Tax_Codes(Coding_List_Name);
		clickOn_New_tax_code();
		checkIsRequired(code_required, name_required, percentage_required);
		checkMaxStringAndMinString(MaxString_Code, MaxString_Name, MaxString_percentage,
				MaxString_percentage_validation, MinString_percentage_validation, MinString_percentage);
		checkUniqueTaxCode(uniqueValidation);
	}

	public void edit_Tax_code_negative(String Coding_Lists, String Coding_List_Name, String code_required_edit,
			String name_required_edit, String percentage_required_edit, String MaxString_Code_edit,
			String MaxString_Name_edit, String MaxString_percentage_edit, String MaxString_percentage_validation_edit,
			String MinString_percentage_validation_edit, String MinString_percentage_edit, String uniqueValidation_edit)
			throws InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_Tax_Codes(Coding_List_Name);
		checkIsRequired_edit(code_required_edit, name_required_edit, percentage_required_edit);
		checkMaxStringAndMinString_edit(MaxString_Code_edit, MaxString_Name_edit, MaxString_percentage_edit,
				MaxString_percentage_validation_edit, MinString_percentage_validation_edit, MinString_percentage_edit);
		checkUniqueTaxCode_edit(uniqueValidation_edit);
	}
}
