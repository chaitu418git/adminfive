package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavigationBar extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
@BeforeTest
public void initialize() throws IOException
{
	driver=initializeDriver();
	driver.get(prop.getProperty("url"));	
}
	@Test
	public void validateText() throws IOException,ArrayIndexOutOfBoundsException
	{
		
		LandingPage lp=new LandingPage(driver);
Assert.assertTrue(lp.verifyNavigationBar().isDisplayed());
		//lp.verifyNavigationBar().isDisplayed();
log.info("Navigation bar is displayed");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}
