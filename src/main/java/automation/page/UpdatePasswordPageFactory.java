package automation.page;

import java.security.PublicKey;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.*;

public class UpdatePasswordPageFactory {
	
	private WebDriver driver;
	@FindBy(id = "UserName") WebElement textEmail;
	//c2: private WebElement textEmail;
	@FindBy (id = "Password") WebElement textPassword;
	@FindBy (xpath = "//button[text()='Đăng nhập']") WebElement buttonLogin;
	@FindBy(id = "my_account") WebElement btnAvatar;
	@FindBy(xpath = "//a[@title='Đổi mật khẩu']") WebElement btnUpdatePass;
	@FindBy(id = "OldPassword") WebElement textOldPass;
	@FindBy(id = "NewPassword") WebElement textNewPass;
	@FindBy(id = "ConfirmNewPassword") WebElement textConfirmNewPass;
	@FindBy(id = "onesignal-slidedown-cancel-button") WebElement cancelButton;
	@FindBy(xpath = "//input[@class='btn btn-primary']") WebElement btnCapnhat;
	@FindBy(xpath = "//input[@class='autosearch-input form-control']") WebElement textSearch;
	@FindBy(xpath = "//button[@type='submit']") WebElement btnSearch;
	
	
	
	public UpdatePasswordPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void LoginFunction(String email, String password) {
		textEmail.sendKeys(email);
		textPassword.sendKeys(password);
		buttonLogin.click();
	}
	
	public void UpdatePassword(String oldPass, String newPass) {
		try {
			while (cancelButton.isDisplayed()) {
				cancelButton.click();
			}
		} catch (Exception e) {
			btnAvatar.click();
			btnUpdatePass.click();
			textOldPass.sendKeys(oldPass);
			textNewPass.sendKeys(newPass);
			textConfirmNewPass.sendKeys(newPass);
			btnCapnhat.click();
		}
	}
	
	public void SearchSuccessfully(String nhapText) {
		textSearch.sendKeys(nhapText);
		btnSearch.click();
	}
		
		//cancelButton.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", btnAvatar);
	}

