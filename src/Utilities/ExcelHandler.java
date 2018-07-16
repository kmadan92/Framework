package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.BindException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell ;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

//import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class ExcelHandler {
	
	public static String pathInsideProject;
	public static String threadDataSheetName;
	public static WebDriver driver;
	public static WebDriverWait wait; 
	public static String Key,Value,FunctionName,ClassName,BrowserName, Environment, URL;
	public static SoftAssert softAssertion = new SoftAssert();
	
	
	public static String getPathCommon() throws URISyntaxException {
		pathInsideProject = new File("").getAbsolutePath();
		return pathInsideProject;
	}
	
	public static void setThreadDataSheetName(String DataSheetName) {
		threadDataSheetName = DataSheetName;
	}
	
	public static String getThreadDataSheetName() {
		return threadDataSheetName;
	}
	
	//function to get total row count
		public static int getRowCount(String sheetName) {
			int rowCount = 0;
			try {
				String FileName = getThreadDataSheetName();
				String path = getPathCommon();
				FileInputStream file = new FileInputStream(new File(path + "//Datafiles//" + FileName));

				@SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(sheetName);
				rowCount = sheet.getLastRowNum() + 1;
			} catch (Exception E) {
				E.printStackTrace();
			}
			return rowCount;
		}

		//Function to get total Column count
	public static int getColCount(String sheetName) throws Exception {
			int colCount = 0;
			try {
				String FileName = getThreadDataSheetName();
				String path = getPathCommon();
				FileInputStream file = new FileInputStream(new File(path + "//Datasheets//" + FileName));

				@SuppressWarnings("resource")
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(sheetName);
				colCount = sheet.getRow(0).getLastCellNum();
			} catch (Exception E) {
				E.printStackTrace();
			}
			return colCount;
		}
	
	public static String getParameterFromInputSheet(String sheetName, String parameter, int rowNum, int headerrow) {
		String value = null;
		
		String FileName = getThreadDataSheetName();
		try {
			String path = getPathCommon();
			FileInputStream file = new FileInputStream(new File(path + "\\Datafiles\\" + FileName));

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int paramCol = -1;
			Iterator<Cell> cellIterator = sheet.getRow(headerrow).cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = (Cell) cellIterator.next();
				try {
					if (cell.getStringCellValue().equals(parameter))
						paramCol = cell.getColumnIndex();
				} catch (Exception e) {
				}
			}
			try {
				value = sheet.getRow(rowNum).getCell(paramCol).getStringCellValue();
			} catch (Exception e) {
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Please verify the Data sheet, and the path where it is saved are correct");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void SetParameterFromInputSheet(String sheetName, String parameter, int rowNum, int headerrow,
			String Value) {
		{
			try {
				String FileName = getThreadDataSheetName();

				String path = getPathCommon();
				FileInputStream file = new FileInputStream(new File(path + "//Datafiles//" + FileName));

				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheet(sheetName);

				int paramCol = -1;
				Iterator<Cell> cellIterator = sheet.getRow(headerrow).cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = (Cell) cellIterator.next();
					try {
						if (cell.getStringCellValue().equals(parameter))
							paramCol = cell.getColumnIndex();
					} catch (Exception e) {
					}
				}
				try {
					XSSFRow row1 = sheet.getRow(rowNum);
					XSSFCell cellA1 = row1.createCell(paramCol);
					cellA1.setCellValue(Value);
				} catch (Exception e) {
				}
				FileOutputStream out = new FileOutputStream(new File(path + "//Datafiles//" + FileName));

				workbook.write(out);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("Please verify the Data sheet, and the path where it is saved are correct");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	
	@SuppressWarnings("resource")
	public static String getBrowserFromEnvConfig(String sheetName, String parameter, int rowNum, int headerrow) {
		String value = null;
		
		String FileName = getThreadDataSheetName();
		try {
			String path = getPathCommon();
			FileInputStream file = new FileInputStream(new File(path + "//Config//" + FileName));

			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			int paramCol = -1;
			Iterator<Cell> cellIterator = sheet.getRow(headerrow).cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = (Cell) cellIterator.next();
				try {
					if (cell.getStringCellValue().equals(parameter))
						paramCol = cell.getColumnIndex();
				} catch (Exception e) {
				}
			}
			try {
				value = sheet.getRow(rowNum).getCell(paramCol).getStringCellValue();
			} catch (Exception e) {
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Please verify the Data sheet, and the path where it is saved are correct");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	 public Map<String, String> readExecutor(String sheetName, String pathName, String fileName) throws Exception 
		{
			int R,C;
			Map<String,String> sheetData=new HashMap<String,String>();
			final String dir = System.getProperty("user.dir");
			File inputFile=new File(dir+"\\" + pathName + "\\"+ fileName);
			Workbook wb;
			try
			{
			wb=Workbook.getWorkbook(inputFile);

			Sheet sheet=wb.getSheet(sheetName);
			
			C=sheet.getColumns();
			R=sheet.getRows();
			sheetData.put("DataCount",Integer.toString(R));
			
		for(int j=1;j<R;j++)
		{
		 for(int i =0; i<C;i++)
		 {
			//(Column,Row)
				jxl.Cell cell=sheet.getCell(i,0);
				jxl.Cell cell_2=sheet.getCell(i,j);
				
				Key=cell.getContents();
				Value=cell_2.getContents();
				
				sheetData.put(Key, Value);
							
				
				if (Key.trim().equals("Execute"))
				{
					if (Value.trim().equals("Yes"))
					{
						BrowserName = sheetData.get("Browser");
						ClassName = sheetData.get("Class");
						FunctionName = sheetData.get("Function");
						
						System.out.println("---------------Scenario "+FunctionName+" started---------------");
						
						driver = BrowserConfig.getBrowser(BrowserName);
						wait = new WebDriverWait(driver, 60);
						
						
						Class<?> cls = Class.forName("Flows."+ClassName);
						Object obj = cls.newInstance();
						java.lang.reflect.Method Meth =  obj.getClass().getMethod(FunctionName);
						Meth.invoke(obj);
						
					}
					
				}
				
				cell=null;
				cell_2=null;
		 }
		}
		
		 inputFile=null;
		 wb=null;
		 sheet=null;
			}
			catch(BindException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		 
			return sheetData;
		 
		}
	 
	 
	 @SuppressWarnings("rawtypes")
	public static Map readConfig() throws BiffException
		{
			String dir = System.getProperty("user.dir");
			Map<String,String> configData=new HashMap<String,String>();
			File inputFile=new File(dir+"\\" + "Config\\" + "Environment.xls");
			Workbook wb;
			String sheetName= "Environment";
			int C=0, R=0;
			String hKey=null, hValue=null;
			
			try
			{
				wb=Workbook.getWorkbook(inputFile);
				Sheet sheet=wb.getSheet(sheetName);
				C=sheet.getColumns();
				R=sheet.getRows();
				
				jxl.Cell cell;
				jxl.Cell  cell_2;
				
				for (int j=1; j<R; j++)
				{
				for(int i=0;i<C;i++)
				{
					//(Column,Row)
				 cell=sheet.getCell(i,0);
				 cell_2=sheet.getCell(i,j);
					hKey=cell.getContents();
					hValue=cell_2.getContents();

					configData.put(hKey, hValue);
										
					if (hKey.trim().equals("ExecutionFlag"))
					{
						if (hValue.equals("Yes"))
						{
							Environment = configData.get("Environment");
						    URL= configData.get("URL");
								   						
						}
											
					}
									
				}	
			        							
				}
				
				cell=null;
				cell_2=null;		
				inputFile=null;
				wb=null;
				sheet=null;
					
			} 
		
			catch (BindException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return configData;
		}
	
	

}
