package IndexTest.ParticularTests.MapsTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import webpages.gismeteo.pages.MapsPageGismeteo;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class WindPageTests extends DefaultPageTest {
    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void mapsWindCheckURL(String region) {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/" + region + "/wind/");
        Assertions.assertEquals("https://www.gismeteo.ru/maps/eur/wind/", driver.getCurrentUrl(), "https://www.gismeteo.ru/maps/eur/wind/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void checkWindTimeList(String region) {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/" + region + "/wind/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void takeWindMapScreenshots(String region) throws IOException {
        int screenshotcounter = 1;
        int expectedquantityofscreenshots = 21;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu:MM:dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/" + region + "/wind/");
        WebElement currentMap = driver.findElement(MapsPageGismeteo.mapContainerSelector);
        WebElement currentTimeZone = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            timeZoneDifferenceElement.click();
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_wind_" + region + "_" + screenshotcounter + "_" + dateTimeFormatter.format(now) + ".png"));
            screenshotcounter++;
        }
        Assertions.assertEquals(expectedquantityofscreenshots, screenshotcounter, "Screenshot quantity does not match");
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void checkWindDateAndTimeList(String region) {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/" + region + "/wind/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void windWindMapLegendColours(String region) {
        List<String> colourCodes = Arrays.asList("#ffffff", "#c5fefd", "#9fe8fa", "#64d5f2", "#82f930", "#f5f336", "#faa729", "#f00c1a", "#ba127c", "#7d24f6", "#020b74", "#000000");
        List<String> mmCodes = Arrays.asList("3", "6", "9", "12", "15", "18", "21", "24", "27", "30", "33", "36 м/c");
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/" + region + "/wind");
        List<WebElement> listOfMapLegendParameters = driver.findElements(new By.ByCssSelector(".item.item-wind"));
        int elementNumber = 0;
        for (WebElement element : listOfMapLegendParameters) {
            String cssValue = element.getCssValue("background-color");
            String colourCodeObtained = Color.fromString(cssValue).asHex();
            Assertions.assertEquals(colourCodes.get(elementNumber), colourCodeObtained, "Colours do not match");
            Assertions.assertEquals(mmCodes.get(elementNumber), element.getText(), "mm do not match");
            elementNumber++;
        }
    }
}
