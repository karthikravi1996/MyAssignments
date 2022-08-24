package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputComponents 
{
 public static void main(String[] args) throws InterruptedException 
 {
	    WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0tmb2389go0xlxjvuy66xu9p668024.node0");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		//TYpe your name
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Karthik");
		
		//To append country for this city
		WebElement country = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		country.clear();
		country.sendKeys("India");
		
		//To verify box is disabled
		boolean disable = driver.findElement(By.xpath("(//input[@type='text'])[4]")).isDisplayed();
		if(disable == true)
			System.out.println("The box is disabled");
		else
			System.out.println("The box is enabled");
		
		//To clear the text
		WebElement clr = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
		clr.clear();
	    System.out.println("The text is cleared.....");
	    Thread.sleep(3000);
	    
	    //To get the given text
	    String txt = driver.findElement(By.xpath("//h5[text()='Retrieve the typed text.']/following::input[1]")).getAttribute("value");
	    System.out.println("The retrieve text is : "+txt);
	   
	    //To type the email
	    driver.findElement(By.xpath("//h5[contains(text(),'Type email and')]//following::input[1]")).sendKeys("karthikravi576@gmail.com",Keys.TAB);
	    
	    //To confirm element moved
	    WebElement elmt = driver.switchTo().activeElement();
	    String val = elmt.getAttribute("placeholder");
	    if(val.contains("About yourself"))
	    	System.out.println("The cursor moved to next element");
	    else
	    	System.out.println("The cursor does not moved");
	
	    //To type about yourself
	    WebElement abt = driver.findElement(By.xpath("//h5[text()='Type about yourself']/following::textarea"));
	    abt.sendKeys("Awesome learning of selenium");
	    Thread.sleep(3000);
	    
	    //To Verify and edit text editor
	    for (int i = 1; i <=3; i++) 
	    {
			driver.findElement(By.xpath("//h5[contains(text(),'Text Editor')]/following::div[4]/span[2]/button["+i+"]")).click();
		}
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")).sendKeys("Hi, This is karthik");
	    
	    Thread.sleep(3000);
	    //Just Press Enter and confirm error message
	    WebElement findElement = driver.findElement(By.xpath("//h5[contains(text(),'error message*')]//following::input[2]"));
	    findElement.sendKeys(Keys.ENTER);
	    Thread.sleep(3000);
	    String text2 = driver.findElement(By.xpath("//span[text()='Age is mandatory']")).getText();
	    if(text2.contains("mandatory"))
	    	System.out.println("Error message displayed");
	    else
	    	System.out.println("Messege not displayed");
	    Thread.sleep(2000);
	    
	    //To find the label position changes
	    int y1 = driver.findElement(By.xpath("//label[text()='Username']")).getLocation().getY();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//h5[contains(text(),'Position Changes')]/following::input[1]")).click();
	    Thread.sleep(2000);
	    int y2 = driver.findElement(By.xpath("//label[text()='Username']")).getLocation().getY();
	    if(y1==y2)
	    	System.out.println("The label position does not changed ");
	    else
	    	System.out.println("The label position got changed");
	    
	    //Type your name and choose the third option
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//input[@placeholder])[5]")).sendKeys("karthik");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[@role='listbox']/ul/li[4]")).click();
	    Thread.sleep(3000);
	    
	    //Type your DOB (mm/dd/yyyy) and confirm date chosen
	    driver.findElement(By.xpath("//h5[contains(text(),'confirm date chosen ')]//following::input[1]")).sendKeys("17-11-1996",Keys.ESCAPE);
	    Thread.sleep(2000);
	    
	    //To enter and swap the enter number 
	    WebElement num = driver.findElement(By.xpath("//h5[contains(text(),'spin')]//following::input[1]"));
	    num.sendKeys("45");
	    Thread.sleep(4000);
	    for (int i = 1; i <=20; i++)
	    {
		    driver.findElement(By.xpath("//h5[contains(text(),'spin')]//following::input[1]/following::span[1]")).click();
	
		}
	    Thread.sleep(2000);
	    String res2 = num.getAttribute("aria-valuenow");  
	    System.out.println(res2);
	    if(res2.equals("45"))
	    	System.out.println("Number not got swapped");
	    else
	    	System.err.println("Number got swapped");
	  
	    
	    //Type random number (1-100) and confirm slider moves correctly
		Thread.sleep(3000);
	     int y3 = driver.findElement(By.xpath("//h5[contains(text(),'1-100)')]/following::input[1]//following::span[1]")).getLocation().getX();
	     driver.findElement(By.xpath("//h5[contains(text(),'1-100)')]/following::input[1]")).sendKeys("45");
	     Thread.sleep(3000);
		 int y4 = driver.findElement(By.xpath("//h5[contains(text(),'1-100)')]/following::input[1]//following::span[1]")).getLocation().getX();
  
         if(y3 == y4)
        	 System.out.println("position Not changed");
         else
        	 System.out.println("position changed");
        	
		
		//To confirm whether keyboard appears
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h5[contains(text(),'Keyboard appears')]//following::input[1]")).click();
		String text = driver.findElement(By.xpath("//button[text()='Close']")).getText();
		if(text.contains("Close"))
			System.out.println("Keyboard appears");
		else
			System.out.println("keyboard not appears");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		
		//To write on custom editor
		Thread.sleep(2000);
		for (int i = 1; i <=3; i++) 
		{
			driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::div[2]/span/button["+i+"]")).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h5[text()='Custom Toolbar']/following::div[4]")).sendKeys("program ends");
		Thread.sleep(2000);
		System.out.println("Program ends successfully");
		driver.close();
 }
}
