package Flows;

import Keywords.KeywordRepository;
import ObjectRepository.LoginPage;
import Utilities.ExcelHandler;

public class LoginLogout extends ExcelHandler {
	
public void Login_Logout() {
	
	ExcelHandler.setThreadDataSheetName("Data.xlsx");
	
//	String UserName = ExcelHandler.getParameterFromInputSheet("Login", "USERNAME", 1, 0);
//	String Password = ExcelHandler.getParameterFromInputSheet("Login", "PASSWORD", 1, 0);

	KeywordRepository.loadURL();
	
	KeywordRepository.setTextField(LoginPage.googleTextBox, "Mumbai Weather");
	
	KeywordRepository.Click(LoginPage.SearchButton);
	
	
//	KeywordRepository.Click(LoginPage.Login);
//	
//	KeywordRepository.getTextAssertion(LoginPage.Logout, "Logout", "LoadingOfDashboard");
//	
//	KeywordRepository.Click(LoginPage.Logout);
	driver.close();
	
}
}
