package page.objectpackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverpackage.PageDriver;
import io.qameta.allure.Step;
import utilitiespackage.CommonMethods;

public class P004_MyAccountpage extends CommonMethods {
	public P004_MyAccountpage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(css = "a[title='Log me out']")
	public WebElement signOutButton;
	
	@FindBy(css = "a[title='View my customer account'] span")
	public WebElement userName;
	

	@Step("Click on Sign Out Button")
	public void clickSignOutButton() {
		signOutButton.click();

	}
}
