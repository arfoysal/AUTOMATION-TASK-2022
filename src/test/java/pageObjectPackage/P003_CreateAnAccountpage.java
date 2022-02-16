package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import utilitiesPackage.CommonMethods;

public class P003_CreateAnAccountpage extends CommonMethods {

	public P003_CreateAnAccountpage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(css = "label[for='id_gender1']")
	public WebElement mrTitle;

	@FindBy(css = "label[for='id_gender2']")
	public WebElement mrsTitle;

	@FindBy(id = "customer_firstname")
	public WebElement firstName;

	@FindBy(id = "customer_lastname")
	public WebElement lastName;

	@FindBy(id = "passwd")
	public WebElement passwordField;

	@FindBy(id = "days")
	public WebElement dayforDOB;

	@FindBy(id = "months")
	public WebElement monthforDOB;

	@FindBy(id = "years")
	public WebElement yearforDOB;

	@FindBy(id = "newsletter")
	public WebElement newsletter;

	@FindBy(id = "optin")
	public WebElement offer;

	@FindBy(id = "company")
	public WebElement companyNameField;

	@FindBy(id = "address1")
	public WebElement yourAddressOneField;

	@FindBy(id = "address2")
	public WebElement yourAddressTwoField;

	@FindBy(id = "city")
	public WebElement cityfield;

	@FindBy(id = "id_state")
	public WebElement stateSelect;

	@FindBy(id = "postcode")
	public WebElement postCode;

	@FindBy(id = "id_country")
	public WebElement countrySelect;

	@FindBy(id = "other")
	public WebElement otherInformationfield;

	@FindBy(id = "phone")
	public WebElement homePhonefield;

	@FindBy(id = "phone_mobile")
	public WebElement mobilePhoneField;

	@FindBy(id = "alias")
	public WebElement aliasfield;

	@FindBy(id = "submitAccount")
	public WebElement registerButton;

	@FindBy(className = "logout")
	public WebElement logoutButton;

	public void fillPersonalInformation(String fisrtname, String lastname, String password, String day, String mounth,
			String year) {
		mrTitle.click();
		sendText(firstName, fisrtname);
		sendText(lastName, lastname);
		sendText(passwordField, password);
		selectitem(dayforDOB, day);
		selectitem(monthforDOB, mounth);
		selectitem(yearforDOB, year);
		newsletter.click();
		offer.click();
	}

	public void fillYourAddress(String companyName, String addressone, String Addresstwo, String city, String statename,
			String zipCode, String countryname, String addiAddress, String homephone, String mobilephone,
			String alias) {
		sendText(companyNameField, companyName);
		sendText(yourAddressOneField, addressone);
		sendText(yourAddressTwoField, Addresstwo);
		sendText(cityfield, city);
		selectitem(stateSelect, statename);
		sendText(postCode, zipCode);
		selectitem(countrySelect, countryname);
		sendText(otherInformationfield, addiAddress);
		sendText(homePhonefield, homephone);
		sendText(mobilePhoneField, mobilephone);
		sendText(aliasfield, alias);
		registerButton.click();

	}
}
