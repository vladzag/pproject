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
    public void informersCheckURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/simple/");
        Assertions.assertEquals("https://www.gismeteo.ru/informers/simple/", driver.getCurrentUrl(), "https://www.gismeteo.ru/informers/simple/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void simpleInformerCheckTopLinks() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/simple");
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
        driver.quit();
    }

    @Test
    public void checkForSimpleInformersHeader() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/simple");
        WebElement someElement = driver.findElement(InfoPageGismeteo.simpleInformersHeaderSelector);
        Assertions.assertTrue(someElement.getText().contains("Простые информеры"));
        driver.quit();
    }

    @Test
    public void checkForSimpleInformersCheckItems() {
        int expectedAmountOfItems = 24;
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/simple");
        WebElement someElement = driver.findElement(InfoPageGismeteo.simpleInformersHeaderSelector);
        List<WebElement> someList = someElement.findElements(By.className("informers__type"));
        int amountOfItems = 0;
        ArrayList<String> listOfStrings = new ArrayList<>();
        for (WebElement someListElement : someList) {
            amountOfItems = amountOfItems + someListElement.findElements(By.className("informer")).size();
            listOfStrings.add(someListElement.getText());
        }
        Assertions.assertTrue(amountOfItems == expectedAmountOfItems);
        driver.quit();
    }

    @Test
    public void checkForSimpleInformersCheckFilling() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/simple");
        WebElement someElement = driver.findElement(InfoPageGismeteo.simpleInformersHeaderSelector);
        List<WebElement> someList = someElement.findElements(By.className("informers__type"));
        ArrayList<String> listOfStringsFromElements = new ArrayList<String>();
        for (WebElement someListElement : someList) {
            listOfStringsFromElements.add(someListElement.getAttribute("clientHeight"));
            listOfStringsFromElements.add(someListElement.getAttribute("clientWidth"));
        }
        Assertions.assertTrue(listOfStringsFromElements != null);
        driver.quit();
    }

    @Test
    public void checkLinkOfInformer() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/simple");
        WebElement someElement = driver.findElement(InfoPageGismeteo.simpleInformersHeaderSelector);
        List<WebElement> someList = someElement.findElements(By.className("informer"));
        for (WebElement someListElement : someList) {
            Assertions.assertTrue(someListElement.getAttribute("href").contains("https://www.gismeteo.ru/informers/simple/tuner"));
        }
        driver.quit();
    }
}
