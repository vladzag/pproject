package IndexTest.ParticularTests.MapsTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.MapsPageGismeteo;
import webpages.gismeteo.pages.NewsPageGismeteo;
import org.openqa.selenium.support.Color;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapsGeneralTests extends DefaultPageTest {
    @Test
    public void mapsCheckURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/");
        Assertions.assertEquals("https://www.gismeteo.ru/maps/", driver.getCurrentUrl(), "https://www.gismeteo.ru/maps/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void checkForTimeZoneButtons() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/");
        clickElement(MapsPageGismeteo.timeZoneSelector);
        List<WebElement> timeZoneOption = driver.findElements(MapsPageGismeteo.dropDownMenuItemsSelector);
        for (int i = 0; i <= 2; i++) {
            timeZoneOption.remove(0);
        }
        int timeZoneValue = -12;
        for (WebElement timeZoneObject : timeZoneOption) {
            String timeZoneString = String.valueOf(timeZoneValue);
            if (timeZoneValue > 0) {
                timeZoneString = "+" + timeZoneString;
            }
            Assertions.assertEquals(timeZoneString, timeZoneObject.getAttribute("innerHTML"), "\n Something went wrong with timezones doest not match " + timeZoneObject.getAttribute("innerHTML"));
            timeZoneValue++;
        }
        driver.quit();
    }

    @Test
    public void maosCheckTopLinks() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/");
        ArrayList<String> topLinksSet = new ArrayList<String>();
        topLinksSet.add("Осадки");
        topLinksSet.add("Температура");
        topLinksSet.add("Ветер");
        topLinksSet.add("Аллергия");
        topLinksSet.add("Облачность");
        WebElement topLinks = driver.findElement(NewsPageGismeteo.linksList);
        List<WebElement> topLinksNames = topLinks.findElements(By.className("header-subnav-link"));
        ArrayList<String> someStringList = new ArrayList<String>();
        for (WebElement elementName : topLinksNames) {
            someStringList.add(elementName.getText());
        }
        Assertions.assertEquals(someStringList.containsAll(topLinksSet), topLinksSet.containsAll(someStringList));
        driver.quit();
    }

    @Test
    public void checkDateAndTimeList() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @Test
    public void takeMapScreenshots() throws IOException {
        int screenshotcounter = 1;
        int expectedquantityofscreenshots = 21;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu:MM:dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/");
        WebElement currentMap = driver.findElement(MapsPageGismeteo.currentMapSelector);
        WebElement currentTimeZone = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            timeZoneDifferenceElement.click();
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_precipitations_" + screenshotcounter + "_" + dateTimeFormatter.format(now) + ".png"));
            screenshotcounter++;
        }
        Assertions.assertEquals(expectedquantityofscreenshots, screenshotcounter, "Screenshot quantity does not match");
        driver.quit();
    }

    @Test
    public void checkRegionNames() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/");
        List<String> expectedList = Arrays.asList("Сибирь", "Европа", "Дальний восток");
        clickElement(MapsPageGismeteo.regionDropDownSelector);
        List<WebElement> regionsAndHoursList = driver.findElements(MapsPageGismeteo.dropDownMenuItemsSelector);
        List<String> regionsList = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            regionsList.add(regionsAndHoursList.get(0).getText());
            regionsAndHoursList.remove(0);
        }
        Assertions.assertEquals(expectedList.containsAll(regionsList), regionsList.containsAll(expectedList), "Lists do not match");
        driver.quit();
    }

    @Test
    public void checkForMapsLegend() {
        List<String> colourCodes = Arrays.asList("#a0ffa0", "#8cff8c", "#64ff64", "#3cff3c", "#00ff00", "#00e600", "#00dc00", "#00c800", "#00b400", "#00a000", "#008c00", "#007800", "#005000");
        List<String> mmCodes = Arrays.asList("0,5 мм", "1", "1,5", "2", "2,5", "3", "3,5", "4", "5", "10", "15", "20", "25 мм");
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/");
        List<WebElement> listOfMapLegendParameters = driver.findElements(new By.ByCssSelector(".item.item-prc"));
        int elementNumber = 0;
        for (WebElement element : listOfMapLegendParameters) {
            String cssValue = element.getCssValue("background-color");
            String colourCodeObtained = Color.fromString(cssValue).asHex();
            Assertions.assertEquals(colourCodes.get(elementNumber), colourCodeObtained, "Colours do not match");
            Assertions.assertEquals(element.getText(), mmCodes.get(elementNumber), "mm do not match");
            elementNumber++;
        }
        driver.quit();
    }
}
