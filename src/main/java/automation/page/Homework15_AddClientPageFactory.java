package automation.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homework15_AddClientPageFactory {
	private WebDriver driver;
	@FindBy(id = "recaptcha-anchor") WebElement btnCapcha;
	@FindBy(xpath = "//button[text()='Sign in']") WebElement btnSignin;
	@FindBy(xpath = "//span[text()='Clients']") WebElement menuClient;
	@FindBy(xpath = "//a[@title='Add client']") WebElement btnAddClient;
	@FindBy(id = "type_person") WebElement radioPerson;
	@FindBy(id ="company_name") WebElement textName;
	@FindBy(xpath = "//button[@type='submit']") WebElement btnSave;
	@FindBy(xpath = "//input[@type='search']") WebElement textSearch;

	
	public Homework15_AddClientPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	public void LoginFunction() throws InterruptedException {
		
//		btnCapcha.click();
//		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('recaptcha-anchor').remove();");
		Thread.sleep(3000);
		btnSignin.click();
		
	}
	public void AddClient(String name) {
		menuClient.click();
		btnAddClient.click();
		radioPerson.click();
		textName.sendKeys(name);
		
	}
	
	public void SearchClient(String nhapCient) {
		textSearch.sendKeys(nhapCient);
	}
}
