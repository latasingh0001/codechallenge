package stepsdefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class contactsteps {
	
	//Locale locale = new Locale("en-AU");

	WebDriver driver = null;
	Faker faker = new Faker();
	
	
	@Given("user navigates to google website")
	public void user_navigates_to_google_website() {

		String projectpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectpath + "/src/test/resources/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.navigate().to("https://google.com.au");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@And("user searches for SecurePay")
	public void user_searches_for_SecurePay() {

		//enter text
		driver.findElement(By.name("q")).sendKeys("SecurePay");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//hit enter
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Validate google search was successful
		driver.getPageSource().contains("SecurePay | Trusted Online Payment Gateway Provider in ...");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("search for securepay");	

	}

	@And("navigates to SecurePay website")
	public void navigates_to_SecurePay_website() {

		driver.findElement(By.xpath("//a[contains(@href,\"https://www.securepay.com.au/\")]")).click();

		// Validate google search was successful
		driver.getPageSource().contains("Contact us");

	}

	@When("user clicks on Contact Us link")
	public void user_clicks_on_Contact_Us_link() {
		
		//Clicked on contact us link
		driver.findElement(By.xpath("//*[text()='Contact us']")).click();
		
		
		//add wait
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		
	}

	@Then("contact Us Page is loaded")
	public void contact_Us_Page_is_loaded() {
		
		// Validate successful landed on Contact Us Page
		 driver.getPageSource().contains("Contact our Sales Team");		
		
	}

	@Then("populate Contact Us form with random data")
	public void populate_Contact_Us_form_with_random_data() {
		
		String fakefirstName = faker.name().firstName();
		driver.findElement(By.name("firstName")).sendKeys(fakefirstName);
		
		String fakelastName = faker.name().lastName(); 
		driver.findElement(By.name("lastName")).sendKeys(fakelastName);
		
		String fakephonenumber = faker.phoneNumber().cellPhone();
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(fakephonenumber);
		
		String fakeemail = faker.internet().emailAddress();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(fakeemail);
		
		String fakecompanyname = faker.company().name();
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys(fakecompanyname);
		
		String fakewebsite = faker.internet().url();
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys(fakewebsite);
		
		String fakemessage = faker.lorem().sentence(); 
		driver.findElement(By.name("message")).sendKeys(fakemessage);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Select drpAmount = new Select(driver.findElement(By.name("amount")));
		drpAmount.selectByVisibleText("Less than $100,000");
			
	}
	@And("validate checkbox is present")
	public void validate_checkbox_is_present() {
		
		//validating checkbox is not enabled
		WebElement checkbox = driver.findElement(By.id("existingCustomer"));
		System.out.println("Is checkbox enabled - " + checkbox.isSelected());
		
	}

	@And("submit button is present")
	public void submit_button_is_present() {
		
		WebElement submit = driver.findElement(By.xpath("//*[@id=\"support-form\"]/div/button"));
		System.out.println("The submit button is present on the page - " + submit.isDisplayed());

		driver.close();
	}

}
