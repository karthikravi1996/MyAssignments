package week4day2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa 
{
  public static void main(String[] args) throws InterruptedException 
  {
	  WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		String one = driver.getTitle();
		System.out.println("The title of first page is : "+one);
		
		//To mouseover on brands 
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(brands).build().perform();
		Thread.sleep(2000);
		
		//To click search L'Oreal Paris under brands
		driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]")).click();
		Thread.sleep(2000);
		String second = driver.getTitle();
		System.out.println("The title of second page is : "+second);
		
		System.out.println("===============================================");
		//To verify page 
		if(second.contains("L'Oreal Paris"))
			System.out.println("Successfully Entered into Oreal paris page");
		else
			System.out.println("Does not entered into page");
		Thread.sleep(2000);
		System.out.println("===============================================");
		
		//To click the popularity
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		Thread.sleep(2000);
		
		//To click cutomer top rated
		driver.findElement(By.xpath("//span[contains(text(),'top rated')]/following::div[1]")).click();
		Thread.sleep(4000);
		
		//To click category
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		
		//To click hair
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(5000);
	   
		//To click hair care
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(5000);
		
		//To click shampoo
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(2000);
		
		//To click concern
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(2000);
		
		//To click Color protection
		driver.findElement(By.xpath("//span[text()='Color Protection']/following::div[1]")).click();
		Thread.sleep(2000);

		
		//To find the brand selected
		System.out.println("The selected brand is : ");
		List<WebElement> path = driver.findElements(By.xpath("//a[@class='name']"));
		Thread.sleep(3000);
		for (int i = 2; i <=path.size(); i++) 
		{
			String text = driver.findElement(By.xpath("(//a[@class='name'])["+i+"]")).getText();
			System.out.println("--> "+text);
		}
		Thread.sleep(3000);
		
		//To find filter is applied or not
		List<WebElement> filter = driver.findElements(By.xpath("//span[@class='filter-value']"));
		System.out.println("The total number of filters applied : "+filter.size());
		System.out.println("The Names of filter applied : ");
		Thread.sleep(3000);
		for (int i = 1; i <= filter.size(); i++) 
		{
			String text = driver.findElement(By.xpath("(//span[@class='filter-value'])["+i+"]")).getText();
			System.out.println(i+". "+text);
		}
		Thread.sleep(2000);
		System.out.println("===============================================");

		//To verify filter is applied with shampoo
		System.out.println("Filter verification : ");
		String verify = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();
		if(verify.contains("Shampoo"))
			System.out.println("Verified filter is applied with shampoo");
		else
			System.out.println("Shampoo is not selected in filter");
		Thread.sleep(3000);
		
		//To Click on L'Oreal Paris Colour
		driver.findElement(By.xpath("//div[contains(text(),'Oreal Paris Colour Protect Shampoo')]")).click();
		Thread.sleep(3000);
		
		//To switch window
		String onewin = driver.getWindowHandle();
	    List<String> all = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(all.get(1));
	    Thread.sleep(2000);
	    
	    //To print MRP of the product
	    String MRP1 = driver.findElement(By.xpath("(//span[text()='MRP:'])[1]/following-sibling::span")).getText();
	    System.out.println("The MRP price is : "+MRP1);
	    Thread.sleep(2000);
	    
	    //Click to add to bag
	    driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
	    Thread.sleep(2000);
	    
	    //To click go to shopping bag
	    driver.findElement(By.xpath("//span[@class='cart-count']")).click();
	    Thread.sleep(2000);
	    
	    
	    //To print grand total 
	    WebElement Frame = driver.findElement(By.xpath("//iframe[contains(@src,'/mobileCartIframe?')]"));
	    driver.switchTo().frame(Frame);
	    Thread.sleep(7000);
	    
	    String MRP2 = driver.findElement(By.xpath("//div[@class='payment-tbl-data']/div[4]/div[2]")).getText();
	    System.out.println("The first grand total is : "+MRP2);
	    Thread.sleep(3000);
	    
	    //To click on proceed
	     driver.findElement(By.xpath("//span[text()='Proceed']")).click();
	     Thread.sleep(3000);
	     
	     //To click continue as guest
	     driver.findElement(By.xpath("//button[@class='btn full big']")).click();
	     Thread.sleep(3000);
	     
	     //To cross check the price
	     String crosscheck = driver.findElement(By.xpath("(//div[@class='value'])[2]/span[1]")).getText();
	     System.out.println("The second grant total : "+crosscheck);
	     if(MRP2.contains(MRP2))
	    	 System.out.println("The grand amount is same as step 14 -- Amount Matched perfect");
	     else
	    	 System.out.println("Grand Total mismatch error!!!!");
	     Thread.sleep(3000);
	     driver.quit();	
	     System.out.println("All test cases completed successfully");
  }
}
