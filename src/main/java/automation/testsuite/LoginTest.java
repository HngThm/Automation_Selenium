package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.LoginPage;

public class LoginTest extends CommonBase{

	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_ALADA);
	}
	
	@Test
	public void loginSuccessfully() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("hongthamng.43@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
	}
	@Test
	public void loginFail_UsernameNotExist() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("hongthamng@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']")).isDisplayed());
	}
	
    @Test
    public void loginFail_PasswordInvalid() {
    	LoginPage login = new LoginPage(driver);
		login.LoginFunction("hongthamng.43@gmail.com", "1234567878");
		assertTrue(driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']")).isDisplayed());
	}
    
	@Test
 	public void loginFail_LeaveBlank() {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("", "");
		assertTrue(driver.findElement(By.xpath("//label[text()='Vui lòng nhập email']")).isDisplayed() 
				&& driver.findElement(By.xpath("//label[text()='Vui lòng nhập mật khẩu']")).isDisplayed() );
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
