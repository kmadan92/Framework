package Flows;

import org.testng.annotations.Test;

import Keywords.KeywordRepository;

public class LoginLogout {
	
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
