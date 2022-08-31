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

public class ScienceNewsPageTest extends DefaultPageTest {
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
    public void checkScienceURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
        Assertions.assertEquals("https://www.gismeteo.ru/news/science/", driver.getCurrentUrl(), "https://www.gismeteo.ru/news/science/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void natureCheckTopLinks() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
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
    public void scienceNewsCountElementsFirstColumn() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
        WebElement firstColumnTab = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        String amountOfChildren = "10";
        Assertions.assertEquals(amountOfChildren, firstColumnTab.getAttribute("childElementCount"), "Количество детей (" + firstColumnTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void getTitlesTopSevenScienceNewsTab() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
        WebElement someElement = driver.findElement(NewsPageGismeteo.topSevenNewsSelector);
        List<WebElement> someElements = someElement.findElements(By.className("card-wrap"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/science/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }

    @Test
    public void readAlsoCounterChildrenScienceNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
        String amountOfChildren = "10";
        WebElement readAlsoField = driver.findElement(NewsPageGismeteo.readAlsoElementSelector);
        Assertions.assertEquals(amountOfChildren, readAlsoField.getAttribute("childElementCount"), "Количество детей (" + readAlsoField.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void explainingRFCountChildrenScienceNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
        String amountOfChildren = "9";
        WebElement explainingRFTab = driver.findElement(NewsPageGismeteo.explainingRFTabSelector);
        Assertions.assertEquals(amountOfChildren, explainingRFTab.getAttribute("childElementCount"), "Количество детей (" + explainingRFTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void TwentyFourSMICountChildrenScienceNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
        String amountOfChildren = "11";
        WebElement twentySMIFourTab = driver.findElement(NewsPageGismeteo.twentyFourSMITabSelector);
        Assertions.assertEquals(amountOfChildren, twentySMIFourTab.getAttribute("childElementCount"), "Количество детей (" + twentySMIFourTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void MoscowTwentyFourCountChildrenScienceNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
        String amountOfChildren = "8";
        WebElement moscowTwentyFourFourTab = driver.findElement(NewsPageGismeteo.moscowTwentyFourTabSelector);
        Assertions.assertEquals(amountOfChildren, moscowTwentyFourFourTab.getAttribute("childElementCount"), "Количество детей (" + moscowTwentyFourFourTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void getTitlesReadAlsoTabScienceNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/science/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }

    @Test
    public void checkMoreNewsButtonScienceNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
        clickElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/science/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }

    @Test
    public void clickMoreNewsButtonScienceNews() {
        int maxAmountOfClicks = 100;
        int amountOfClicks = 0;
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
        WebElement moreNewsButton = driver.findElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
        while (moreNewsButton.isDisplayed() && amountOfClicks <= maxAmountOfClicks) {
            clickElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
            amountOfClicks++;
        }
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/science/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }
}