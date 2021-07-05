package com.inetHome.TestCases1;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetHome.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();	
	public static WebDriver driver;
	public static final Logger logger = LoggerFactory.getLogger(BaseClass.class);
	
				
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		//For Log 4j
		logger.info("Setup method started");
		//PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(br.equals("ie")) {
			//WebDriverManager.iedriver().setup();
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");			
			driver= new InternetExplorerDriver();
		}else if(br.equals("opera")) {
			//WebDriverManager.operadriver().setup();
			System.setProperty("webdriver.opera.driver",System.getProperty("user.dir")+"/Drivers/operadriver.exe");
			driver = new OperaDriver();
		}else if(br.equals("edge")) {
			//WebDriverManager.edgedriver().setup();
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/Drivers/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(baseURL);
		}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws Exception{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		try {
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
		catch(Exception e){
			System.out.println("Screenshot not Taken");	
		}}
	
	public static String randomeString(int no) 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(no);
		return generatedString;
	}
	
	public static String randomeNumber(int no) 
	{
		String generatedNumberString = RandomStringUtils.randomNumeric(no);
		return generatedNumberString;
	}
	
}
