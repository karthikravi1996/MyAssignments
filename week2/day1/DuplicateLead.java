package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead 
{
  public static void main(String[] args) 
  {
	  WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.id("label")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(" AparInnosysLLP");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(" Karthik");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(" Ravi");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(" karthi");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(" Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys(" Interested in automation Testing");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("karthikravi576@gmail.com");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dropdown1 = new Select(state);
		dropdown1.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		String currenttitle = driver.getTitle();
		System.out.println("The first title : "+currenttitle);
		driver.findElement(By.className("subMenuButton")).click();
		WebElement ref1 = driver.findElement(By.id("createLeadForm_companyName"));
		ref1.clear();
		ref1.sendKeys("PayPal");
		WebElement ref2 = driver.findElement(By.id("createLeadForm_firstName"));
		ref2.clear();
		ref2.sendKeys("Karthikravi");
		driver.findElement(By.name("submitButton")).click();
		String title2 = driver.getTitle();
		System.out.println("The second title : "+title2);
		
		
		
		
  }
}
