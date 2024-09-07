package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day16_BTVN_Bai3 extends CommonBase {
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_GURU_ALERT);
	}
	
	@Test
	public void alert() {
		type(By.name("cusid"), "123456");
		click(By.name("submit"));
		waitAlert();
		driver.switchTo().alert().accept();
		String actualMessage = driver.switchTo().alert().getText();
		assertEquals(actualMessage,"Customer Successfully Delete!");
		driver.switchTo().alert().accept();
		driver.getTitle();
	}

}
