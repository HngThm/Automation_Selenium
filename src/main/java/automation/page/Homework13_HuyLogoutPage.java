package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework13_HuyLogoutPage {
	private WebDriver driver;
	public Homework13_HuyLogoutPage(WebDriver _driver) {
		this.driver = _driver;
	}
	public void LogoutFunction() {
		WebElement buttonAdmin = driver.findElement(By.xpath("//a[normalize-space()='Admin']"));
		if(buttonAdmin.isDisplayed()) buttonAdmin.click();
		
		WebElement buttonDangxuat = driver.findElement(By.xpath("//button[text()='Đăng xuất' and @type='button']"));
		if(buttonDangxuat.isDisplayed()) buttonDangxuat.click();
		
		WebElement buttonHuyDangxuat = driver.findElement(By.xpath("//button[text()='Hủy']"));
		if(buttonHuyDangxuat.isDisplayed()) {
			buttonHuyDangxuat.click();
		}
	}
}
