package Flows;

import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Keywords.KeywordRepository;
import ObjectRepository.DashboardPage;
import Utilities.BrowserConfig;
import Utilities.ExcelHandler;
import jxl.read.biff.BiffException;

public class LoginLogout extends ExcelHandler {
	
	@BeforeMethod
	public void InitializeTest()
	{
		setThreadDataSheetName("Environment.xls");
		String BrowserName = getBrowserFromEnvConfig("Environment", "Browser", 1, 0); 
		driver = BrowserConfig.getBrowser(BrowserName);
		wait = new WebDriverWait(driver, 60);
	}
	
	@AfterMethod
	public void EndTest()
	{
		softAssertion.assertAll();
	}
	
  @Test
  public void DemoQA() {
	  
	  KeywordRepository.loadURL();
	  driver.quit();
	  
  }
  
  @Test
  public void DemoQARegister() {
	  setThreadDataSheetName("Data.xlsx");
	  String FirstName = getParameterFromInputSheet("Login","FirstName",1,0);
	  String LastName = getParameterFromInputSheet("Login","LastName",1,0);
	  String PhoneNumber = getParameterFromInputSheet("Login","PhoneNumber",1,0);
	  
	  
	  KeywordRepository.loadURL();
	  KeywordRepository.getTextAssertion(DashboardPage.RegistrationButton, "Registration");
	  KeywordRepository.Click(DashboardPage.RegistrationButton);
	  KeywordRepository.setTextField(DashboardPage.FN_TextBox, FirstName);
	  KeywordRepository.setTextField(DashboardPage.LN_TextBox, LastName);
	  KeywordRepository.setTextField(DashboardPage.PhnNumber, PhoneNumber);
	  
	  driver.quit();
  }
  
 
}
