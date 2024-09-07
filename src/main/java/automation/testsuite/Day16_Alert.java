package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day16_Alert extends CommonBase{
	@BeforeMethod
	public void openChrome() {
		driver = initFirefoxDriver(CT_PageURLs.URL_AUTOMATIONTESTING);
	}
	
	@Test(priority = 1)
	public void verifyAlertMessage() {
		click(By.xpath("//a[normalize-space()='Alert with Textbox']"));
		click(By.xpath("//button[@class='btn btn-info']"));
		waitAlert();
		String actualMessage = driver.switchTo().alert().getText();
		assertEquals(actualMessage,"Please enter your name");
	}
	@Test(priority = 2)
	public void pressOkOnAlert() {
		click(By.xpath("//a[normalize-space()='Alert with Textbox']"));
		click(By.xpath("//button[@class='btn btn-info']"));
		waitAlert();
		driver.switchTo().alert().sendKeys("Thắm");
		driver.switchTo().alert().accept();
		WebElement helloLabel = getElementPresentDOM(By.id("demo1"));
		assertEquals(helloLabel.getText(), "Hello Thắm How are you today");
	}
	
	@Test(priority = 3)
	public void pressCancelOnAlert() {
		click(By.xpath("//a[normalize-space()='Alert with Textbox']"));
		click(By.xpath("//button[@class='btn btn-info']"));
		waitAlert();
		driver.switchTo().alert().sendKeys("Thắm");
		driver.switchTo().alert().dismiss();
		assertFalse(isElementVisibility(By.id("demo1")));
	}
}
