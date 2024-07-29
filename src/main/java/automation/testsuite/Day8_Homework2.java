package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day8_Homework2 extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver("https://automationfc.github.io/basic-form/index.html");
	}
	
	@Test
	public void getElementById() {
		WebElement txtName = driver.findElement(By.id("name"));
		System.out.println(txtName);
		
		WebElement txtAddress = driver.findElement(By.name("address"));
		System.out.println(txtAddress);
		
		WebElement txtEmail = driver.findElement(By.id("email"));
		System.out.println(txtEmail);
		
		WebElement txtPassword = driver.findElement(By.name("password"));
		System.out.println(txtPassword);

	}
}
