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

	@FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
	public WebElement SummaryProceedToCheckoutButton;

	@FindBy(name = "message")
	public WebElement commentField;

	@FindBy(css = "button[name='processAddress'] span")
	public WebElement addressProceedToCheckoutButton;

	@FindBy(id = "cgv")
	public WebElement termsOfServiceCheckbox;

	@FindBy(css = "button[name='processCarrier'] span")
	public WebElement shippingProceedToCheckoutButton;

	@FindBy(css = "a[title='Pay by check.']")
	public WebElement payByCheck;

	@FindBy(xpath = "//span[normalize-space()='I confirm my order']")
	public WebElement confirmMyOrderButton;

	public void clickSummaryProceedToCheckout() {
		scrollToElement(SummaryProceedToCheckoutButton);
		SummaryProceedToCheckoutButton.click();
		timeOut();
	}

	public void addCommentAndProceedToCheckout(String comment) {
		scrollToElement(addressProceedToCheckoutButton);
		sendText(commentField, comment);
		addressProceedToCheckoutButton.click();
		timeOut();
	}
	
	public void checkTOSAndProceedToCheckout() {
		scrollToElement(shippingProceedToCheckoutButton);
		termsOfServiceCheckbox.click();
		shippingProceedToCheckoutButton.click();
		timeOut();
	}
	
	public void clickPaybyCheque() {
		scrollToElement(payByCheck);
		payByCheck.click();
		timeOut();
	}
	
	public void clickConfirmOrder() {
		confirmMyOrderButton.click();
		timeOut();
	}
}
