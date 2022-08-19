package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webpages.gismeteo.IndexPageGismeteo;
import webpages.gismeteo.pages.CityPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static webpages.gismeteo.pages.CityPage.*;


public class CityPageContentsTest extends DefaultPageTest {

    ConfiguresAndConstants.City currentCity = new ConfiguresAndConstants.City("voronezh", 5026);

    String cityNameURL = ConfiguresAndConstants.defaultURL + "weather-" + currentCity.getCityName() + "-" + currentCity.getCityID() + "/";
    String currentCityWeatherTitle = "GISMETEO: Погода в Воронеже сегодня, прогноз погоды Воронеж на сегодня, Воронеж (городской округ), Воронежская область, Россия";

    String currentCityWeatherRadar = currentCity.cityRadar(currentCity.getCityName(), currentCity.getCityID());

    String currentCityDairy = currentCity.cityDairy(currentCity.getCityID());

    @Test
    public void superiorPartWeatherApp() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(nowWeatherSelector);
        Assertions.assertEquals(cityNameURL + "now/", driver.getCurrentUrl(), cityNameURL + "now/" + " и " + driver.getCurrentUrl() + " неверные");
        clickElement(todayWeatherSelector);
        Assertions.assertEquals(cityNameURL, driver.getCurrentUrl(), cityNameURL + " и " + driver.getCurrentUrl() + " неверные");
        clickElement(nextDayWeatherSelector);
        Assertions.assertEquals(cityNameURL + "tomorrow", driver.getCurrentUrl(), cityNameURL + "tomorrow/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void testPageContentsTest() {
        defaultPage.openWebPages(cityNameURL);
        Assertions.assertEquals(currentCityWeatherTitle, driver.getTitle(), driver.getTitle() + " и " + currentCityWeatherTitle + " не совпадают");
        String windSpeed = getText(CityPage.windSpeedSelector);
        String pollenQuantity = getText(pollenPointsSelector);
        String weatherOnRoads = getText(CityPage.weatherOnRoadsSelector);
        String barometricPressure = getText(CityPage.barometricPressureSelector);
        String humidityPercentage = getText(humidityPercentSelector);
        String sunAndMoon = getText(CityPage.sunAndMoonSelector);
        String geomagneticActivity = getText(CityPage.geomagneticActivitySelector);
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
        defaultPage.openWebPages(cityNameURL);
        Assertions.assertEquals(currentCityWeatherTitle, driver.getTitle(), driver.getTitle() + " и " + currentCityWeatherTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(barometricPressureSelector));
        moveCursor.moveToElement(driver.findElement(nextDateBarometricPressureSelector)).click().perform();
        Assertions.assertEquals(cityNameURL + "tomorrow/", driver.getCurrentUrl(), cityNameURL + "tomorrow/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickBarometricYesterday() {
        defaultPage.openWebPages(cityNameURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(barometricPressureSelector));
        moveCursor.moveToElement(driver.findElement(nextDateBarometricPressureSelector)).click().perform();
        moveCursor.moveToElement(driver.findElement(barometricPressureSelector));
        moveCursor.moveToElement(driver.findElement(previousDateBarometricPressureSelector)).click().perform();
        Assertions.assertEquals(cityNameURL, driver.getCurrentUrl(), cityNameURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }


    @Test
    public void clickWindspeedTomorrow() {
        defaultPage.openWebPages(cityNameURL);
        Assertions.assertEquals(currentCityWeatherTitle, driver.getTitle(), driver.getTitle() + " и " + currentCityWeatherTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(windSpeedSelector));
        moveCursor.moveToElement(driver.findElement(nextDateWindSpeedSelector)).click().perform();
        Assertions.assertEquals(cityNameURL + "tomorrow/", driver.getCurrentUrl(), cityNameURL + "tomorrow/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickWindSpeedYesterday() {
        defaultPage.openWebPages(cityNameURL);
        Assertions.assertEquals(currentCityWeatherTitle, driver.getTitle(), driver.getTitle() + " и " + currentCityWeatherTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(windSpeedSelector));
        moveCursor.moveToElement(driver.findElement(nextDateWindSpeedSelector)).click().perform();
        moveCursor.moveToElement(driver.findElement(windSpeedSelector));
        moveCursor.moveToElement(driver.findElement(previousDateWindSpeedSelector)).click().perform();
        Assertions.assertEquals(cityNameURL, driver.getCurrentUrl(), cityNameURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickHumidityTomorrow() {
        defaultPage.openWebPages(cityNameURL);
        Assertions.assertEquals(currentCityWeatherTitle, driver.getTitle(), driver.getTitle() + " и " + currentCityWeatherTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(humidityPercentSelector));
        moveCursor.moveToElement(driver.findElement(nextDateHumidityPercentSelector)).click().perform();
        Assertions.assertEquals(cityNameURL + "tomorrow/", driver.getCurrentUrl(), cityNameURL + "tomorrow/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickHumidityYesterday() {
        defaultPage.openWebPages(cityNameURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(humidityPercentSelector));
        moveCursor.moveToElement(driver.findElement(nextDateHumidityPercentSelector)).click().perform();
        moveCursor.moveToElement(driver.findElement(humidityPercentSelector));
        moveCursor.moveToElement(driver.findElement(previousDateHumidityPercentSelector)).click().perform();
        Assertions.assertEquals(cityNameURL, driver.getCurrentUrl(), cityNameURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickSunAndMoonTomorrow() {
        defaultPage.openWebPages(cityNameURL);
        Assertions.assertEquals(currentCityWeatherTitle, driver.getTitle(), driver.getTitle() + " и " + currentCityWeatherTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(sunAndMoonSelector));
        moveCursor.moveToElement(driver.findElement(nextDateSunAndMoonSelector)).click().perform();
        Assertions.assertEquals(cityNameURL + "tomorrow/", driver.getCurrentUrl(), cityNameURL + "tomorrow/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickSunAndMoonYesterday() {
        defaultPage.openWebPages(cityNameURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(sunAndMoonSelector));
        moveCursor.moveToElement(driver.findElement(nextDateSunAndMoonSelector)).click().perform();
        moveCursor.moveToElement(driver.findElement(sunAndMoonSelector));
        moveCursor.moveToElement(driver.findElement(previousDateSunAndMoonSelector)).click().perform();
        Assertions.assertEquals(cityNameURL, driver.getCurrentUrl(), cityNameURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickGeomagneticTomorrow() {
        defaultPage.openWebPages(cityNameURL);
        Assertions.assertEquals(currentCityWeatherTitle, driver.getTitle(), driver.getTitle() + " и " + currentCityWeatherTitle + " не совпадают");
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(geomagneticActivitySelector));
        moveCursor.moveToElement(driver.findElement(nextDateGeomagneticActivitySelector)).click().perform();
        Assertions.assertEquals(cityNameURL + "tomorrow/", driver.getCurrentUrl(), cityNameURL + "tomorrow/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void clickGeomagneticYesterday() {
        defaultPage.openWebPages(cityNameURL);
        Actions moveCursor = new Actions(driver);
        moveCursor.moveToElement(driver.findElement(geomagneticActivitySelector));
        moveCursor.moveToElement(driver.findElement(nextDateGeomagneticActivitySelector)).click().perform();
        moveCursor.moveToElement(driver.findElement(geomagneticActivitySelector));
        moveCursor.moveToElement(driver.findElement(previousDateGeomagneticActivitySelector)).click().perform();
        Assertions.assertEquals(cityNameURL, driver.getCurrentUrl(), cityNameURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void checkForRealTimeChildrenTab() {
        defaultPage.openWebPages(cityNameURL);
        WebElement countElementsDailyNews = driver.findElement(realTimeTabSelector);
        String expectedAmountOfLines = "11";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.quit();
    }

    @Test
    public void checkForChildrenCityAnnouncementsRussiaTab() {
        defaultPage.openWebPages(cityNameURL);
        WebElement countElementsDailyNews = driver.findElement(cityAnnouncementsRussiaTabSelector);
        String expectedAmountOfLines = "11";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.quit();
    }

    @Test
    public void checkForChildrenPulsationTab() {
        defaultPage.openWebPages(cityNameURL);
        WebElement countElementsDailyNews = driver.findElement(pulsationTabSelector);
        String expectedAmountOfLines = "7";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.quit();
    }

    @Test
    public void checkForChildrenDailyNewsTab() {
        defaultPage.openWebPages(cityNameURL);
        WebElement countElementsDailyNews = driver.findElement(cityNewsTabSelector);
        String expectedAmountOfLines = "14";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.quit();
    }

    @Test
    public void checkForChildrenPartnersNewsTab() {
        defaultPage.openWebPages(cityNameURL);
        WebElement countElementsDailyNews = driver.findElement(partnersNewsTabSelector);
        String expectedAmountOfLines = "16";
        Assertions.assertEquals(expectedAmountOfLines, countElementsDailyNews.getAttribute("childElementCount"), expectedAmountOfLines + " и " + countElementsDailyNews.getAttribute("childElementCount") + " не сходятся");
        driver.quit();
    }

    @Test
    public void clearSearchHistory() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(IndexPageGismeteo.meteoStationBulchug);
        driver.navigate().back();
        clickElement(IndexPageGismeteo.meteoStationSVO);
        driver.get(ConfiguresAndConstants.defaultURL);
        clickElement(CityPage.clearVisitedCitiesSelector);
        Assertions.assertFalse(driver.findElement(clearVisitedCitiesSelector).isDisplayed(), driver.findElement(clearVisitedCitiesSelector).isDisplayed() + " is somehow displayed");
        driver.quit();
    }

    @Test
    public void gismeteoNews() {
        defaultPage.openWebPages(cityNameURL);
        String gismeteoNewsPageTitle = "GISMETEO: Новости погоды. Свежие новости погоды в России и мире. Погодные новости дня.";
        String originalWindow = driver.getWindowHandle();
        clickElement(gismeteoNewsTabSelector);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assertions.assertEquals(gismeteoNewsPageTitle, driver.getTitle(), gismeteoNewsPageTitle + " and " + driver.getTitle() + " do not match");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherNow() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhWeatherNowSelector);
        Assertions.assertEquals(cityNameURL + "now/", driver.getCurrentUrl(), cityNameURL + "now/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherToday() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhWeatherNowSelector);
        clickElement(CityPage.voronezhWeatherTodaySelector);
        Assertions.assertEquals(cityNameURL, driver.getCurrentUrl(), cityNameURL + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherTomorrow() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhWeatherTomorrowSelector);
        Assertions.assertEquals(cityNameURL + "tomorrow/", driver.getCurrentUrl(), cityNameURL + "tomorrow/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherThreeDays() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhWeatherThreeDaysSelector);
        Assertions.assertEquals(cityNameURL + "3-days/", driver.getCurrentUrl(), cityNameURL + "3-days/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherTenDays() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhWeatherTenDaysSelector);
        Assertions.assertEquals(cityNameURL + "10-days/", driver.getCurrentUrl(), cityNameURL + "1--days/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherTwoWeeks() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhWeatherTwoWeeksSelector);
        Assertions.assertEquals(cityNameURL + "2-weeks/", driver.getCurrentUrl(), cityNameURL + "2-weeks/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherMonth() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhWeatherMonthSelector);
        Assertions.assertEquals(cityNameURL + "month/", driver.getCurrentUrl(), cityNameURL + "month/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherRadar() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhWeatherRadarSelector);
        Assertions.assertEquals(currentCityWeatherRadar, driver.getCurrentUrl(), currentCityWeatherRadar + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherWeekly() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhWeatherWeeklySelector);
        Assertions.assertEquals(cityNameURL + "weekly/", driver.getCurrentUrl(), cityNameURL + "weekly/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherWeekend() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhUpperMoreButtonSelector);
        clickElement(CityPage.voronezhWeatherWeekendSelector);
        Assertions.assertEquals(cityNameURL + "weekend/", driver.getCurrentUrl(), cityNameURL + "weekend/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherGeoMagnetic() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhUpperMoreButtonSelector);
        clickElement(CityPage.voronezhWeatherGeoMagneticSelector);
        Assertions.assertEquals(cityNameURL + "gm/", driver.getCurrentUrl(), cityNameURL + "gm/" + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }

    @Test
    public void verifyVoronezhWeatherDairy() {
        defaultPage.openWebPages(cityNameURL);
        clickElement(CityPage.voronezhUpperMoreButtonSelector);
        clickElement(CityPage.voronezhWeatherDairySelector);
        Assertions.assertEquals(currentCityDairy, driver.getCurrentUrl(), currentCityDairy + " и " + driver.getCurrentUrl() + " неверные");
        driver.quit();
    }
}