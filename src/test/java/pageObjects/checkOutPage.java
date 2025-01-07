package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class checkOutPage extends BasePage {
	
	public checkOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='Checkout']") WebElement checkout;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement addToCartSuccessful;
	@FindBy(xpath = "//span[contains(text(), \"Add to Cart\")]") WebElement AddToCart;
	@FindBy(xpath = "//div[@class=\"input-group btn-block\"]//input") WebElement Quantity;
	@FindBy(xpath = "//i[@class='fa fa-refresh']") WebElement Refresh;
	@FindBy(xpath ="//i[@class='fa fa-times-circle']") WebElement Delete;
	@FindBy(xpath = "//tbody//tr//td[6]") WebElement Total;
	@FindBy(xpath = "//a[@class='btn btn-primary']") WebElement CheckOutProducts;
	@FindBy(xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]") WebElement ShoppingCartEmpty;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement ProductsUnavailable;
	@FindBy(xpath = "//a[normalize-space()='Estimate Shipping & Taxes']") WebElement EstimateShippingAndTaxes;
	@FindBy(xpath = "//select[@id='input-country']") WebElement Country;
	@FindBy(xpath = "//select[@id='input-zone']") WebElement State;
	@FindBy(xpath = "//input[@id='input-postcode']") WebElement PostCode;
	@FindBy(xpath = "//button[@id='button-quote']") WebElement GetQuotes;
	@FindBy(xpath = "//input[@name='shipping_method']") WebElement FlatRate;
	@FindBy(xpath = "//input[@id='button-shipping']") WebElement ApplyShipping;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement ShippingEstimateApplied;
	@FindBy(xpath = "//tbody//tr//td[6]") WebElement total;
	@FindBy(xpath = "//div[@class=\"table-responsive\"]//tbody//td[@class=\"text-right\"][1]") WebElement unitPrice;
	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")List <WebElement> ItemsInCart;
	//div[@class=\"table-responsive\"]//tbody//td[@xpath=\"1\"]
	
	public void clickCheckout() {
		checkout.click();
	}
	
	public void clickQuantity(String num) {
		Quantity.clear();
		Quantity.sendKeys(num);
	}
	
	public void clickRefresh() {
		Refresh.click();
	}
	
	public void clickDelete() {
		Delete.click();
	}
	
	public String getTotalText() {
		try {
			return(Total.getText());
		} catch (Exception e) {
			return(e.getMessage());
		}
	}
	
	public boolean shoppingCartEmptyDisplayed() {
		try {
			return(ShoppingCartEmpty.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean SuccessfullyAddedDisplayed() {
		try {
			return(addToCartSuccessful.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	public void clickCheckOutProducts() {
		CheckOutProducts.click();
	}
	public boolean unavailableProductDisplayed() {
		try {
			return(ProductsUnavailable.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	public void clickAddToCart() {
		AddToCart.click();
	}
	
	public void clickShippingAndTaxes() {
		EstimateShippingAndTaxes.click();
	}
	
	public void SelectCountry(String data) {
		Select s = new Select(Country);
		s.selectByVisibleText(data);
		
	}
	public void SelectState(String data) {
		Select s = new Select(State);
		s.selectByVisibleText(data);
	}
	
	public void enterPostCode(String data) {
		PostCode.sendKeys(data);
	}
	
	public void clickGetQuotes() {
		GetQuotes.click();
	}
	
	public void clickFlatRateShipping() {
		FlatRate.click();
	}
	public void clickApplyShipping() throws Exception {
		ApplyShipping.click();
		Thread.sleep(3000);
	}
	
	public boolean shippingEstimateDisplayed() {
		try {
			return(ShippingEstimateApplied.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	public String totalText() {
		try {
			return(total.getText());
		} catch (Exception e) {
			return(e.getMessage());
		}
	}
	
	public String UnitPriceText() {
		try {
			return(unitPrice.getText());
		} catch (Exception e) {
			return(e.getMessage());
		}
	}
	public List<WebElement> ItemsInCartss() {
		return ItemsInCart;
	}

}
