package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkComponents 
{
  public static void main(String[] args) throws InterruptedException 
  {
	   WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.leafground.com/link.xhtml");
			driver.manage().window().maximize();
			String title1 = driver.getTitle();
			System.out.println("The current page is : "+title1);
			Thread.sleep(2000);
			//To get title of directed page
			driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[1]")).click();
			String title = driver.getTitle();
			System.out.println("The directed page is : "+title);
			driver.navigate().back();
			Thread.sleep(2000);
			String attribute = driver.findElement(By.linkText("Find the URL without clicking me.")).getAttribute("href");
			System.out.println("Got link without clicking :"+attribute);
			Thread.sleep(2000);
			//To find the broken link
			driver.findElement(By.xpath("//a[contains(text(),'Broken?')]")).click();
			Thread.sleep(3000);
			String text = driver.findElement(By.xpath("//h2[contains(text(),'HTTP ERROR 404 ')]")).getText();
			if(text.contains("404"))
				System.out.println("The link is broken");
			else
				System.out.println("The link works fine");
			driver.navigate().back();
			Thread.sleep(2000);
			//To find duplicate link
			String duplicate = driver.findElement(By.linkText("Go to Dashboard")).getAttribute("href");
			if(duplicate.contains("dashboard.xhtml"))
				System.out.println("Page has duplicate link");
			else
				System.out.println("page does not have duplicate link");
			//To find how many links inside this page
			driver.findElement(By.xpath("//a[contains(text(),'How many links in this p')]")).click();
			Thread.sleep(3000);
			List<WebElement> nol = driver.findElements(By.tagName("a"));
			System.out.println("Total number of links inside the page :"+nol.size());
			driver.navigate().back();
			Thread.sleep(3000);
			//To find number links in current page
			List<WebElement> nol1 = driver.findElements(By.tagName("a"));
			System.out.println("Total number of links in link component page :"+nol1.size());
			driver.close();		
			
  }
}
