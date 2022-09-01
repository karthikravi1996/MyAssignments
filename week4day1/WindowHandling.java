package week4day1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling 
{
  public static void main(String[] args) throws InterruptedException 
  {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	//To launch the url
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	
	//To enter username and password
	driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
    
	//To click on crm/sfa
	driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
	Thread.sleep(2000);
	
	//Click on contacts Button
	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	
	// Click on Merge Contacts using Xpath Locator
	driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
	Thread.sleep(2000);
	
	//To get the title of page
	System.out.println(driver.getTitle());
	Thread.sleep(2000);
	
	// Click on Widget of From Contact
	driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a[1]")).click();
	Thread.sleep(2000);
	String windowHandle = driver.getWindowHandle();
    List<String> Window = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(Window.get(1));
    Thread.sleep(3000);
    
    //Click on First Resulting Contact
    driver.findElement(By.xpath("//div[@class='x-grid3-body']/div[1]//tbody/tr[1]/td[1]//a[1]")).click();
    driver.switchTo().window(windowHandle);
	driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a[2]")).click();
	Thread.sleep(3000);
	
	//Click on Second Resulting Contact
	String windowHandle2 = driver.getWindowHandle();
    List<String> Window2 = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(Window2.get(1));
	Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@class='x-grid3-body']/div[2]//tbody/tr[1]/td[1]//a[1]")).click();
	Thread.sleep(2000);
    driver.switchTo().window(windowHandle2);
    Thread.sleep(2000);
    
    // Click on Merge button using Xpath Locator
    driver.findElement(By.className("buttonDangerous")).click();
    Thread.sleep(2000);
   
    //Accept the Alert
    Alert accept1 = driver.switchTo().alert();
    accept1.accept();
    Thread.sleep(2000);
  }
}
