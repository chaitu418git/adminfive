package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

public class LandingPage {
public WebDriver driver;
By signin=By.xpath("//span[contains(text(),'Login')]");
By verifyText=By.xpath("//h2[contains(text(),'Featured Courses')]");
By navigationBar=By.xpath("//div[@class='navbar navbar-default navbar-static-top']/div[1]/nav/ul/li/a");



public LandingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
}
public WebElement getLogin() 
{
return driver.findElement(signin);	
}
public WebElement verifyText() 
{
return driver.findElement(verifyText);	
}
public WebElement verifyNavigationBar() 
{
return driver.findElement(navigationBar);	
}
}
