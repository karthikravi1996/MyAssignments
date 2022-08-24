package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead 
{
  public static void main(String[] args) throws InterruptedException 
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
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]//following::input[1]")).sendKeys("Karthik");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//div[text()='First name']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-row   '])[1]//tbody//td[3]//div//a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		WebElement updatecompname = driver.findElement(By.id("updateLeadForm_companyName"));
		updatecompname.clear();
		updatecompname.sendKeys("Danfoss engineering");
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(3000);
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("The changed company name : "+text);
		driver.close();
		
  }
}
