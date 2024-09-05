package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity", "Master",})
	public void verify_Login() {
		logger.info("******* Starting tc_002_LoginTest *********");
		
		try {
		//HomePage
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LogInPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyaccountPage
		MyAccountPage macc = new MyAccountPage(driver) ;
		boolean targetPage = macc.isMyAccountPageExists();
		Assert.assertEquals(targetPage, true, "Login Failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******* Finished tc_002_LoginTest *********");
	}

}
