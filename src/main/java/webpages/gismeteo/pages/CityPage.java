package webpages.gismeteo.pages;

import org.openqa.selenium.By;

public class CityPage {


    public static final By windSpeed = new By.ByCssSelector(".widget.widget-wind.widget-oneday");
    public static final By nextDayWeather = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section.section.section-content.section-bottom-collapse > div > a:nth-child(3) > div");
    public static final By nowWeather = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section.section.section-content.section-bottom-collapse > div > a:nth-child(1) > div");
    public static final By todayWeather = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section.section.section-content.section-bottom-collapse > div > a:nth-child(2) > div");
    public static final By nextDateWindSpeed = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(10) > div > div.widget-subtitle > a");

    public static final By previousDateWindSpeed = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(10) > div > div.widget-subtitle > a.daylink.daylink-prev");
    public static final By pollenPoints = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(11) > div > div.widget-title");
    public static final By weatherOnRoads = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(12) > div > div.widget-title");
    public static final By barometricPressure = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(14) > div > div.widget-title");
    public static final By nextDateBarometricPressure = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(14) > div > div.widget-subtitle > a");

    public static final By previousDateBarometricPressure = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(14) > div > div.widget-subtitle > a.daylink.daylink-prev");
    public static final By humidityPercent = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(15) > div > div.widget-title");

    public static final By nextDateHumidityPercent = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(15) > div > div.widget-subtitle > a");
    public static final By previousDateHumidityPercent = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(15) > div > div.widget-subtitle > a.daylink.daylink-prev");
    public static final By sunAndMoon = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(17) > div > div.widget-title");
    public static final By nextDateSunAndMoon = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(17) > div > div.widget-subtitle > a.daylink.daylink-next");
    public static final By previousDateSunAndMoon = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(17) > div > div.widget-subtitle > a.daylink.daylink-prev");
    public static final By geomagneticActivity = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(19) > div > div.widget-title");
    public static final By nextDateGeomagneticActivity = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(19) > div > div.widget-subtitle > a.daylink.daylink-next");
    public static final By previousDateGeomagneticActivity = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(19) > div > div.widget-subtitle > a.daylink.daylink-prev");

    public static final By cityAnnouncementsRussiaTab = new By.ByCssSelector("body > section.content.wrap > div.content-column.column2 > section:nth-child(4) > div.feed.feed-partner");
    public static final By realTimeTab = new By.ByCssSelector("body > section.content.wrap > div.content-column.column2 > section:nth-child(5) > div.feed.feed-partner");
    public static final By pulsationTab = new By.ByCssSelector("body > section.content.wrap > div.content-column.column2 > section:nth-child(6) > div.feed.feed-partner");
    public static final By cityNewsTab = new By.ByCssSelector("body > section.content.wrap > div.content-column.column2 > section:nth-child(3) > div.feed.feed-partner");
    public static final By partnersNewsTab = new By.ByCssSelector("body > section.content.wrap > div.content-column.column3 > section:nth-child(1) > div.feed.feed-partner");
    public static final By clearVisitedCities = new By.ByXPath("/html/body/section/div[1]/section[2]/div/div[1]/div[1]/span[2]");
            //ByCssSelector("body > section > div.content-column.column1 > section:nth-child(2) > div > div.cities-viewed > div.cities-head > span.cities-btn.link.js-clear");
}