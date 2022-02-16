package testPackage;

import org.testng.annotations.Test;

import driverPackage.BaseDriver;
import pageObjectPackage.P001_Homepage;
import pageObjectPackage.P002_SignInpage;
import pageObjectPackage.P004_MyAccountpage;
import pageObjectPackage.P005_CasualDressespage;
import pageObjectPackage.P006_T_Shirtspage;
import pageObjectPackage.P007_Cartpage;
import pageObjectPackage.P008_Checkoutpage;
import utilitiesPackage.DataSet;

public class T002_Login_And_Purchase extends BaseDriver {

	@Test(dataProvider = "userInfo", dataProviderClass = DataSet.class)
	public void loginAndPurchase(String email, String password, String comment) {
		P001_Homepage homepage = new P001_Homepage();
		P002_SignInpage signInpage = new P002_SignInpage();
		P004_MyAccountpage myAccountpage = new P004_MyAccountpage();
		P005_CasualDressespage casualDressespage = new P005_CasualDressespage();
		P006_T_Shirtspage t_Shirtspage = new P006_T_Shirtspage();
		P007_Cartpage cartpage = new P007_Cartpage();
		P008_Checkoutpage checkoutpage = new P008_Checkoutpage();

		homepage.clickSignInButton();

		signInpage.waitForPageLoad();
		signInpage.loginwithEmailPassword(email, password);

		homepage.hoverAndClickCasualDresses();
		casualDressespage.waitForPageLoad();
		casualDressespage.productAddToCart();
		cartpage.clickContinueShopping();

		homepage.clickOnTShirtsButton();
		t_Shirtspage.waitForPageLoad();
		t_Shirtspage.filterBlueColor();
		t_Shirtspage.productAddToCart();

		cartpage.clickProceedToCheckout();
		checkoutpage.waitForPageLoad();
		checkoutpage.clickSummaryProceedToCheckout();
		checkoutpage.addCommentAndProceedToCheckout(comment);
		checkoutpage.checkTOSAndProceedToCheckout();

		checkoutpage.clickPaybyCheque();
		checkoutpage.clickConfirmOrder();

		myAccountpage.clickSignOutButton();
	}

}
