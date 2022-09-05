package webpages.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webpages.defaultData.DefaultPage;

public class InfoPageGismeteo extends DefaultPage {
    public InfoPageGismeteo(WebDriver driver) {
        super(driver);
    }

    public static final By topLinksSelector = new By.ByCssSelector("body > section > nav > div");
    public static final By scrollerTableSelector = new By.ByClassName("b-j-scroller__table");
    public static final By offerConditionsSelector = new By.ByPartialLinkText("Условия использования");
    public static final By firstListSetForAllSitesSelector = new By.ByCssSelector("body > section > div:nth-child(4) > div > div > div > table > tbody > tr:nth-child(1)");
    public static final By secondListSetForAllSitesSelector = new By.ByCssSelector("body > section > div:nth-child(4) > div > div > div > table > tbody > tr:nth-child(2)");
    public static final By setForAnySiteLastSelector = new By.ByCssSelector(".iconLine.last");
    public static final By simpleInformersHeaderSelector = new By.ByCssSelector("body > section > div > div > div > div");
    public static final By informersLanguageSelector = new By.ByCssSelector(".params.field.switch");
    public static final By cityNameSelector = new By.ByXPath("/html/body/section/div/div/div/div/div[2]/div/form/table/tbody/tr/td[3]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/table/tbody/tr/td[1]/div/span");
    public static final By nameOfLocationSelector = new By.ByCssSelector("#cityRadioLabel");
    public static final By cityLocationSampleSelector = new By.ByCssSelector("#gsCityHead > span");
    public static final By cityLocationAtopSelector = new By.ByCssSelector("#gsCityHead > span");
    public static final By locationAtopSelector = new By.ByCssSelector("#cityPlaceLabel2");
    public static final By locationLeftSelector = new By.ByCssSelector("#cityPlaceLabel3");
    public static final By currentWeatherSelector = new By.ById("moduleCheckboxLabel1");
    public static final By currentWeatherSampleSelector = new By.ById("tdIcon");
    public static final By iconCurrentWeatherSelector = new By.ById("moduleCurrentIconLabel");
    public static final By iconCurrentWeatherSampleSelector = new By.ByCssSelector("#tdIcon > div.gsWeatherIcon.display");
    public static final By descriptionCurrentWeatherSelector = new By.ById("moduleCurrentDescLabel");
    public static final By descriptionCurrentWeatherSampleSelector = new By.ByCssSelector("#gs-moduleCurrentBlock > div.gsAddInfo2.padding > div.gsAddInfo > span");
    public static final By windCurrentWeatherSelector = new By.ById("moduleCurrentWindLabel");
    public static final By getWindCurrentWeatherSampleSelector = new By.ById("windAddInfo");
    public static final By pressureCurrentWeatherSelector = new By.ById("moduleCurrentPressCheckbox");
    public static final By pressureCurrentWeatherSampleSelector = new By.ById("pressAddInfo");
    public static final By humidityCurrentWeatherSelector = new By.ByCssSelector("moduleCurrentHumidityLabel");
    public static final By humidityCurrentWeatherSampleSelector = new By.ById("humidityAddInfo");
    public static final By forecastSelector = new By.ById("moduleCheckboxLabel2");
    public static final By forecastSampleSelector = new By.ById("gs-moduleForecastBlock");
    public static final By dateForecastSelector = new By.ById("moduleForecastDateLabel");
    public static final By dateForecastTodaySampleSelector = new By.ByCssSelector(".col_h.today");
    public static final By dateForecastTomorrowSampleSelector = new By.ByCssSelector(".col_h.tomorrow");
    public static final By iconForecastSelector = new By.ById("moduleForecastIconLabel");
    public static final By iconForecastSampleFirstSelector = new By.ByCssSelector("#tab-h24-0 > span.s_icon.sunny");
    public static final By iconForecastSampleSecondSelector = new By.ByCssSelector("#tab-h24-1 > span.s_icon.sunny");
    public static final By iconForecastSampleThirdSelector = new By.ByCssSelector("#tab-h24-2 > span.s_icon.sunny");
    public static final By iconForecastSampleFourthSelector = new By.ByCssSelector("#tab-h24-3 > span.s_icon.sunny");
    public static final By windForecastSelector = new By.ById("moduleForecastWindLabel");
    public static final By windForecastSampleFirstSelector = new By.ByCssSelector("#tab-h24-0 > div.centralized > div:nth-child(1) > span");
    public static final By windForecastSampleSecondSelector = new By.ByCssSelector("#tab-h24-1 > div.centralized > div:nth-child(1) > span");
    public static final By windForecastSampleThirdSelector = new By.ByCssSelector("#tab-h24-2 > div.centralized > div:nth-child(1) > span");
    public static final By windForecastSampleFourthSelector = new By.ByCssSelector("#tab-h24-3 > div.centralized > div:nth-child(1) > span");
    public static final By pressureForecastSelector = new By.ById("moduleForecastPressLabel");
    public static final By pressureForecastSampleFirstSelector = new By.ByCssSelector("#tab-h24-0 > div.centralized > div:nth-child(2) > span");
    public static final By pressureForecastSampleSecondSelector = new By.ByCssSelector("#tab-h24-1 > div.centralized > div:nth-child(2) > span");
    public static final By pressureForecastSampleThirdSelector = new By.ByCssSelector("#tab-h24-2 > div.centralized > div:nth-child(2) > span");
    public static final By pressureForecastSampleFourthSelector = new By.ByCssSelector("#tab-h24-3 > div.centralized > div:nth-child(2) > span");
    public static final By humidityForecastSelector = new By.ById("moduleForecastHumidityLabel");
    public static final By humidityForecastSampleFirstSelector = new By.ByCssSelector("#tab-h24-0 > div.centralized > div:nth-child(3) > span");
    public static final By humidityForecastSampleSecondSelector = new By.ByCssSelector("#tab-h24-1 > div.centralized > div:nth-child(3) > span");
    public static final By humidityForecastSampleThirdSelector = new By.ByCssSelector("#tab-h24-2 > div.centralized > div:nth-child(3) > span");
    public static final By humidityForecastSampleFourthSelector = new By.ByCssSelector("#tab-h24-3 > div.centralized > div:nth-child(3) > span");
    public static final By checkTemperatureCelsiusSelector = new By.ById("temperatureLabel1");
    public static final By checkTemperatureFahrenheitSelector = new By.ById("temperatureLabel2");
    public static final By checkTemperatureSamplesSelector = new By.ById("deg");
    public static final By windSpeedMeterSecondSelector = new By.ById("vWindLabel1");
    public static final By windSpeedKilometreHourSelector = new By.ById("vWindLabel2");
    public static final By windSpeedSampleSelector = new By.ById("windEd");
    public static final By pressureMMHGSelector = new By.ById("pressLabel1");
    public static final By pressuregPASelector = new By.ById("pressLabel2");
    public static final By pressureSampleSelector = new By.ById("pressEd");
    public static final By iconLeftSelector = new By.ByCssSelector("#iconStyleSwitch > span:nth-child(1) > label");
    public static final By iconRightSelector = new By.ByCssSelector("#iconStyleSwitch > span:nth-child(2) > label");
    public static final By contourSampleSelector = new By.ById("gsInformer");
    public static final By contourSelector = new By.ByCssSelector("#borderLabel1");
    public static final By transparentBackgroundSelector = new By.ById("informerTransparentBGOne");
    public static final By transparentBackgroundSampleSelector = new By.ByClassName("secondaryWrap");

}
