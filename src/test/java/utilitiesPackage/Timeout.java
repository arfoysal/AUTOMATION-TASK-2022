package utilitiesPackage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverPackage.PageDriver;

public class Timeout {
	WebDriverWait wait;

	
	public void timeOut() {
		try {
			Thread.sleep(2000);
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void timeOut(int duretionMS) {
		try {
			Thread.sleep(duretionMS);
		} catch ( InterruptedException e) {
			e.printStackTrace();
		}
	}
	public Alert alertWait() {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}
	public void waitForEl(By locator) {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public void waitForPageLoad() {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		wait.until((ExpectedCondition<Boolean>) wd ->  
				((JavascriptExecutor) wd ).executeScript("return document.readyState;")
				.equals("complete"));
	}

}
