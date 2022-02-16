package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import utilitiesPackage.CommonMethods;
import utilitiesPackage.Timeout;

public class P004_MyAccountpage extends CommonMethods {
	public P004_MyAccountpage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	Timeout timer = new Timeout();

	@FindBy(css = "a[title='Log me out']")
	public WebElement signOutButton;

	public void clickSignOutButton() {
		signOutButton.click();
		timer.waitForPageLoad();
	}
}
