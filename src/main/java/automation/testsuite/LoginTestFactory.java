package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPageFactory;
import automation.page.LogoutPageFactory;

public class LoginTestFactory extends CommonBase {

	LoginPageFactory loginFactory;
	LogoutPageFactory logoutFactory;

	@BeforeMethod
	public void openFirefox() {
		driver = initChromeDriver(CT_PageURLs.URL_CODESTAR);
	}

	@Test
	public void loginSuccessfully() throws InterruptedException {
		loginFactory = new LoginPageFactory(driver);
		loginFactory.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
		//goi logout
		Thread.sleep(10000);
		logoutFactory = new LogoutPageFactory(driver);
		logoutFactory.LogoutFunction();
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
	}
	
	@Test
	public void loginFail_IncorrectPassword() {
		loginFactory = new LoginPageFactory(driver);
		loginFactory.LoginFunction("admin@gmail.com", "123456");
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
	}
	
	@AfterMethod
	public void closeBrowser() {
		closeBrowser();
	}
}
