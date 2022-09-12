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

public class ArchitectCertifications 
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
	    
	    //Click role as salesforce architect
	    driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
	    Thread.sleep(3000);
	    
	    System.out.println("Summary of salesforce architect : ");
	    System.out.println("------------------------------------------");
	    //To get the summary of selected role
	    String text = driver.findElement(By.xpath("//h1[text()='Salesforce Architect']/following::div[1]")).getText();
	    System.out.println(text);
	    System.out.println("------------------------------------------");
	    Thread.sleep(3000);
        
	    //To get list of salesforce architect certifications available  
	    List<WebElement> siz = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
	    System.out.println("The available certifications under architect salesforce : "+siz.size());
	    Thread.sleep(3000);  
	    for (int i = 1; i<= siz.size(); i++) 
	    {
	    	String list = driver.findElement(By.xpath("(//div[@class='credentials-card_title']/a)["+i+"]")).getText();
	    	System.out.println(+i+". "+list);
	    	Thread.sleep(2000);
		}
	    Thread.sleep(2000);
	    
	    //To click on application architect
	    driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
	    Thread.sleep(3000);
	    
	    //verify page
	    System.out.println("=============================");
	    String title = driver.findElement(By.xpath("(//div[text()='Application Architect'])[2]")).getText();
	    if(title.contains("Architect"))
	        System.out.println("Successfully landed in Appliaction architect page");
	    else
	    	System.out.println("Not landed  in Appliaction architect page ");
	    Thread.sleep(3000);
	    
	    System.out.println("=============================");
	    List<WebElement> siz1 = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
	    System.out.println("Certifications under Application Architect is :"+siz.size());
	    Thread.sleep(3000);  
	    for (int i = 1; i<= siz.size(); i++) 
	    {
	    	String list = driver.findElement(By.xpath("(//div[@class='credentials-card_title']/a)["+i+"]")).getText();
	    	System.out.println(+i+". "+list);
	    	Thread.sleep(2000);
		}
	    driver.quit();   
	    System.out.println("All test cases passed successfully");
  }
}
