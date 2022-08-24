package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button 
{
	public static void main(String[] args) throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/button.xhtml");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//span[text()='Click']")).click();
	Thread.sleep(3000);
	String title1 = driver.getTitle();
	System.out.println("After clicking  : "+title1);
	driver.navigate().back();
	boolean displayed = driver.findElement(By.xpath("//span[text()='Disabled']")).isDisplayed();
	System.out.println("Disabled condition : "+displayed);
	Point location = driver.findElement(By.xpath("(//span[text()='Submit'])[1]")).getLocation();
	System.out.println("The location is : "+location);
	String cssValue = driver.findElement(By.xpath("(//button[@type='button'])[4]")).getCssValue("background");
	System.out.println("The colourvalue is : "+cssValue);
	Dimension size = driver.findElement(By.xpath("(//button[@type='button'])[5]")).getSize();
	System.out.println("The dimension is : "+size);
	String beforemousing = driver.findElement(By.xpath("(//button[@type='button'])[6]")).getCssValue("background-color");
	System.out.println("Before mousing :  "+beforemousing);
	WebElement after = driver.findElement(By.xpath("(//button[@type='button'])[6]"));
	Actions act = new Actions(driver);
	act.moveToElement(after).clickAndHold(after).build().perform();
	Thread.sleep(2000);
	String aftermousing = driver.findElement(By.xpath("//span[@style='background-color: salmon;']")).getCssValue("background-color");
	System.out.println("After mousing :  "+aftermousing);
	if(beforemousing == aftermousing)
		System.out.println("Colour not changed");
	else
		System.out.println("colour got changed successfully");
	driver.findElement(By.xpath("//span[text()='Image']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='grid formgrid']")).click();
	List<WebElement> totalbuttons = driver.findElements(By.xpath("//h5[contains(text(),'rounded')]//following::button"));
	System.out.println("Total number of buttons : "+totalbuttons.size());
	for (int i = 1; i <=totalbuttons.size(); i++) 
	{
	 String text = driver.findElement(By.xpath("//h5[contains(text(),'rounded')]//following::button["+i+"]/span")).getText();
	 System.out.println(""+i+" Button name : "+text);
	}
	driver.close();
	
	
	
	
	
	
	
	
	
	}

}
