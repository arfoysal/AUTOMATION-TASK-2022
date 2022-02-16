package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import utilitiesPackage.CommonMethods;

public class P005_CasualDressespage extends CommonMethods {
	public P005_CasualDressespage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(className = "product-container")
	public WebElement product;

	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	public WebElement addToCartButton;

	public void productAddToCart() {
		scrollToElement(product);
		hover(product);
		addToCartButton.click();
		timeOut();
	}
}
