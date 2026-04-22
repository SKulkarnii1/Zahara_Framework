package Test.Kit.Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Nominal_Codes_Locators {
	public WebDriver driver;

	public Create_Nominal_Codes_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav plus-sign']//a[contains(text(),' Business')]")
	private WebElement Business_Module;

	public WebElement getBusiness_Module() {
		return Business_Module;
	}

	@FindBy(xpath = "//li[@class='dropdown dropdown-hover open']//ul[@class='dropdown-menu']//li")
	private List<WebElement> Business_Modules;

	public List<WebElement> getBusiness_Modules() {
		return Business_Modules;
	}

	@FindBy(xpath = "//div[@class='card card-custom gutter-b left-nav']//ul//span[text()='Nominal Codes ']")
	private WebElement Nominal_Codes;

	public WebElement getNominal_Codes() {
		return Nominal_Codes;
	}

	@FindBy(xpath = "//div[@class='kt-portlet__head-label']//h3[text()='Nominal Codes']")
	private WebElement Verify_Nominal_Codes;

	public WebElement getVerify_Nominal_Codes() {
		return Verify_Nominal_Codes;
	}

	@FindBy(xpath = "//div[@class='kt-portlet__head-label']//a[text()=' New nominal code ']")
	private WebElement New_Nominal_Codes_Create;

	public WebElement getNew_Nominal_Codes_Create() {
		return New_Nominal_Codes_Create;
	}

	@FindBy(xpath = "//div[@class='form-group mb-4']//div[@class='col-12']//input[@formcontrolname='code']")
	private WebElement Code;

	public WebElement getCode() {
		return Code;
	}

	@FindBy(xpath = "//div[@class='form-group mb-4']//div[@class='col-12']//input[@formcontrolname='description']")
	private WebElement Description;

	public WebElement getDescription() {
		return Description;
	}

	@FindBy(xpath = "//label[@for='mat-slide-toggle-1-input']//span//input[@role='switch']")
	private WebElement Clone_for_All_Business_Units;

	public WebElement getClone_for_All_Business_Units() {
		return Clone_for_All_Business_Units;
	}

	@FindBy(xpath = "//div[@class='footer']//button[text()=' Create nominal code ']")
	private WebElement Create_Nominal_Code;

	public WebElement getCreate_Nominal_Code() {
		return Create_Nominal_Code;
	}

	@FindBy(xpath = "//div[@style='opacity: 1;']//div[@role='alertdialog']")
	private WebElement Verify_record;

	public WebElement getVerify_record() {
		return Verify_record;
	}

	@FindBy(xpath = "//div[contains(text(),'created successfully')]")
	private WebElement SuccessMsg;

	public WebElement getSuccessMsg() {
		return SuccessMsg;
	}

	@FindBy(xpath = "//input[@formcontrolname='code']/following-sibling::small")
	private WebElement isRequired_Code;

	public WebElement getisRequired_Code() {
		return isRequired_Code;
	}

	@FindBy(xpath = "//input[@formcontrolname='code']//parent::div//small[@class='form-text text-muted kt-font-danger text-right ng-star-inserted']")
	private WebElement MaxString_validation_Code;

	public WebElement getMaxString_validation_Code() {
		return MaxString_validation_Code;
	}

	@FindBy(xpath = "//input[@formcontrolname='description']/following-sibling::small[@class='form-text text-muted kt-font-danger ng-star-inserted']")
	private WebElement isRequired_Description;

	public WebElement getisRequired_Description() {
		return isRequired_Description;
	}

	@FindBy(xpath = "//input[@formcontrolname='description']//parent::div//small[@class='form-text text-muted kt-font-danger text-right ng-star-inserted']")
	private WebElement MaxString_validation_Description;

	public WebElement getMaxString_validation_Description() {
		return MaxString_validation_Description;
	}

	@FindBy(xpath = "(//mat-cell[@class='mat-cell cdk-cell cdk-column-code mat-column-code ng-star-inserted']//span)[1]")
	private WebElement nominalCode_records;

	public WebElement getnominalCode_records() {
		return nominalCode_records;
	}

	@FindBy(xpath = "(//mat-cell[@class='mat-cell cdk-cell cdk-column-code mat-column-code ng-star-inserted']//span)[2]")
	private WebElement nominalCode_records_second;

	public WebElement getnominalCode_records_second() {
		return nominalCode_records_second;
	}

	@FindBy(xpath = "//mat-table//mat-row//mat-cell//mat-checkbox")
	private List<WebElement> CheckBoxes;

	public List<WebElement> getCheckBoxes() {
		return CheckBoxes;
	}
	
	
	@FindBy(xpath = "//div//mat-table//mat-header-row//mat-header-cell//mat-checkbox")
	private WebElement SelectAll;

	public WebElement getSelectAll() {
		return SelectAll;
	}
	
	@FindBy(xpath = "//div[@class='kt-portlet__head-toolbar']//button[text()=' Update ']")
	private WebElement Update;

	public WebElement getUpdate() {
		return Update;
	}
	
	@FindBy(xpath = "//ng-select[@id='columnName0']//div[@role='combobox']")
	private WebElement Select_Field;

	public WebElement getSelect_Field() {
		return Select_Field;
	}
	
	
	@FindBy(xpath = "//div[@class='ng-dropdown-panel-items scroll-host']//div[@role='option']")
	private WebElement Active_Status_field;

	public WebElement getActive_Status_field() {
		return Active_Status_field;
	}
	
	@FindBy(xpath = "//div[@role='checkbox']")
	private WebElement Active_Status_Checkbox;

	public WebElement getActive_Status_Checkbox() {
		return Active_Status_Checkbox;
	}
	
	@FindBy(xpath = "//div[@class='footer']//button[@type='submit']")
	private WebElement Update_Nominal_Codes;

	public WebElement getUpdate_Nominal_Codes() {
		return Update_Nominal_Codes;
	}
	
	@FindBy(xpath = "//div[@style='opacity: 1;']//div[@role='alertdialog']")
	private WebElement Update_Alert;

	public WebElement getUpdate_Alert() {
		return Update_Alert;
	}
	
	@FindBy(xpath = "//div[contains(text(),'nominal codes updated successfully ')]")
	private WebElement SuccessMsgForMultiple;

	public WebElement getSuccessMsgForMultiple() {
		return SuccessMsgForMultiple;
	}
	
	@FindBy(xpath = "//div[contains(text(),'updated successfully ')]")
	private WebElement SuccessMsgForSingle;

	public WebElement getSuccessMsgForSingle() {
		return SuccessMsgForSingle;
	}
	
	@FindBy(xpath = "//mat-row[@data-at='rowId-1']//mat-cell//i[@class='fal fa-edit']")
	private WebElement edit;

	public WebElement getedit() {
		return edit;
	}
	
	@FindBy(xpath = "//div[@role='checkbox']")
	private WebElement Active_Check;

	public WebElement getActive_Check() {
		return Active_Check;
	}
	
	@FindBy(xpath = "//button[text()=' Update nominal code ']")
	private WebElement Update_Code;

	public WebElement getUpdate_Code() {
		return Update_Code;
	}
	
	@FindBy(xpath = "//div[@style='opacity: 1;']//div[@role='alertdialog']")
	private WebElement Verify_alert;

	public WebElement getVerify_alert() {
		return Verify_alert;
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
	
	@FindBy(xpath = "//button[@class='btn btn-link btn-link-danger kt-margin-r-5']")
	private WebElement Delete;
 
	public WebElement getDelete() {
		return Delete;
	}
	
	@FindBy(xpath = "//div[@class='modal-header bg-danger']//h3")
	private WebElement Verify_Delete;
 
	public WebElement getVerify_Delete() {
		return Verify_Delete;
	}
	

	@FindBy(xpath = "//button[normalize-space()='Delete nominal code']")
	private WebElement Delete_Button;
 
	public WebElement getDelete_Button() {
		return Delete_Button;
	}
	
	@FindBy(xpath = "//div[@style='opacity: 1;']//div[@role='alertdialog']")
	private WebElement Verify_alert_delete;

	public WebElement getVerify_alert_delete() {
		return Verify_alert_delete;
	}

	@FindBy(xpath = "	//div[contains(text(),'deleted successfully ')]")
	private WebElement SuccessDeleteMsg;

	public WebElement getSuccessDeleteMsg() {
		return SuccessDeleteMsg;
	}
}
