package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchProductsPage;
import pageObjects.checkOutPage;
import testBase.BaseClass;
import utilities.dataProviders;

public class TC004_SearchProducts extends BaseClass {
	
	@Test(dataProvider = "searchData", dataProviderClass = dataProviders.class)
	public void verify_searchProducts(String txt, String exp) {
		
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText(txt);
		sp.SearchClick();
		boolean targetCart = sp.AddCartDisplayed();
		boolean noproduct = sp.noProductDisplayed();
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetCart==true) {
				Assert.assertTrue(true);
				sp.searchClear();
			}
			else {
				Assert.assertTrue(false);
				sp.searchClear();
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(noproduct==true) {
				Assert.assertTrue(true);
				sp.searchClear();
			}
			else {
				Assert.assertTrue(false);
				sp.searchClear();
			}
		}
	} 
	@Test(priority = 2, dataProvider = "AddItems", dataProviderClass = dataProviders.class)
	public void verify_adding_multiple_items_to_cart(String it, String exp) throws Exception {
		
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText(it);
		sp.SearchClick();
		Thread.sleep(1000);
		
		checkOutPage cp = new checkOutPage(driver);
		cp.clickAddToCart();
		cp.clickCheckout();
		Thread.sleep(3000);
		
		List<WebElement> ItemsInCart = cp.ItemsInCartss();
		
		//System.out.println(ItemsInCart.get(0).getText());
		for(WebElement iic : ItemsInCart) {
			System.out.println(iic.getText());
			if(iic.getText().equalsIgnoreCase(exp)) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		cp.clickDelete();
		cp.clickRefresh();
		
		
		sp.searchClear();
		
	}

}
