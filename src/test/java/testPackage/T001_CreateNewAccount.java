package testPackage;

import org.testng.annotations.Test;

import driverPackage.BaseDriver;
import pageObjectPackage.P001_Homepage;
import pageObjectPackage.P002_SignInpage;
import pageObjectPackage.P003_CreateAnAccountpage;
import pageObjectPackage.P004_MyAccountpage;
import utilitiesPackage.DataSet;

public class T001_CreateNewAccount extends BaseDriver {

	@Test(dataProvider = "data", dataProviderClass = DataSet.class)
	public void registration(String email, String firstname, String lastname, String password, String day,
			String mounth, String year, String companyName, String addressone, String Addresstwo, String city,
			String statename, String zipCode, String countryname, String addiAddress, String homephone,
			String mobilephone, String alias) throws InterruptedException {
		
		P001_Homepage homepage = new P001_Homepage();
		P002_SignInpage signInpage = new P002_SignInpage();
		P003_CreateAnAccountpage register = new P003_CreateAnAccountpage();
		P004_MyAccountpage myAccountpage = new P004_MyAccountpage();
		
		homepage.clickSignInButton();
		signInpage.createAccountWithEmail(email);
		
		Thread.sleep(3000);
		register.fillPersonalInformation(firstname, lastname, password, day, mounth, year);
		register.fillYourAddress(companyName, addressone, Addresstwo, city, statename, zipCode, countryname,
				addiAddress, homephone, mobilephone, alias);
		Thread.sleep(2000);
		myAccountpage.clickSignOutButton();
		Thread.sleep(2000);

	}

}
