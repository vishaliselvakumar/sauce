package Step;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDef<webDriverWait> {
	
	public WebDriver driver;
	Properties prop = new Properties();
	File file = new File("C:\\Users\\VISHALI\\eclipse-workspace(sauce)\\sauce\\src\\test\\java\\Properties\\sauce.properties");
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() 
	{
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VISHALI\\eclipse-workspace(sauce)\\sauce\\Mydriver\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() throws IOException 
	{
		
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		driver.findElement(By.id("user-name")).sendKeys(prop. getProperty("user-name"));
		driver.findElement(By.id("password")).sendKeys(prop. getProperty("password"));
		
	}
	

	@And("Click login button")
	public void click_login_button() 
	{
		
		driver.findElement(By.id("login-button")).click();
		
	}
	

	@Then("User is logged in and navigated to product page")
	public void user_is_logged_in_and_navigated_to_product_page() 
	{
		
	    driver.findElement(By.cssSelector("span[class=\"title\"]")).getText();
	    
	}
	
	
	@Given("user is adding multiple product to cart and click on cart button")
	public void user_is_adding_multiple_product_to_cart_and_click_on_cart_button() 
	{
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.xpath("(//button[@class=\"btn btn_primary btn_small btn_inventory \"])[4]")).click();
		driver.findElement(By.xpath("//a[@data-test=\"shopping-cart-link\"]")).click();
		driver.findElement(By.id("continue-shopping")).click();
		driver.findElement(By.tagName("add-to-cart-sauce-labs-bike-light")).click();
		
	}
	

	@When("user click on checkout button")
	public void user_click_on_checkout_button() 
	{
		
		driver.findElement(By.xpath("//button[@name=\"checkout\"]")).click();
		
	}
	

	@When("user is on checkout page and enter valid firstname, lastname and zipcode")
	public void user_is_on_checkout_page_and_enter_valid_firstname_lastname_and_zipcode() throws IOException 
	{
		
		System.out.println(driver.findElement(By.xpath("//span[@class=\"title\"]")).getText());
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		
		driver.findElement(By.id("first-name")).sendKeys(prop. getProperty("first-name"));
		driver.findElement(By.id("last-name")).sendKeys(prop. getProperty("last-name"));
		driver.findElement(By.name("postalCode")).sendKeys(prop. getProperty("postal-code"));
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
		
	}

	@Then("user is on payment option page and click on finish button")
	public void user_is_on_payment_option_page_and_click_on_finish_button() 
	{
		
		System.out.println(driver.findElement(By.cssSelector("span[class=\"title\"]")).getText());
		driver.findElement(By.id("finish")).click();
		driver.findElement(By.xpath("//h2[@class=\"complete-header\"]")).getText();
		
	}

	}
