package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.NewsPageGismeteo;

public class NewsPageTest extends DefaultPageTest {

    @BeforeEach
    public void beforeEachMethod() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/");
    }

    @AfterEach
    public void afterEachMethod() {
        driver.quit();
    }

    @Test
    public void checkURL() {
        Assertions.assertEquals("https://www.gismeteo.ru/news/", driver.getCurrentUrl(), "https://www.gismeteo.ru/news/" + driver.getCurrentUrl() + " не соответствуют");
    }

    @Test
    public void checkTopLinks() {
        String expectedTopLinks = "Все новости\n" + "Эпидемия коронавируса\n" + "Наука и космос\n" + "О погоде\n" + "Пожары в России\n" + "Природа\n" + "Авто\n" + "Животные";
        WebElement topLinks = driver.findElement(NewsPageGismeteo.linksList);
        Assertions.assertEquals(expectedTopLinks, topLinks.getAttribute("innerText"), expectedTopLinks + " и " + topLinks.getAttribute("innerText") + " do not match");
    }
}
