package webpages.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webpages.defaultData.DefaultPage;

public class SoftPageGismeteo extends DefaultPage {
    public SoftPageGismeteo(WebDriver driver) {
        super(driver);
    }
    public static final By topLinksSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div");
    public static final By classLinkSelector = new By.ByClassName("link");
    public static final By iOSDevicesSelector = new By.ByCssSelector("body > section > div > section > div.softmain-list > div:nth-child(1) > div.softmain-subitem.softmain-subitem-ios > a > span");
    public static final By androidDevicesSelector = new By.ByCssSelector("body > section > div > section > div.softmain-list > div:nth-child(1) > div.softmain-subitem.softmain-subitem-android > a > span");
    public static final By windowPhoneDeviceSelector = new By.ByCssSelector("body > section > div > section > div.softmain-list > div:nth-child(1) > div.softmain-subitem.softmain-subitem-winphone > a > span");
    public static final By smartTvSelector = new By.ByCssSelector("body > section > div > section > div.softmain-list > div:nth-child(2) > div.softmain-subitem.softmain-subitem-tv > a > span");
    public static final By browserExtensionSelector = new By.ByCssSelector("body > section > div > section > div.softmain-list > div:nth-child(3) > div.softmain-subitem.softmain-subitem-browsers > a > span");
    public static final By windowsOSSelector = new By.ByCssSelector("body > section > div > section > div.softmain-list > div:nth-child(3) > div.softmain-subitem.softmain-subitem-windows > a > span");
    public static final By mobileDeviceLinkSelector = new By.ByClassName("mobile-device-link");
    public static final By windowsMobileStoreImageSelector = new By.ByCssSelector("body > section > div > section > div.mobile-device.mobile-device-winphone.wrap > div > a");
    public static final By windowsStandByStoreSelector = new By.ByCssSelector("body > section > div > section > div.desktop-device.desktop-device-windows.wrap > div > div > a");
    public static final By clickOperaSelector = new By.ByCssSelector("body > header > div.header-subnav > div.subsubnav > div > a:nth-child(3)");
    public static final By installExtensionButtonSelector = new By.ByClassName("install-btn");
}
