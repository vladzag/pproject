package webpages.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webpages.defaultData.DefaultPage;

public class MapsPageGismeteo extends DefaultPage {
    public MapsPageGismeteo(WebDriver driver) {
        super(driver);
    }

    public static final By timeZoneSelector = new By.ByCssSelector("body > section > div > section > div.maps-header > div.dropdown-handle");
    public static final By dateAndTimeListSelector = new By.ByCssSelector("body > section > div > section > div.maps-main > div.right-side > div");
    public static final By dropDownMenuItemsSelector = new By.ByClassName("dropdown-menu-item");
    public static final By regionDropDownSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div > div.subnav-menu-item.dropdown-handle");
    public static final By currentMapSelector = new By.ByCssSelector("body > section > div > section > div.maps-main > div.left-side > section.map-container > div.img-slides.eur > div.background.layout-3 > svg");
    public static final By mapContainerSelector = new By.ByClassName("map-container");
}
