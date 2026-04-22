package Test.Kit.Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_test_kit_Locators {

	public WebDriver driver;

	public Create_test_kit_Locators(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/admin/barcode-batches']")
	WebElement Barcode_batches;

	public WebElement getBarcode_batches() {
		return Barcode_batches;
	}
	@FindBy(xpath = "//button[@type='button'][contains(.,'Create blood batch')]")
	WebElement Create_blood_batch;

	public WebElement getCreate_blood_batch() {
		return Create_blood_batch;
	}
	
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	List<WebElement> Type;

	public List<WebElement> getType() {
		return Type;
	}
	
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	WebElement Type1;

	public WebElement getType1() {
		return Type1;
	}
	
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	List<WebElement>  Subtype;

	public List<WebElement>  getSubtype() {
		return Subtype;
	}
		
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	WebElement  Subtype1;

	public WebElement  getSubtype1() {
		return Subtype1;
	}
		
	
	@FindBy(xpath = "(//input[@type='number'])[1]")
		WebElement Count;

		public WebElement getCount() {
			return Count;
		}
		
		@FindBy(xpath = "(//button[@type='submit'])[1]")
		WebElement Submit_blood_batch;

		public WebElement Submit_blood_batch() {
			return Submit_blood_batch;
		}
		
		@FindBy(xpath = "//button[text()='Enable Later']")
		WebElement enable_later;

		public WebElement Enable_Later() {
			return enable_later;
		
		}
		@FindBy(xpath = "(//h2[contains(.,'Barcodes created')])[2]")
		WebElement Barcode_count01;

		public WebElement getBarcode01() {
			return Barcode_count01;
		}
		
		@FindBy(xpath = "//a[@id='nav-barcode-tab']")
		WebElement Barcode;

		public WebElement getBarcode() {
			return Barcode;
		}
		
		
}
