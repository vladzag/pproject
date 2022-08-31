package IndexTest.ParticularTests.InformersTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.InfoPageGismeteo;

import java.util.ArrayList;
import java.util.List;

public class ConstructorsInformerTests extends DefaultPageTest {
/*
    @BeforeAll
    public void BeforeEachMethod() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/simple/");
    }

    @AfterEach
    public void AfterEachMethod() {
        driver.close();
    }

    @AfterAll
    public void AfterAllMethod() {
        driver.quit();
    }*/

    @Test
    public void constructorsCheckURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/constructor/");
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.gismeteo.ru/informers/constructor/#"));
        driver.quit();
    }

    @Test
    public void simpleInformerCheckTopLinks() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/constructor/");
        ArrayList<String> topLinksSet = new ArrayList<String>();
        topLinksSet.add("Простой информер");
        topLinksSet.add("Условия использования");
        WebElement topLinks = driver.findElement(InfoPageGismeteo.topLinksSelector);
        List<WebElement> topLinksNames = topLinks.findElements(new By.ByCssSelector(".subnav_item.nolink"));
        ArrayList<String> someStringList = new ArrayList<String>();
        for (WebElement elementName : topLinksNames) {
            someStringList.add(elementName.getText());
        }
        Assertions.assertEquals(someStringList.containsAll(topLinksSet), topLinksSet.containsAll(someStringList));
        driver.quit();
    }

    @Test
    public void checkForLanguagesAvailable() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/constructor/");
        WebElement generalListOfLanguages = driver.findElement(InfoPageGismeteo.informersLanguageSelector);
        String locatorID = "languageLabel";
        for (int i = 1; i == 8; i++) {
            System.out.println(locatorID);
            locatorID = locatorID + i;
            System.out.println("new locatorID is " + locatorID);
            generalListOfLanguages.findElement(By.id(locatorID)).click();
            System.out.println(generalListOfLanguages.findElement(By.id(locatorID)).getText());
        }
        driver.quit();
    }

}
