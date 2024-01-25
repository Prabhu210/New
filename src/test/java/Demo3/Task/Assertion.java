package Demo3.Task;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion {
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	@Test(priority=1)
	void logoTest() throws InterruptedException
	{
	Thread.sleep(5000);
		WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
		Assert.assertTrue(logo.isDisplayed(),"logo was not displayed in the page");
	}
	@Test(priority=2)
	void homepageTitle()
	{
		String title = driver.getTitle();
		Assert.assertEquals("OrangeHRM",title,"Title is not matched");
		
	}
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
	

}
