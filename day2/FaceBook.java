package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook 
{
  public static void main(String[] args) throws InterruptedException 
  {

	    WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		System.out.println("The title name : "+driver.getTitle());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		driver.findElement(By.name("firstname")).sendKeys("karthik");
		driver.findElement(By.name("lastname")).sendKeys("Ravi");
		driver.findElement(By.name("reg_email__")).sendKeys("8667250326");
		driver.findElement(By.id("password_step_input")).sendKeys("123456789");
		Select drp1 = new Select(driver.findElement(By.id("day")));
		drp1.selectByVisibleText("17");
		Select drp2 = new Select(driver.findElement(By.id("month")));
	    drp2.selectByVisibleText("Nov");
	    Select drp3 = new Select(driver.findElement(By.id("year")));
	    drp3.selectByVisibleText("1996");
	    WebElement gender = driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input"));
	    gender.click();
	    Thread.sleep(5000);
	    driver.close();
	    
	    
	    
	    
	    
	    
  }
}
