package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.common.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static Map<String,Map<String,String>> td;
	public static Properties prop;
	public static String TCName;
	
	
	public void initiation() 
	{
		if(prop==null)
		{
		prop = readproperties();
		}
		if(td==null)
		{
			td= readTestData(System.getProperty("user.dir")+"/src/test/resources/TestData/Data.xlsx","Sheet1");
		}
		
		//System.out.println(td);
		//System.exit(0);
		if(extent==null)
		{
		createExtentReport();
		
		}
	}
	
	
	public void teirDown()
	{
		driver.quit();
	}
	

	
	
	public void launchApp()
	{
		if(driver==null)
		{
		if(prop.getProperty("Browser").equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(prop.getProperty("Browser").equals("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else if(prop.getProperty("Browser").equals("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("AppUrl"));
		int tm = Integer.parseInt(prop.getProperty("TimeOut"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(tm));
		}
	}
	
	
	public void createExtentReport()
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+fileName+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD); 
		
	}
	
	
	
	
	public Map<String,Map<String,String>> readTestData(String path, String sheet)
	{
		Xls_Reader xr = new Xls_Reader(path);
		int rows = xr.getRowCount(sheet);
		int colms = xr.getColumnCount(sheet);
		Map<String,Map<String,String>> td = new HashMap<String,Map<String,String>>();
		for(int i=2;i<=rows;i++)
		{
			Map<String,String> rdt = new HashMap<String,String>();
			for(int j=1;j<=colms;j++)
			{
				String key = xr.getCellData(sheet, j, 1).trim();
				String val = xr.getCellData(sheet, j, i).trim();
				rdt.put(key, val);
			}
			
			td.put(xr.getCellData(sheet, 0, i), rdt);
			
		}
		
		return td;
		
	}
	
	
	public Properties readproperties() 
	{
		Properties prop = new Properties();
		
	    try {
	    	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/settings.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return prop;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
