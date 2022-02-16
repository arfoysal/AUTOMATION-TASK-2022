package testPackage;

import org.testng.annotations.Test;

import driverPackage.BaseDriver;
import pageObjectPackage.P001_Homepage;
import pageObjectPackage.P002_SignInpage;
import pageObjectPackage.P004_MyAccountpage;
import pageObjectPackage.P005_CasualDressespage;
import pageObjectPackage.P007_Cartpage;
import utilitiesPackage.DataSet;

public class T002_Login_And_Purchase extends BaseDriver {
	
	
	@Test(dataProvider = "userInfo", dataProviderClass = DataSet.class)
	public void loginAndPurchase(String email, String password) throws InterruptedException {
		P001_Homepage homepage = new P001_Homepage();
		P002_SignInpage signInpage = new P002_SignInpage();
		P004_MyAccountpage myAccountpage = new P004_MyAccountpage();
		P005_CasualDressespage casualDressespage = new P005_CasualDressespage();
		P007_Cartpage cartpage = new P007_Cartpage();
		Thread.sleep(4000);
		homepage.clickSignInButton();
		Thread.sleep(4000);
		signInpage.loginwithEmailPassword(email, password);
		Thread.sleep(4000);
		homepage.hoverAndClickCasualDresses();
		Thread.sleep(4000);
		casualDressespage.productAddToCart();
		Thread.sleep(4000);
		cartpage.clickContinueShopping();
		Thread.sleep(4000);
		homepage.clickOnTShirtsButton();
		Thread.sleep(4000);
		myAccountpage.clickSignOutButton();
		Thread.sleep(4000);

	}

}
