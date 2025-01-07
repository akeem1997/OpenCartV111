package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchProductsPage;
import pageObjects.checkOutPage;
import testBase.BaseClass;
import utilities.dataProviders;

public class TC005_Checkout extends BaseClass {
	
	@Test(priority = 1)
	public void verify_Add_to_cart() {
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText("phone");
		sp.SearchClick();
		
		checkOutPage cp = new checkOutPage(driver);
		cp.clickAddToCart();
		boolean cart =sp.AddCartDisplayed();
		Assert.assertEquals(cart, true);
		sp.searchClear();
	} 
	
	@Test(priority = 2)
	public void verify_successfully_checkedout() throws Exception {
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText("phone");
		sp.SearchClick();
		
		checkOutPage cp = new checkOutPage(driver);
		cp.clickAddToCart();
		cp.clickCheckout();
		cp.clickQuantity("5");
		cp.clickShippingAndTaxes();
		cp.SelectCountry("United States");
		cp.SelectState("Minnesota");
		cp.enterPostCode("55443");
		cp.clickGetQuotes();
		cp.clickFlatRateShipping();
		cp.clickApplyShipping();
		boolean sed = cp.shippingEstimateDisplayed();
		Assert.assertEquals(sed, true);
		cp.clickCheckOutProducts();
		boolean prods = cp.unavailableProductDisplayed();
		Assert.assertEquals(prods, true);
	}
	
	@Test(priority = 3 )
	public void verify_products_successfully_deleted() throws Exception {
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText("phone");
		sp.SearchClick();
		
		checkOutPage cp = new checkOutPage(driver);
		cp.clickAddToCart();
		cp.clickCheckout();
		cp.clickDelete();
		boolean cartEmpty = cp.shoppingCartEmptyDisplayed();
		Assert.assertEquals(cartEmpty, true);
		Thread.sleep(4000);
		
	} 
	
	@Test(priority = 4, dataProvider = "CheckOutData", dataProviderClass = dataProviders.class)
	public void verifyItemCountAndPrices_Matches_TotalPrice_(String ph, String quan, String rst) throws Exception {
		SearchProductsPage sp = new SearchProductsPage(driver);
		sp.enterSearchText(ph);
		sp.SearchClick();
		
		checkOutPage cp = new checkOutPage(driver);
		cp.clickAddToCart();
		cp.clickCheckout();
		cp.clickQuantity(quan);
		//Thread.sleep(3000);
		cp.clickRefresh();
		
		String expPrice = cp.totalText();
		//System.out.println(expPrice);
		String UnitPrice = cp.UnitPriceText();
		//System.out.println(UnitPrice);
		String ep =expPrice.replaceAll("[^\\d.]", "");  // Remove dollar sign and commas
		String up =UnitPrice.replaceAll("[^\\d.]", "");
		int quantity = Integer.parseInt(quan);
		Double UnitP = Double.parseDouble(up);
		double calculatedPrice = quantity * UnitP;
		double expP =Double.parseDouble(ep);
		
		
		
		if(calculatedPrice== expP) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
		cp.clickCheckOutProducts();
		
	} 

}
