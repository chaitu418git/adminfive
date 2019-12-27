package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	}
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username,String Password) throws IOException,ArrayIndexOutOfBoundsException
	{
		//driver=initializeDriver();
		//driver.get(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		lp.getLogin().click();
		log.info("clicked on Login for login");
		LoginPage login=new LoginPage(driver);
		login.getUname().sendKeys(username);
		log.info("Enetered username");
		login.getPassword().sendKeys(Password);
		log.info("Enetered Password");
		login.loginClick().click();
		log.info("clicked on Login");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//Column stands for how many values for each test we need to provide
		Object[][] data=new Object[2][2];
		//oth row
		data[0][0]="abc@gmail.com";
		data[0][1]="abc@1234";
		//1st row
		data[1][0]="abcd@gmail.com";
		data[1][1]="abac@1234";
		return data;
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
	
}
