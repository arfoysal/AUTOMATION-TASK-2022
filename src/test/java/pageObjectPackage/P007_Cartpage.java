package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import utilitiesPackage.CommonMethods;

public class P007_Cartpage extends CommonMethods{
	public P007_Cartpage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(xpath = "//span[@title='Continue shopping']//span[1]")
	public WebElement continueShoppingButton;

	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	public WebElement proceedToCheckoutButton;
	
	
	public void clickContinueShopping() {
		continueShoppingButton.click();
		timeOut();
	}
	
	public void clickProceedToCheckout() {
		proceedToCheckoutButton.click();
	}
}
