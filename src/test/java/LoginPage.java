import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends MainTest {

public void login(){
    loginOrRegistration();
    registration();
    enterDetails();
    //existingCustomer();
}
private void loginOrRegistration(){
    DriverSingleton.getDriverInstance().findElement(By.className("notSigned")).click();
}
  private void registration(){
    DriverSingleton.getDriverInstance().findElement(By.className("text-link")).click();
}
private void enterDetails(){
    //Name
    WebElement nameElement= DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[1]/label/input")); //*[@id="ember1977"]
    nameElement.sendKeys(Constants.name);
    String name="Tzipora Hamoy";
   // Assert.assertEquals(name,nameElement.getText());
    //Email
    WebElement emailElement= DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[2]/label/input"));//*[@id="ember1984"]
    emailElement.sendKeys(Constants.email);
    String email="052710393901z@gmail.com";
    //Assert.assertEquals(email,emailElement);
    //password
    WebElement passwordElemnt=DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[3]/label/input"));//*[@id="valPass"]
    passwordElemnt.sendKeys(Constants.password);
    String password="Abcabc1234";
    //Assert.assertEquals(passwordElemnt,password);
    //validation password
    WebElement validationPasswordElement= DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/div[4]/label/input ")); //*[@id="ember1998"]
    validationPasswordElement.sendKeys(Constants.password);
    String validationPassword= "Abcabc1234";
   // Assert.assertEquals(validationPassword,validationPasswordElement);
    //Buyme registration
    DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/button")).click();//*[@id="ember2004"]
}
    /*private void existingCustomer(){
       WebElement mail= DriverSingleton.getDriverInstance().findElement(By.xpath("//*[@id=\"ember1768\"]"));
        mail.sendKeys("05271039391z@gmail.com");
        WebElement password= DriverSingleton.getDriverInstance().findElement(By.xpath("//*[@id=\"ember1775\"]"));
        password.sendKeys("Zmzm3973");
        DriverSingleton.getDriverInstance().findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div/div[3]/div[2]/div[3]/form/button")).click();
    }*/

}
