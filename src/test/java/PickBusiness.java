import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PickBusiness extends  MainTest{
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));
    public void pickBusiness(){
        selectBusiness();
        enterChoosePrice();
        press();
    }
    private void selectBusiness() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/ul/div[4]/a/div"))).click();
    }
    private void enterChoosePrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=tel]"))).sendKeys("100");
    }
    private void press(){
        wait.until(ExpectedConditions.elementToBeClickable(By.className("money-btn"))).click();
    }
    }

