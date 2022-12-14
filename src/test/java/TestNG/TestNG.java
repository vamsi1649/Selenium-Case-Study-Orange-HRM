package TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG
   {
    public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	@BeforeTest 
	public void beforetest() throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get(url);
 	}	
	@Test(enabled=true,priority = 0)
	public void testcase1() throws InterruptedException
	{
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//*[@type='submit']")).click();
	}
		
	@Test(enabled=true,priority=1)
	public void testcase2() throws InterruptedException
	{	
     List <WebElement> list = driver.findElements(By.tagName("a"));
     System.out.println("total links in the hrm :  "+ list.size());
     
	 }
		
	  @Test(enabled=true,priority = 2)
	  public void testcase3() throws InterruptedException
	 {
	 driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(8).click();
	 driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(8).click();	
	 driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();	
	 Thread.sleep(3000);
     }
	  
	  @AfterTest
	  public void aftertest() throws InterruptedException
	  {
	   driver.findElement(By.xpath("//*[@class='oxd-userdropdown-name']")).click();
	   driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
	   Thread.sleep(3000);
	   driver.close();	
	  }
    }
		
		
		
		
