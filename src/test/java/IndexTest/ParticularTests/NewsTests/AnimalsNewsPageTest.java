package IndexTest.ParticularTests.NewsTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.NewsPageGismeteo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalsNewsPageTest extends DefaultPageTest {

    @BeforeEach
    public void beforeEachMethod() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/animals");
    }

    @AfterEach
    public void afterEachMethod() {
        driver.quit();
    }

    @Test
    public void checkAnimalsURL() {
        Assertions.assertEquals("https://www.gismeteo.ru/news/animals/", driver.getCurrentUrl(), "https://www.gismeteo.ru/news/animals/" + driver.getCurrentUrl() + " не соответствуют");
    }

    @Test
    public void animalsCheckTopLinks() {
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
    }

    @Test
    public void animalsNewsCountElementsFirstColumn() {
        WebElement firstColumnTab = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        String amountOfChildren = "10";
        Assertions.assertEquals(amountOfChildren, firstColumnTab.getAttribute("childElementCount"), "Количество детей (" + firstColumnTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
    }

    @Test
    public void getTitlesTopSevenAnimalsNewsTab() {
        WebElement someElement = driver.findElement(NewsPageGismeteo.topSevenNewsSelector);
        List<WebElement> someElements = someElement.findElements(By.className("card-wrap"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/animals/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
    }

    @Test
    public void readAlsoCounterChildrenAnimalsNews() {
        String amountOfChildren = "10";
        WebElement readAlsoField = driver.findElement(NewsPageGismeteo.readAlsoElementSelector);
        Assertions.assertEquals(amountOfChildren, readAlsoField.getAttribute("childElementCount"), "Количество детей (" + readAlsoField.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
    }

    @Test
    public void explainingRFCountChildrenAnimalsNews() {
        String amountOfChildren = "9";
        WebElement explainingRFTab = driver.findElement(NewsPageGismeteo.explainingRFTabSelector);
        Assertions.assertEquals(amountOfChildren, explainingRFTab.getAttribute("childElementCount"), "Количество детей (" + explainingRFTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
    }

    @Test
    public void TwentyFourSMICountChildrenAnimalsNews() {
        String amountOfChildren = "11";
        WebElement twentySMIFourTab = driver.findElement(NewsPageGismeteo.twentyFourSMITabSelector);
        Assertions.assertEquals(amountOfChildren, twentySMIFourTab.getAttribute("childElementCount"), "Количество детей (" + twentySMIFourTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
    }

    @Test
    public void MoscowTwentyFourCountChildrenAnimalsNews() {
        String amountOfChildren = "8";
        WebElement moscowTwentyFourFourTab = driver.findElement(NewsPageGismeteo.moscowTwentyFourTabSelector);
        Assertions.assertEquals(amountOfChildren, moscowTwentyFourFourTab.getAttribute("childElementCount"), "Количество детей (" + moscowTwentyFourFourTab.getAttribute("childElementCount") + ") не равно ожидаемому (" + amountOfChildren + ")");
    }

    @Test
    void getTitlesReadAlsoTabAnimalsNews() {
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/animals/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
    }

    @Test
    public void checkMoreNewsButtonAnimalsNews() {
        clickElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/animals/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
    }

    @Test
    public void clickMoreNewsButtonAnimalsNews() {
        int maxAmountOfClicks = 100;
        int amountOfClicks = 0;
        WebElement moreNewsButton = driver.findElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
        while (moreNewsButton.isDisplayed() && amountOfClicks <= maxAmountOfClicks) {
            clickElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
            amountOfClicks++;
        }
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/animals/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
    }
}