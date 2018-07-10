package test.java;

import org.testng.annotations.Test;

import Utilities.ExcelHandler;

public class MavenTest {
	
  @Test
  public void FirstTestCase() throws Exception {
	  
	  ExcelHandler handle = new ExcelHandler();
	  handle.readExecutor("Executor", "Config", "Executor.xls");
  }
  
  
}
