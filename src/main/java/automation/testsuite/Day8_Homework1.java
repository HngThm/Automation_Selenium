package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day8_Homework1 extends CommonBase {

	@BeforeMethod
	public void openBrowser() {
		driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
	}
	
	@Test
	public void getElementById() {
		WebElement txtEmail = driver.findElement(By.name("email"));
		//txtHovaTen.sendKeys("Á");
		System.out.println(txtEmail);
		
		WebElement txtPassword = driver.findElement(By.name("Password"));
		System.out.println(txtPassword);
		
		WebElement txtCompany = driver.findElement(By.name("company"));
		System.out.println(txtCompany);
		
		WebElement txtMobileNumber = driver.findElement(By.name("mobile number"));
		System.out.println(txtMobileNumber);

	}
}
