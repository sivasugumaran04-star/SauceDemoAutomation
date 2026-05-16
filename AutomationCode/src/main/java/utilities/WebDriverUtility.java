package Utilities;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import Utilities.Java_utilities;

public class WebDriverUtility {

	public static void takeScreenshot(WebDriver driver) {
		  
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  File trg = new File("./Screenshots/DWS_"+Java_utilities.getName()+".png");
		  try {
		   FileHandler.copy(src, trg);//./Screenshots/iphone"+count+".png
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		 }
		 public static void takeScreenshot(WebElement element) {
		  
		  File src = element.getScreenshotAs(OutputType.FILE);
		  File trg = new File("./Screenshots/DWS_WE"+Java_utilities.getName()+ ".png");
		  try {
		   FileHandler.copy(src, trg);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		 }

	public static void selectDropDownOption(WebElement element, String option) {
		Select sel = new Select(element);
		sel.selectByVisibleText(option);
	}

	public static void deselectDropDownOption(WebElement element, String option) {
		Select sel = new Select(element);
		if (sel.isMultiple()) {
			sel.deselectByVisibleText(option);
		} else {
			throw new UnsupportedOperationException("De-selection not possiblein single select Dropdown");
		}
	}

	public static List<WebElement> getDropdownOptions(WebElement element) {
		Select sel = new Select(element);
		return sel.getOptions();
	}

	public static void click(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void eneterData(WebDriver driver, WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + data + "';", element);
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void switchToWindow(WebDriver driver, String title) {
		String perant = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		allWindows.remove(perant);
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(title)) {
				break;

			}
		}
	}
}
