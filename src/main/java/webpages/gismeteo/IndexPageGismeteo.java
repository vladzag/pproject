package webpages.gismeteo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webpages.defaultData.DefaultPage;

public class IndexPageGismeteo extends DefaultPage {

    public IndexPageGismeteo(WebDriver driver) {
        super(driver);
    }

    public static final By headerLinkWeather = new By.ByPartialLinkText("Погода");
    public static final By headerLinkNews = new By.ByPartialLinkText("Новости");
    public static final By headerLinkMaps = new By.ByPartialLinkText("Карты");
    public static final By headerLinkInformers = new By.ByPartialLinkText("Информеры");
    public static final By headerLinkSoft = new By.ByPartialLinkText("Приложения");
    public static final By searchField = new By.ByXPath("/html/body/header/div[2]/div[2]/div/div/div[1]/div/input");
    public static final By clearSearchField = new By.ByXPath("/html/body/header/div[2]/div[2]/div/div/div[1]/div/i[2]");
    public static final By firstItemInSearch = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div > div.found > div > div.search-list.weather-menu.menu-white > a:nth-child(1) > div.city > div.city-text");

    public static final By meteoStationBulchug = new By.ByCssSelector("body > section > div.content-column.column1 > section:nth-child(1) > div.widget.nearestams > div.meteostations > a:nth-child(1) > div.meteostation-title > span");
    public static final By meteoStationSVO = new By.ByCssSelector("body > section > div.content-column.column1 > section:nth-child(1) > div.widget.nearestams > div.meteostations > a:nth-child(4) > div.meteostation-title > span");
    public static final By firstItemInSearchUXSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div > div.found > div > div.search-list.weather-menu.menu-white > a:nth-child(1)");




    // "//a[contains(@class, \"search-item list-item icon-menu icon-menu-gray\")]");
    //ByClassName(classname);
    //ByXPath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"found\", \" \" ))]");
    //ByXPath("(//a[class=\'.search-item.list-item.icon-menu.icon-menu-gray\'])[1]");
    //ByCssSelector("a.search-item.list-item.icon-menu.icon-menu-gray");
    //ByXPath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"city\", \"1\" ))]");
    //ByClassName(".search-item.list-item.icon-menu.icon-menu-gray");
    //By.ByXPath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"city\", \" \" ))]");
    //.ByCssSelector(".found");
    //ByXPath("//city[@id='1']city[1]");


    public IndexPageGismeteo firstItemInSearchClick() {
        driver.findElement(firstItemInSearch).click();
        return this;
    }

    public IndexPageGismeteo searchFieldWithText(String searchRequest) {
        driver.findElement(searchField).sendKeys(searchRequest);
        return this;
    }

    public IndexPageGismeteo clearSearchFieldClick() {
        driver.findElement(clearSearchField).click();
        return this;
    }

    public IndexPageGismeteo clickWeatherClick() {
        driver.findElement(headerLinkWeather).click();
        return this;
    }

    public IndexPageGismeteo clickNewsClick() {
        driver.findElement(headerLinkNews).click();
        return this;
    }

    public IndexPageGismeteo clickMaps() {
        driver.findElement(headerLinkMaps).click();
        return this;
    }

    public IndexPageGismeteo clickInformers() {
        driver.findElement(headerLinkInformers).click();
        return this;
    }

    public IndexPageGismeteo clickSoft() {
        driver.findElement(headerLinkSoft).click();
        return this;
    }


}