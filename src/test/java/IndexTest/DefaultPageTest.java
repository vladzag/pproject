package IndexTest;

import common.CommonActivities;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webpages.defaultData.DefaultPage;
import webpages.gismeteo.IndexPageGismeteo;

public class DefaultPageTest {

    protected WebDriver driver = CommonActivities.createDriver();
    Actions action = new Actions(driver);

    protected IndexPageGismeteo indexPage = new IndexPageGismeteo(driver);
    protected DefaultPage defaultPage = new DefaultPage(driver);

    public void clickElement(By byName) {
        driver.findElement(byName).click();
    }

    public void hoverOverElement (By byName){
        action.moveToElement((WebElement) byName).build().perform();
    }

    public String getText(By byName) {
        return driver.findElement(byName).getText();
    }

}