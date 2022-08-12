package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
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
    String voronezhWeatherThreeDays = "https://www.gismeteo.ru/weather-voronezh-5026/3-days/";
    String voronezhWeatherTenDays = "https://www.gismeteo.ru/weather-voronezh-5026/10-days/";
    String voronezhWeatherTwoWeeks = "https://www.gismeteo.ru/weather-voronezh-5026/2-weeks/";
    String voronezhWeatherMonth = "https://www.gismeteo.ru/weather-voronezh-5026/month/";
    String voronezhWeatherRadar = "https://www.gismeteo.ru/nowcast-voronezh-5026/";
    String voronezhWeatherWeekly = "https://www.gismeteo.ru/weather-voronezh-5026/weekly/";
    String voronezhWeatherWeekend = "https://www.gismeteo.ru/weather-voronezh-5026/weekend/";
    String voronezhWeatherGeoMagnetic = "https://www.gismeteo.ru/weather-voronezh-5026/gm/";
    String voronezhWeatherDairy = "https://www.gismeteo.ru/diary/5026/";


    @Test
    public void superiorPartWeatherApp() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(nowWeather);
        Assertions.assertEquals(voronezhWeatherNow, driver.getCurrentUrl(), voronezhWeatherNow + " и " + driver.getCurrentUrl() + " неверные");
        clickElement(todayWeather);
        Assertions.assertEquals(voronezhURL, driver.getCurrentUrl(), voronezhURL + " и " + driver.getCurrentUrl() + " неверные");
        clickElement(nextDayWeather);
        Assertions.assertEquals(voronezhWeatherTomorrow, driver.getCurrentUrl(), voronezhWeatherTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
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
        driver.close();
    }

    @Test
    public void clickBarometricTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(barometricPressure));
        moveCursor.moveToElement(driver.findElement(nextDateBarometricPressure)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
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
        driver.close();
    }


    @Test
    public void clickWindspeedTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(windSpeed));
        moveCursor.moveToElement(driver.findElement(nextDateWindSpeed)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
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
        driver.close();
    }

    @Test
    public void clickHumidityTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(humidityPercent));
        moveCursor.moveToElement(driver.findElement(nextDateHumidityPercent)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
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
        driver.close();
    }

    @Test
    public void clickSunAndMoonTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(sunAndMoon));
        moveCursor.moveToElement(driver.findElement(nextDateSunAndMoon)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
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
        driver.close();
    }

    @Test
    public void clickGeomagneticTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(geomagneticActivity));
        moveCursor.moveToElement(driver.findElement(nextDateGeomagneticActivity)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
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
        driver.close();
    }

    @Test
    public void checkForRealTimeChildrenTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(realTimeTab);
        String expectedAmountOfLines = "11";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.close();
    }

    @Test
    public void checkForChildrenCityAnnouncementsRussiaTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(cityAnnouncementsRussiaTab);
        String expectedAmountOfLines = "11";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.close();
    }

    @Test
    public void checkForChildrenPulsationTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(pulsationTab);
        String expectedAmountOfLines = "7";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.close();
    }

    @Test
    public void checkForChildrenDailyNewsTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(cityNewsTab);
        String expectedAmountOfLines = "14";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.close();
    }

    @Test
    public void checkForChildrenPartnersNewsTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(partnersNewsTab);
        String expectedAmountOfLines = "16";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.close();
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
        driver.close();
    }

    @Test
    public void gismeteoNews() {
        String gismeteoNewsPageTitle = "GISMETEO: Новости погоды. Свежие новости погоды в России и мире. Погодные новости дня.";
        defaultPage.openWebPages(voronezhURL);
        String originalWindow = driver.getWindowHandle();
        clickElement(gismeteoNewsTab);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assertions.assertEquals(gismeteoNewsPageTitle, driver.getTitle(), gismeteoNewsPageTitle + " and " + driver.getTitle() + " do not match");
        driver.close();
    }

    @Test
    public void verifyVoronezhWeatherNow() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherNow);
        Assertions.assertEquals(voronezhWeatherNow, driver.getCurrentUrl(), voronezhWeatherNow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void verifyVoronezhWeatherToday() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherNow);
        clickElement(CityPage.voronezhWeatherToday);
        Assertions.assertEquals(voronezhURL, driver.getCurrentUrl(), voronezhURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherTomorrow() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherTomorrow);
        Assertions.assertEquals(voronezhWeatherTomorrow, driver.getCurrentUrl(), voronezhWeatherTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherThreeDays() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherThreeDays);
        Assertions.assertEquals(voronezhWeatherThreeDays, driver.getCurrentUrl(), voronezhWeatherThreeDays + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherTenDays() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherTenDays);
        Assertions.assertEquals(voronezhWeatherTenDays, driver.getCurrentUrl(), voronezhWeatherTenDays + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherTwoWeeks() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherTwoWeeks);
        Assertions.assertEquals(voronezhWeatherTwoWeeks, driver.getCurrentUrl(), voronezhWeatherTwoWeeks + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherMonth() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherMonth);
        Assertions.assertEquals(voronezhWeatherMonth, driver.getCurrentUrl(), voronezhWeatherMonth + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherRadar() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherRadar);
        Assertions.assertEquals(voronezhWeatherRadar, driver.getCurrentUrl(), voronezhWeatherRadar + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherWeekly() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherWeekly);
        Assertions.assertEquals(voronezhWeatherWeekly, driver.getCurrentUrl(), voronezhWeatherWeekly + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherWeekend() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhUpperMoreButton);
        clickElement(CityPage.voronezhWeatherWeekend);
        Assertions.assertEquals(voronezhWeatherWeekend, driver.getCurrentUrl(), voronezhWeatherWeekend + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherGeoMagnetic() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhUpperMoreButton);
        clickElement(CityPage.voronezhWeatherGeoMagnetic);
        Assertions.assertEquals(voronezhWeatherGeoMagnetic, driver.getCurrentUrl(), voronezhWeatherGeoMagnetic + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherDairy() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhUpperMoreButton);
        clickElement(CityPage.voronezhWeatherDairy);
        Assertions.assertEquals(voronezhWeatherDairy, driver.getCurrentUrl(), voronezhWeatherDairy + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }
}