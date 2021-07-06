package utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class ReusableMethods {

//	Declaring static variable for currentwindow
	public static String currentWindow;

//	Method to switch window handle
	public static void switchWindow(WebDriver driver) {
		currentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String windows : windowHandles) {
			if (!windows.equalsIgnoreCase(currentWindow)) {
				driver.switchTo().window(windows);
			}
		}
	}

//	Method to switch window handle and close parent handle
	public static void switchWindowClose(WebDriver driver) {
		currentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		driver.close();
		for (String windows : windowHandles) {
			if (!windows.equalsIgnoreCase(currentWindow)) {
				driver.switchTo().window(windows);
			}
		}
	}

//	Method to switch back to parent handle and close current handle
	public static void switchBackClose(WebDriver driver) {
		driver.close();
		driver.switchTo().window(currentWindow);
	}

//	Method to switch back to parent window handle
	public static void switchBackWindow(WebDriver driver) {
		driver.switchTo().window(currentWindow);
	}
}
