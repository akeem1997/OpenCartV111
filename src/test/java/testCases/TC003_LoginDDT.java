package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.dataProviders;


// data is valid - login sucess - test pass - logout
// data is valid -- login failed -- test fail
// data is invalid - login sucess - test fail - logout
// data is invalid -- login failed - test pass

public class TC003_LoginDDT extends BaseClass {
	
	
	@Test(dataProvider = "LoginData", dataProviderClass = dataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp) {
		logger.info("******** Starting tc003_LoginDDT **********");
		
		try {
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LogInPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyaccountPage
		MyAccountPage macc = new MyAccountPage(driver) ;
		boolean targetPage = macc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			
		}
			else {
				
				Assert.assertTrue(true);
			}
			}
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******** Finished tc003_LoginDDT **********");
			
	}
	

}
