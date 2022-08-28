package IndexTest.ParticularTests.InformersTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.Test;
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
    }

    @Test
    public void informerCheckTopLinks() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/");
        ArrayList<String> topLinksSet = new ArrayList<String>();
        topLinksSet.add("Простой информер");
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
    public void checkForHeadersTextOfSection() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/");
        WebElement someElement = driver.findElement(InfoPageGismeteo.simpleInformersHeaderSelector);
        Assertions.assertTrue(someElement.getText().contains("Создайте свой уникальный погодный информер"));
    }
}
