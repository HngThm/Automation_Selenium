package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework13_LoginPageLocator {

	private WebDriver driver;
	public Homework13_LoginPageLocator (WebDriver _driver) {
		this.driver = _driver;
	}
	public void LoginFunction(String email, String password) {
		
		WebElement textEmail = driver.findElement(By.id("email"));
		if(textEmail.isDisplayed()) {
			textEmail.sendKeys(email);
		}
		
		WebElement textPassword = driver.findElement(By.id("password"));
		if(textPassword.isDisplayed()) {
			textPassword.sendKeys(password);
		}
		
		WebElement btnLogin = driver.findElement(By.xpath("//button[text()='Đăng nhập']"));
		if(btnLogin.isDisplayed()) {
			btnLogin.click();
		}
	}
}
