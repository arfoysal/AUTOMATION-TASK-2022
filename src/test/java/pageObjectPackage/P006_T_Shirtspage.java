package pageObjectPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverPackage.PageDriver;
import utilitiesPackage.CommonMethods;

public class P006_T_Shirtspage extends CommonMethods {
	public P006_T_Shirtspage() {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
	}

	@FindBy(id = "layered_id_attribute_group_14")
	public WebElement filterBlueColorCheckbox;

	@FindBy(className = "product-container")
	public WebElement product;

	@FindBy(xpath = "//span[normalize-space()='Add to cart']")
	public WebElement addToCartButton;

	public void filterBlueColor() {
		filterBlueColorCheckbox.click();
		timeOut();
	}

	public void productAddToCart() {
		scrollToElement(product);
		hover(product);
		addToCartButton.click();
		timeOut();
	}
}
