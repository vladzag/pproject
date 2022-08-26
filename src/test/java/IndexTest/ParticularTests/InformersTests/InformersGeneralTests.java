package IndexTest.ParticularTests.InformersTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.IndexPageGismeteo;
import webpages.gismeteo.pages.InfoPageGismeteo;
import webpages.gismeteo.pages.MapsPageGismeteo;
import webpages.gismeteo.pages.NewsPageGismeteo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

public class InformersGeneralTests extends DefaultPageTest {
    @Test
    public void informersCheckURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/");
        Assertions.assertEquals("https://www.gismeteo.ru/informers/", driver.getCurrentUrl(), "https://www.gismeteo.ru/informers/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
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
        driver.quit();
    }

    @Test
    public void checkForTableElements() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/");
        WebElement scrollerTableElement = driver.findElement(InfoPageGismeteo.scrollerTableSelector);
        List<WebElement> scrollerTableElementsList = scrollerTableElement.findElements(By.className("b-j-scroller__cell"));
        int countElementNumber = 1;
        for (WebElement tableElement : scrollerTableElementsList) {
            System.out.println(countElementNumber + ".  " + tableElement.getLocation() + "   " + tableElement.getSize() + tableElement.getAttribute("innerHTML"));
            Assertions.assertTrue(tableElement.getAttribute("innerHTML").contains("gismeteo.ru/assets/"));
            countElementNumber++;
        }
        driver.quit();
    }

    @Test
    public void checkOffer() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/");
        clickElement(InfoPageGismeteo.offerConditionsSelector);
        Assertions.assertEquals("https://www.gismeteo.ru/informers/offer/", driver.getCurrentUrl(), "https://www.gismeteo.ru/informers/offer/" + driver.getCurrentUrl() + " не соответствуют");
        WebElement firstParagraph = driver.findElement(By.cssSelector("#content > div > p:nth-child(2)"));
        Assertions.assertTrue(firstParagraph.getAttribute("innerHTML").contains("ООО «НПЦ «Мэп Мейкер» владеет и управляет сайтом www.gismeteo.ru (далее — Сайт)"));
        driver.quit();
    }
}
