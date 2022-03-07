package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Base {
public WebDriver driver;
	
	public ConfigDataProvider config;
	@BeforeSuite
	public void SetupSuite()
	{
		
		config=new ConfigDataProvider();
	}
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startApplication(driver,config.getBrowser(), config.getStagingURL());
	}
	
//	@AfterClass
//	public void tearDown() {
//		BrowserFactory.quitBrowser(driver);
//	}


}
