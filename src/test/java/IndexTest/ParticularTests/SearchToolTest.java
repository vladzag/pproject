package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import webpages.gismeteo.IndexPageGismeteo;

import java.util.stream.Stream;

public class SearchToolTest extends DefaultPageTest {

    private static Stream<Arguments> requestList() {
        return Stream.of(
                Arguments.of("Москва", "https://www.gismeteo.ru/weather-moscow-4368/"),
                Arguments.of("Moscow", "https://www.gismeteo.ru/weather-moscow-4368/"),
                Arguments.of("Csphfym", "https://www.gismeteo.ru/weather-syzran-4448/"),
                Arguments.of("Санкт-Петербург (Пулково)", "https://www.gismeteo.ru/weather-sankt-peterburg-pulkovo-12967/"),
                Arguments.of("Урю", "https://www.gismeteo.ru/weather-uryupinsk-5045/"),
                Arguments.of("", "https://www.gismeteo.ru/weather-moscow-4368/"),
                Arguments.of(" ", "https://www.gismeteo.ru/weather-moscow-4368/"),
                Arguments.of("Москва", "https://www.gismeteo.ru/weather-moscow-4368/")

                );
    }

    @ParameterizedTest
    @MethodSource("requestList")
    public void searchFieldTest(String searchRequest, String searchResult) throws InterruptedException {
        defaultPage.openWebPages("https://www.gismeteo.ru/");
        indexPage.searchFieldWithText(searchRequest);
        Thread.sleep(3000);
        clickElement(IndexPageGismeteo.firstItemInSearch);
        Assertions.assertEquals(searchResult, driver.getCurrentUrl(), driver.getCurrentUrl() + " and " + searchResult + " do not match");
    }
}