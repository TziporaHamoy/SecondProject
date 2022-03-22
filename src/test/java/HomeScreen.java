import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomeScreen extends MainTest {
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(10));

    public void homeScreen() {
        price();
        region();
        category();
        findPresentToMe();
    }

    private void price() {
        WebElement price = DriverSingleton.getDriverInstance().findElement(By.cssSelector("span[alt=סכום]"));
        wait.until(ExpectedConditions.elementToBeClickable(price));
        price.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1064"))).click();
    }

    private void region() {
        WebElement region = DriverSingleton.getDriverInstance().findElement(By.cssSelector("span[alt=אזור]"));
        wait.until(ExpectedConditions.elementToBeClickable(region));
        region.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1099"))).click();
    }

    private void category() {
        WebElement category = DriverSingleton.getDriverInstance().findElement(By.cssSelector("span[alt=קטגוריה]"));
        wait.until(ExpectedConditions.elementToBeClickable(category));
        category.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1160")));
    }

    private void findPresentToMe() {
        WebElement findPresent = DriverSingleton.getDriverInstance().findElement(By.linkText("תמצאו לי מתנה"));//(By.id("ember1188")))
        findPresent.click();

    }
}

