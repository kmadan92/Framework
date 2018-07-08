package Keywords;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Utilities.ExcelHandler;


public class KeywordRepository extends ExcelHandler
{

	public static boolean ExitFlag=false;
	public static String TestStepStatus=null;
	
	public static void Click(String currentObject)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currentObject))).click();
		}
		catch(Exception e)
		{
			System.out.println("Keyword Click Failed");
			e.printStackTrace();
		}
		
	}
	
	public  static void ClickByJS(String currentObject) throws InterruptedException
	{
		try
		{
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", currentObject);
		}
		catch(Exception e)
		{
			System.out.println("Keyword ClickByJS Failed");
			e.printStackTrace();
		}
	}
	
	public static void setTextField(String currentObject, String value)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currentObject))).sendKeys(value);
		}
		catch(Exception e)
		{
			System.out.println("Keyword setTextField Failed");
			e.printStackTrace();
		}
	}
	
	public static String loadURL()
	{
		try
		{

		driver.get(ExcelHandler.URL);
		driver.manage().window().maximize();
	
		}
		catch(Exception e)
		{
			System.out.println("Keyword loadURL Failed");
			e.printStackTrace();
		}
		return ExcelHandler.URL;
	}

	public static void NavigateUrl(String URL) {
		
		try
		{
		driver.get(URL);
		}
		catch(Exception e)
		{
			System.out.println("Keyword NavigateUrl Failed");
			e.printStackTrace();
		}
		
	}
	
	public static String getUrl() {
		
		String CurURL = null;
		try
		{
			CurURL = driver.getCurrentUrl();
		}
		catch(Exception e)
		{
			System.out.println("Keyword getUrl Failed");
			e.printStackTrace();
		}
	return CurURL;
	
		
	}
	
	public static void getscreenshot()  
    {
         
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String dir = System.getProperty("user.dir");
            String text=new SimpleDateFormat("MM-dd-yyyy HH-mm-ss").format(new Date());
            String text1=new SimpleDateFormat("MM-dd-yyyy").format(new Date());
            String filename= ExcelHandler.FunctionName+ "_" + text +".jpg";
            String functionname=ExcelHandler.FunctionName + "_" + text1;
            String classname=ExcelHandler.ClassName + "_" + text1;
            File ScreenshotFolder=  new File(dir+"\\Screenshots\\");
            File ModuleFolder = new File (dir + "\\Screenshots\\"+ classname+"\\"+functionname);
            //The below method will save the screen shot in d drive with specified name
            try {
            	if (ScreenshotFolder.exists())
            	{
            		if(ModuleFolder.exists())
            		{
            			FileUtils.copyFile(scrFile, new File(dir+"\\Screenshots\\"+classname+"\\"+functionname+"\\"+filename));
            			ExitFlag=true;
        				TestStepStatus="PASS";
            		}
            		else
            		{
            			ModuleFolder.mkdir();
            			FileUtils.copyFile(scrFile, new File(dir+"\\Screenshots\\"+classname+"\\"+functionname+"\\"+filename));
            			ExitFlag=true;
        				TestStepStatus="PASS";
            		}
            	}
            	else
            	{
            		ScreenshotFolder.mkdir();
            		ModuleFolder.mkdir();
            		FileUtils.copyFile(scrFile, new File(dir+"\\Screenshots\\"+classname+"\\"+functionname+"\\"+filename));
            		ExitFlag=true;
    				TestStepStatus="PASS";
            	}
				
				
			} 
            catch (IOException e)
			{
            	System.out.println("Keyword getscreenshot Failed");
				// TODO Auto-generated catch block
				e.printStackTrace();
				ExitFlag=false;
				TestStepStatus="FAIL";
			}
            
    }
	
	public static void getTextAssertion(String currentObject, String origValue, String keyword)
	{
		String compareValue;
		try
		{
		compareValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(currentObject))).getText();
		
		if(compareValue.equals(origValue))
		{
			getscreenshot();
			System.out.println("Step "+keyword+" Passed");
			ExitFlag=true;
			TestStepStatus="PASS";
		}
		
		else
		{
			getscreenshot();
			System.out.println("Step "+keyword+" Failed");
			ExitFlag=false;
			TestStepStatus="FAIL";
		}
		}catch(Exception e)
		{
			System.out.println("Keyword getTextAssertion Failed");
			e.printStackTrace();
		}
		
		
	}
}
