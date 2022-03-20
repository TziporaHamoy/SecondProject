import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends MainTest {

public void login(){
    loginOrRegistration();
    registration();
    enterDetails();
}
private void loginOrRegistration(){
    DriverSingleton.getDriverInstance().findElement(By.className("notSigned")).click();
}
private void registration(){
    DriverSingleton.getDriverInstance().findElement(By.className("text-link")).click();
}
private void enterDetails(){
    //name
    WebElement nameElement= DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[1]/label/input"));
    nameElement.sendKeys("Tzipora Hamoy2");
    String name="Tzipora Hamoy2";
   // Assert.assertEquals(name,nameElement.getText());
    //email
    WebElement emailElement= DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[2]/label/input"));
    emailElement.sendKeys("05271039392z@gmail.com");
    String email="05271039392z@gmail.com";
    //Assert.assertEquals(email,emailElement);
    //password
    WebElement passwordElemnt=DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[3]/label/input"));
    passwordElemnt.sendKeys("Zmzm23973");
    String password="Zmzm23973";
    //Assert.assertEquals(passwordElemnt,password);
    //validation password
    WebElement validationPasswordElement= DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[4]/label/input"));
    validationPasswordElement.sendKeys("Zmzm23973");
    String validationPassword= "Zmzm23973";
   // Assert.assertEquals(validationPassword,validationPasswordElement);
    //Buyme registration
    DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/button")).click();
}

}
