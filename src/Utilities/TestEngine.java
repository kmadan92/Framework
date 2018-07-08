package Utilities;

public class TestEngine{
	

	public static void main(String args[]) throws Exception
	{
		ExcelHandler handle = new ExcelHandler();
		handle.readExecutor("Executor", "Config", "Executor.xls");
	}

}
