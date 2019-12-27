package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public static WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException
{
	prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Chaitu\\eclipse-workspace\\Project\\src\\main\\java\\resources\\data.properties");
    prop.load(fis);
    String browserName=prop.getProperty("browser");
    String diverPath="E:\\MyNewSelenium\\chromedriver_win32\\chromedriver.exe";
    if(browserName.equalsIgnoreCase("chrome"))
    {
    	System.setProperty("webdriver.chrome.driver", diverPath);
    	 driver=new ChromeDriver();
    }
    else if(browserName.equalsIgnoreCase("firefox"))
    {
    	 driver=new FirefoxDriver();
    }
    	
    else if(browserName.equalsIgnoreCase("IE"))
    {
    	 driver=new InternetExplorerDriver();
    }
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	return driver;
    
} 
public void getScreenshot(String result) throws IOException {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(src, new File("E:\\Selenium New -Must Learn\\testscreenshots\\"+result+"screenshot.png"));
    
}
}
