package Flows;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Keywords.KeywordRepository;
import Utilities.ExcelHandler;
import jxl.read.biff.BiffException;

public class LoginLogout3 {
	

	
  @Test
  public void FirstTestCase() {
	  
	  KeywordRepository.loadURL();
  }
  
  @Test
  public void SecondTestCase() {
	  
	  System.out.println("------This is Second TC-------");
  }
  
  @Test
  public void ThirdTestCase() {
	  
	  System.out.println("-----This is Third TC------");
  }
}
