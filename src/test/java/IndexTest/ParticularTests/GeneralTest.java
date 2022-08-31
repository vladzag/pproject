package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.IndexPageGismeteo;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static webpages.gismeteo.IndexPageGismeteo.*;

public class GeneralTest extends DefaultPageTest {
/*
    @BeforeEach
    public void beforeEachMethod() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL);
    }

    @AfterEach
    public void afterEachMethod() {
        driver.quit();
    }*/

    @ParameterizedTest
    @ValueSource(strings = {"https://www.gismeteo.ru/", "https://www.gismeteo.ru/weather-syzran-4448/", "https://www.gismeteo.ru/news/", "https://www.gismeteo.ru/maps/", "https://www.gismeteo.ru/informers/", "https://www.gismeteo.ru/soft/"})
    public void Error400Test(String pageWeb) throws InterruptedException {
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        Thread.sleep(2500);
        driver.get(pageWeb);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            System.out.println(url);
            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
           /*if (!url.startsWith(pageWeb)) {
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }*/
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }

    @Test
    public void replaceYandexCookie() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL);
        Cookie cookieTest = new Cookie("yuidss", "8"); //original value = 1914338451625754248
        driver.manage().addCookie(cookieTest);
        driver.quit();
    }

    @Test
    public void deleteAllCookiesLoadingTime() {
        long startWithCookies = System.currentTimeMillis();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL);
        long finishWithCookies = System.currentTimeMillis();
        long totalTimeWithCookies = finishWithCookies - startWithCookies;
        driver.manage().deleteAllCookies();
        long startWithoutCookies = System.currentTimeMillis();
        driver.navigate().refresh();
        long finishWithoutCookies = System.currentTimeMillis();
        long totalTimeWithoutCookies = finishWithoutCookies - startWithoutCookies;
        System.out.println(totalTimeWithCookies - totalTimeWithoutCookies + " миллисекунд разница между загрузкой с куками и без");
        driver.quit();
    }

    private static Stream<Arguments> requestList() {
        return Stream.of(
                Arguments.of("Moscow", "https://www.gismeteo.ru/weather-moscow-4368/"),
                Arguments.of("Csphfym", "https://www.gismeteo.ru/weather-syzran-4448/"),
                Arguments.of("Санкт-Петербург (Пулково)", "https://www.gismeteo.ru/weather-sankt-peterburg-pulkovo-12967/"),
                Arguments.of("Урю", "https://www.gismeteo.ru/weather-uryupinsk-5045/"),
                Arguments.of("Москва", "https://www.gismeteo.ru/weather-moscow-4368/"),
                Arguments.of("", "https://www.gismeteo.ru/weather-moscow-4368/"),
                Arguments.of(" ", "https://www.gismeteo.ru/weather-moscow-4368/")

        );
    }

    @ParameterizedTest
    @MethodSource("requestList")
    public void searchFieldTest(String searchRequest, String searchResult) throws InterruptedException {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL);
        indexPage.searchFieldWithText(searchRequest);
        Thread.sleep(3000);
        clickElement(IndexPageGismeteo.firstItemInSearch);
        Assertions.assertEquals(searchResult, driver.getCurrentUrl(), driver.getCurrentUrl() + " and " + searchResult + " do not match");
        driver.quit();
    }

    @Test
    public void ClickableHeaderLinksTest() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL);
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