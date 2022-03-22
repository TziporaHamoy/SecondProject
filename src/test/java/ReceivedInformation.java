import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ReceivedInformation extends MainTest{
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));
    public void receivedInformation() throws InterruptedException {
        toAnotherPerson();
        receiverPresentName();
        pickAnEvent();
        blessing();
        uploadPicture();
        pressContinue();
    }
    private void toAnotherPerson(){
        DriverSingleton.getDriverInstance().findElement(By.className("button-forSomeone")).click();
    }
    private void receiverPresentName() throws InterruptedException {
        WebElement receiverPresentName= DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[2]/div[1]/label/input"));
        Thread.sleep(2000);
        receiverPresentName.sendKeys(Constants.receiverName);
        String findReceiverPresentName =DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[2]/div[1]/label/input")).getAttribute("value");
        Assert.assertEquals(findReceiverPresentName,Constants.receiverName);
    }
    private void pickAnEvent(){
        WebElement mySelection = DriverSingleton.getDriverInstance().findElement(By.className("selected-name"));
        wait.until(ExpectedConditions.elementToBeClickable(mySelection));
        mySelection.click();
        DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/div/div[1]/form/div[2]/div[2]/label/div/div[2]/ul/li[2]")).click();
    }
    private void blessing(){
        DriverSingleton.getDriverInstance().findElement(By.className("parsley-success")).clear();
        DriverSingleton.getDriverInstance().findElement(By.className("parsley-success")).sendKeys("ברכות ליום הולדתך ה26");
    }
    private void uploadPicture() throws InterruptedException {
        WebElement getPicture = DriverSingleton.getDriverInstance().findElement(By.id("ember2378"));
        Thread.sleep(5000);
        getPicture.sendKeys("C:\\Users\\user1\\Desktop\\Niso.jpg");
        Thread.sleep(15000);
    }
    private void pressContinue(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type=submit]"))).click();
    }
}