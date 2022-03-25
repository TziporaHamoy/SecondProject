import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainTest {
   private static ExtentReports extent= new ExtentReports();
   private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
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
        String byMeUrl= "https://buyme.co.il/";
        Assert.assertEquals(byMeUrl,DriverSingleton.getDriverInstance().getCurrentUrl());
    }
    @Test
    public void test02_login(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }
    @Test
    public void test03_homeScreen(){
        HomeScreen homeScreenPage= new HomeScreen();
        homeScreenPage.homeScreen();
    }
    @Test
    public void test04_assertionURLScreen3() {
        String byMeeURL3="https://buyme.co.il/search?budget=1&category=359&region=13";
        Assert.assertEquals(byMeeURL3, DriverSingleton.getDriverInstance().getCurrentUrl());

    }
    @Test
    public void test05_pickBusiness() {
        PickBusiness pickBusinessPage = new PickBusiness();
        pickBusinessPage.pickBusiness();
    }
    @Test
    public void test_06_receivedInformation() throws InterruptedException {
        ReceivedInformation receivedInformationPage = new ReceivedInformation();
        receivedInformationPage.receivedInformation();
    }
    @Test
    public void test_07_sendInformation() {
        SendInformation sendInformationpage= new SendInformation();
        sendInformationpage.sendInformation();
    }

    }
