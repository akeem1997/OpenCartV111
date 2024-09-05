package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	
	@Test(groups = { "Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("******* Starting TC001_AccountRegistrationTest ******");
		
		
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		logger.info("******* Clicked on My Account link ******");
		
		hp.clickRegister();
		logger.info("******* Clicked on Register Link ******");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver) ;
		
		logger.info("******* Providing Customer Details ******");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password = randomeAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("******* Validating expected message ******");
		String confmsg = regpage.getConfirmationMessage();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		logger.info("****** Finished testing **********");
		
	}
	
	

}
