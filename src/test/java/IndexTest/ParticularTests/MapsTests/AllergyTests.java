package IndexTest.ParticularTests.MapsTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.IndexPageGismeteo;
import webpages.gismeteo.pages.MapsPageGismeteo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

public class AllergyTests extends DefaultPageTest {
    @Test
    public void allergyCheckURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/allergy/");
        Assertions.assertEquals("https://www.gismeteo.ru/maps/allergy/", driver.getCurrentUrl(), "https://www.gismeteo.ru/maps/allergy/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    private static Stream<Arguments> requestList() {
        return Stream.of(
                Arguments.of("Москва", "https://www.gismeteo.ru/maps/allergy/?q=7LVRCKk2hVPTyHlF5fvPkA%3D%3D"),
                Arguments.of("Чебоксары", "https://www.gismeteo.ru/maps/allergy/?q=d5qNt9PD%2F94D2dnA1A8i3w%3D%3D"),
                Arguments.of("Moscow", "https://www.gismeteo.ru/maps/allergy/?q=7LVRCKk2hVPTyHlF5fvPkA%3D%3D"),
                Arguments.of("Сам", "https://www.gismeteo.ru/maps/allergy/?q=iO%2BUhsxUqmpTUzDR8ywIM%2BAvCclQL3xUFFuXjbcO25I%3D")
        );
    }

    @ParameterizedTest
    @MethodSource("requestList")
    public void allergySearchFieldTest(String searchRequest, String searchResult) throws InterruptedException {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/allergy/");
        driver.findElement(MapsPageGismeteo.searchInputSelector).sendKeys(searchRequest);
        Thread.sleep(3000);
        clickElement(IndexPageGismeteo.firstItemInSearch);
        Assertions.assertEquals(searchResult, driver.getCurrentUrl(), driver.getCurrentUrl() + " and " + searchResult + " do not match");
        driver.quit();
    }

    @Test
    public void checkLegendList() {
        List<String> alertCodes = Arrays.asList("Низкая", "Умеренная", "Высокая", "Очень высокая", "Экстремальная");
        List<String> cssCodes = Arrays.asList("rgba(255, 221, 51, 0.8)", "rgba(255, 153, 51, 0.8)", "rgba(255, 0, 0, 0.8)", "rgba(153, 0, 0, 0.8)", "rgba(0, 0, 0, 0.8)");
        int indexNumber = 0;
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/allergy/");
        List<WebElement> listOfLegendElements = driver.findElements(By.className("legend-value"));
        for (WebElement listElement : listOfLegendElements) {
            Assertions.assertEquals(alertCodes.get(indexNumber), listElement.getText(), "alert codes do not match");
            Assertions.assertEquals(cssCodes.get(indexNumber), listElement.getCssValue("background-color"), "CSS codes do not match");
            indexNumber++;
        }
        driver.quit();
    }

    @Test
    public void checkSelectSource() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/allergy/");
        clickElement(MapsPageGismeteo.mapToggleSelector);
        clickElement(MapsPageGismeteo.ragweedSelector);
        Assertions.assertEquals("https://www.gismeteo.ru/maps/allergy?q=yWyvY%2FZbgGd8GIcMgUaZWLJSjOI%3D", driver.getCurrentUrl(), "URL does not match");
        clickElement(MapsPageGismeteo.mapToggleSelector);
        clickElement(MapsPageGismeteo.grassSelector);
        Assertions.assertEquals("https://www.gismeteo.ru/maps/allergy?q=CQSwSKNJGDKRX1%2Bs8y6xYw%3D%3D", driver.getCurrentUrl(), "URL does not match");
        driver.quit();
    }

    //TODO починить следующие три теста, они хрупкие с утра, когда показывается вчерашний день.
    @Test
    public void checkMapLegendToday() {
        String pattern = "EE dd MMM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("ru", "RU"));
        String date = simpleDateFormat.format(new Date());
        String date2 = date.substring(0, 1).toUpperCase() + date.substring(1).replace(".", "") + " сегодня";
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/allergy/");
        Assertions.assertEquals(date2, driver.findElement(MapsPageGismeteo.todayDateLegendSelector).getText(), "texts don't match");
        driver.quit();
    }


    @Test
    public void checkMapLegendTomorrow() {
        Instant timestamp = Instant.now().plus(1, ChronoUnit.DAYS);
        LocalDateTime ldt = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EE dd MMM").withLocale(new Locale("ru"));
        String stringDateFormatted = ldt.format(format);
        stringDateFormatted = stringDateFormatted.substring(0, 1).toUpperCase() + stringDateFormatted.substring(1).replace(".", "") + " завтра";
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/allergy/");
        Assertions.assertEquals(stringDateFormatted, driver.findElement(MapsPageGismeteo.tomorrowDateLegendSelector).getText(), "texts don't match");
        driver.quit();
    }

    @Test
    public void getMapLegendDayAfterTomorrow() {
        Instant timestamp = Instant.now().plus(2, ChronoUnit.DAYS);
        LocalDateTime ldt = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EE dd MMM").withLocale(new Locale("ru"));
        String stringDateFormatted = ldt.format(format);
        stringDateFormatted = stringDateFormatted.substring(0, 1).toUpperCase() + stringDateFormatted.substring(1).replace(".", "");
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/allergy/");
        Assertions.assertEquals(stringDateFormatted, driver.findElement(MapsPageGismeteo.dayAfterTomorrowDateLegendSelector).getText(), "texts don't match");
        driver.quit();
    }
}

