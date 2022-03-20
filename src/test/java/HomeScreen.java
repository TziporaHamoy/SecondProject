import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class HomeScreen extends MainTest {
    public void homeScreen(){
        price();
       // region();
        //category();
       // findPresentToMe();
    }
    private void price(){
        Select mySelection = new Select( DriverSingleton.getDriverInstance().findElement(By.id("ember1042")));
        mySelection.selectByVisibleText("עד 99 ש\"ח");
    }
    //private void region(){}
   // private void category(){}
   // private void findPresentToMe(){}
}
