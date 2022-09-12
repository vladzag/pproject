package IndexTest.ParticularTests.SoftTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.SoftPageGismeteo;

import java.util.ArrayList;
import java.util.List;

public class SoftGeneralTests extends DefaultPageTest {
    @BeforeEach
    public void BeforeEachMethod() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "soft/");
    }

    @AfterEach
    public void AfterEachMethod() {
        driver.quit();
    }

    @Test
    public void softCheckURL() {
        Assertions.assertEquals("https://www.gismeteo.ru/soft/", driver.getCurrentUrl(), "https://www.gismeteo.ru/soft/" + driver.getCurrentUrl() + " не соответствуют");
    }

    @Test
    public void softCheckTopLinks() {
        ArrayList<String> topLinksList = new ArrayList<>();
        topLinksList.add("Для мобильных устройств");
        topLinksList.add("Компьютеров");
        topLinksList.add("Телевизоров");
        WebElement topLinks = driver.findElement(SoftPageGismeteo.topLinksSelector);
        List<WebElement> topLinksNames = topLinks.findElements(new By.ByClassName("header-subnav-link"));
        ArrayList<String> stringsList = new ArrayList<>();
        for (WebElement elementName : topLinksNames) {
            stringsList.add(elementName.getText());
        }
        Assertions.assertEquals(stringsList.containsAll(topLinksList), topLinksList.containsAll(stringsList));
    }

    @Test
    public void checkLink() {
        List<WebElement> listOfElements = driver.findElements(SoftPageGismeteo.classLinkSelector);
        for (int i = 0; i < listOfElements.size(); i++) {
            Assertions.assertTrue(listOfElements.get(i).getAttribute("baseURI").contains("gismeteo.ru"));
        }
    }

    @Test
    public void goToPageiOSDevices() {
        String checkURI = "https://www.gismeteo.ru/soft-mobile-ios/";
        clickElement(SoftPageGismeteo.iOSDevicesSelector);
        Assertions.assertTrue(driver.getCurrentUrl() == checkURI);
    }

    @Test
    public void goToPageAndroidDevices() {
        String checkURI = "https://www.gismeteo.ru/soft-mobile-android/";
        clickElement(SoftPageGismeteo.androidDevicesSelector);
        Assertions.assertTrue(driver.getCurrentUrl() == checkURI);
    }

    @Test
    public void goToPageWIphoneDevices() {
        String checkURI = "https://www.gismeteo.ru/soft-mobile-winphone/";
        clickElement(SoftPageGismeteo.windowPhoneDeviceSelector);
        Assertions.assertTrue(driver.getCurrentUrl() == checkURI);
    }

    @Test
    public void goToPageSmartTVDevices() {
        String checkURI = "https://www.gismeteo.ru/soft-tv/";
        clickElement(SoftPageGismeteo.smartTvSelector);
        Assertions.assertTrue(driver.getCurrentUrl() == checkURI);
    }

    @Test
    public void goToPageBrowserExtensionDevices() {
        String checkURI = "https://www.gismeteo.ru/soft-desktop-chrome/";
        clickElement(SoftPageGismeteo.browserExtensionSelector);
        Assertions.assertTrue(driver.getCurrentUrl() == checkURI);
    }

    @Test
    public void goToPageWindowsOSDevices() {
        String checkURI = "https://www.gismeteo.ru/soft-desktop-windows/";
        clickElement(SoftPageGismeteo.windowsOSSelector);
        Assertions.assertTrue(driver.getCurrentUrl() == checkURI);
    }

    @Test
    public void checkiOSLink() {
        String checkURI = "https://itunes.apple.com/ru/app/gismeteo/id916760091";
        clickElement(SoftPageGismeteo.iOSDevicesSelector);
        WebElement iOsPriceElement = driver.findElement(SoftPageGismeteo.mobileDeviceLinkSelector);
        String iOSLink = iOsPriceElement.getAttribute("href");
        Assertions.assertTrue(iOSLink.contains(checkURI));
    }

    @Test
    public void checkAndroidLink() {
        String checkURI = "https://play.google.com/store/apps/details?id=";
        clickElement(SoftPageGismeteo.androidDevicesSelector);
        List<WebElement> someElementList = driver.findElements(SoftPageGismeteo.mobileDeviceLinkSelector);
        for (int i = 0; i == someElementList.size(); i++) {
            Assertions.assertTrue(someElementList.contains(checkURI));
        }
    }

    @Test
    public void checkWIphoneLink() {
        String checkURI = "https://www.microsoft.com/ru-ru/store/apps/gismeteo/9wzdncrfj1r1";
        clickElement(SoftPageGismeteo.windowPhoneDeviceSelector);
        WebElement someElement = driver.findElement(SoftPageGismeteo.windowsMobileStoreImageSelector);
        String windowsPhoneLinkReceived = someElement.getAttribute("href");
        Assertions.assertTrue(windowsPhoneLinkReceived.contains(checkURI));
    }

    @Test
    public void checkWindowsOSLink() {
        String checkURI = "https://www.microsoft.com/ru-ru/store/apps/gismeteo/9wzdncrfj2k1";
        clickElement(SoftPageGismeteo.windowsOSSelector);
        WebElement someElement = driver.findElement(SoftPageGismeteo.windowsStandByStoreSelector);
        String windowsPhoneLinkReceived = someElement.getAttribute("href");
        Assertions.assertTrue(windowsPhoneLinkReceived.contains(checkURI));
    }

    @Test
    public void chromeExtensionsLink() {
        String checkURI = "https://chrome.google.com/webstore/detail/gismeteo";
        clickElement(SoftPageGismeteo.browserExtensionSelector);
        List<WebElement> listOfButtons = driver.findElements(SoftPageGismeteo.installExtensionButtonSelector);
        for (int i = 0; i < listOfButtons.size(); i++) {
            String currentLink = listOfButtons.get(i).getAttribute("href");
            Assertions.assertTrue(currentLink.contains(checkURI));
        }
    }

    @Test
    public void operaExtensionsLink() {
        String checkURI = "https://addons.opera.com/ru/extensions/details/gismeteo";
        clickElement(SoftPageGismeteo.browserExtensionSelector);
        clickElement(SoftPageGismeteo.clickOperaSelector);
        List<WebElement> listOfButtons = driver.findElements(SoftPageGismeteo.installExtensionButtonSelector);
        for (int i = 0; i < listOfButtons.size(); i++) {
            String currentLink = listOfButtons.get(i).getAttribute("href");
            Assertions.assertTrue(currentLink.contains(checkURI));
        }
    }

}
