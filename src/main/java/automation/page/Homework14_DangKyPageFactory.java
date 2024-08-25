package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homework14_DangKyPageFactory {
	
	private WebDriver driver;
	@FindBy(xpath = "//a[text()='Đăng Ký']") WebElement btnDangKy;
	@FindBy (id = "txtFirstname") WebElement textHoVaTen;
	@FindBy(id ="txtEmail") WebElement textEmail;
	@FindBy(id="txtCEmail") WebElement textNhaplaiEmail;
	@FindBy(id = "txtPassword") WebElement textPassword;
	@FindBy (id ="txtCPassword") WebElement textNhaplaiPasss;
	@FindBy (id="txtPhone") WebElement textDienThoai;
	@FindBy(xpath = "//button[@type='submit' and text()='ĐĂNG KÝ']") WebElement btnSummitDangKy;
	public Homework14_DangKyPageFactory(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	public void Dangky_Function(String hoten, String email, String nhaplaiEmail, String password, String nhaplaiPassword, String dienthoai) {
		btnDangKy.click();
		textHoVaTen.sendKeys(hoten);
		textEmail.sendKeys(email);
		textNhaplaiEmail.sendKeys(nhaplaiEmail);
		textPassword.sendKeys(password);
		textNhaplaiPasss.sendKeys(nhaplaiPassword);
		textDienThoai.sendKeys(dienthoai);
		btnSummitDangKy.click();
	}
	

}
