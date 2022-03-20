import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainTest {
    @BeforeClass
    public void beforeAll(){
        DriverSingleton.getDriverInstance().get("https://buyme.co.il/");
        DriverSingleton.getDriverInstance().manage().window().maximize();
        DriverSingleton.getDriverInstance().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        DriverSingleton.getDriverInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

    }
