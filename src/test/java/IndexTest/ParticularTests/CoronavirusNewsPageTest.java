package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.NewsPageGismeteo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoronavirusNewsPageTest extends DefaultPageTest {
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
    public void checkCoronavirusURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/coronavirus");
        Assertions.assertEquals("https://www.gismeteo.ru/news/coronavirus/", driver.getCurrentUrl(), "https://www.gismeteo.ru/news/coronavirus/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void coronavirusCheckTopLinks() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/coronavirus/");
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
    public void coronavirusNewsCountElementsFirstColumn() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/coronavirus/");
        WebElement firstColumnTab = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        String amountOfChildren = "10";
        Assertions.assertEquals(amountOfChildren, firstColumnTab.getAttribute("childElementCount"), "Количество детей (" + firstColumnTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void getTitlesTopSevenCoronavirusNewsTab() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/coronavirus/");
        WebElement someElement = driver.findElement(NewsPageGismeteo.topSevenNewsSelector);
        List<WebElement> someElements = someElement.findElements(By.className("card-wrap"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/coronavirus/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }

    @Test
    public void readAlsoCounterChildrenCoronavirusNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/coronavirus/");
        String amountOfChildren = "10";
        WebElement readAlsoField = driver.findElement(NewsPageGismeteo.readAlsoElementSelector);
        Assertions.assertEquals(amountOfChildren, readAlsoField.getAttribute("childElementCount"), "Количество детей (" + readAlsoField.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void explainingRFCountChildrenCoronavirusNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/coronavirus/");
        String amountOfChildren = "9";
        WebElement explainingRFTab = driver.findElement(NewsPageGismeteo.explainingRFTabSelector);
        Assertions.assertEquals(amountOfChildren, explainingRFTab.getAttribute("childElementCount"), "Количество детей (" + explainingRFTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void TwentyFourSMICountChildrenCoronavirusNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/coronavirus/");
        String amountOfChildren = "11";
        WebElement twentySMIFourTab = driver.findElement(NewsPageGismeteo.twentyFourSMITabSelector);
        Assertions.assertEquals(amountOfChildren, twentySMIFourTab.getAttribute("childElementCount"), "Количество детей (" + twentySMIFourTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void MoscowTwentyFourCountChildrenCoronavirusNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/coronavirus/");
        String amountOfChildren = "8";
        WebElement moscowTwentyFourFourTab = driver.findElement(NewsPageGismeteo.moscowTwentyFourTabSelector);
        Assertions.assertEquals(amountOfChildren, moscowTwentyFourFourTab.getAttribute("childElementCount"), "Количество детей (" + moscowTwentyFourFourTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
        driver.quit();
    }

    @Test
    public void getTitlesReadAlsoTabCoronavirusNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/coronavirus/");
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/coronavirus/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }

    @Test
    public void checkMoreNewsButtonCoronavirusNews() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/coronavirus/");
        clickElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/coronavirus/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }

    @Test
    public void clickMoreNewsButtonCoronavirusNews() {
        int maxAmountOfClicks = 100;
        int amountOfClicks = 0;
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/coronavirus/");
        WebElement moreNewsButton = driver.findElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
        while (moreNewsButton.isDisplayed() && amountOfClicks <= maxAmountOfClicks) {
            clickElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
            amountOfClicks++;
        }
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/coronavirus/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
    }
}