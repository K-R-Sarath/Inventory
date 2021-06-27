package wrappers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.InputData;
import utils.ReadConfig;

public class Annotations {

	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public String excelFileName;
	
	ReadConfig readConfig = new ReadConfig();
	
	@BeforeTest
	public void setExtentAndData() {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/my-report"+timestamp+".html");
		
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows8");
		extent.setSystemInfo("User", "Sarath");
		
		excelFileName = "TestData";
		
	}
	
	@AfterTest
	public void endReport() {
		
		extent.flush();
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void invokeBrowserAndLaunch(String br) {
		
		if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
			}else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",readConfig.getIEPath());
			driver = new InternetExplorerDriver();
			}else if(br.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
				driver = new ChromeDriver();
			}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://app.asalta.com/login/");
		System.out.println("Browser Invoked and redirected to site");
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		
		test = extent.createTest(result.getName());
		
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed is " +result.getName());
			test.log(Status.FAIL, "Test Case Failed is " +result.getThrowable());
			test.log(Status.FAIL, "Please find the screenshot below : ");
			
			String screenshotPath = Annotations.captureScreen(driver, result.getName());
			
			test.addScreenCaptureFromPath(screenshotPath);
		} 
		else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skipped is " +result.getName());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed is " +result.getName());
		}
		
		driver.close();
		
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData() throws InvalidFormatException, IOException{
		return InputData
				.readExcel(excelFileName);
}
	@DataProvider(name="fetchData1")
	public Object[][] getData1() throws InvalidFormatException, IOException{
		return InputData
				.readExcel1(excelFileName);
	}
	
	public static String captureScreen(WebDriver driver,String tname) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/Screenshots/"+tname+timestamp+".png";
		File target = new File(destination);
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		return destination;
	}
	
	

}

