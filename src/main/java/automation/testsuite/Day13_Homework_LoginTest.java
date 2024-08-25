package automation.testsuite;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.Homework13_HuyLogoutPage;
import automation.page.Homework13_LoginPageLocator;
import automation.page.Homework13_LogoutPage;
import automation.page.LogoutPageFactory;

public class Day13_Homework_LoginTest extends CommonBase {

	@BeforeMethod
	public void openFirefox() {
		driver = initFirefoxDriver(CT_PageURLs.URL_CODESTAR);
	}
	@Test
	public void loginSuccessfully() {
		Homework13_LoginPageLocator login = new Homework13_LoginPageLocator(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
	}

	@Test
	public void loginFail_UsernameNotExist() {
		Homework13_LoginPageLocator login = new Homework13_LoginPageLocator(driver);
		login.LoginFunction("ad@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
	}

	@Test
	public void loginFail_PasswordInvalid() {
		Homework13_LoginPageLocator login = new Homework13_LoginPageLocator(driver);
		login.LoginFunction("admin@gmail.com", "123");
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
	}

	@Test
	public void loginFail_LeaveBlank() {
		Homework13_LoginPageLocator login = new Homework13_LoginPageLocator(driver);
		login.LoginFunction("", "");
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
	}
	
	@Test
	public void logoutSuccessfully() throws InterruptedException {
		loginSuccessfully(); //goi lại hàm login thành công
		//gọi logout
		Thread.sleep(10000);
		Homework13_LogoutPage logout = new Homework13_LogoutPage(driver);
		logout.LogoutFunction();
	    Thread.sleep(5000);
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
	}
	
	@Test
	public void logoutNotSuccess() throws InterruptedException {
		loginSuccessfully();
		//gọi logout
		Thread.sleep(10000);
		Homework13_HuyLogoutPage logout = new Homework13_HuyLogoutPage(driver);
		logout.LogoutFunction();
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
	}
	 
	@AfterMethod
	public void closeFirefox() {
		driver.close();
	}
}
