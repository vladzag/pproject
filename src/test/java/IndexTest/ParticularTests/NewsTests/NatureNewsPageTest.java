package IndexTest.ParticularTests.NewsTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.NewsPageGismeteo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NatureNewsPageTest extends DefaultPageTest {
/*
    @BeforeEach
    public void beforeEachMethod() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
    }

    @AfterEach
    public void afterEachMethod() {
        driver.quit();
    }*/

    @Test
    public void checkNatureURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/nature");
        Assertions.assertEquals("https://www.gismeteo.ru/news/nature/", driver.getCurrentUrl(), "https://www.gismeteo.ru/news/nature/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void natureCheckTopLinks() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/nature/");
        ArrayList<String> topLinksSet = new ArrayList<>();
        topLinksSet.add("Все новости");
        topLinksSet.add("Авто");
        topLinksSet.add("Животные");
        topLinksSet.add("Наука и космос");
        topLinksSet.add("О погоде");
        topLinksSet.add("Пожары в России");
        topLinksSet.add("Природа");
        topLinksSet.add("Эпидемия коронавируса");
        WebElement topLinks = driver.findElement(NewsPageGismeteo.linksList);
        topLinksSet.contains(Collections.singleton(topLinks.getAttribute("innerText")));
        driver.quit();
    }

    @Test
    public void natureNewsCountElementsFirstColumn() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/nature/");
        WebElement firstColumnTab = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        String amountOfChildren = "10";
        Assertions.assertEquals(amountOfChildren, firstColumnTab.getAttribute("childElementCount"), "Количество детей (" + firstColumnTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void getTitlesTopSevenNatureNewsTab() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/nature/");
        WebElement someElement = driver.findElement(NewsPageGismeteo.topSevenNewsSelector);
        List<WebElement> someElements = someElement.findElements(By.className("card-wrap"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/nature/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }

    @Test
    public void readAlsoCounterChildrenNatureNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/nature/");
        String amountOfChildren = "10";
        WebElement readAlsoField = driver.findElement(NewsPageGismeteo.readAlsoElementSelector);
        Assertions.assertEquals(amountOfChildren, readAlsoField.getAttribute("childElementCount"), "Количество детей (" + readAlsoField.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void explainingRFCountChildrenNatureNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/nature/");
        String amountOfChildren = "9";
        WebElement explainingRFTab = driver.findElement(NewsPageGismeteo.explainingRFTabSelector);
        Assertions.assertEquals(amountOfChildren, explainingRFTab.getAttribute("childElementCount"), "Количество детей (" + explainingRFTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void TwentyFourSMICountChildrenNatureNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/nature/");
        String amountOfChildren = "11";
        WebElement twentySMIFourTab = driver.findElement(NewsPageGismeteo.twentyFourSMITabSelector);
        Assertions.assertEquals(amountOfChildren, twentySMIFourTab.getAttribute("childElementCount"), "Количество детей (" + twentySMIFourTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void MoscowTwentyFourCountChildrenNatureNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/nature/");
        String amountOfChildren = "8";
        WebElement moscowTwentyFourFourTab = driver.findElement(NewsPageGismeteo.moscowTwentyFourTabSelector);
        Assertions.assertEquals(amountOfChildren, moscowTwentyFourFourTab.getAttribute("childElementCount"), "Количество детей (" + moscowTwentyFourFourTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void getTitlesReadAlsoTabNatureNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/nature/");
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/nature/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }

    @Test
    public void checkMoreNewsButtonNatureNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/nature/");
        clickElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/nature/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }

    @Test
    public void clickMoreNewsButtonNatureNews() {
        int maxAmountOfClicks = 100;
        int amountOfClicks = 0;
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/nature/");
        WebElement moreNewsButton = driver.findElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
        while (moreNewsButton.isDisplayed() && amountOfClicks <= maxAmountOfClicks) {
            clickElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
            amountOfClicks++;
        }
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/nature/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }
}