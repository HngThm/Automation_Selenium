package automation.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homework14_ChinhsuaPageFactory {
	private WebDriver driver;
	@FindBy(xpath = "//div[@class='avatar2']/descendant::img")
	WebElement btnInfo;
	@FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']")
	WebElement btnEditInfo;
	@FindBy(id = "txtpassword")
	WebElement textPassword;
	@FindBy(id = "txtnewpass")
	WebElement textNewpass;
	@FindBy(id = "txtrenewpass")
	WebElement textRenewpass;
	@FindBy(xpath = "//button[text()='Lưu mật khẩu mới']")
	WebElement btnLuu;
//	@FindBy (id = "txtFirstname") WebElement textHoVaTen;

	public Homework14_ChinhsuaPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}

	public void Chinhsua_Function(String password, String newpassword, String renewpassword) {
		try {
			btnInfo.click();
			Thread.sleep(2000);
			btnEditInfo.click();
			Thread.sleep(2000);
			textPassword.sendKeys(password);
			textNewpass.sendKeys(newpassword);
			textRenewpass.sendKeys(renewpassword);
			Thread.sleep(2000);
			btnLuu.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
