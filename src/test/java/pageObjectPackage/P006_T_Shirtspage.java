package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import utilitiesPackage.CommonMethods;

public class P006_T_Shirtspage extends CommonMethods {
	public P006_T_Shirtspage() {
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
