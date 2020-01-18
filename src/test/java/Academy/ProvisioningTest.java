package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.utility.Xls_Reader;

import pageObjects.ProvisioingPage;

//import java.util.logging.LogManager;

import resources.Base;

public class ProvisioningTest extends Base {
	
public static Logger log=LogManager.getLogger(Base.class.getName());

@BeforeTest
public void initialize() throws IOException {
	driver=initializeDriver();
}
@Test(priority=1)
public void login()
{
	driver.get(prop.getProperty("url"));
	ProvisioingPage page=new ProvisioingPage(driver);
	Xls_Reader reader=new Xls_Reader("E:\\New Selenium\\DemoFramework\\src\\main\\java\\com\\testData\\ProvisioingFormData.xlsx",1);
	page.getPartnerName().sendKeys(reader.getCellData("logindetails", "partner name", 2));
	log.info("entered username");
	page.getPassword().sendKeys(reader.getCellData("logindetails", "password", 2));
	log.info("entered password");
    page.submitClick().click();	
    log.info("clicked on submit button");
}
@Test(priority = 2)
public void provisioningFormCreation()
{
	ProvisioingPage page=new ProvisioingPage(driver);
	Xls_Reader reader=new Xls_Reader("E:\\New Selenium\\DemoFramework\\src\\main\\java\\com\\testData\\ProvisioingFormData.xlsx",0);
    //Account Info
	page.accountName().sendKeys(reader.getCellData("provisioningdata", "AccountName", 2));
	log.info("accoutn name entered");
    page.userExtlength("5");
    log.info("User ext length is selected");
    page.curPhoneNumber().sendKeys(reader.getCellData("provisioningdata", "PhoneNumber", 2));
    log.info("cur phone number entrered");
    page.companyName().sendKeys(reader.getCellData("provisioningdata", "Company Name", 2));
    log.info("company name entreed");
    page.timezoneselect(reader.getCellData("provisioningdata", "TimeZone", 2));
    log.info("timezone is selected");
    page.industryType(reader.getCellData("provisioningdata", "Industry Type", 2));
    log.info("Industry type is selected");
    //Admin info
    page.fName().sendKeys(reader.getCellData("provisioningdata", "FirstName", 2));
    log.info("fname is entered");
    page.lName().sendKeys(reader.getCellData("provisioningdata", "LastName", 2));
    log.info("lastname is entered");
    page.emailAddress().sendKeys(reader.getCellData("provisioningdata", "Email Adress", 2));
    log.info("emailaddress is entered");
    page.reemailAddress().sendKeys(reader.getCellData("provisioningdata", "Retype Email Address", 2));
    log.info("retype email addreess is entered");
    //payment and bill info
    String mode=reader.getCellData("provisioningdata", "PaymentMode", 2);
    switch(mode)
    {
    case "Credit Card":
    	page.creditCard().click();
    	break;
    case "check":
    	page.check().click();
    	break;
    case "eft":
    	page.check().click();
    	break;
    }
    log.info("paymeent mode credot card is selected");
    page.cardType(reader.getCellData("provisioningdata", "CardType", 2));
    log.info("Cardtype visa is selected");
    page.expMonth(reader.getCellData("provisioningdata", "ExpriesOnDay", 2));
    log.info("exp month is selected");
    page.expYear(reader.getCellData("provisioningdata", "ExpriesOnMonth", 2));
    log.info("exp year is selected");
    page.ccNumber().sendKeys(reader.getCellData("provisioningdata", "Credit card number", 2));
    page.exactName().sendKeys(reader.getCellData("provisioningdata", "Exact Name on Card", 2));
    page.cardID().sendKeys(reader.getCellData("provisioningdata", "CardID", 2));
    page.billEmailAdsress().sendKeys(reader.getCellData("provisioningdata", "Billing Email Address", 2));
    page.stradrs1().sendKeys(reader.getCellData("provisioningdata", "Street Adrs1", 2));
    page.cityTown().sendKeys(reader.getCellData("provisioningdata", "City/Town", 2));
    page.paymentState(reader.getCellData("provisioningdata", "State", 2));
    page.zipCode().sendKeys(reader.getCellData("provisioningdata", "ZipCode", 2));
    page.paymentCountry(reader.getCellData("provisioningdata", "Country", 2));
    page.locName().sendKeys(reader.getCellData("provisioningdata", "Location Name", 2));
    page.locsaddrs1().sendKeys(reader.getCellData("provisioningdata", "Loc Street adrs1", 2));
    page.locCity().sendKeys(reader.getCellData("provisioningdata", "Loc city", 2));
    page.locState(reader.getCellData("provisioningdata", "LocState", 2));
    page.locZipcode().sendKeys(reader.getCellData("provisioningdata", "Loc ZipCode", 2));
    page.locCountry(reader.getCellData("provisioningdata", "LocCountry", 2));
    page.submitButton().click();
   browserClose();
/*public static void main(String []args)
{
Xls_Reader reader=new Xls_Reader("E:\\New Selenium\\DemoFramework\\src\\main\\java\\com\\testData\\ProvisioingFormData.xlsx",1);	
	System.out.println(reader.getCellData("logindetails", "partner name", 2));
}*/
}
}