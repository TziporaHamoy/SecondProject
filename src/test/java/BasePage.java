import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class BasePage {
    public void clickElement(By locator) {
        getWebElement(locator).click();
    }
    public void sendKeysToElementList(int index, String text, List<WebElement> list){
    list.get(index).sendKeys(text);
    }
    public WebElement getWebElementFromList(List<WebElement> list, int index) {
        return list.get(index);
    }
    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    public WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }

    public void clearElement(By locator) {
        getWebElement(locator).clear();
    }

    public static String getData (String keyName) throws Exception
    //פונקציה להבאת DATA מתוך קובץ XML בו  קיימות הגדרות לפרויקט
    {
        ClassLoader classLoader = BasePage.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(Objects.requireNonNull(classLoader.getResource("data.xml")).getFile()));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
}