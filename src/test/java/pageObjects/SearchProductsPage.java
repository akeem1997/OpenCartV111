package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductsPage extends BasePage {
	
	public SearchProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder='Search']") WebElement SearchText;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']") WebElement clickSearch;
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[1]") WebElement addCart;
	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]") WebElement noProduct;
	
	public void enterSearchText(String txt) {
		SearchText.sendKeys(txt);
	}
	public void searchClear() {
		SearchText.clear();
	}
	
	public void SearchClick() {
		clickSearch.click();
	}
	
	public boolean AddCartDisplayed() {
		try {
			return (addCart.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	public boolean noProductDisplayed() {
		try {
			return(noProduct.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	

}
