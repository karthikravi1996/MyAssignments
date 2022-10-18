package assignement4;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Final 
{
   public static void main(String[] args) 
   {
	   WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//To login website
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//div[contains(@class,'login-action')]/button")).click();
		
		//To click admin option
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		
		int size = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div")).size();
		System.out.println("Total rows : "+size);
		
		int size2 = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div[1]/div/div")).size();
		System.out.println("Total columns : "+size2);
		
		List<WebElement> all = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div/div/div[2]"));
		 Set<String> alll = new HashSet<String>();
		for (WebElement role : all) 
		{
			String text1 = role.getText();
			alll.add(text1);
		}
		System.out.println("Number of roles available : "+alll.size());
		System.out.println(alll);
		
		List<WebElement> roles = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div/div/div[3]"));
		 Set<String> rolee = new HashSet<String>();
		for (WebElement role : roles) 
		{
			String text2 = role.getText();
			rolee.add(text2);
		}
		System.out.println("Number of roles available : "+rolee.size());
		System.out.println(rolee);
		
		Object[] array = rolee.toArray();
		String[] arr = Arrays.copyOf(array,array.length,String[].class);
		String val1 =arr[0];
		String val2 =arr[1];
		
		
		
		
		
   }
}
