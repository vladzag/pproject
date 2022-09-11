package IndexTest.ParticularTests.InformersTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.InfoPageGismeteo;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
        ArrayList<String> topLinksSet = new ArrayList<>();
        topLinksSet.add("Простой информер");
        topLinksSet.add("Условия использования");
        WebElement topLinks = driver.findElement(InfoPageGismeteo.topLinksSelector);
        List<WebElement> topLinksNames = topLinks.findElements(new By.ByCssSelector(".subnav_item.nolink"));
        ArrayList<String> someStringList = new ArrayList<>();
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
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.calendarSampleSelector).getCssValue("border").contains("0px"));
        clickElement(InfoPageGismeteo.contourSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.calendarSampleSelector).getCssValue("border").contains("1px"));
    }

    @Test
    public void checkBackgroundTransparent() {
        clickElement(InfoPageGismeteo.transparentBackgroundSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.transparentBackgroundSampleSelector).getCssValue("background").contains("rgba(0, 0, 0, 0)"));
        clickElement(InfoPageGismeteo.transparentBackgroundSelector);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.transparentBackgroundSampleSelector).getCssValue("background").contains("rgb(210, 232, 255)"));
    }

    @Test
    public void selectDifferentFonts() {
        List<String> fontsList = Arrays.asList(new String[]{"Arial", "Tahoma", "Verdana", "Georgia", "Comic Sans MS", "Courier New", "Times New Roman", "Trebuchet MS"});
        Select dropdownfonts = new Select(driver.findElement(InfoPageGismeteo.fontFaceSelector));
        for (int i = 0; i < fontsList.size(); i++) {
            dropdownfonts.selectByIndex(i);
            Assertions.assertTrue(driver.findElement(InfoPageGismeteo.calendarSampleSelector).getCssValue("font-family").contains(fontsList.get(i)));
        }
    }

    private static Stream<Arguments> listOfValues() {
        return Stream.of(
                Arguments.of("0", 236),
                Arguments.of("208", 210),
                Arguments.of("212", 210),
                Arguments.of("213", 211),
                Arguments.of("500", 498),
                Arguments.of("2000", 1998),
                Arguments.of("2002", 1998),
                Arguments.of("2003", 1998),
                Arguments.of("50000", 1998)
        );
    }

    @ParameterizedTest
    @MethodSource("listOfValues")
    public void informerSizeChanger(String value, Integer resultExpected) throws InterruptedException {
        clickElement(InfoPageGismeteo.informerSizeSelector);
        driver.findElement(InfoPageGismeteo.informerSizeSelector).sendKeys(Keys.chord(Keys.COMMAND, "a"));
        driver.findElement(InfoPageGismeteo.informerSizeSelector).sendKeys(Keys.BACK_SPACE, value, Keys.ENTER);
        Thread.sleep(3000);
        String defacto = driver.findElement(InfoPageGismeteo.calendarSampleSelector).getAttribute("offsetWidth");
        Assertions.assertTrue(Integer.parseInt(defacto) == resultExpected);
    }

    private static Stream<Arguments> citiesList() {
        return Stream.of(
                Arguments.of("Москва", "Москва"),
                Arguments.of("Csphfym", "Сызрань"),
                Arguments.of("Санкт-Петербург (Пулково)", "Санкт-Петербург (Пулково)"),
                Arguments.of("Урю", "Урюпинск"),
                Arguments.of("Moscow", "Москва")
        );
    }

    @ParameterizedTest
    @MethodSource("citiesList")
    public void checkLocationPositive(String city, String expectedCityToBe) {
        clickElement(InfoPageGismeteo.cityNameForSampleSelector);
        WebElement cityInput = driver.findElement(InfoPageGismeteo.cityNameForSampleSelector);
        cityInput.sendKeys(city);
        clickElement(InfoPageGismeteo.cityFirstElement);
        Assertions.assertEquals(expectedCityToBe, driver.findElement(InfoPageGismeteo.cityResultSamplerSelector).getAttribute("innerText"), "_" + expectedCityToBe + "_ does not match _" + driver.findElement(InfoPageGismeteo.cityResultSamplerSelector).getAttribute("innerText") + "_");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "123", "someemail@mail.ru"})
    public void checkLocationNegative(String city) {
        clickElement(InfoPageGismeteo.cityNameForSampleSelector);
        WebElement cityInput = driver.findElement(InfoPageGismeteo.cityNameForSampleSelector);
        cityInput.sendKeys(city);
        try {
            driver.findElement(InfoPageGismeteo.cityFirstElement).isDisplayed();
            fail("Element is displayed");
        } catch (Exception e) {
            assertNotNull(e);
        }
    }

    @Test
    public void checkMultiplePlacesLink() {
        clickElement(InfoPageGismeteo.multipleCitiesPage);
        Assertions.assertTrue(driver.getCurrentUrl().contains("tourism"));
    }

    @Test
    public void twoCitiesCheck() {
        clickElement(InfoPageGismeteo.multipleCitiesPage);
        clickElement(InfoPageGismeteo.inputCitySelector);
        WebElement cityInput = driver.findElement(InfoPageGismeteo.inputCitySelector);
        cityInput.sendKeys("Киев");
        clickElement(InfoPageGismeteo.multipleCityInputSelector);

        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.premiereMultipleCities).getText().contains("Москва"));
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.secondeMultipleCities).getText().contains("Киев"));
    }

    @Test
    public void twoCitiesInterchangeCheck() {
        clickElement(InfoPageGismeteo.multipleCitiesPage);
        clickElement(InfoPageGismeteo.inputCitySelector);
        WebElement cityInput = driver.findElement(InfoPageGismeteo.inputCitySelector);
        cityInput.sendKeys("Киев");
        clickElement(InfoPageGismeteo.multipleCityInputSelector);
        clickElement(InfoPageGismeteo.cityKievUpButton);
        Assertions.assertTrue(driver.findElement(InfoPageGismeteo.premiereMultipleCities).getText().contains("Киев"));
    }

    @Test
    public void twoCitiesInterchangeAndRemoveOneCheck() {
        clickElement(InfoPageGismeteo.multipleCitiesPage);
        clickElement(InfoPageGismeteo.inputCitySelector);
        WebElement cityInput = driver.findElement(InfoPageGismeteo.inputCitySelector);
        cityInput.sendKeys("Киев");
        clickElement(InfoPageGismeteo.multipleCityInputSelector);
        clickElement(InfoPageGismeteo.cityKievUpButton);
        clickElement(InfoPageGismeteo.cityKievRemoveButtonSelector);
        Assertions.assertFalse(driver.findElement(InfoPageGismeteo.premiereMultipleCities).getText().contains("Киев"));
    }


   /* @Test
    public void someTestName() throws InterruptedException {
        String colourCode = "00FF00";
      clickElement(InfoPageGismeteo.contourSelector);
        clickElement(InfoPageGismeteo.contourSelector);
        clickElement(InfoPageGismeteo.borderInputDeFactoSelector);
        Thread.sleep(50000);
        for (int i = 0; i < 6; i++) {
            driver.findElement(InfoPageGismeteo.borderInputDeFactoTwoSelector).sendKeys(Keys.BACK_SPACE);
        }
        Thread.sleep(50000);
        driver.findElement(InfoPageGismeteo.borderInputDeFactoTwoSelector).sendKeys(colourCode);
        driver.findElement(InfoPageGismeteo.colourSubmitButton).click();
        Thread.sleep(50000);
        System.out.println(driver.findElement(InfoPageGismeteo.borderSampleSelector).getCssValue("border"));
        // Assertions.assertTrue(driver.findElement(InfoPageGismeteo.transparentBackgroundSampleSelector).getCssValue("background").contains("rgb(0, 255, 0)"));
    }*/
}

