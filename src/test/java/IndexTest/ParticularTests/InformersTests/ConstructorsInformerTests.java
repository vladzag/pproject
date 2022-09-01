package IndexTest.ParticularTests.InformersTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.InfoPageGismeteo;

import java.util.ArrayList;
import java.util.List;

public class ConstructorsInformerTests extends DefaultPageTest {

    @BeforeEach
    public void beforeEachMethod() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL);
    }

    @AfterEach
    public void AfterEachMethod() {driver.quit();}

    @Test
    public void constructorsCheckURL() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.gismeteo.ru/informers/constructor/#"));
    }

    @Test
    public void simpleInformerCheckTopLinks() {
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
    }

    @Test
    public void checkForLanguagesAvailable() {
        WebElement generalListOfLanguages = driver.findElement(InfoPageGismeteo.informersLanguageSelector);
        String locatorID = "languageLabel";
        for (int i = 1; i == 8; i++) {
            System.out.println(locatorID);
            locatorID = locatorID + i;
            System.out.println("new locatorID is " + locatorID);
            generalListOfLanguages.findElement(By.id(locatorID)).click();
            System.out.println(generalListOfLanguages.findElement(By.id(locatorID)).getText());
        }
    }

}
