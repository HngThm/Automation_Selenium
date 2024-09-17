package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.UpdatePasswordPageFactory;

public class Day15_UpdatePasswordTest extends CommonBase{
	
	@BeforeMethod
	@Parameters("browser")
	public void openChrome(@Optional("firefox") String browserName) {
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_TEDU);
		//driver = initMSEdgeDriver(CT_PageURLs.URL_TEDU);
	}
	 
	@Test
	public void updatePasswordSuccessfully() {
		UpdatePasswordPageFactory updatePass = new UpdatePasswordPageFactory(driver);
		updatePass.LoginFunction("hongthamng.43@gmail.com", "123456");
		updatePass.UpdatePassword("123456", "123456");
		assertTrue(driver.findElement(By.xpath("//div[text()='Đổi mật khẩu thành công. Mời bạn đăng nhập lại.']")).isDisplayed());
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
