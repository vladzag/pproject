package IndexTest.ParticularTests.InformersTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.InfoPageGismeteo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConstructorsInformerTests extends DefaultPageTest {

    @BeforeEach
    public void beforeEachMethod() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/constructor");
    }

    @AfterEach
    public void AfterEachMethod() {
        driver.quit();
    }

    @Test
    public void constructorsCheckURL() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.gismeteo.ru/informers/constructor/#"));
    }

    @Test
    public void simpleInformerCheckTopLinks() {
        ArrayList<String> topLinksSet = new ArrayList<String>();
        topLinksSet.add("Простой информер");
        topLinksSet.add("Условия использования");
        WebElement topLinks = driver.findElement(InfoPageGismeteo.topLinksSelector);
        List<WebElement> topLinksNames = topLinks.findElements(new By.ByCssSelector(".subnav_item.nolink"));
        ArrayList<String> someStringList = new ArrayList<String>();
        for (WebElement elementName : topLinksNames) {
            someStringList.add(elementName.getText());
        }
        Assertions.assertEquals(someStringList.containsAll(topLinksSet), topLinksSet.containsAll(someStringList));
    }

    @Test
    public void checkForLanguagesClickable() {
        WebElement generalListOfLanguages = driver.findElement(InfoPageGismeteo.informersLanguageSelector);
        String locatorID = "languageLabel";
        int clickedTimes = 0;
        List<String> cityList = new ArrayList();
        for (int i = 1; i < 9; i++) {
            String secondLocator = locatorID + i;
            generalListOfLanguages.findElement(By.id(secondLocator)).click();
            clickedTimes++;
        }
        Assertions.assertTrue(clickedTimes == 8);
    }

    @Test
    public void checkForLanguages() {
        WebElement generalListOfLanguages = driver.findElement(InfoPageGismeteo.informersLanguageSelector);
        HashMap<String, String> LanguageCityMap = new HashMap<>() {{
            put("Русский", "Москва");
            put("Английский", "Moscow");
            put("Латышский", "Maskava");
            put("Литовский", "Maskva");
            put("Немецкий", "Moskau");
            put("Польский", "Moskwa");
            put("Румынский", "Moscova");
            put("Украинский", "Москва");
        }};
        String locatorID = "languageLabel";
        for (int i = 1; i < 9; i++) {
            String secondLocator = locatorID + i;
            String verifyString = generalListOfLanguages.findElement(By.id(secondLocator)).getText();
            Assertions.assertTrue(LanguageCityMap.containsKey(verifyString));
        }
    }

    @Test
    public void checkForLanguagesAndCities() {
        WebElement generalListOfLanguages = driver.findElement(InfoPageGismeteo.informersLanguageSelector);
        HashMap<String, String> LanguageCityMap = new HashMap<>() {{
            put("Русский", "Москва");
            put("Английский", "Moscow");
            put("Латышский", "Maskava");
            put("Литовский", "Maskva");
            put("Немецкий", "Moskau");
            put("Польский", "Moskwa");
            put("Румынский", "Moscova");
            put("Украинский", "Москва");
        }};
        String locatorID = "languageLabel";
        for (int i = 1; i < 9; i++) {
            String secondLocator = locatorID + i;
            generalListOfLanguages.findElement(By.id(secondLocator)).click();
            String verifyString = generalListOfLanguages.findElement(InfoPageGismeteo.cityNameSelector).getText();
            Assertions.assertTrue(LanguageCityMap.containsValue(verifyString));
        }
    }

    @Test
    public void verifyLocationName() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.locationAtopSelector).isDisplayed());
        clickElement(InfoPageGismeteo.nameOfLocationSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.locationAtopSelector).isDisplayed());
    }

    @Test
    public void verifyDisappearLocationInSample() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.cityLocationSampleSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.cityLocationAtopSelector).isDisplayed());
        clickElement(InfoPageGismeteo.nameOfLocationSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.cityLocationSampleSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.cityLocationAtopSelector).isDisplayed());
    }

    @Test
    public void verifyPositionAtop() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.cityLocationSampleSelector).isDisplayed());
        clickElement(InfoPageGismeteo.locationAtopSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.cityLocationSampleSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.cityLocationAtopSelector).isDisplayed());
    }

    @Test
    public void verifyLeftLocation() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.cityLocationAtopSelector).isDisplayed());
        clickElement(InfoPageGismeteo.locationLeftSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.cityLocationSampleSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.cityLocationAtopSelector).isDisplayed());
    }

    @Test
    public void verifyCurrentWeather() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.currentWeatherSampleSelector).isDisplayed());
        clickElement(InfoPageGismeteo.currentWeatherSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.currentWeatherSampleSelector).isDisplayed());
    }

    @Test
    public void verifyIconDisappearOnClick() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.iconCurrentWeatherSampleSelector).isDisplayed());
        clickElement(InfoPageGismeteo.iconCurrentWeatherSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.iconCurrentWeatherSampleSelector).isDisplayed());
    }

    @Test
    public void verifyDescriptionDisappearOnClick() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.descriptionCurrentWeatherSampleSelector).isDisplayed());
        clickElement(InfoPageGismeteo.descriptionCurrentWeatherSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.descriptionCurrentWeatherSampleSelector).isDisplayed());
    }

    @Test
    public void verifyWindDisappearOnClick() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.getWindCurrentWeatherSampleSelector).isDisplayed());
        clickElement(InfoPageGismeteo.windCurrentWeatherSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.getWindCurrentWeatherSampleSelector).isDisplayed());
    }

    @Test
    public void verifyPressureDisappearOnClick() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.pressureCurrentWeatherSampleSelector).isDisplayed());
        clickElement(InfoPageGismeteo.pressureCurrentWeatherSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.pressureCurrentWeatherSampleSelector).isDisplayed());
    }

    @Test
    public void verifyHumidityDisappearOnClick() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.humidityCurrentWeatherSampleSelector).isDisplayed());
        clickElement(InfoPageGismeteo.humidityCurrentWeatherSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.humidityCurrentWeatherSampleSelector).isDisplayed());
    }

    @Test
    public void verifyWeatherForecast() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.forecastSampleSelector).isDisplayed());
        clickElement(InfoPageGismeteo.forecastSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.forecastSampleSelector).isDisplayed());
    }

    @Test
    public void verifyDateForecastDisappearOnClick() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.dateForecastTodaySampleSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.dateForecastTomorrowSampleSelector).isDisplayed());
        clickElement(InfoPageGismeteo.dateForecastSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.dateForecastTodaySampleSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.dateForecastTomorrowSampleSelector).isDisplayed());
    }

    @Test
    public void verifyIconForecastDisappearOnClick() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.iconForecastSampleFirstSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.iconForecastSampleSecondSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.iconForecastSampleThirdSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.iconForecastSampleFourthSelector).isDisplayed());

        clickElement(InfoPageGismeteo.iconForecastSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.iconForecastSampleFirstSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.iconForecastSampleSecondSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.iconForecastSampleThirdSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.iconForecastSampleFourthSelector).isDisplayed());

    }

    @Test
    public void verifyWindForecastDisappearOnClick() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.windForecastSampleFirstSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.windForecastSampleSecondSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.windForecastSampleThirdSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.windForecastSampleFourthSelector).isDisplayed());
        clickElement(InfoPageGismeteo.windForecastSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.windForecastSampleFirstSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.windForecastSampleSecondSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.windForecastSampleThirdSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.windForecastSampleFourthSelector).isDisplayed());
    }

    @Test
    public void verifyPressureForecastDisappearOnClick() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.pressureForecastSampleFirstSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.pressureForecastSampleSecondSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.pressureForecastSampleThirdSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.pressureForecastSampleFourthSelector).isDisplayed());
        clickElement(InfoPageGismeteo.pressureForecastSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.pressureForecastSampleFirstSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.pressureForecastSampleSecondSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.pressureForecastSampleThirdSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.pressureForecastSampleFourthSelector).isDisplayed());
    }

    @Test
    public void verifyHumidityForecastDisappearOnClick() {
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.humidityForecastSampleFirstSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.humidityForecastSampleSecondSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.humidityForecastSampleThirdSelector).isDisplayed());
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.humidityForecastSampleFourthSelector).isDisplayed());
        clickElement(InfoPageGismeteo.humidityForecastSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.humidityForecastSampleFirstSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.humidityForecastSampleSecondSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.humidityForecastSampleThirdSelector).isDisplayed());
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.humidityForecastSampleFourthSelector).isDisplayed());
    }

    @Test
    public void changeTemperatureToFahrenheit() {
        clickElement(InfoPageGismeteo.checkTemperatureFahrenheitSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.checkTemperatureSamplesSelector).getText().contains("F"));
    }

    @Test
    public void changeTemperatureToCelsius() {
        clickElement(InfoPageGismeteo.checkTemperatureFahrenheitSelector);
        clickElement(InfoPageGismeteo.checkTemperatureCelsiusSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.checkTemperatureSamplesSelector).getText().contains("C"));
    }

    @Test
    public void changeWindSpeedToKMHour() {
        clickElement(InfoPageGismeteo.windSpeedKilometreHourSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.windSpeedSampleSelector).getText().contains("км/ч"));
    }

    @Test
    public void changeWindSpeedToMS() {
        clickElement(InfoPageGismeteo.windSpeedKilometreHourSelector);
        clickElement(InfoPageGismeteo.windSpeedMeterSecondSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.windSpeedSampleSelector).getText().contains("м/с"));
    }

    @Test
    public void changePressureTogPA() {
        clickElement(InfoPageGismeteo.pressuregPASelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.pressureSampleSelector).getText().contains("гПа"));
    }

    @Test
    public void changePressureToMMHG() {
        clickElement(InfoPageGismeteo.pressuregPASelector);
        clickElement(InfoPageGismeteo.pressureMMHGSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.pressureSampleSelector).getText().contains("мм рт. ст."));
    }

    @Test
    public void clickIconRight() {
        String checkOuterHTML = "<img src=\"/assets/flat-ui/img/icons/weather/standart/small/d.sun.png\">";
        clickElement(InfoPageGismeteo.iconRightSelector);
        Assertions.assertTrue(driver.findElement(By.cssSelector("#tab-h24-0 > span.s_icon.sunny > img")).getAttribute("outerHTML").contains(checkOuterHTML));
    }

    @Test
    public void clickIconLeft() {
        String checkOuterHTML = "<img src=\"/assets/flat-ui/img/icons/weather/clip_art/small/d0.png\">";
        clickElement(InfoPageGismeteo.iconRightSelector);
        clickElement(InfoPageGismeteo.iconLeftSelector);
        Assertions.assertTrue(driver.findElement(By.cssSelector("#tab-h24-0 > span.s_icon.sunny > img")).getAttribute("outerHTML").contains(checkOuterHTML));
    }

    @Test
    public void contourAppearAndDisappear() {
        clickElement(InfoPageGismeteo.contourSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.contourSampleSelector).getCssValue("border").contains("0px"));
        clickElement(InfoPageGismeteo.contourSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.contourSampleSelector).getCssValue("border").contains("1px"));
    }

    @Test
    public void checkBackgroundTransparent() {
        clickElement(InfoPageGismeteo.transparentBackgroundSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.transparentBackgroundSampleSelector).getCssValue("background").contains("rgba(0, 0, 0, 0)"));
        clickElement(InfoPageGismeteo.transparentBackgroundSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.transparentBackgroundSampleSelector).getCssValue("background").contains("rgb(210, 232, 255)"));
    }
}
