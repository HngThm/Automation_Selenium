package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.UpdatePasswordPageFactory;

public class Day15_UpdatePasswordTest extends CommonBase{
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_TEDU);
	}
	 
	@Test
	public void updatePasswordSuccessfully() {
		UpdatePasswordPageFactory updatePass = new UpdatePasswordPageFactory(driver);
		updatePass.LoginFunction("hongthamng.43@gmail.com", "12345678");
		updatePass.UpdatePassword("12345678", "123456");
		assertTrue(driver.findElement(By.xpath("//div[text()='Đổi mật khẩu thành công. Mời bạn đăng nhập lại.']")).isDisplayed());
	}
	
}
