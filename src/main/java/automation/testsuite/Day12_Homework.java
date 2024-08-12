package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day12_Homework extends CommonBase{
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEASE4);
	}
	@Test
	public void case1_Dropdownlist() {
	Select dropdownState =new Select(driver.findElement(By.name("state")));
	
	//kiểm tra chọn 1 giá trị trong dropdownlist
	dropdownState.selectByVisibleText("Hawaii");
	assertEquals(dropdownState.getFirstSelectedOption().getText(), "Hawaii"); 
  } 
	@Test
	public void case2_CheckRadioSuccessfully() {
		
		WebElement hostingYes = driver.findElement(By.xpath("//input[@value='yes']"));
		if(hostingYes.isDisplayed()) {
			hostingYes.click();
			assertTrue(hostingYes.isSelected());
		}
		
		WebElement hostingNo = driver.findElement(By.xpath("//input[@value='no']"));
		if(hostingNo.isDisplayed()) {
			hostingNo.click();
			assertTrue(hostingNo.isSelected());
			assertFalse(hostingYes.isSelected());
		}
	}
}
