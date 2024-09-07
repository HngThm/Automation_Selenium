package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day16_BTVN_Bai2 extends CommonBase{
	
	@BeforeMethod
	public void openFirefox() {
		driver = initFirefoxDriver(CT_PageURLs.URL_SELENIUM_PRACTISE);
	}
	
	@Test
	public void verifyMessageAlert() {
		click(By.xpath("//button[text()='Try it']"));
		waitAlert();
		String actualMessage = driver.switchTo().alert().getText();
		assertEquals(actualMessage,"Welcome to Selenium WebDriver Tutorials");
		driver.switchTo().alert().accept();
	}

}
