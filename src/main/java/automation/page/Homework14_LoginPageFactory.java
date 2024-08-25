package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homework14_LoginPageFactory {
	
	private WebDriver driver;
	@FindBy(xpath = "//a[text()='Đăng Nhập']") WebElement btnDangNhap;
	//c2: private WebElement textEmail;
	@FindBy (id = "txtLoginUsername") WebElement textEmail;
	@FindBy (id = "txtLoginPassword") WebElement textPassword;
	@FindBy (xpath = "//button[text()='ĐĂNG NHẬP' and @type='submit']") WebElement btnLogin;
	public Homework14_LoginPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void LoginFunction(String email, String password) {
		btnDangNhap.click();
		textEmail.sendKeys(email);
		textPassword.sendKeys(password);
		btnLogin.click();
	}

}
