package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import webpages.gismeteo.IndexPageGismeteo;
import webpages.gismeteo.pages.CityPage;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static webpages.gismeteo.pages.CityPage.*;


public class TestPageContents extends DefaultPageTest {

    String defaultURL = "https://www.gismeteo.ru/";
    String voronezhURL = "https://www.gismeteo.ru/weather-voronezh-5026/";
    String degtyarskURL = "https://www.gismeteo.ru/weather-degtyarsk-12761/";
    String degtyarskURLTomorrow = "https://www.gismeteo.ru/weather-degtyarsk-12761/tomorrow/";
    String degtyarskTitle = "GISMETEO: Погода в Дегтярске сегодня, прогноз погоды Дегтярск на сегодня, Дегтярск (городской округ), Свердловская область, Россия";
    String voronezhTitle = "GISMETEO: Погода в Воронеже сегодня, прогноз погоды Воронеж на сегодня, Воронеж (городской округ), Воронежская область, Россия";
    String voronezhWeatherNow = "https://www.gismeteo.ru/weather-voronezh-5026/now/";
    String voronezhWeatherTomorrow = "https://www.gismeteo.ru/weather-voronezh-5026/tomorrow/";


    @Test
    public void superiorPartWeatherApp() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(nowWeather);
        Assertions.assertEquals(voronezhWeatherNow, driver.getCurrentUrl(), voronezhWeatherNow + " и " + driver.getCurrentUrl() + " неверные");
        clickElement(todayWeather);
        Assertions.assertEquals(voronezhURL, driver.getCurrentUrl(), voronezhURL + " и " + driver.getCurrentUrl() + " неверные");
        clickElement(nextDayWeather);
        Assertions.assertEquals(voronezhWeatherTomorrow, driver.getCurrentUrl(), voronezhWeatherTomorrow + " и " + driver.getCurrentUrl() + " неверные");


    }

    @Test
    public void testPageContentsTest() {
        defaultPage.openWebPages(voronezhURL);
        Assertions.assertEquals(voronezhTitle, driver.getTitle(), driver.getTitle() + " и " + voronezhTitle + " не совпадают");
        String windSpeed = getText(CityPage.windSpeed);
        String pollenQuantity = getText(pollenPoints);
        String weatherOnRoads = getText(CityPage.weatherOnRoads);
        String barometricPressure = getText(CityPage.barometricPressure);
        String humidityPercentage = getText(humidityPercent);
        String sunAndMoon = getText(CityPage.sunAndMoon);
        String geomagneticActivity = getText(CityPage.geomagneticActivity);
        String expectedWindSpeed = "Ветер, м/с";
        String expectedPollen = "Пыльца, баллы";
        String expectedWeatherOnRoads = "Погода на дорогах";
        String expectedPressure = "Давление, мм рт. ст.";
        String expectedHumidity = "Влажность, %";
        String expectedSunAndMoon = "Солнце и Луна";
        String expectedGeoActivity = "Геомагнитная активность, Кп-индекс";
        assertThat(windSpeed, containsString(expectedWindSpeed));
        assertThat(pollenQuantity, containsString(expectedPollen));
        assertThat(weatherOnRoads, containsString(expectedWeatherOnRoads));
        assertThat(barometricPressure, containsString(expectedPressure));
        assertThat(humidityPercentage, containsString(expectedHumidity));
        assertThat(sunAndMoon, containsString(expectedSunAndMoon));
        assertThat(geomagneticActivity, containsString(expectedGeoActivity));
        driver.quit();
    }

    @Test
    public void clickBarometricTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(barometricPressure));
        moveCursor.moveToElement(driver.findElement(nextDateBarometricPressure)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickBarometricYesterday() {
        defaultPage.openWebPages(degtyarskURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(barometricPressure));
        moveCursor.moveToElement(driver.findElement(nextDateBarometricPressure)).click().perform();
        moveCursor.moveToElement(driver.findElement(barometricPressure));
        moveCursor.moveToElement(driver.findElement(previousDateBarometricPressure)).click().perform();
        Assertions.assertEquals(degtyarskURL, driver.getCurrentUrl(), degtyarskURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }


    @Test
    public void clickWindspeedTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(windSpeed));
        moveCursor.moveToElement(driver.findElement(nextDateWindSpeed)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickWindSpeedYesterday() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(windSpeed));
        moveCursor.moveToElement(driver.findElement(nextDateWindSpeed)).click().perform();
        moveCursor.moveToElement(driver.findElement(windSpeed));
        moveCursor.moveToElement(driver.findElement(previousDateWindSpeed)).click().perform();
        Assertions.assertEquals(degtyarskURL, driver.getCurrentUrl(), degtyarskURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickHumidityTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(humidityPercent));
        moveCursor.moveToElement(driver.findElement(nextDateHumidityPercent)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickHumidityYesterday() {
        defaultPage.openWebPages(degtyarskURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(humidityPercent));
        moveCursor.moveToElement(driver.findElement(nextDateHumidityPercent)).click().perform();
        moveCursor.moveToElement(driver.findElement(humidityPercent));
        moveCursor.moveToElement(driver.findElement(previousDateHumidityPercent)).click().perform();
        Assertions.assertEquals(degtyarskURL, driver.getCurrentUrl(), degtyarskURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickSunAndMoonTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(sunAndMoon));
        moveCursor.moveToElement(driver.findElement(nextDateSunAndMoon)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickSunAndMoonYesterday() {
        defaultPage.openWebPages(degtyarskURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(sunAndMoon));
        moveCursor.moveToElement(driver.findElement(nextDateSunAndMoon)).click().perform();
        moveCursor.moveToElement(driver.findElement(sunAndMoon));
        moveCursor.moveToElement(driver.findElement(previousDateSunAndMoon)).click().perform();
        Assertions.assertEquals(degtyarskURL, driver.getCurrentUrl(), degtyarskURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickGeomagneticTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(geomagneticActivity));
        moveCursor.moveToElement(driver.findElement(nextDateGeomagneticActivity)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickGeomagneticYesterday() {
        defaultPage.openWebPages(degtyarskURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(geomagneticActivity));
        moveCursor.moveToElement(driver.findElement(nextDateGeomagneticActivity)).click().perform();
        moveCursor.moveToElement(driver.findElement(geomagneticActivity));
        moveCursor.moveToElement(driver.findElement(previousDateGeomagneticActivity)).click().perform();
        Assertions.assertEquals(degtyarskURL, driver.getCurrentUrl(), degtyarskURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void checkForRealTimeChildrenTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(realTimeTab);
        String expectedAmountOfLines = "11";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.quit();
    }

    @Test
    public void checkForChildrenCityAnnouncementsRussiaTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(cityAnnouncementsRussiaTab);
        String expectedAmountOfLines = "11";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.quit();
    }

    @Test
    public void checkForChildrenPulsationTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(pulsationTab);
        String expectedAmountOfLines = "7";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.quit();
    }

    @Test
    public void checkForChildrenDailyNewsTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(cityNewsTab);
        String expectedAmountOfLines = "14";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.quit();
    }

    @Test
    public void checkForChildrenPartnersNewsTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(partnersNewsTab);
        String expectedAmountOfLines = "16";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.quit();
    }

    @Test
    public void clearSearchHistory() throws InterruptedException {
        defaultPage.openWebPages(defaultURL);
        clickElement(IndexPageGismeteo.meteoStationBulchug);
        PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "default mouse");
        Sequence actions = new Sequence(mouse, 0)
                .addAction(mouse.createPointerDown(PointerInput.MouseButton.BACK.asArg()))
                .addAction(mouse.createPointerUp(PointerInput.MouseButton.BACK.asArg()));
        ((RemoteWebDriver) driver).perform(Collections.singletonList(actions));
        clickElement(IndexPageGismeteo.meteoStationSVO);
        driver.get(defaultURL);
        clickElement(CityPage.clearVisitedCities);
        Assertions.assertFalse(driver.findElement(clearVisitedCities).isDisplayed(), driver.findElement(clearVisitedCities).isDisplayed() + " is somehow displayed");
        driver.quit();
    }
}