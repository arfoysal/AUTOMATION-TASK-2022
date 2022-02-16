package utilitiesPackage;

import org.openqa.selenium.Alert;

public class Browser_Alerts {
	Timeout time = new Timeout();
	
	public void accept() {
		Alert alert = time.alertWait();
		alert.accept();

	}
	public void accept(String value) {
		Alert alert = time.alertWait();
		alert.sendKeys(value);
		alert.accept();

	}
	public void dismiss() {
		Alert alert = time.alertWait();
		alert.dismiss();

	}
}
