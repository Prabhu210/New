package Demo3.Task;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameterization {
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser","url"})
	void setup(String browser,String app)
	{
		if (browser.equalsIgnoreCase("chrome")) {
			
		//11	
//		WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
		driver=new ChromeDriver(option);
		
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.get(app);
		driver.manage().window().maximize();
		
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
	//prabhu
	//master
	private void master() {
		// TODO Auto-generated method stub

	}
	@Test(priority=3)
	void test() throws InterruptedException
	{
		WebElement user = driver.findElement(By.name("username"));
		user.sendKeys("Admin");
		
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("admin123");
		
		WebElement submit = driver.findElement(By.xpath("//button[text()=' Login ']"));
		submit.click();
		
		Thread.sleep(5000);
		
		List<WebElement> elements = driver.findElements(By.xpath("//span[@class = 'oxd-text oxd-text--span oxd-main-menu-item--name']"));
		for (WebElement webElement : elements) {
			
			String text = webElement.getText();
			System.out.println(text);
				
		}
		
		WebElement dashboardElement = driver.findElement(By.xpath("//span[text()='Dashboard']"));
//		 String dashboardText = dashboardElement.getText();
//	        System.out.println(dashboardText);

	        // Check if the 'Dashboard' element is selected by default
	        
		Assert.assertTrue(dashboardElement.isEnabled());
//	      Assertions.assert();
	        
	}
	
	@AfterClass
	void teardown()
	{
		driver.quit();
	}
	

}
