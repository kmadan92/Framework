package test.java;

import org.testng.annotations.Test;

import Utilities.ExcelHandler;

public class MavenTest {
	
  @Test
  public void FirstTestCase() throws Exception {
	  
	  ExcelHandler handle = new ExcelHandler();
	 handle.readExecutor("Executor", "Config", "Executor.xls");
  }
  
  @Test
  public void SecondTestCase() throws Exception {
	  
	  System.out.println("-----This is 2nd TC------");
  }
  
  @Test
  public void ThirdTestCase() throws Exception {
	  
	  System.out.println("-----This is 3rd TC------");
  }
}
