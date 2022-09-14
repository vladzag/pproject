package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import webpages.gismeteo.IndexPageGismeteo;

public class UXTests extends DefaultPageTest {
    //TODO здесь будут тесты на пользовательское поведение
    @BeforeEach
    public void beforeEachMethod() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL);
    }

    @AfterEach
    public void afterEachMethod() {
        driver.quit();
    }

    @Test
    public void someTestName() throws InterruptedException {
        indexPage.searchFieldWithText("Москва");
        Thread.sleep(100);
        clickElement(IndexPageGismeteo.firstItemInSearchUXSelector);
        Thread.sleep(2500);
        clickElement(webpages.gismeteo.UXTests.watchLivePrecipitationSelector);
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.gismeteo.ru/nowcast-moscow-"));
        clickElement(webpages.gismeteo.UXTests.buttonPressPrecipitationsPlaySelector);
        Thread.sleep(2000);
        clickElement(webpages.gismeteo.UXTests.buttonPressPrecipitationsPlaySelector);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)", "");
        Thread.sleep(200);
        js.executeScript("window.scrollBy(0,-500)", "");
        Thread.sleep(300);
        clickElement(webpages.gismeteo.UXTests.clickWeatherNowInMoscowSelector);
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.gismeteo.ru/weather-moscow-4368/now/"));
        driver.findElement(webpages.gismeteo.UXTests.searchForStPetSelector).sendKeys("Санк", Keys.ENTER);
        clickElement(IndexPageGismeteo.firstItemInSearchUXSelector);
        Assertions.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.gismeteo.ru/weather-sankt-peterburg-4079/now/"));
        clickElement(webpages.gismeteo.UXTests.weatherTomorrowStPetSelector);
        Assertions.assertTrue(driver.getCurrentUrl().contains("4079/tomorrow"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("sankt-peterburg-");


    }
}