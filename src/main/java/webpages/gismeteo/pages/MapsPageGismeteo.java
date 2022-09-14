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
    public static final By mapToggleSelector = new By.ByCssSelector("#js-interactive-map > form > div > select");
    public static final By ragweedSelector = new By.ByCssSelector("#js-interactive-map > form > div > select > option:nth-child(2)");
    public static final By grassSelector = new By.ByCssSelector("#js-interactive-map > form > div > select > option:nth-child(1)");
    public static final By searchInputSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.search.js-search > div.search-form.js-search-form > div > input");
    public static final By yesterdayDateLegendSelector = new By.ByCssSelector("    public static final By todayDateLegendSelector = new By.ByCssSelector(\"body > section > div > section > div.interactive-map-container > div.controls.js-map-controls > div.timeline-wrap.js-timeline-wrap > div > div:nth-child(1) > div.date > span");
    public static final By todayDateLegendSelector = new By.ByCssSelector("body > section > div > section > div.interactive-map-container > div.controls.js-map-controls > div.timeline-wrap.js-timeline-wrap > div > div:nth-child(2) > div.date > span");
    public static final By tomorrowDateLegendSelector = new By.ByCssSelector("body > section > div > section > div.interactive-map-container > div.controls.js-map-controls > div.timeline-wrap.js-timeline-wrap > div > div:nth-child(3) > div.date > span");
    public static final By dayAfterTomorrowDateLegendSelector = new By.ByCssSelector("body > section > div > section > div.interactive-map-container > div.controls.js-map-controls > div.timeline-wrap.js-timeline-wrap > div > div:nth-child(4) > div.date > span");

}