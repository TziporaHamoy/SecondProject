import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SendInformation extends BasePage{
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));
    public void sendInformation() {
        pressRadioButtonNow();
        pickEmail();
        insertEmail();
        assertSenderName();
        continueToPayment();
    }
    private void pressRadioButtonNow(){
        wait.until(ExpectedConditions.elementToBeClickable(By.className("button-now"))).click();
    }
    private void pickEmail(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg[gtm=method-email]"))).click();
    }
    private void insertEmail(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("email"))).sendKeys("027103939z@gmail.com");
    }
    private void assertSenderName(){
        //clearElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/label/input"));
        DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/label/input")).clear();
        //sendKeysToElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/label/input"),Constants.name);
        DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/label/input")).sendKeys(Constants.name);
        String senderName = DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[3]/div[2]/label/input")).getAttribute("value");
        Assert.assertEquals(senderName,Constants.name);
    }
    private void continueToPayment(){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember2705"))).click();//ember2962
    }
}
