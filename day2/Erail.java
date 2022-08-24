package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail 
{
  public static void main(String[] args) throws InterruptedException 
  {
	    WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		System.out.println("The title name : "+driver.getTitle());
		Thread.sleep(6000);
	    WebElement fromstation = driver.findElement(By.id("txtStationFrom"));	
	    fromstation.clear();
	    fromstation.sendKeys("MS",Keys.TAB);
	    Thread.sleep(5000);
	    WebElement tostation = driver.findElement(By.id("txtStationTo"));
	    tostation.clear();
	    tostation.sendKeys("PDY",Keys.ENTER);
	    Thread.sleep(5000);
	    driver.findElement(By.id("chkSelectDateOnly")).click();
	    Thread.sleep(5000);
	    List<WebElement> totalrows = driver.findElements(By.xpath("(//table)[3]/tbody/tr"));
	    int size = totalrows.size();
	    System.out.println("Total number of rows : "+ size);
	    List<WebElement> totalcolumns = driver.findElements(By.xpath("(//table)[3]/tbody/tr/td"));
	    System.out.println("Total number of columns : "+totalcolumns.size());
	    Thread.sleep(5000);
	    
	    for (int i =1 ; i <=size; i++) 
	    {
			for (int j = 1; j <=9; j++) 
			{
				String text = driver.findElement(By.xpath("(//table)[3]/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(text +" , ");
				
			}
			System.out.println();
		}
	    
	    System.out.println("===========Program ends==================");
	    driver.close();
	    
  }
}
