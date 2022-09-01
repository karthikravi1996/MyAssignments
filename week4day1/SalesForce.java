package week4day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce 
{
  public static void main(String[] args) throws InterruptedException 
  {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	
	//To login username name and password
	driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Password#123");
	driver.findElement(By.id("Login")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	
	//To click on learn more option under mobile publisher,
	driver.findElement(By.xpath("//span[text()='Learn More']")).click();
	
	//To switch on other window
	String window1 = driver.getWindowHandle();
	List<String> allwin = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(allwin.get(1));
	Thread.sleep(4000);
	
	//To click on confirm button in redirecting page

	driver.findElement(By.xpath("//button[text()='Confirm']")).click();
	Thread.sleep(2000);
	System.out.println("The title of the page : "+driver.getTitle());
	Thread.sleep(2000);
	
	//To close the second window
	driver.close();
	
	//To switch back to primary window
	driver.switchTo().window(window1);
	driver.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  }
}
