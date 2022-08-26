package marathoncoding;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow 
{
  public static void main(String[] args) throws InterruptedException, IOException 
  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//To launch the given Url
		driver.get("https://in.bookmyshow.com/");
		driver.manage().window().maximize();
		driver.manage().deleteCookieNamed("");
		
		//To select city as hyderabad and to get confirm current url
		driver.findElement(By.xpath("//span[text()='Popular Cities']/following::li[4]")).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The current loaded url is "+currentUrl);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='sc-lnhrs7-2 eQezya']/div[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Book tickets'])[1]")).click();
		Thread.sleep(2000);
		
		//To print the name of first theater
		String text = driver.findElement(By.xpath("//ul[@id='venuelist']/li[1]/div[1]//a[1]")).getText();
		System.out.println("The selected theater name is : "+text);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='wzrk-alert wiz-show-animate']/div[3]/button[2]")).click();
		
		//To click on info of first appearing theater
		driver.findElement(By.xpath("//ul[@id='venuelist']/li[1]/div[1]/div[2]//div[1]//div[1]/div[1]/div[1]")).click();
		Thread.sleep(3000);
		
		//To confirm parking facility available
	    String park = driver.findElement(By.xpath("//div[@class='venue-facilities']/div[4]/div[2]")).getText();
	    if(park.contains("Parking Facility"))
	      System.out.println("Parking facility is available in theater");
	    else
	    	System.out.println("parking facility is not there");
	    Thread.sleep(2000);
	    
	    //To close the facility popup
	    driver.findElement(By.xpath("//div[@class='cross-container']")).click();
	    Thread.sleep(2000);
	    
	    //To select first green available
	    driver.findElement(By.xpath("//ul[@id='venuelist']/li[2]/div[2]/div[2]/div[1]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("btnPopupAccept")).click();
	    Thread.sleep(2000);
	    
	    //To select the no of seat = 1
	    driver.findElement(By.xpath("//ul[@id='popQty']/li[1]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("proceed-Qty")).click();
	    Thread.sleep(2000);
	    
	    //To select respected seat in dynamic
	    driver.findElement(By.xpath("//div[@id='layout']/table/tbody/tr[9]//div[18]")).click();
	    Thread.sleep(2000);
	    
	    //To click pay
	    driver.findElement(By.id("btmcntbook")).click();
	    Thread.sleep(9000);
	   
	    //To print the subtotal
	    String subtotal = driver.findElement(By.id("subTT")).getText();
	    System.out.println("The subtotal amount is :"+subtotal);
	    
	    
	    //To get the screenshot using commonIO dependency
	    File source = driver.getScreenshotAs(OutputType.FILE);
	    File target = new File("./snaps/movie_paymentSS.png");
	    FileUtils.copyFile(source, target);
	    
	    System.out.println("..........Program ended successfully..........");
	    
	    
	    
	
	
	
	
		
	  
		
		
		
  }
}
