package automation.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPageFactory {
	private WebDriver driver;
	@FindBy(xpath = "//a[normalize-space()='Admin']") WebElement buttonAdmin;
	
	@FindBy(xpath = "//button[text()='Đăng xuất' and @type='button']") WebElement buttonDangxuat;
	
	@FindBy(xpath = "//button[text()='Đăng xuất' and @type='submit']") WebElement buttonXnDangxuat;

	public LogoutPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void LogoutFunction() {
			buttonAdmin.click();
			buttonDangxuat.click();
			buttonXnDangxuat.click();
	}
}
