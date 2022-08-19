package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.NewsPageGismeteo;

import java.util.*;

public class NewsPageTest extends DefaultPageTest {
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
    public void checkNewsURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
        Assertions.assertEquals("https://www.gismeteo.ru/news/", driver.getCurrentUrl(), "https://www.gismeteo.ru/news/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void checkTopLinks() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
        ArrayList<String> topLinksSet = new ArrayList<String>();
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
    public void getTitlesTopSevenNewsTab() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
        WebElement someElement = driver.findElement(NewsPageGismeteo.topSevenNewsSelector);
        List<WebElement> someElements = someElement.findElements(By.className("card-wrap"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }


    @Test
    public void countElementsFirstColumn() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
        WebElement firstColumnTab = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        String amountOfChildren = "10";
        Assertions.assertEquals(amountOfChildren, firstColumnTab.getAttribute("childElementCount"), "Количество детей (" + firstColumnTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void readAlsoCounterChildren() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
        String amountOfChildren = "10";
        WebElement readAlsoField = driver.findElement(NewsPageGismeteo.readAlsoElementSelector);
        Assertions.assertEquals(amountOfChildren, readAlsoField.getAttribute("childElementCount"), "Количество детей (" + readAlsoField.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void explainingRFCountChildren() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
        String amountOfChildren = "9";
        WebElement explainingRFTab = driver.findElement(NewsPageGismeteo.explainingRFTabSelector);
        Assertions.assertEquals(amountOfChildren, explainingRFTab.getAttribute("childElementCount"), "Количество детей (" + explainingRFTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void TwentyFourSMICountChildren() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
        String amountOfChildren = "11";
        WebElement twentySMIFourTab = driver.findElement(NewsPageGismeteo.twentyFourSMITabSelector);
        Assertions.assertEquals(amountOfChildren, twentySMIFourTab.getAttribute("childElementCount"), "Количество детей (" + twentySMIFourTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void MoscowTwentyFourCountChildren() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
        String amountOfChildren = "8";
        WebElement moscowTwentyFourFourTab = driver.findElement(NewsPageGismeteo.moscowTwentyFourTabSelector);
        Assertions.assertEquals(amountOfChildren, moscowTwentyFourFourTab.getAttribute("childElementCount"), "Количество детей (" + moscowTwentyFourFourTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void getTitlesReadAlsoTab() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }

    @Test
    public void checkMoreNewsButton() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
        clickElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        Integer countArticles = 0;
        for (WebElement articleItem : someElements) {
            System.out.println(articleItem.getAttribute("innerText"));
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
            countArticles++;
        }
        System.out.println(countArticles);
        driver.quit();
    }

    @Test
    public void clickMoreNewsButton() {
        Integer maxAmountOfClicks = 100;
        Integer amountOfClicks = 0;
        Integer countArticles = 0;
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
        WebElement moreNewsButton = driver.findElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
        while (moreNewsButton.isDisplayed() && amountOfClicks <= maxAmountOfClicks) {
            clickElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
            amountOfClicks++;
        }
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
            countArticles++;
        }
        driver.quit();
    }
}