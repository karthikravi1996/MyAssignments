package week4day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorCertifications 
{
   public static void main(String[] args) throws InterruptedException 
   {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--diable-notifications");
	ChromeDriver driver = new ChromeDriver();
	
	//To launch the URL
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	//To login the account
	driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Password#123");
	driver.findElement(By.id("Login")).click();
	Thread.sleep(3000);
	
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
	driver.findElement(By.xpath("//a[text()='Resources']")).click();
	Thread.sleep(4000);
	
	//Use and create object for shadow instance of class which from (i.e) javascript to interact element in freeze mode
	//To click on resources and mouse hover on learning on trailhead
    Shadow shade = new Shadow(driver);
    WebElement learn = shade.findElementByXPath("//span[text()='Learning']");
    learn.click();
    Thread.sleep(3000);
   
    WebElement traillearn = shade.findElementByXPath("//span[text()='Learning on Trailhead']");
    Actions click1 = new Actions(driver);
    click1.moveToElement(traillearn).build().perform();
    Thread.sleep(3000);
    
    //click on salesforce certification
    WebElement clicktraillearn = shade.findElementByXPath("//a[text()='Salesforce Certification']");
    shade.scrollTo(clicktraillearn);
    Actions click2 = new Actions(driver);
    click1.click(clicktraillearn).build().perform();
    Thread.sleep(3000);
    
    //to click certification administrator of salesforce
    driver.findElement(By.xpath("//a[text()='Administrator']")).click();
    Thread.sleep(3000);
    
    //To verify landed in administartor page 
    String verify = driver.findElement(By.xpath("(//div[text()='Administrator'])[2]")).getText();
    if(verify.contains("Administrator"))
    	System.out.println("Successfully landed in administrator page");
    else
    	System.out.println("Not landed in administrator page");
    Thread.sleep(3000);
    
    //To find number of certification under administrator salesforce
    List<WebElement> Noofcertification = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
    System.out.println("Total number of certifications under administartor salesforce is : "+Noofcertification.size());
    Thread.sleep(3000);
	System.out.println("======================================");
	System.out.println("The following "+Noofcertification.size()+" names listed below : ");
	System.out.println("======================================");

	for (int i = 1; i <=Noofcertification.size(); i++) 
	{
		String text = driver.findElement(By.xpath("(//div[@class='credentials-card_title']/a)["+i+"]")).getText();
		System.out.println(+i+". "+text);
		Thread.sleep(2000);
	}
	
	driver.quit();
    System.out.println("All test cases passed successfully");

   }
}
