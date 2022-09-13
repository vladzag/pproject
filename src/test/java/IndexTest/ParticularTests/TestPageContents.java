package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import webpages.gismeteo.IndexPageGismeteo;
import webpages.gismeteo.pages.CityPage;


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
        clickElement(CityPage.nowWeatherSelector);
        Assertions.assertEquals(voronezhWeatherNow, driver.getCurrentUrl(), voronezhWeatherNow + " и " + driver.getCurrentUrl() + " неверные");
        clickElement(CityPage.todayWeatherSelector);
        Assertions.assertEquals(voronezhURL, driver.getCurrentUrl(), voronezhURL + " и " + driver.getCurrentUrl() + " неверные");
        clickElement(CityPage.nextDayWeatherSelector);
        Assertions.assertEquals(voronezhWeatherTomorrow, driver.getCurrentUrl(), voronezhWeatherTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void testPageContentsTest() {
        defaultPage.openWebPages(voronezhURL);
        Assertions.assertEquals(voronezhTitle, driver.getTitle(), driver.getTitle() + " и " + voronezhTitle + " не совпадают");
        String windSpeed = getText(CityPage.windSpeedSelector);
        String pollenQuantity = getText(CityPage.pollenPointsSelector);
        String weatherOnRoads = getText(CityPage.weatherOnRoadsSelector);
        String barometricPressure = getText(CityPage.barometricPressureSelector);
        String humidityPercentage = getText(CityPage.humidityPercentSelector);
        String sunAndMoon = getText(CityPage.sunAndMoonSelector);
        String geomagneticActivity = getText(CityPage.geomagneticActivitySelector);
        String expectedWindSpeed = "Ветер, м/с";
        String expectedPollen = "Пыльца, баллы";
        String expectedWeatherOnRoads = "Погода на дорогах";
        String expectedPressure = "Давление, мм рт. ст.";
        String expectedHumidity = "Влажность, %";
        String expectedSunAndMoon = "Солнце и Луна";
        String expectedGeoActivity = "Геомагнитная активность, Кп-индекс";
        Assertions.assertTrue(windSpeed.contains(expectedWindSpeed));
        Assertions.assertTrue(pollenQuantity.contains(expectedPollen));
        Assertions.assertTrue(weatherOnRoads.contains(expectedWeatherOnRoads));
        Assertions.assertTrue(barometricPressure.contains(expectedWindSpeed));
        Assertions.assertTrue(humidityPercentage.contains(expectedPressure));
        Assertions.assertTrue(sunAndMoon.contains(expectedSunAndMoon));
        Assertions.assertTrue(geomagneticActivity.contains(expectedGeoActivity));
        driver.close();
    }

    @Test
    public void clickBarometricTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(CityPage.barometricPressureSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.nextDateBarometricPressureSelector)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void clickBarometricYesterday() {
        defaultPage.openWebPages(degtyarskURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(CityPage.barometricPressureSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.nextDateBarometricPressureSelector)).click().perform();
        moveCursor.moveToElement(driver.findElement(CityPage.barometricPressureSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.previousDateBarometricPressureSelector)).click().perform();
        Assertions.assertEquals(degtyarskURL, driver.getCurrentUrl(), degtyarskURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }


    @Test
    public void clickWindspeedTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(CityPage.windSpeedSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.nextDateWindSpeedSelector)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void clickWindSpeedYesterday() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(CityPage.windSpeedSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.nextDateWindSpeedSelector)).click().perform();
        moveCursor.moveToElement(driver.findElement(CityPage.windSpeedSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.previousDateWindSpeedSelector)).click().perform();
        Assertions.assertEquals(degtyarskURL, driver.getCurrentUrl(), degtyarskURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void clickHumidityTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(CityPage.humidityPercentSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.nextDateHumidityPercentSelector)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void clickHumidityYesterday() {
        defaultPage.openWebPages(degtyarskURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(CityPage.humidityPercentSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.nextDateHumidityPercentSelector)).click().perform();
        moveCursor.moveToElement(driver.findElement(CityPage.humidityPercentSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.previousDateHumidityPercentSelector)).click().perform();
        Assertions.assertEquals(degtyarskURL, driver.getCurrentUrl(), degtyarskURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void clickSunAndMoonTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(CityPage.sunAndMoonSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.nextDateSunAndMoonSelector)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void clickSunAndMoonYesterday() {
        defaultPage.openWebPages(degtyarskURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(CityPage.sunAndMoonSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.nextDateSunAndMoonSelector)).click().perform();
        moveCursor.moveToElement(driver.findElement(CityPage.sunAndMoonSelector));
        moveCursor.moveToElement(driver.findElement(CityPage.previousDateSunAndMoonSelector)).click().perform();
        Assertions.assertEquals(degtyarskURL, driver.getCurrentUrl(), degtyarskURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void clickGeomagneticTomorrow() {
        defaultPage.openWebPages(degtyarskURL);
        Assertions.assertEquals(degtyarskTitle, driver.getTitle(), driver.getTitle() + " и " + degtyarskTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(CityPage.geomagneticActivitySelector));
        moveCursor.moveToElement(driver.findElement(CityPage.nextDateGeomagneticActivitySelector)).click().perform();
        Assertions.assertEquals(degtyarskURLTomorrow, driver.getCurrentUrl(), degtyarskURLTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void clickGeomagneticYesterday() {
        defaultPage.openWebPages(degtyarskURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(CityPage.geomagneticActivitySelector));
        moveCursor.moveToElement(driver.findElement(CityPage.nextDateGeomagneticActivitySelector)).click().perform();
        moveCursor.moveToElement(driver.findElement(CityPage.geomagneticActivitySelector));
        moveCursor.moveToElement(driver.findElement(CityPage.previousDateGeomagneticActivitySelector)).click().perform();
        Assertions.assertEquals(degtyarskURL, driver.getCurrentUrl(), degtyarskURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void checkForRealTimeChildrenTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(CityPage.realTimeTabSelector);
        String expectedAmountOfLines = "11";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.close();
    }

    @Test
    public void checkForChildrenCityAnnouncementsRussiaTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(CityPage.cityAnnouncementsRussiaTabSelector);
        String expectedAmountOfLines = "11";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.close();
    }

    @Test
    public void checkForChildrenPulsationTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(CityPage.pulsationTabSelector);
        String expectedAmountOfLines = "7";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.close();
    }

    @Test
    public void checkForChildrenDailyNewsTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(CityPage.cityNewsTabSelector);
        String expectedAmountOfLines = "14";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.close();
    }

    @Test
    public void checkForChildrenPartnersNewsTab() {
        defaultPage.openWebPages(voronezhURL);
        WebElement countElementsDailyNews = driver.findElement(CityPage.partnersNewsTabSelector);
        String expectedAmountOfLines = "16";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.close();
    }

    @Test
    public void clearSearchHistory() throws InterruptedException {
        defaultPage.openWebPages(defaultURL);
        clickElement(IndexPageGismeteo.meteoStationBulchug);
        PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "default mouse");
        driver.navigate().back();
        clickElement(IndexPageGismeteo.meteoStationSVO);
        driver.get(defaultURL);
        clickElement(CityPage.clearVisitedCitiesSelector);
        Assertions.assertFalse(driver.findElement(CityPage.clearVisitedCitiesSelector).isDisplayed(), driver.findElement(CityPage.clearVisitedCitiesSelector).isDisplayed() + " is somehow displayed");
        driver.close();
    }

    @Test
    public void gismeteoNews() {
        String gismeteoNewsPageTitle = "GISMETEO: Новости погоды. Свежие новости погоды в России и мире. Погодные новости дня.";
        defaultPage.openWebPages(voronezhURL);
        String originalWindow = driver.getWindowHandle();
        clickElement(CityPage.gismeteoNewsTabSelector);
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
        clickElement(CityPage.voronezhWeatherNowSelector);
        Assertions.assertEquals(voronezhWeatherNow, driver.getCurrentUrl(), voronezhWeatherNow + " и " + driver.getCurrentUrl() + " неверные");
        driver.close();
    }

    @Test
    public void verifyVoronezhWeatherToday() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherNowSelector);
        clickElement(CityPage.voronezhWeatherTodaySelector);
        Assertions.assertEquals(voronezhURL, driver.getCurrentUrl(), voronezhURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherTomorrow() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherTomorrowSelector);
        Assertions.assertEquals(voronezhWeatherTomorrow, driver.getCurrentUrl(), voronezhWeatherTomorrow + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherThreeDays() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherThreeDaysSelector);
        Assertions.assertEquals(voronezhWeatherThreeDays, driver.getCurrentUrl(), voronezhWeatherThreeDays + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherTenDays() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherTenDaysSelector);
        Assertions.assertEquals(voronezhWeatherTenDays, driver.getCurrentUrl(), voronezhWeatherTenDays + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherTwoWeeks() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherTwoWeeksSelector);
        Assertions.assertEquals(voronezhWeatherTwoWeeks, driver.getCurrentUrl(), voronezhWeatherTwoWeeks + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherMonth() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherMonthSelector);
        Assertions.assertEquals(voronezhWeatherMonth, driver.getCurrentUrl(), voronezhWeatherMonth + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherRadar() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherRadarSelector);
        Assertions.assertEquals(voronezhWeatherRadar, driver.getCurrentUrl(), voronezhWeatherRadar + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherWeekly() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhWeatherWeeklySelector);
        Assertions.assertEquals(voronezhWeatherWeekly, driver.getCurrentUrl(), voronezhWeatherWeekly + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherWeekend() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhUpperMoreButtonSelector);
        clickElement(CityPage.voronezhWeatherWeekendSelector);
        Assertions.assertEquals(voronezhWeatherWeekend, driver.getCurrentUrl(), voronezhWeatherWeekend + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherGeoMagnetic() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhUpperMoreButtonSelector);
        clickElement(CityPage.voronezhWeatherGeoMagneticSelector);
        Assertions.assertEquals(voronezhWeatherGeoMagnetic, driver.getCurrentUrl(), voronezhWeatherGeoMagnetic + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherDairy() {
        defaultPage.openWebPages(voronezhURL);
        clickElement(CityPage.voronezhUpperMoreButtonSelector);
        clickElement(CityPage.voronezhWeatherDairySelector);
        Assertions.assertEquals(voronezhWeatherDairy, driver.getCurrentUrl(), voronezhWeatherDairy + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }
}