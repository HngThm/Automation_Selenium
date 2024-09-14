package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day17_iFrame extends CommonBase {
	
	@BeforeMethod
	public void openChrome() {
		driver =initChromeDriver(CT_PageURLs.URL_CODESTAR2);
	}
	
//	@Test
//	public void findIndexIframe() {
//		pause(5000);
//		try {
//		int totalIframe = getListWebElement(By.tagName("iframe")).size();
//		System.out.println("Tổng số iframe lf: " + totalIframe);
//		for(int i=0; i < totalIframe; i++) {
//			System.out.println("Switch đến iframe thứ " + i);
//			
//				driver.switchTo().frame(i);
//				if(isElementVisibility(By.xpath("//button[normalize-space()='Gửi ngay' and @type='submit']")) == true){
//					System.out.println("iframe chứa button Gửi ngay ở vị trí thứ " + i);
//			}
//			}
//		}
//			catch (Exception ex) {
//				System.out.println("có exception xảy ra: "+ ex);
//				findIndexIframe();
//			
//		}
//	}

	
	@Test
	public void handleIframeDangkyTuVan() {
		scrollToElement(By.xpath("(//iframe)[1]"));
		WebElement btnGuiNgay = getElementPresentDOM(By.xpath("(//iframe[@title='Khách hàng'])[1]"));
		driver.switchTo().frame(btnGuiNgay);
		System.out.println("Switch tới iframe Đăng ký tư vấn lộ trình thành công");
		type(By.id("name"),"Test");
		type(By.id("phone_number"), "09888888");
		click(By.xpath("//button[normalize-space()='Gửi ngay']"));
		assertTrue(isElementVisibility(By.xpath("//button[normalize-space()='Gửi ngay']")));
	}
}

