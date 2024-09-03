package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.Homework15_AddClientPageFactory;

public class Day15_Homework_AddClientTest extends CommonBase{
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_RISE);
	}
	
	@Test
	public void addClientSuccessfully() throws InterruptedException {
		Homework15_AddClientPageFactory addClient = new Homework15_AddClientPageFactory(driver);
		addClient.LoginFunction();
		addClient.AddClient("Auto");
		addClient.SearchClient("Auto");
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//a[text()='Abc']")).isDisplayed());
	}
	

}
