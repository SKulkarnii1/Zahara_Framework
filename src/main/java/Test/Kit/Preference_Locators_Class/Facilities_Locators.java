package Test.Kit.Preference_Locators_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facilities_Locators {
	
	public WebDriver driver;

	public Facilities_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//span[contains(text(),'Preferences')]")
	private WebElement PrefModule;

	public  WebElement getPrefModule() {
		return PrefModule;
	}
	
	@FindBy(xpath = "//button[@title='Facilities']//span[@class='k-button-icon k-icon ng-star-inserted']")
	private WebElement FacTab;

	public  WebElement getFacilityTab() {
		return FacTab;
	}
	
	@FindBy(xpath = "//a[@title=\"Edit\"]")
	private WebElement FacLists;

	public WebElement getListsOfFacilities() {
		return FacLists;
	}


	public WebElement getEditFacilityBtn(String facName) {
	    return driver.findElement(By.xpath(
	        "//tbody/tr/td/a[contains(normalize-space(),'" + facName + "')]/parent::td/preceding-sibling::td//span//preceding-sibling::button"
	    ));
	}

	 @FindBy(xpath = "//span[contains(text(),'Dashboard Settings')]")
		private WebElement DashboardSettings;

		public WebElement getDashboardSettings() {
			return DashboardSettings;
		}
		
	 @FindBy(xpath = "//div[@class='top-actions']//span[@class='k-button-text'][normalize-space()='Save']")
			private WebElement FacSave;

			public WebElement getFacSave() {
				return FacSave;
			}

}
