package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day18_BTVN_Bai2 extends CommonBase{
	
	@BeforeMethod
	@Parameters("browser")
	public void openChrome(String browserName) {
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_BEPANTOAN);
}

@Test
public void handleWindowMessenger() {
	click(By.xpath("(//span[text()='Chat với chúng tôi'])[1]"));
	String mainWindow = driver.getWindowHandle();
	System.out.println("main Window: "+  mainWindow);
	Set<String> listWindows = driver.getWindowHandles();
	for(String windowItem:listWindows) {
		System.out.println("window is: " + windowItem);
		if(!windowItem.equals(mainWindow)) {
			driver.switchTo().window(windowItem);
			pause(3000);
			assertTrue(isElementVisibility(By.xpath("//h2[text()='Connect with your favourite people']")));
			driver.close();
		}
	}
	driver.switchTo().window(mainWindow);
	assertTrue(isElementVisibility(By.xpath("//span[text()='Danh mục sản phẩm']")));
}

@AfterMethod
public void closeChrome() {
	driver.close();
}

}
