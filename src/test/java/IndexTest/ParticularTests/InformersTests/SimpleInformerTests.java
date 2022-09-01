package IndexTest.ParticularTests.InformersTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.InfoPageGismeteo;
import java.util.ArrayList;
import java.util.List;

public class SimpleInformerTests extends DefaultPageTest {
    @BeforeEach
    public void BeforeEachMethod() {defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/simple/");}

    @AfterEach
    public void AfterEachMethod() {
        driver.quit();
    }

    @Test
    public void informersCheckURL() {
        Assertions.assertEquals("https://www.gismeteo.ru/informers/simple/", driver.getCurrentUrl(), "https://www.gismeteo.ru/informers/simple/" + driver.getCurrentUrl() + " не соответствуют");
    }

    @Test
    public void simpleInformerCheckTopLinks() {
        ArrayList<String> topLinksSet = new ArrayList<String>();
        topLinksSet.add("Конструктор");
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
    public void checkForSimpleInformersHeader() {
        WebElement someElement = driver.findElement(InfoPageGismeteo.simpleInformersHeaderSelector);
        Assertions.assertTrue(someElement.getText().contains("Простые информеры"));
    }

    @Test
    public void checkForSimpleInformersCheckItems() {
        int expectedAmountOfItems = 24;
        WebElement someElement = driver.findElement(InfoPageGismeteo.simpleInformersHeaderSelector);
        List<WebElement> someList = someElement.findElements(By.className("informers__type"));
        int amountOfItems = 0;
        ArrayList<String> listOfStrings = new ArrayList<>();
        for (WebElement someListElement : someList) {
            amountOfItems = amountOfItems + someListElement.findElements(By.className("informer")).size();
            listOfStrings.add(someListElement.getText());
        }
        Assertions.assertTrue(amountOfItems == expectedAmountOfItems);
    }

    @Test
    public void checkForSimpleInformersCheckFilling() {
        WebElement someElement = driver.findElement(InfoPageGismeteo.simpleInformersHeaderSelector);
        List<WebElement> someList = someElement.findElements(By.className("informers__type"));
        ArrayList<String> listOfStringsFromElements = new ArrayList<String>();
        for (WebElement someListElement : someList) {
            listOfStringsFromElements.add(someListElement.getAttribute("clientHeight"));
            listOfStringsFromElements.add(someListElement.getAttribute("clientWidth"));
        }
        Assertions.assertTrue(listOfStringsFromElements != null);
    }

    @Test
    public void checkLinkOfInformer() {
        WebElement someElement = driver.findElement(InfoPageGismeteo.simpleInformersHeaderSelector);
        List<WebElement> someList = someElement.findElements(By.className("informer"));
        for (WebElement someListElement : someList) {
            Assertions.assertTrue(someListElement.getAttribute("href").contains("https://www.gismeteo.ru/informers/simple/tuner"));
        }
    }
}
