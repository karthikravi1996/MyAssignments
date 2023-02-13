package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoLoginSteps 
{
	ChromeDriver driver;
	String currentUrl;
   @Given("Chrome browser should be open")
   public void launchBrowser()
   {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
   }
   
   @And("Load the application URL as {string}")
   public void launchURL(String url)
   {
	   driver.get(url);  
   }
   
   @And("Maximize and set the timeouts")
   public void manageWindow()
   {
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	   currentUrl = driver.getCurrentUrl();
   }
      
   @And("Enter the valid username as {string}")
   public void enterUsername(String Username)
   {
	   driver.findElement(By.id("username")).sendKeys(Username);
   }
   
   @And("Enter the valid password as {string}")
   public void enterPassword(String Password)
   {
	   driver.findElement(By.id("password")).sendKeys(Password);
   }
   
   @When("Login Button should be clicked")
   public void loginButton()
   {
	   driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
   }
   
   @Then("Home page verification")
   public void verifyHomePage()
   {
	    if(currentUrl.equals(currentUrl))
	    {
	    	int sizee = driver.findElements(By.xpath("//div[@id='errorDiv']/p")).size();
	    	for (int i = 1; i<=sizee; i++) 
	    	{
				String text = driver.findElement(By.xpath("//div[@id='errorDiv']/p["+i+"]")).getText();
				System.out.println(text);
				System.out.println();
			}
	    }
	    else
	    {
	    	System.out.println("Successfully entered into homepage");
	    }
	    driver.close();
   }
   
   
}
