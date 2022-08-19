package webpages.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webpages.defaultData.DefaultPage;

public class MapsPageGismeteo extends DefaultPage {
    public MapsPageGismeteo(WebDriver driver) {
        super(driver);
    }

    public static final By timeZoneSelector = new By.ByCssSelector("body > section > div > section > div.maps-header > div.dropdown-handle");
    public static final By dropDownElementSelector = new By.ByCssSelector("body > section > div > section > div.maps-header > div.dropdown-menu.js-tz");
public static final By dropDownMenuItemsSelector = new By.ByClassName("dropdown-menu-item");
//ByXPath("*[@class='dropdown-menu-item' and text()!='Сибирь'||'Европа'||'Дальний Восток']");
//ByClassName("dropdown-menu-item");

public static final By getDropDownMenuItemsSelector2 = new By.ByCssSelector("body > section > div > section > div.maps-header > div.dropdown-menu.js-tz > div:nth-child(1)");
}
