package automation.testsuite;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.Homework14_ChinhsuaPageFactory;
import automation.page.Homework14_DangKyPageFactory;
import automation.page.Homework14_LoginPageFactory;
import automation.page.Homework14_LogoutPageFactory;

public class Day14_Homework_TestFactory extends CommonBase{
	Homework14_DangKyPageFactory Dangky;
	Homework14_ChinhsuaPageFactory Chinhsua;
	Homework14_LoginPageFactory Login;
	Homework14_LogoutPageFactory Logout;
	
	String email = "tham17@gmail.com";
	String passwword = "123456";
	String passwword_new = "1234567";
	
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_ALADA);
	}

	@Test(priority = 1)
	public void DangKyThanhCong() throws InterruptedException {
		Dangky = new Homework14_DangKyPageFactory(driver);
		Dangky.Dangky_Function("Hồng Thắm", email, email, passwword, passwword, "0999999999");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
	
	}
	@Test (priority = 2)
	public void ChinhsuaThongTin() {
		try {
			//đang nhập vs pass luc dang ky
			Login = new Homework14_LoginPageFactory(driver);
			Login.LoginFunction(email, passwword);
			assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
			Thread.sleep(20000);
			Chinhsua = new Homework14_ChinhsuaPageFactory(driver);
			Chinhsua.Chinhsua_Function(passwword,passwword_new,passwword_new);
			
			Thread.sleep(5000);
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			assertTrue(alertText.equals("Cập nhật mật khẩu mới thành công!"));
			alert.accept();
			Thread.sleep(2000);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void LoginSuccessfully() {
		Login = new Homework14_LoginPageFactory(driver);
		Login.LoginFunction(email, passwword_new);
		assertTrue(driver.findElement(By.xpath("(//a[text()='Khóa học của tôi'])[1]")).isDisplayed());
		
	}

	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
	
//	public void LogoutSuccessfully() {
//	
//	Logout = new Homework14_LogoutPageFactory(driver);
//	Logout.LogoutFunction();
//	assertTrue(driver.findElement(By.xpath("//a[text()='Đăng Ký']")).isDisplayed());
//}
}
