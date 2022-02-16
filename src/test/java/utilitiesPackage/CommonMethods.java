package utilitiesPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverPackage.PageDriver;

public class CommonMethods {
	
	/**************************
	 * Get Current Page URL * 
	 * ************************
	 */

	public String currentPageUrl() {
		return PageDriver.getCurrentDriver().getCurrentUrl();
	}
	
	/**************************
	 * Get Current Page Title * 
	 * ************************
	 */
	
	public String getTitle() {
		return PageDriver.getCurrentDriver().getTitle();
	}
	
	/**************************
	 * Write in a input field * 
	 * ************************
	 */

	public void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	/******************************
	 * Perform Hover on a element * 
	 * ****************************
	 */

	public void hover(WebElement element) {
		Actions actions = new Actions(PageDriver.getCurrentDriver());
		actions.clickAndHold(element).build().perform();
	}
	
	/***********************************
	 * Handle shadow Dome Related Task * 
	 * *********************************
	 */

	public void shadowDomePopUp(WebElement host, By btn) {
		// Finding the ShadowRoot in a WebElement
		SearchContext context = host.getShadowRoot();
		// finding the targeted element
		context.findElement(btn).click();
	}
	
	/******************************************
	 * Handle Select Tag Related Element Task * 
	 * ****************************************
	 */

	public void selectitem(WebElement element, String value) {
		Select selectItems = new Select(element);
		selectItems.selectByValue(value);
	}

	public String selecteditemText(WebElement element) {
		Select selectItems = new Select(element);
		return selectItems.getFirstSelectedOption().getText();
	}

	public Boolean itemSelectStatus(List<WebElement> elements, String value) {
		for (WebElement element : elements) {
			if (element.getAttribute("value").equals(value)) {
				return element.isSelected();
			}
		}
		return false;
	}
	
	/*************************************
	 * Handle List elements Related Task * 
	 * ***********************************
	 */
	
	public void clickOnNthNumberButton(List<WebElement> elements, int position) {
		elements.get(position - 1).click();
	}
	
	public void listitem(List<WebElement> elements, String visibleText) {
		for (WebElement element : elements) {
			if (element.getText().equals(visibleText)) {
				element.click();
				break;
			}
		}
	}
	
	
	
	/**********************************
	 * Handle JavaScript Related Task * 
	 * ********************************
	 */

	public void clickOnAButtonJs(String script) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript(script + ".click();");
	}

	public void highlighter(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;background: beige');", element);
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollInsideElement(String cssLocator, int offsetX, int offsetY) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("document.querySelector('" + cssLocator + "').scrollBy(" + offsetX + "," + offsetY + ");");
	}

	/****************************
	 * Handle Wait Related Task * 
	 * **************************
	 */
	WebDriverWait wait;

	public void timeOut() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void timeOut(int duretionMS) {
		try {
			Thread.sleep(duretionMS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Alert waitForAlert() {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		return alert;
	}

	public void waitForElement(By locator) {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForPageLoad() {
		wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(30));
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState;").equals("complete"));
	}

	/*****************************
	 * Handle Alert Related Task * 
	 * ***************************
	 */

	public void alertAccept() {
		Alert alert = waitForAlert();
		alert.accept();
	}

	public void allertAccep(String value) {
		Alert alert = waitForAlert();
		alert.sendKeys(value);
		alert.accept();
	}

	public void alertDismiss() {
		Alert alert = waitForAlert();
		alert.dismiss();
	}

}
