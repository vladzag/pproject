package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        clickElement(IndexPageGismeteo.firstItemInSearch);
        Thread.sleep(2500);
clickElement(webpages.gismeteo.UXTests.watchLivePrecipitationSelector);
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.gismeteo.ru/nowcast-moscow-"));
    }
}