package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class locators {
	
	WebDriver driver;

	public static By txtfirstNameContact = By.xpath("//input[@name='firstName']");
												
	public static By txtlocallastNameContact = By.xpath("//*[@id=\"support-form\"]/div/div[2]/div/label/input");
	
	public static By txtlocalemailAddressContact = By.xpath("//*[@id=\"support-form\"]/div/div[3]/div/label/input");
	
	public static By txtlocalphoneNumberContact = By.xpath("//*[@id=\"support-form\"]/div/div[4]/div/label/input");
	
	public static By txtlocalcompanyNameContact = By.xpath("//*[@id=\"support-form\"]/div/div[5]/div/label/input");
	
	public static By txtlocalwebsiteURLContact = By.xpath("//*[@id=\"support-form\"]/div/div[6]/div/label/input");
	
	public static By txtlocalyourMessageContact = By.xpath("//*[@id=\"support-form\"]/div/div[7]/div/label/input");
	
	public static By txtlocalexistingCustomerContact = By.xpath("//*[@id=\\\"support-form\\\"]/div/div[3]/div/label/input");
	
	public static By checkboxexistingCustomerContact = By.xpath("//*[@id=\\\"existingCustomer\\\"]");
	
	public locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterfirstName(String firstname){
	driver.findElement(txtfirstNameContact).sendKeys(firstname);
	}
	
	public void enterlastName(String lastname){
		driver.findElement(txtlocallastNameContact).sendKeys(lastname);
		}
	
	public void enteremailAddress(String email){
		driver.findElement(txtlocalemailAddressContact).sendKeys(email);
		}
	
	public void enterphoneNumber(String fakephonenumber){
		driver.findElement(txtlocalphoneNumberContact).sendKeys(fakephonenumber);
		}
	
	public void entercompanyName(String company){
		driver.findElement(txtlocalcompanyNameContact).sendKeys(company);
		}
	
	public void enterwebsiteURL(String url){
		driver.findElement(txtlocalwebsiteURLContact).sendKeys(url);
		}
	
	public void entermessage(String message){
		driver.findElement(txtlocalyourMessageContact).sendKeys(message);
		}
	
	public void txtexitingCustomer(){
		driver.findElement(txtlocalexistingCustomerContact).isDisplayed();
		}
	
	public void clickexitingCustomer(){
		driver.findElement(checkboxexistingCustomerContact).click();
		}
	
	
	public static By errorfirstName = By.name("firstName");
	public static By errorlastName = By.name("lastName");
	public static By erroremailAddress = By.name("email");
	public static By errorphoneNumber = By.name("phone");
	public static By errorcompanyName = By.name("company");
	public static By errorwebsiteURL = By.name("website");
	public static By erroryourMessage = By.name("message");
	public static By errorexistingCustomer = By.id("existingCustomer");
	public static By errorexistingCustomercheckbox = By.id(null);

}

