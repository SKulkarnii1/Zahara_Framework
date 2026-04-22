package Test.Kit.Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Tax_Codes_Locators {

	public WebDriver driver;

	public Create_Tax_Codes_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav plus-sign']//a[contains(text(),' Business')]")
	WebElement Business_module;

	public WebElement getBusiness_module() {
		return Business_module;
	}

	@FindBy(xpath = "//ul//li[@class='dropdown dropdown-hover open']//ul[@class='dropdown-menu']//li")
	List<WebElement> Business_modules;

	public List<WebElement> getBusiness_modules() {
		return Business_modules;

	}

	@FindBy(xpath = "//button[@class='btn btn-block nav-btn active ng-star-inserted']//span[@class='nav-text']")
	WebElement tax_codes;

	public WebElement gettax_codes() {
		return tax_codes;
	}

	@FindBy(xpath = "//div//h3[normalize-space()='Tax Codes']")
	WebElement Verify_tax_codes;

	public WebElement getVerifytax_codes() {
		return Verify_tax_codes;
	}

	@FindBy(xpath = "//a[normalize-space()='New tax rate']")
	WebElement New_tax_code;

	public WebElement getNew_tax_code() {
		return New_tax_code;
	}

	@FindBy(xpath = "//div//input[@formcontrolname='code']")
	WebElement Code;

	public WebElement getCode() {
		return Code;
	}

	@FindBy(xpath = "//div//input[@formcontrolname='name']")
	WebElement Tax_code_Name;

	public WebElement getTax_code_Name() {
		return Tax_code_Name;
	}

	@FindBy(xpath = "//div//input[@formcontrolname='taxPercentage']")
	WebElement Tax_code_Percentage;

	public WebElement getTax_code_Percentage() {
		return Tax_code_Percentage;
	}

	@FindBy(xpath = "//div[@class='form-group mb-4 col-12']//span")
	WebElement chkDefault;

	public WebElement getchkDefault() {
		return chkDefault;
	}

	@FindBy(xpath = "//div[@class='form-group col-12']//p-checkbox[@label='Active']//div[@role='checkbox']")
	WebElement chkActive;

	public WebElement getchkActive() {
		return chkActive;
	}

	@FindBy(xpath = "//div[@class='footer']//button")
	WebElement Create_tax_code;

	public WebElement getCreate_tax_code() {
		return Create_tax_code;
	}

	@FindBy(xpath = "//div[@style='opacity: 1;']//div[@role='alertdialog']")
	WebElement Verify_record;

	public WebElement getVerify_record() {
		return Verify_record;
	}

	@FindBy(xpath = "//div[contains(text(),'created successfully')]")
	private WebElement SuccessMsg;

	public WebElement getSuccessMsg() {
		return SuccessMsg;
	}

	@FindBy(xpath = "//input[@formcontrolname='code']/following-sibling::small[@class='form-text text-muted kt-font-danger ng-star-inserted']")
	private WebElement code_Is_Required;

	public WebElement getcode_Is_Required() {
		return code_Is_Required;
	}

	@FindBy(xpath = "//input[@formcontrolname='name']/following-sibling::small[@class='form-text text-muted kt-font-danger ng-star-inserted']")
	private WebElement name_Is_Required;

	public WebElement getname_Is_Required() {
		return name_Is_Required;
	}

	@FindBy(xpath = "//input[@formcontrolname='taxPercentage']/following-sibling::small[@class='form-text text-muted kt-font-danger col-12 ng-star-inserted']")
	private WebElement percentage_Is_Required;

	public WebElement getpercentage_Is_Required() {
		return percentage_Is_Required;
	}

	@FindBy(xpath = "//input[@formcontrolname='code']//parent::div//small[@class='form-text text-muted kt-font-danger text-right ng-star-inserted']")
	private WebElement max_string_validation_code;

	public WebElement getmax_string_validation_code() {
		return max_string_validation_code;
	}

	@FindBy(xpath = "//input[@formcontrolname='name']//parent::div//small[@class='form-text text-muted kt-font-danger text-right ng-star-inserted']")
	private WebElement max_string_validation_name;

	public WebElement getmax_string_validation_name() {
		return max_string_validation_name;
	}

	@FindBy(xpath = "//input[@formcontrolname='taxPercentage']//parent::div//small[@class='form-text text-muted kt-font-danger col-12 ng-star-inserted']")
	private WebElement max_string_validation_percentage;

	public WebElement getmax_string_validation_percentage() {
		return max_string_validation_percentage;
	}

	@FindBy(xpath = "//mat-table[@role='table']//mat-cell[@class='mat-cell cdk-cell cdk-column-code mat-column-code ng-star-inserted']//span[@class='text-ellipsis kt-padding-r-15 ng-star-inserted']")
	private List<WebElement> listOfTaxCodes;

	public List<WebElement> listOfTaxCodes() {
		return listOfTaxCodes;
	}

	@FindBy(xpath = "(//mat-table[@role='table']//mat-cell[@class='mat-cell cdk-cell cdk-column-code mat-column-code ng-star-inserted']//span[@class='text-ellipsis kt-padding-r-15 ng-star-inserted'])[1]")
	private WebElement TaxCodeRecord;

	public WebElement getTaxCodeRecord() {
		return TaxCodeRecord;
	}

	@FindBy(xpath = "(//mat-table[@role='table']//mat-cell[@class='mat-cell cdk-cell cdk-column-code mat-column-code ng-star-inserted']//span[@class='text-ellipsis kt-padding-r-15 ng-star-inserted'])[2]")
	private WebElement TaxCodeRecord2;

	public WebElement getTaxCodeRecord2() {
		return TaxCodeRecord2;
	}

	@FindBy(xpath = "//input[@formcontrolname='code']/following-sibling::small[@class='form-text text-muted kt-font-danger ng-star-inserted']")
	private WebElement TaxCodeUniqueValidation;

	public WebElement getTaxCodeUniqueValidation() {
		return TaxCodeUniqueValidation;
	}
	

	@FindBy(xpath = "//*[@id=\"mat-checkbox-1\"]/label/span[1]")
	WebElement chkCode;

	public WebElement getchkCode() {
		return chkCode;
	}
	
	@FindBy(xpath = "//div//button[normalize-space()='Update']")
	WebElement btnUpdate;

	public WebElement get_btnUpdate() {
		return btnUpdate;
	}
	
	@FindBy(xpath = "//ng-select[@id='columnName0']//div[@role='combobox']")
	WebElement ddl_Select_field_Active;

	public WebElement getddl_Select_field_Active() {
		return ddl_Select_field_Active;
	}
	
	@FindBy(xpath = "//ng-dropdown-panel[@role='listbox']//div[@role='option']")
	private List<WebElement> ddlList_Select_field;
 
	public List<WebElement> getddlList_Select_field() {
		return ddlList_Select_field;
	}
	
	@FindBy(xpath = "//div[@role='checkbox']")
	WebElement chk_Active_status;

	public WebElement getchk_Active_status() {
		return chk_Active_status;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Add field']")
	WebElement btn_Add_field;

	public WebElement getbtn_Add_field() {
		return btn_Add_field;
	}
	
	@FindBy(xpath = "//ng-select[@id='columnName1']//div[@role='combobox']")
	WebElement ddl_Select_field2;

	public WebElement getddl_Select_field2() {
		return ddl_Select_field2;
	}
	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted' and text()='Percentage']")
	WebElement ddl_Select_field_Percentage;

	public WebElement getddl_Select_field_Percentage() {
		return ddl_Select_field_Percentage;
	}
	
	@FindBy(xpath = "//input[@id='newValue1' and @type='number']")
	WebElement txt_Percentage;

	public WebElement gettxt_Percentage() {
		return txt_Percentage;
	}
	@FindBy(xpath = "//div[@class='footer']//button[@type='submit']")
	WebElement btn_update_tax_code;

	public WebElement getbtn_update_tax_code() {
		return btn_update_tax_code;
	}
	@FindBy(xpath = "//div[@style='opacity: 1;']//div[@role='alertdialog']")
	private WebElement Update_Tax_Alert;
 
	public WebElement getUpdate_Tax_Alert() {
		return Update_Tax_Alert;
	}
	
	@FindBy(xpath = "//mat-table//mat-row//mat-cell//mat-checkbox")
	private List<WebElement> CheckBoxes;
 
	public List<WebElement> getCheckBoxes() {
		return CheckBoxes;
	}
	
	@FindBy(xpath = "//div[contains(text(),'updated successfully ')]")
	private WebElement SuccessMsgForSingle;

	public WebElement getSuccessMsgForSingle() {
		return SuccessMsgForSingle;
	}
	
	@FindBy(xpath = "//div[contains(text(),'tax codes updated successfully ')]")
	private WebElement SuccessMsgForMultiple;

	public WebElement getSuccessMsgForMultiple() {
		return SuccessMsgForMultiple;
	}
	
	@FindBy(xpath = "//mat-row[@data-at='rowId-1']//mat-cell//i[@class='fal fa-edit']")
	WebElement editCode;

	public WebElement geteditCode() {
		return editCode;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Update tax rate']")
	WebElement btn_update_tax_code_edit;

	public WebElement getbtn_update_tax_code_edit() {
		return btn_update_tax_code_edit;
	}

	@FindBy(xpath = "//div[@style='opacity: 1;']//div[@role='alertdialog']")
	private WebElement tax_Verify_alert;
 
	public WebElement getVerify_tax_alert() {
		return tax_Verify_alert;
	}
	
	@FindBy(xpath = "//div[contains(text(),'updated successfully ')]")
	private WebElement SuccessMsg_edit;

	public WebElement getSuccessMsg_edit() {
		return SuccessMsg_edit;
	}
	
	@FindBy(xpath = "//mat-table//mat-row//mat-cell//mat-checkbox")
	private List<WebElement> CheckBoxes_delete;
 
	public List<WebElement> getCheckBoxes_delete() {
		return CheckBoxes_delete;
	}
	
	@FindBy(xpath = "//span[@class='kt-hidden-mobile']")
	private WebElement btn_Tax_CodeDelete;
 
	public WebElement getbtn_Tax_CodeDelete() {
		return btn_Tax_CodeDelete;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Delete tax rate']")
	private WebElement Confirm_Delete_Tax_Code_Delete;
 
	public WebElement getConfirm_Delete_Tax_Code_Delete() {
		return Confirm_Delete_Tax_Code_Delete;
	}
	
	@FindBy(xpath = "//div[@style='opacity: 1;']//div[@role='alertdialog']")
	private WebElement tax_Verify_delete_alert;
 
	public WebElement gettax_Verify_delete_alert() {
		return tax_Verify_delete_alert;
	}
	
	@FindBy(xpath = "	//div[contains(text(),'deleted successfully ')]")
	private WebElement SuccessDeleteMsg;

	public WebElement getSuccessDeleteMsg() {
		return SuccessDeleteMsg;
	}
}
