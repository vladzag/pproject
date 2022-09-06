package IndexTest.ParticularTests.InformersTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.InfoPageGismeteo;

import java.util.*;

public class InformersGeneralTests extends DefaultPageTest {

    @BeforeEach
    public void BeforeEachMethod() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/");
    }

    @AfterEach
    public void AfterEachMethod() {
        driver.quit();
    }

    @Test
    public void informersCheckURL() {
        Assertions.assertEquals("https://www.gismeteo.ru/informers/", driver.getCurrentUrl(), "https://www.gismeteo.ru/informers/" + driver.getCurrentUrl() + " не соответствуют");
    }

    @Test
    public void informerCheckTopLinks() {
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
    public void checkForTableElements() {
        WebElement scrollerTableElement = driver.findElement(InfoPageGismeteo.scrollerTableSelector);
        List<WebElement> scrollerTableElementsList = scrollerTableElement.findElements(By.className("b-j-scroller__cell"));
        int countElementNumber = 1;
        for (WebElement tableElement : scrollerTableElementsList) {
            System.out.println(countElementNumber + ".  " + tableElement.getLocation() + "   " + tableElement.getSize() + tableElement.getAttribute("innerHTML"));
            Assertions.assertTrue(tableElement.getAttribute("innerHTML").contains("gismeteo.ru/assets/"));
            countElementNumber++;
        }
    }

    @Test
    public void checkOffer() {
        clickElement(InfoPageGismeteo.offerConditionsSelector);
        Assertions.assertEquals("https://www.gismeteo.ru/informers/offer/", driver.getCurrentUrl(), "https://www.gismeteo.ru/informers/offer/" + driver.getCurrentUrl() + " не соответствуют");
        WebElement firstParagraph = driver.findElement(By.cssSelector("#content > div > p:nth-child(2)"));
        Assertions.assertTrue(firstParagraph.getAttribute("innerHTML").contains("ООО «НПЦ «Мэп Мейкер» владеет и управляет сайтом www.gismeteo.ru (далее — Сайт)"));
    }

    @Test
    public void checkForElementsSetAnySite() {
        int expectedamountofitems = 8;
        int counttotalelements = 0;
        int counttotalelementsfirsttime = 1;
        int counttotalementssecondtime = 1;
        List<WebElement> firstListOfElements = driver.findElements(InfoPageGismeteo.firstListSetForAllSitesSelector);
        String array[] = new String[]{"", "Язык", "Модули", "Местоположение", "Показатели"};
        for (int i = 1; i < array.length; i++) {
            for (WebElement element : firstListOfElements) {
                String someName = element.findElement(By.cssSelector("body > section > div:nth-child(4) > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(" + counttotalelementsfirsttime + ") > div > div > h4")).getText();
                Assertions.assertTrue(someName.contains(array[i]));
                counttotalelements++;
                counttotalelementsfirsttime++;
            }
        }
        List<WebElement> secondListOfElements = driver.findElements(InfoPageGismeteo.secondListSetForAllSitesSelector);
        String array2[] = new String[]{"", "Размеры", "Иконки", "Цвет"};
        for (int i = 1; i < array2.length; i++) {
            for (WebElement element : secondListOfElements) {
                String someName2 = element.findElement(By.cssSelector("body > section > div:nth-child(4) > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(" + counttotalementssecondtime + ") > div > div > h4")).getText();
                Assertions.assertTrue(someName2.contains(array2[i]));
                counttotalementssecondtime++;
                counttotalelements++;
            }
        }
        WebElement lastTableElement = driver.findElement(InfoPageGismeteo.setForAnySiteLastSelector);
        Assertions.assertTrue(lastTableElement.getText().contains("Шрифт"));
        if (lastTableElement != null) {
            counttotalelements++;
        }
        Assertions.assertEquals(expectedamountofitems, counttotalelements, " counttotalelements does not match expected one");
    }

    @Test
    public void checkForHeadersTextOfSection() {
        WebElement someElement = driver.findElement(InfoPageGismeteo.simpleInformersHeaderSelector);
        Assertions.assertTrue(someElement.getText().contains("Создайте свой уникальный погодный информер"));
    }
}
