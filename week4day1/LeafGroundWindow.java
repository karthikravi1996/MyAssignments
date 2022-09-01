package week4day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindow 
{
   public static void main(String[] args) throws InterruptedException 
   {
	 WebDriverManager.chromedriver().setup();
	 ChromeDriver driver = new ChromeDriver();
	 
	 //To launch the Url
	 driver.get("https://leafground.com/window.xhtml");
	 driver.manage().window().maximize();
	 String firsttitle = driver.getTitle();
	 System.out.println("The title of first page : "+firsttitle);
	 
	 //Click and Confirm new Window Opens
	 driver.findElement(By.xpath("//span[text()='Open']")).click();
	 Thread.sleep(3000);
	 String current = driver.getWindowHandle();
	 List<String> ref1 = new ArrayList<String>(driver.getWindowHandles());
	 driver.switchTo().window(ref1.get(1));
	 
	 Thread.sleep(3000);
	 String secondwindow = driver.getTitle();
	 System.out.println("The title of second page is : "+secondwindow);
	 if (secondwindow.contains("Dashboard")) 
	   System.out.println("After clicking new window opened");
	 else
		 System.out.println("New window does not exists");
	 driver.close();
	 driver.switchTo().window(current);
	 
	 //Find the number of opened tabs
     driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
     Thread.sleep(3000);
     String currentwin = driver.getWindowHandle();
	 List<String> ref2 = new ArrayList<String>(driver.getWindowHandles());
	 System.out.println("The number of taps opened : "+ref2.size() );
	 driver.switchTo().window(ref2.get(2));
	 driver.close();
	 Thread.sleep(3000);
	 driver.switchTo().window(ref2.get(1));
	 driver.close();
	 Thread.sleep(3000);
	 driver.switchTo().window(currentwin);
	 Thread.sleep(3000);
	 

     //To close all window except primary
	 driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
	 Thread.sleep(3000);
	 String curent = driver.getWindowHandle();
	 List<String> ref3 = new ArrayList<String>(driver.getWindowHandles());
	 
	 for (int i = 1; i <ref3.size(); i++) 
	 {
		driver.switchTo().window(ref3.get(i));
		driver.close();
	 }
	 Thread.sleep(3000);
	 driver.switchTo().window(curent);
	 System.out.println("All windows got closed........");
	 
	 //Wait for 2 new tabs to open
	 driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
	 List<String> list = new ArrayList<String>(driver.getWindowHandles());
	 System.out.println("Total windows :"+list.size());
	 driver.switchTo().window(list.get(1));
	 Thread.sleep(3000);
	 
	 System.out.println("..........All test cases executed successfully.......");
	 driver.quit();
	 
	 
	 
	 
   }
}
