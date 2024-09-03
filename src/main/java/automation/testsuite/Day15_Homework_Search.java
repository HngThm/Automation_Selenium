package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.UpdatePasswordPageFactory;

public class Day15_Homework_Search extends CommonBase {
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_TEDU);
	}
	
	@Test
	public void searchSuccessfully() {
		UpdatePasswordPageFactory search = new UpdatePasswordPageFactory(driver);
		search.LoginFunction("hongthamng.43@gmail.com", "123456");
		search.SearchSuccessfully("ASP Net");
		assertTrue(driver.findElement(By.xpath("//a[text()='Bài 52: Gửi phản hồi và gửi mail trong ASP NET sử dụng SMTP']")).isDisplayed());
		
	}

}
