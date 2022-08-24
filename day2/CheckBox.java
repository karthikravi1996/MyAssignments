package week2.day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox 
{
  public static void main(String[] args) throws InterruptedException 
  {
	  WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//h5[text()='Basic Checkbox']//following::div[5]")).click();
		driver.findElement(By.xpath("//h5[text()='Notification']//following::div[5]")).click();
		driver.findElement(By.xpath("//h5[contains(text(),'favorite language')]//following::div[3]")).click();
		driver.findElement(By.xpath("//h5[contains(text(),'Tri State')]//following::div[3]")).click();
		WebElement enable = driver.findElement(By.xpath("//h5[contains(text(),'Toggle')]//following::div[1]"));
		enable.click();
		Thread.sleep(2000);
		boolean b = enable.isEnabled();
		System.out.println("Is toggle switch enabled : "+b);
		WebElement disable = driver.findElement(By.xpath("//h5[contains(text(),'Verify if check box')]//following::div[5]"));
		boolean displayed = disable.isDisplayed();
		if(displayed == true)
		System.out.println("verified the button is disabled");	
		else
			System.out.println("The button is enabled");
		driver.findElement(By.xpath("//h5[text()='Select Multiple']//following::ul[1]")).click();
		Thread.sleep(2000);
		for (int i = 1; i <=5; i++)
		{
			driver.findElement(By.xpath("//ul[@role='group']/li["+i+"]/div[1]")).click();
			Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-close']")).click();
        Thread.sleep(2000);
        System.out.println("===Program ends=====");
		driver.close();
	
  }
}
