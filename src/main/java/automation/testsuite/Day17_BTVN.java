package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day17_BTVN extends CommonBase{
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_MEDIAMART);
	}
	
	@Test
	public void handleChatMessenger() {
		pause(5000);
		click(By.xpath("//div[text()='Gửi tin nhắn']"));
		assertTrue(isElementVisibility(By.xpath("//button[text()='Tiếp tục chat']")));
	}
	
	@Test
	public void handleIframeChatZalo() {
		pause(5000);
		click(By.xpath("//div[@class='widget-preview--btn-close']"));
		WebElement chatZalo = getElementPresentDOM(By.xpath("(//iframe)[1]"));
		driver.switchTo().frame(chatZalo);
		click(By.xpath("//div[@class='logo']/img"));
		assertTrue(isElementVisibility(By.xpath("//div[text()='Chat bằng Zalo']")));
	}
}
