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

public class ValidateText extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to given url");
		
	}

	@Test
	public void validateText() throws IOException,ArrayIndexOutOfBoundsException
	{
	//	driver=initializeDriver();
		//driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		Assert.assertEquals(lp.verifyText().getText(), "FEATURED COURSES123");
		//lp.verifyText().getText();
		//Assert.assertTrue(lp.verifyNavigationBar());
		log.info("successfully validated Text Message");
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}

}
