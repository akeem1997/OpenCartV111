package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.SearchProductsPage;
import pageObjects.wishListPage;
import testBase.BaseClass;

public class TC006_WishList extends BaseClass {
	
	@Test(priority = 1)
	public void writeReview() {
		
		
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LogInPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText("macbook");
		sp.SearchClick();
		
		driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).click();
		
		wishListPage wp = new wishListPage(driver);
		wp.clearQuant();
		wp.EnterQuant("2");
		wp.clickWriteAReview();
		wp.clearName();
		wp.EnterName("angel micheal");
		wp.EnterYourReview("Product is reliable, light and easy to navigate. I can use this product anytime of the day without worrying about anything");
		wp.clickBestRate();
		wp.clickContinue();
		boolean thankYou = wp.ThankYouReviewIsDisplayed();
		Assert.assertEquals(thankYou, true);
		
		
		hp.clickMyAccount();
		lp.clickLogOut();
}
	
	@Test(priority = 2)
	public void addToWishList() {
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LogInPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText("macbook");
		sp.SearchClick();
		
		driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).click();
		wishListPage wp = new wishListPage(driver);
		wp.clickWishList();
		boolean thankYou = wp.ThankYouReviewIsDisplayed();
		Assert.assertEquals(thankYou, true);
		hp.clickMyAccount();
		lp.clickLogOut();
		
	} 
	
	@Test(priority = 3)
	public void testSubmitReviewWithoutText() {
		
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LogInPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText("macbook");
		sp.SearchClick();
		
		driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).click();
		
		
		wishListPage wp = new wishListPage(driver);
		wp.clearQuant();
		wp.EnterQuant("2");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000);");
		wp.clickWriteAReview();
		wp.clearName();
		wp.clickContinue();
		boolean error = wp.SelectReviewRatingIsDisplayed();
		Assert.assertEquals(error, true);
		hp.clickMyAccount();
		lp.clickLogOut();
	}
	
	@Test(priority = 4)
	public void testSubmitReviewWithoutRating() {
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LogInPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText("macbook");
		sp.SearchClick();
		
		driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).click();
		
		
		wishListPage wp = new wishListPage(driver);
		wp.clearQuant();
		wp.EnterQuant("2");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000);");
		wp.clickWriteAReview();
		wp.clearName();
		wp.EnterName("angel micheal");
		wp.EnterYourReview("Product is reliable, light and easy to navigate. I can use this product anytime of the day without worrying about anything");
		wp.clickContinue();
		boolean error = wp.SelectReviewRatingIsDisplayed();
		Assert.assertEquals(error, true);
		hp.clickMyAccount();
		lp.clickLogOut();
	} 
	
	@Test(priority = 5)
	public void testSubmitReviewWithoutChararcters() throws Exception  {
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LogInPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText("macbook");
		sp.SearchClick();
		
		driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).click();
		
		
		wishListPage wp = new wishListPage(driver);
		wp.clearQuant();
		wp.EnterQuant("2");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000);");
		wp.clickWriteAReview();
		wp.clearName();
		wp.EnterName("angel micheal");
		
		wp.clickBestRate();
		wp.clickContinue();
		
		
		
		boolean error = wp.SelectReviewRatingIsDisplayed();
		Assert.assertEquals(error, true);
		
		
		hp.clickMyAccount();
		lp.clickLogOut();
		
		
	} 
	@Test(priority = 6)
	public void  testReviewCharacterLimit() {
		Homepage hp = new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LogInPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText("macbook");
		sp.SearchClick();
		
		driver.findElement(By.xpath("//a[normalize-space()='MacBook']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000);");
		
		wishListPage wp = new wishListPage(driver);
		wp.clearQuant();
		wp.EnterQuant("2");
		wp.clickWriteAReview();
		wp.clearName();
		wp.EnterName("angel micheal");
		wp.EnterYourReview("Pr");
		wp.clickBestRate();
		wp.clickContinue();
		boolean error = wp.SelectReviewRatingIsDisplayed();
		Assert.assertEquals(error, true);
		
		
		hp.clickMyAccount();
		lp.clickLogOut();
	}

}
