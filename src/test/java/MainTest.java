import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class MainTest {
   private static ExtentReports extent= new ExtentReports();
   private static ExtentTest test = extent.createTest("MySecondProject", "Sample description");
    @BeforeClass
    public void beforeAll(){
        DriverSingleton.getDriverInstance().get("https://buyme.co.il/");
        DriverSingleton.getDriverInstance().manage().window().maximize();
        DriverSingleton.getDriverInstance().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C://Users//extent.html");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO, "before test method");
    }

    @Test
    public void test01_assertionURL(){
        try {
            String byMeUrl= "https://buyme.co.il/";
            Assert.assertEquals(byMeUrl,DriverSingleton.getDriverInstance().getCurrentUrl());
            test.log(Status.PASS, "Test 1 Passed");
        }
        catch (Exception e){
            e.printStackTrace();
            String timeNow=String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL,"Test 1 Failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }

    }
    @Test
    public void test02_login(){
        try{
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        test.log(Status.PASS, "Test 2 Passed");
    }
        catch (Exception e){
        e.printStackTrace();
            String timeNow=String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL,"Test 2 Failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }
    @Test
    public void test03_homeScreen(){
        try {
            HomeScreen homeScreenPage= new HomeScreen();
            homeScreenPage.homeScreen();
            test.log(Status.PASS, "Test 3 Passed");
        }
        catch (Exception e){
            e.printStackTrace();
            String timeNow=String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL,"Test 3 Failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }
    @Test
    public void test04_assertionURLScreen3() {
        try {
            String byMeeURL3="https://buyme.co.il/search?budget=1&category=359&region=13";
            Assert.assertEquals(byMeeURL3, DriverSingleton.getDriverInstance().getCurrentUrl());
            test.log(Status.PASS, "Test 4 Passed");
        }
        catch (Exception e){
            e.printStackTrace();
            String timeNow=String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL,"Test 4 Failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }
    @Test
    public void test05_pickBusiness() {
        try {
            PickBusiness pickBusinessPage = new PickBusiness();
            pickBusinessPage.pickBusiness();
            test.log(Status.PASS, "Test 5 Passed");
        }
        catch (Exception e){
            e.printStackTrace();
            String timeNow=String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL,"Test 5 Failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }
    @Test
    public void test_06_receivedInformation() throws InterruptedException {
        try {
            ReceivedInformation receivedInformationPage = new ReceivedInformation();
            receivedInformationPage.receivedInformation();
            test.log(Status.PASS, "Test 6 Passed");
        }
        catch (Exception e){
            e.printStackTrace();
            String timeNow=String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL,"Test 6 Failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }
    @Test
    public void test_07_sendInformation() {
        try {
            SendInformation sendInformationPage= new SendInformation();
            sendInformationPage.sendInformation();
            test.log(Status.PASS, "Test 7 Passed");
        }
      catch (Exception e){
          e.printStackTrace();
          String timeNow=String.valueOf(System.currentTimeMillis());
          test.log(Status.FAIL,"Test 7 Failed"+e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
      }
    }
    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        DriverSingleton.getDriverInstance().quit();
        // build and flush report
        extent.flush();
    }
    public static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverSingleton.getDriverInstance();
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }
    }
