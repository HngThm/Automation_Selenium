package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day16_BTVN_Bai1 extends CommonBase{
	
	String email = "hongthamng.43@gmail.com";
	String passwword = "123456";
	String passwword_new = "12345678"; 
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_ALADA_ALERT);
	}

	@Test
	public void acceptAlert() {
		type(By.id("txtLoginUsername"), email);
		type(By.id("txtLoginPassword"), passwword);
		click(By.xpath("//button[text()='ĐĂNG NHẬP' and @type='submit']"));
		click(By.xpath("//div[@class='avatar2']/descendant::img"));
		click(By.xpath("//a[text()='Chỉnh sửa thông tin']"));
		scrollToElement(By.xpath("//div[text()='Thông tin đăng nhập']"));
		type(By.id("txtpassword"), passwword);
		type(By.id("txtnewpass"), passwword_new);
		type(By.id("txtrenewpass"), passwword_new);
		click(By.xpath("//button[text()='Lưu mật khẩu mới']"));
		waitAlert();
		String actualMessage = driver.switchTo().alert().getText();
		assertEquals(actualMessage,"Cập nhật mật khẩu mới thành công!");
		driver.switchTo().alert().accept();
		driver.getTitle();
	}
}
