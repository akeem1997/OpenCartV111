package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class wishListPage extends BasePage {
	
	public wishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='product-product']//div[@class='btn-group']//button[1]") WebElement WishList;
	@FindBy(xpath = "//i[@class='fa fa-exchange']") WebElement compare;
	@FindBy(xpath = "//input[@id='input-quantity']") WebElement qty;
	@FindBy(xpath = "//button[@id='button-cart']") WebElement AddToCart;
	@FindBy(xpath = "//a[normalize-space()='Write a review']") WebElement WriteAReview;
	@FindBy(xpath = "//input[@id='input-name']") WebElement Name;
	@FindBy(xpath = "//textarea[@id='input-review']") WebElement YourReview;
	@FindBy(xpath = "//body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[4]/div[1]/input[1]") WebElement BadRate;
	@FindBy(xpath = "//input[@value='2']") WebElement fairRate;
	@FindBy(xpath = "//input[@value='3']") WebElement goodRate;
	@FindBy(xpath = "//input[@value='4']") WebElement BetterRate;
	@FindBy(xpath = "//input[@value='5']") WebElement BestRate;
	@FindBy(xpath = "//button[@id='button-review']") WebElement Continue;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement SelectReviewRating;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement ThankYouReview;
	
	
	public void clickWishList() {
		WishList.click();
	}
	
	public void clickCompare() {
		compare.click();
	}
	
	public void EnterQuant(String input) {
		qty.sendKeys(input);
	}
	
	public void clearQuant() {
		qty.clear();
	}
	
	public void clickAddToCart() {
		AddToCart.click();
	}
	
	public void clickWriteAReview() {
		WriteAReview.click();
	}
	
	public void EnterName(String nm) {
		Name.sendKeys(nm);
	}
	
	public void clearName() {
		Name.clear();
	}
	
	public void EnterYourReview(String rv) {
		YourReview.sendKeys(rv);
	}
	
	public void clickBadRate() {
		BadRate.click();
	}
	
	public void clickfairRate() {
		fairRate.click();
	}
	
	public void clickgoodRate() {
		goodRate.click();
	}
	
	public void clickBetterRate() {
		BetterRate.click();
	}
	
	public void clickBestRate() {
		BestRate.click();
	}
	
	public void clickContinue() {
		Continue.click();
	}
	
	public boolean SelectReviewRatingIsDisplayed() {
		try {
			return(SelectReviewRating.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean ThankYouReviewIsDisplayed() {
		try {
			return(ThankYouReview.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}


}
