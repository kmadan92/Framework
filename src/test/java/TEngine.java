package test.java;

import org.junit.Test;

import Utilities.ExcelHandler;

public class TEngine {

	@Test
	public void test() throws Exception {
		ExcelHandler handle = new ExcelHandler();
		handle.readExecutor("Executor", "Config", "Executor.xls");
	}

}
