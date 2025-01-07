package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {
	
	//WebDriver driver;
	
	public Homepage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement lnkMyaccount;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") WebElement lnkRegister;
	@FindBy(xpath = "//a[normalize-space()='Login']") WebElement linkLogin;
	@FindBy(xpath = "//span[normalize-space()='Wish List (0)']") WebElement WishList;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement WishListDisplayed;
	
	
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click(); 
	}
	
	public void clickLogin() {
		linkLogin.click();
	}
	
	public void clickWishlist() {
		WishList.click();
	}
	public boolean wishListIsDisplayed() {
		try {
			return(WishListDisplayed.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	
	

}
