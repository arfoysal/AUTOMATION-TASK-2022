package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import utilitiesPackage.CommonMethods;
import utilitiesPackage.Timeout;

public class P001_Homepage extends CommonMethods {
	public P001_Homepage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	Timeout timer = new Timeout();

	@FindBy(css = "a[title='Log in to your customer account']")
	public WebElement signInButton;

	@FindBy(xpath = "(//a[@title='Dresses'])[2]")
	public WebElement dressesButton;

	@FindBy(xpath = "(//a[@title='Casual Dresses'])[2]")
	public WebElement CasualDressesButton;

	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	public WebElement tShirtsButton;

	public void clickSignInButton() {
		signInButton.click();
		timer.waitForPageLoad();
	}

	public void hoverAndClickCasualDresses() {
		hover(dressesButton);
		CasualDressesButton.click();
	}

	public void clickOnTShirtsButton() {
		tShirtsButton.click();
	}

}
