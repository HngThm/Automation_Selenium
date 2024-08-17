package automation.testsuite;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;

public class Day12_Dropdownlist extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_SELENIUMEASE3);
	}
	
	@Test
	public void case1_Dropdownlist() {
	Select dropdownDay =new Select(driver.findElement(By.id("select-demo")));
	//case1 kiêm tra size của dropdownlist là 7 (size từ 1-8)
	assertEquals(dropdownDay.getOptions().size(), 8);
	
	//case2 chọn monday bằng cách 1, kiểm tra giá trị sau khi chọn
	dropdownDay.selectByVisibleText("Monday");
	assertEquals(dropdownDay.getFirstSelectedOption().getText(), "Monday"); 
	
	//case 3 chọn Tuesday bằng cách 2, kiểm tra giá trị sau khi chọn
	dropdownDay.selectByValue("Tuesday");
	assertEquals(dropdownDay.getFirstSelectedOption().getText(), "Tuesday");
	
	//Case 4 : chọn Sunday bằng cách 3, kiểm tra giá trị sau khi chọn (index từ 0 - 7)
	dropdownDay.selectByIndex(1);
	assertEquals(dropdownDay.getFirstSelectedOption().getText(), "Sunday");
	}
}
