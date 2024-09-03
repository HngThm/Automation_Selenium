package automation.testsuite;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class HandleDatePicker extends CommonBase{
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_GURU99);
	}
	
	@Test
	public void inputBirthDay() {
		WebElement bdayText = driver.findElement(By.name("bdaytime"));
		bdayText.sendKeys("20112002");
		bdayText.sendKeys(Keys.TAB);
		bdayText.sendKeys("0900AM");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		assertTrue(driver.findElement(By.xpath("//div[contains(text(),'2002-11-20')]")).isDisplayed());
	}
}
