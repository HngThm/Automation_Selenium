package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homework14_LogoutPageFactory {
	
	private WebDriver driver;
	@FindBy(xpath = "//div[@class='avatar2']/descendant::img") WebElement btnInfo;
	
	@FindBy(xpath = "//a[text()='Thoát']") WebElement btnThoat;
	
	public Homework14_LogoutPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void LogoutFunction() {
		btnInfo.click();
		btnThoat.click();
	}

}
