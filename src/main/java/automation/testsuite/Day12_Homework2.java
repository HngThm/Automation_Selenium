package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day12_Homework2 extends CommonBase{
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEASY5);
	}

	@Test
	public void case1_Dropdownlist() {
	Select dropdownState =new Select(driver.findElement(By.xpath("//select")));
	
	//kiểm tra chọn 1 giá trị trong dropdownlist
	dropdownState.selectByVisibleText("Australia");
	assertEquals(dropdownState.getFirstSelectedOption().getText(), "Australia"); 
  } 
}
