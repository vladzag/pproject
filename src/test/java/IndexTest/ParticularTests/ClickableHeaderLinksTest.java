package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static webpages.gismeteo.IndexPageGismeteo.*;


public class ClickableHeaderLinksTest extends DefaultPageTest {
    @Test
    public void ClickableHeaderLinksTest() {
        defaultPage.openWebPages("https://www.gismeteo.ru/");
        clickElement(headerLinkMaps);
        String mapsTitleExpected = "GISMETEO: осадки в Европе, прогноз осадков на карте Европы";
        Assertions.assertEquals(mapsTitleExpected, driver.getTitle(), "was expected " + mapsTitleExpected + ", but got " + driver.getTitle());
        clickElement(headerLinkInformers);
        String informersTitleExpected = "GISMETEO:";
        Assertions.assertEquals(informersTitleExpected, driver.getTitle(), "was expected " + informersTitleExpected + ", but got " + driver.getTitle());
        clickElement(headerLinkNews);
        String newsTitleExpected = "GISMETEO: Новости погоды. Свежие новости погоды в России и мире. Погодные новости дня.";
        Assertions.assertEquals(newsTitleExpected, driver.getTitle(), "was expected " + newsTitleExpected + ", but got " + driver.getTitle());
        clickElement(headerLinkSoft);
        String softTitleExpected = "GISMETEO: погодные приложения, программы и виджеты погоды";
        Assertions.assertEquals(softTitleExpected, driver.getTitle(), "was expected " + softTitleExpected + ", but got " + driver.getTitle());
        clickElement(headerLinkWeather);
        String weatherTitleExpected = "GISMETEO: Погода в России, прогноз погоды на сегодня, завтра, 3 дня, выходные, неделю, 10 дней, месяц.";
        Assertions.assertEquals(weatherTitleExpected, driver.getTitle(), "was expected " + weatherTitleExpected + ", but got " + driver.getTitle());
        driver.quit();
    }


}
