package week4day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Customer_Service_Options 
{
   public static void main(String[] args) throws InterruptedException 
   {
	   WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//To launch the URL
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//To login the account
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		
		
		//To click on learn more of mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Thread.sleep(3000);
		
		//To switch window 
		String window0 = driver.getWindowHandle();
		List<String> allwin = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allwin.get(1));
		Thread.sleep(3000);
				
		//To click confirm on confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(3000);
		
		
		//To click products and mousehover on service
		 Shadow shade = new Shadow(driver);
		 WebElement learn = shade.findElementByXPath("//span[text()='Products']");
		 learn.click();
		 Thread.sleep(3000);
		
	   //To mouse hover on service 
		 WebElement service = shade.findElementByXPath("//span[text()='Service']");
		 Actions act = new Actions(driver);
		 act.moveToElement(service).build().perform();
		 Thread.sleep(3000);		
		 
	  //To click on customer service
	  WebElement customerservice = shade.findElementByXPath("//a[text()='Customer Service']");
	  Actions act1 = new Actions(driver);
	  act1.click(customerservice).build().perform();
	  Thread.sleep(5000);
	  
	  //To get names of services available and its total counts
	  System.out.println("=========================");
	  List<WebElement> seravailable = driver.findElements(By.xpath("//a[@class='page-list-item ']"));
	  System.out.println("No of customer services available is : "+seravailable.size());
	  System.out.println("=========================");
	  Thread.sleep(2000);
	  for (int i = 1; i <=seravailable.size(); i++) 
	  {
		String text = driver.findElement(By.xpath("(//a[@class='page-list-item '])["+i+"]")).getText();
		System.out.println(+i+". "+ text);
        Thread.sleep(2000);
	  }
	  Thread.sleep(2000);
	  System.out.println("=========================");
	  System.out.println("The title name of page is : "+driver.getTitle());	
	  driver.quit();
	  System.out.println("All test cases passed successfully");
   }
}
