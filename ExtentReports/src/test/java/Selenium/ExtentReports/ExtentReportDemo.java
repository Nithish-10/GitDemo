package Selenium.ExtentReports;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ExtentReportDemo {

	ExtentReports extent;

    @BeforeTest
    public void config() {
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Nithish B");
        
    }

	
	@Test
    public void initialDemo() {
		
		ExtentTest test =  extent.createTest("Initial Demo");
        //extent.createTest("Initial Demo");

        // ✅ WebDriverManager automatically downloads and sets up the correct ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        System.out.println("hello world");

        //test.addScreenCaptureFromBase64String("screenshotBase64String");
        test.fail("Result do not match");  // to mark the test as failed
        driver.quit();   // always close the browser
        extent.flush();  // generate the report
    }


}
