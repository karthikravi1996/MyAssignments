package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass 
{
  public static void main(String[] args) throws InterruptedException 
  {
	  WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();	
	    WebElement drp1 = driver.findElement(By.className("ui-selectonemenu"));
	    Select lst1 = new Select(drp1);
	    lst1.selectByVisibleText("Selenium");
	    //To select country
	    WebElement drp2 = driver.findElement(By.xpath("//label[text()='Select Country']"));
	    drp2.click();
	    driver.findElement(By.xpath("//li[text()='India']")).click();
	    Thread.sleep(5000);
	    //To select city
	     driver.findElement(By.xpath("//label[text()='Select City']")).click();
	    Thread.sleep(4000);
	    System.out.println("The loaded cities are : ");
	    List<WebElement> city = driver.findElements(By.xpath("(//div[@class='ui-selectonemenu-items-wrapper'])[4]/ul/li"));
	    Thread.sleep(5000);
	    for (int i = 2; i <=city.size(); i++) 
	    {
		   String text = driver.findElement(By.xpath("(//div[@class='ui-selectonemenu-items-wrapper'])[4]/ul/li["+i+"]")).getText();
		   System.out.println("The name of the city : "+ text);
	    }
	    driver.findElement(By.xpath("//li[text()='Chennai']")).click();
	    //To choose the course
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[@class='ui-selectonemenu-items-wrapper']/following::li[3]")).click();
	    //To choose the language
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//h5[contains(text(),'Choose language')]/following::div[6]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//li[text()='Select Language']/following::li[1]")).click();
	    Thread.sleep(3000);
	    //To click the second number word
	    driver.findElement(By.xpath("//label[text()='Select Values']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//li[text()='Select Values']/following::li[3]")).click();
	    Thread.sleep(3000);
	    driver.close();
	    
  }
}
