package utilitiesPackage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import driverPackage.PageDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class Take_Screenshot {

	public void screenshot(String name) throws IOException {
		String strtime = setdate();
		File scFile = ((TakesScreenshot) PageDriver.getCurrentDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scFile, new File("./image/" + strtime + "_" + name + ".png"));
	}

	public void screenshot(String name, WebElement element) throws IOException {
		String strtime = setdate();
		File scFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scFile, new File("./image/" + strtime + name + ".png"));
	}

	@Step("Taking a screenshot for {0}")
	public static void takeScreenShot(String name) {
		Allure.addAttachment(name, new ByteArrayInputStream(
				((TakesScreenshot) PageDriver.getCurrentDriver()).getScreenshotAs(OutputType.BYTES)));
	}

	public String setdate() {
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyymmdd_HHmmss");
		String strdate = formatter.format(date);
		return strdate;
	}

}
