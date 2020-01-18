package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.inject.spi.Element;

import resources.Base;

public class ProvisioingPage  {
	 public WebDriver driver;
	 //Login Details WebElements
	 By partnerName= By.xpath("//table/tbody/tr[2]/td[2]/input");
	 
	 By password=By.xpath("//table/tbody/tr[3]/td[2]/input");
	 By submit=By.id("CSDLoginAction_submit");
	 //Provisioing Form Web Elements
	 By accountName=By.xpath("//input[@name='provisioningobj.accountname']");
	 By userExtLength=By.xpath("//select[@name='provisioningobj.extnlength']");
	 
	 By currentPhoneNumber=By.xpath("//input[@name='provisioningobj.curphonenum']");
	 By companyName=By.xpath("//input[@name='provisioningobj.companyname']");
	 By timeZone=By.id("ProvisioningAction_provisioningobj_timezone");
	 By industryType=By.id("ProvisioningAction_provisioningobj_industrytype");
	 //Administrator Info
	 By firstName = By.xpath("//input[@name='provisioningobj.firstname']");
	 By lastName=By.xpath("//input[@name='provisioningobj.lastname']");
	 By emailAddress=By.xpath("//input[@name='provisioningobj.email']");
	 By retypeEmailAddress=By.xpath("//input[@name='provisioningobj.retypeemail']");
	 
	 //Payment And Billing Info :
	 By paymentCreditcard=By.xpath("//table[@class='mainTable']//input[2]");
	 By check=By.xpath("//table[@class='mainTable']//input[3]");
	 By eft=By.xpath("//table[@class='mainTable']//input[4]");
	 By cardType=By.id("ProvisioningAction_provisioningobj_paymenttype");
	 By expirymonth=By.id("ProvisioningAction_provisioningobj_expires_month");
	 By expiryYear=By.name("provisioningobj.expires_year");
	 By ccNumber=By.xpath("//input[@name='provisioningobj.creditcardnumber']");
	 By exactNameonCard=By.xpath("//input[@name='provisioningobj.nameoncard']");
	 By cardID=By.xpath("//input[@name='provisioningobj.cardid']");
	 By billingEmailAddress=By.xpath("//input[@name='provisioningobj.billingEmailAddr']");
	 By saddrs1=By.xpath("//input[@name='provisioningobj.pay_StreetAddNo']");
	 By cityTown=By.xpath("//input[@name='provisioningobj.city_payment']");
	 By zipCode=By.xpath("//input[@name='provisioningobj.postalcode_payment']");
	 By state=By.xpath("//select[@id='ProvisioningAction_provisioningobj_state_payment']");
	 By country=By.xpath("//select[@id='ProvisioningAction_provisioningobj_country_payment']");
	 

	 //Location Information
	 
	 By locName=By.xpath("//input[@name='provisioningobj.locationname']");
	 By slocaddrs1=By.xpath("//input[@name='provisioningobj.loca_StreetAddressNumber']");
	 By loccityTown=By.xpath("//input[@name='provisioningobj.city_location']");
	 By loczipCode=By.xpath("//input[@name='provisioningobj.postalcode_location']");
	 By locState=By.xpath("//select[@id='ProvisioningAction_provisioningobj_state_location']");
	 By locCountry=By.xpath("//select[@id='ProvisioningAction_provisioningobj_country_location']");
	 By submitButton=By.xpath("//input[@id='ProvisioningAction_submit']");
	 
