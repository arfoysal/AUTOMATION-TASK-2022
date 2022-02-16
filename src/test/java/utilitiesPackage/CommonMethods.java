package utilitiesPackage;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import driverPackage.PageDriver;

public class CommonMethods {

	public String currentPageUrl() {
		return PageDriver.getCurrentDriver().getCurrentUrl();
	}

	public String getTitle() {
		return PageDriver.getCurrentDriver().getTitle();
	}


	public void clickOnNthNumberButton(By btn, int position) {
		List<WebElement> allElements = PageDriver.getCurrentDriver().findElements(btn);
		allElements.get(position - 1).click();

	}

	public String getText(By element) {
		return PageDriver.getCurrentDriver().findElement(element).getText();
	}

	public int getSize(By element) {
		return PageDriver.getCurrentDriver().findElements(element).size();
	}

	public String getAttributeValue(By element, String attribute) {
		return PageDriver.getCurrentDriver().findElement(element).getAttribute(attribute);
	}

	public List<WebElement> getEls(By element) {
		return PageDriver.getCurrentDriver().findElements(element);
	}

	public void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void hover(WebElement element) {
		Actions actions = new Actions(PageDriver.getCurrentDriver());
		actions.clickAndHold(element).build().perform();
	}

	public void shadowDomPopUp(By host, By btn) {
		WebElement shadowDomHostElement = PageDriver.getCurrentDriver().findElement(host);
		// Finding the ShadowRoot in a WebElement
		SearchContext context = shadowDomHostElement.getShadowRoot();
		// finding the targeted element
		context.findElement(btn).click();
	}

	public void selectitem(WebElement element, String value) {
		Select selectItems = new Select(element);
		selectItems.selectByValue(value);;

	}

	public String currentlySelecteditem(By element) {
		Select selectItems = new Select(PageDriver.getCurrentDriver().findElement(element));
		return selectItems.getFirstSelectedOption().getText();

	}

	public void listitem(By element, String visibleText) {
		List<WebElement> listItems = PageDriver.getCurrentDriver().findElements(element);
		for (WebElement item : listItems) {
			if (item.getText().equals(visibleText)) {
				item.click();
				break;
			}
		}
	}

	public Boolean itemSelecteStatus(By element, String value) {
		List<WebElement> listItems = PageDriver.getCurrentDriver().findElements(element);
		for (WebElement item : listItems) {
			if (item.getAttribute("value").equals(value)) {
				return item.isSelected();
			}
		}
		return false;
	}

	public void clickOnAButtonJs(String script) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		// WebElement el = (WebElement)(js.executeScript("return "+ script));
		// js.executeScript("arguments[0].click();" ,el);
		js.executeScript(script + ".click();");
	}

	public void highlighter(By element) {
		WebElement el = PageDriver.getCurrentDriver().findElement(element);
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("arguments[0].setAttribute('style','border:2px solid red;background: beige');", el);

	}

	public void scorllToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scorllInsideElement(String cssLocator, int offsetX, int offsetY) {
		JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		js.executeScript("document.querySelector('" + cssLocator + "').scrollBy(" + offsetX + "," + offsetY + ");");
	}

	/*
	 * public void windows() { Set<String> handles =
	 * PageDriver.getCurrentDriver().getWindowHandles(); }
	 */
	public void windowHandle() {
		String parent = PageDriver.getCurrentDriver().getWindowHandle();
		Set<String> handles = PageDriver.getCurrentDriver().getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(parent)) {
				PageDriver.getCurrentDriver().switchTo().window(handle);
			}
		}
	}
}
