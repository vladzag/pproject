package webpages.gismeteo.pages;

import org.openqa.selenium.By;

public class CityPage {
    public static final By windSpeedSelector = new By.ByCssSelector(".widget.widget-wind.widget-oneday");
    public static final By nextDayWeatherSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section.section.section-content.section-bottom-collapse > div > a:nth-child(3) > div");
    public static final By nowWeatherSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section.section.section-content.section-bottom-collapse > div > a:nth-child(1) > div");
    public static final By todayWeatherSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section.section.section-content.section-bottom-collapse > div > a:nth-child(2) > div");
    public static final By nextDateWindSpeedSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(10) > div > div.widget-subtitle > a");
    public static final By previousDateWindSpeedSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(10) > div > div.widget-subtitle > a.daylink.daylink-prev");
    public static final By pollenPointsSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(11) > div > div.widget-title");
    public static final By weatherOnRoadsSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(12) > div > div.widget-title");
    public static final By barometricPressureSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(14) > div > div.widget-title");
    public static final By nextDateBarometricPressureSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(14) > div > div.widget-subtitle > a");
    public static final By previousDateBarometricPressureSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(14) > div > div.widget-subtitle > a.daylink.daylink-prev");
    public static final By humidityPercentSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(15) > div > div.widget-title");
    public static final By nextDateHumidityPercentSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(15) > div > div.widget-subtitle > a");
    public static final By previousDateHumidityPercentSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(15) > div > div.widget-subtitle > a.daylink.daylink-prev");
    public static final By sunAndMoonSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(17) > div > div.widget-title");
    public static final By nextDateSunAndMoonSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(17) > div > div.widget-subtitle > a.daylink.daylink-next");
    public static final By previousDateSunAndMoonSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(17) > div > div.widget-subtitle > a.daylink.daylink-prev");
    public static final By geomagneticActivitySelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(19) > div > div.widget-title");
    public static final By nextDateGeomagneticActivitySelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(19) > div > div.widget-subtitle > a.daylink.daylink-next");
    public static final By previousDateGeomagneticActivitySelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(19) > div > div.widget-subtitle > a.daylink.daylink-prev");
    public static final By cityAnnouncementsRussiaTabSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column2 > section:nth-child(4) > div.feed.feed-partner");
    public static final By realTimeTabSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column2 > section:nth-child(5) > div.feed.feed-partner");
    public static final By pulsationTabSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column2 > section:nth-child(6) > div.feed.feed-partner");
    public static final By cityNewsTabSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column2 > section:nth-child(3) > div.feed.feed-partner");
    public static final By partnersNewsTabSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column3 > section:nth-child(1) > div.feed.feed-partner");
    public static final By clearVisitedCitiesSelector = new By.ByXPath("/html/body/section/div[1]/section[2]/div/div[1]/div[1]/span[2]");
    public static final By gismeteoNewsTabSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(7) > div > a");
    public static final By voronezhWeatherNowSelector = new By.ByCssSelector("    body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > a:nth-child(1)");
    public static final By voronezhWeatherTodaySelector = new By.ByCssSelector("    body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > a:nth-child(2)");
    public static final By voronezhWeatherTomorrowSelector = new By.ByCssSelector("hbody > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > a:nth-child(3)");
    public static final By voronezhWeatherThreeDaysSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > a:nth-child(4)");
    public static final By voronezhWeatherTenDaysSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > a:nth-child(5)");
    public static final By voronezhWeatherTwoWeeksSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > a:nth-child(6)");
    public static final By voronezhWeatherMonthSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > a:nth-child(7)");
    public static final By voronezhWeatherRadarSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > a:nth-child(8)");
    public static final By voronezhWeatherWeeklySelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > a:nth-child(9)");
    public static final By voronezhUpperMoreButtonSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > div.subnav-menu-item.dropdown-handle");
    public static final By voronezhWeatherWeekendSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > div.dropdown-menu > a:nth-child(1)");
    public static final By voronezhWeatherGeoMagneticSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > div.dropdown-menu > a:nth-child(2)");
    public static final By voronezhWeatherDairySelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > div.dropdown-menu > a:nth-child(3)");

}