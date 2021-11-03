package ptl.test;

import ptl.utilities.ConfigurationReader;
import ptl.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    protected static ExtentReports report;
    //this class is used to create HTML report file
    protected static ExtentHtmlReporter htmlReporter;
    //this will  define a test, enables adding logs, authors, test steps
    protected static ExtentTest extentLogger;

    @BeforeTest
    public void BeforeTest(){
        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/Screenshots/Areport.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("PLT Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
    }
    @BeforeMethod
    public void BeforeMethod(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
    }
    //ITestResult class describes the result of a test in TestNG
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        //if test fails
        if(result.getStatus()==ITestResult.FAILURE){
            //record the name of failed test case
            //extentLogger.fail(result.getName());

            // name the screenshot with the current date time to avoid duplicate name
            String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            // TakesScreenshot ---> interface from selenium which takes screenshots
            TakesScreenshot ts = (TakesScreenshot) Driver.get();
            File source = ts.getScreenshotAs(OutputType.FILE);
            // full path to the screenshot location
            String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + result.getName() + date + ".png";
            File finalDestination = new File(target);
            // save the screenshot to the path given
            FileUtils.copyFile(source, finalDestination);

            //take the screenshot and return location of screenshot
            //String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            System.out.println(target);
            System.out.println(source);

            //add your screenshot to your report
            //extentLogger.addScreenCaptureFromPath(target);
            extentLogger.addScreenCaptureFromPath(result.getName()+date+".png");

            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }
        Thread.sleep(1000);
        Driver.closeDriver();
    }
    @AfterTest
    public void AfterTest(){
        //close report
        //this is when the report is actually created
       report.flush();
        //Driver.closeDriver();
    }
}