	 public ProvisioingPage(WebDriver driver)
	 {
		 this.driver=driver;
	 }
public WebElement getPartnerName() {
	return driver.findElement(partnerName);
	
	}
public WebElement getPassword() {
	return driver.findElement(password);
	}
public WebElement submitClick() {
	return driver.findElement(submit);
	}
public WebElement accountName() {
	return driver.findElement(accountName);
	}

public void select(By element,String value)
{
	Select s=new Select(driver.findElement(element));
	//s.selectByValue(value);
	s.selectByVisibleText(value);
//	return null;
	
}
public void select(By element,int index)
{
	Select s=new Select(driver.findElement(element));
	s.selectByIndex(index);
	}
public void userExtlength(String value) {
	select(userExtLength, value);
	selectIdentify(userExtLength, value);
	//return driver.findElement(userExtLength);
	}
public void timezoneselect(String value) {
	select(timeZone, value);
	selectIdentify(timeZone, value);
	//return driver.findElement(userExtLength);
	}
public void industryType(String value) {
	select(industryType, value);
	selectIdentify(industryType, value);
	//return driver.findElement(userExtLength);
	}

public void cardType(String value) {
	select(cardType, value);
	selectIdentify(cardType, value);
	//return driver.findElement(userExtLength);
	}
public void expMonth(String value) {
	select(expirymonth, value);
	selectIdentify(expirymonth, value);
	//return driver.findElement(userExtLength);
	}
public void expYear(String value) {
	select(expiryYear, value);
	selectIdentify(expiryYear, value);
	//return driver.findElement(userExtLength);
	}
public void paymentState(String value) {
	select(state, value);
	selectIdentify(state, value);
	//return driver.findElement(userExtLength);
	}
public void paymentCountry(String value) {
	select(country, value);
	selectIdentify(country, value);
	//return driver.findElement(userExtLength);
	}
public void locState(String value) {
	select(locState, value);
	selectIdentify(locState, value);
	//return driver.findElement(userExtLength);
	}
public void locCountry(String value) {
	select(locCountry, value);
	selectIdentify(locCountry, value);
	//return driver.findElement(userExtLength);
	}
//method to identify selected value from drop down
public void selectIdentify(By element,String value)
{
	List<WebElement> s=new Select(driver.findElement(element)).getOptions();
	for(int i=0;i<s.size();i++)
	{
		if(s.get(i).getText().equalsIgnoreCase(value))
		{
			System.out.println("given value is selected");
			break;
		}
		
	}
	
	
}

/*public void select()
{
	Select s=new Select((WebElement) userExtLength);
	s.selectByValue("4");
	
}*/

public WebElement curPhoneNumber() {
	return driver.findElement(currentPhoneNumber);
	}
public WebElement companyName() {
	return driver.findElement(companyName);
	}

//Administartor info:
public WebElement fName() {
	return driver.findElement(firstName);
	}
public WebElement lName() {
	return driver.findElement(lastName);
	}
public WebElement emailAddress() {
	return driver.findElement(emailAddress);
	}
public WebElement reemailAddress() {
	return driver.findElement(retypeEmailAddress);
	}


//Payment & Billing info
public WebElement creditCard() {
	return driver.findElement(paymentCreditcard);
}
public WebElement check() {
	return driver.findElement(check);
}
public WebElement eft() {
	return driver.findElement(eft);
}
public boolean paymentModecheck()
{
	return isSelected(paymentCreditcard);
}
public boolean isSelected(By element)
{
if(driver.findElement(element).isSelected())
{
	System.out.println("credit card is selected");
}
	//return null;
return true;
}
public WebElement ccNumber() {
	return driver.findElement(ccNumber);
	}
public WebElement exactName() {
	return driver.findElement(exactNameonCard);
	}
public WebElement cardID() {
	return driver.findElement(cardID);
	}
public WebElement billEmailAdsress() {
	return driver.findElement(billingEmailAddress);
	}
public WebElement stradrs1() {
	return driver.findElement(saddrs1);
	}
public WebElement cityTown() {
	return driver.findElement(cityTown);
	}
public WebElement zipCode() {
	return driver.findElement(zipCode);
	}
//location info:
public WebElement locName() {
	return driver.findElement(locName);
	}
public WebElement locsaddrs1() {
	return driver.findElement(slocaddrs1);
	}
public WebElement locCity() {
	return driver.findElement(loccityTown);
	}
public WebElement locZipcode() {
	return driver.findElement(loczipCode);
	}
public WebElement submitButton() {
	return driver.findElement(submitButton);
	}
public static void main(String []args)
{
	
}
}
