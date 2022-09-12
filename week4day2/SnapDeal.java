package week4day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal 
{
  public static void main(String[] args) throws InterruptedException, IOException 
  {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.snapdeal.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
	Thread.sleep(3000);
	System.out.println("The title of page is : "+driver.getTitle());
	
	//To Go to mens fashion
	WebElement mensfashion = driver.findElement(By.xpath("(//span[contains(text(),'Men')])[1]"));
	Actions act = new Actions(driver);
	act.moveToElement(mensfashion).build().perform();
	Thread.sleep(3000);
	WebElement sportsshoes = driver.findElement(By.xpath("(//span[contains(text(),'Sports Shoes')])[1]"));
	act.click(sportsshoes).build().perform();
	Thread.sleep(5000);
	
	//Go get count of sports shoes
	String text = driver.findElement(By.xpath("//h1[contains(text(),'Sports Shoes for Men')]/following::span[1]")).getText();
	System.out.println("Total count of sports shoes : "+text);
	Thread.sleep(3000);
	
	//To click Training shoes
	driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	Thread.sleep(3000);
	
	//To check price before sort
	List<WebElement> sort = driver.findElements(By.xpath("//div[@id='products']//span[@class='lfloat product-price']"));
	List<Integer> lst = new ArrayList<Integer>();
     for (WebElement val : sort) 
     {
	   lst.add(Integer.valueOf(val.getText().replace("Rs. ","").replace(",", "")));
     }
   System.out.println("Before sorting : "+ lst);
	
	//To click sort Low to High
	driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
	Thread.sleep(5000);
	
	//Check items sorted are displayed correctly
	List<WebElement> sort1 = driver.findElements(By.xpath("//div[@id='products']//span[@class='lfloat product-price']"));
	Thread.sleep(3000);
	List<Integer> lst1 = new ArrayList<Integer>();
     for (WebElement val2 : sort1) 
     {
	   lst1.add(Integer.valueOf(val2.getText().replace("Rs. ","").replace(",", "")));
     }
     System.out.println("After sorting : "+ lst1);
     if(lst!=lst1)
    	 System.out.println("verified price is sorted correctly");
     else
    	 System.out.println("The price is not sorted correctly"); 
     Thread.sleep(2000);
     
     
     //To select filter with color Navy
     driver.findElement(By.xpath("(//div[@class='filter-inner filter-inner-height'])[1]/div[5]")).click();
     Thread.sleep(3000);
     
     //To select price range (900-1200)
     WebElement firstrange = driver.findElement(By.xpath("//input[@name='fromVal']"));
     firstrange.clear();
     firstrange.sendKeys("400");
     Thread.sleep(3000);
     WebElement secondrange = driver.findElement(By.xpath("//input[@name='toVal']"));
     secondrange.clear();
     secondrange.sendKeys("1200");
     Thread.sleep(3000);
     driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
     Thread.sleep(3000);    
     
     //To find number of filters applied 
     List<WebElement> filter = driver.findElements(By.xpath("(//div[@class='filters'])[1]//a[1]"));
     System.out.print("The number of filters applied : "+filter.size());
     System.out.println();
     Thread.sleep(3000);
      System.out.println("The applied filters are : ");
     for (int i = 1; i <=filter.size(); i++) 
     {
		String text2 = driver.findElement(By.xpath("((//div[@class='filters'])[1]//a[1])["+i+"]")).getText();
		System.out.print(text2 + ", ");
	 }
     System.out.println();
     
     //To mouseover and clickQuickView Button
     WebElement mouseover = driver.findElement(By.xpath("(//picture[@class='picture-elem'])[1]"));
     Actions actt = new Actions(driver);
     actt.moveToElement(mouseover).build().perform();
     Thread.sleep(2000);
     driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
     Thread.sleep(4000);
     
     //To print the cost and discount of percentage
     String cost = driver.findElement(By.xpath("//div[@class='lfloat']/div[2]/span[1]")).getText();
     System.out.println("The cost of product is : "+cost);
     Thread.sleep(2000);


     String discount = driver.findElement(By.xpath("//div[@class='lfloat']/div[2]/span[2]")).getText();
     System.out.println("The cost of product is : "+discount);
     
     //To take screenshot
     File source = driver.getScreenshotAs(OutputType.FILE);
     File target = new File("./snaps/snapdeals.png");
     FileUtils.copyFile(source, target);
     Thread.sleep(3000);
     
     //To close current window
     driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
     
     //To close main window
     driver.close();
     
     
     
     
   
  }
}