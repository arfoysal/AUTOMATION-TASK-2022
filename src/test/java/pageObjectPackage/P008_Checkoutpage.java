package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import utilitiesPackage.CommonMethods;

public class P008_Checkoutpage extends CommonMethods {
	public P008_Checkoutpage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(css = "a[title='Log in to your customer account']")
	public WebElement signInButton;

	@FindBy(id = "com.continuum.emi.calculator:id/btnCompare")
	public WebElement compareLoansBtnElement;

	public void clickSignInButton() {
		signInButton.click();
	}
}
