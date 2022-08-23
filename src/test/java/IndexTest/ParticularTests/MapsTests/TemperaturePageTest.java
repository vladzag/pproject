package IndexTest.ParticularTests.MapsTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.MapsPageGismeteo;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TemperaturePageTest extends DefaultPageTest {

    @Test
    public void temperatureEURCheckURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/eur/temp/");
        Assertions.assertEquals("https://www.gismeteo.ru/maps/eur/temp/", driver.getCurrentUrl(), "https://www.gismeteo.ru/maps/eur/temp/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void checkEurTimeList() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/eur/temp/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @Test
    public void takeEurMapScreenshots() throws IOException {
        int screenshotcounter = 1;
        int expectedquantityofscreenshots = 21;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu:MM:dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/eur/temp/");
        WebElement currentMap = driver.findElement(MapsPageGismeteo.mapContainerSelector);
        WebElement currentTimeZone = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            timeZoneDifferenceElement.click();
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_temperature_eur_" + screenshotcounter + "_" + dateTimeFormatter.format(now) + ".png"));
            screenshotcounter++;
        }
        Assertions.assertEquals(expectedquantityofscreenshots, screenshotcounter, "Screenshot quantity does not match");
        driver.quit();
    }

    @Test
    public void temperatureEurMapLegendGradient() {
        String expectedCSSValue = "linear-gradient(100deg, rgb(0, 0, 0), rgb(127, 37, 251) 10%, rgb(11, 36, 251) 20%, rgb(23, 131, 251) 30%, rgb(72, 192, 252) 40%, rgb(133, 255, 254) 50%, rgb(132, 253, 49) 60%, rgb(255, 253, 56) 70%, rgb(253, 128, 35) 80%, rgb(252, 13, 27) 90%, rgb(255, 255, 255))";
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/eur/temp/");
        WebElement mapLegendElement = driver.findElement(By.cssSelector(".values.values-temp"));
        Assertions.assertEquals(expectedCSSValue, mapLegendElement.getCssValue("background-image"), "CSS does not match");
        driver.quit();
    }

    @Test
    public void temperatureSibCheckURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/sib/temp/");
        Assertions.assertEquals("https://www.gismeteo.ru/maps/sib/temp/", driver.getCurrentUrl(), "https://www.gismeteo.ru/maps/sib/temp/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void checkSibTimeList() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/sib/temp/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @Test
    public void takeSibMapScreenshots() throws IOException {
        int screenshotcounter = 1;
        int expectedquantityofscreenshots = 21;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu:MM:dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/sib/temp/");
        WebElement currentMap = driver.findElement(MapsPageGismeteo.mapContainerSelector);
        WebElement currentTimeZone = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            timeZoneDifferenceElement.click();
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_temperature_sib_" + screenshotcounter + "_" + dateTimeFormatter.format(now) + ".png"));
            screenshotcounter++;
        }
        Assertions.assertEquals(expectedquantityofscreenshots, screenshotcounter, "Screenshot quantity does not match");
        driver.quit();
    }

    @Test
    public void temperatureSibMapLegendGradient() {
        String expectedCSSValue = "linear-gradient(100deg, rgb(0, 0, 0), rgb(127, 37, 251) 10%, rgb(11, 36, 251) 20%, rgb(23, 131, 251) 30%, rgb(72, 192, 252) 40%, rgb(133, 255, 254) 50%, rgb(132, 253, 49) 60%, rgb(255, 253, 56) 70%, rgb(253, 128, 35) 80%, rgb(252, 13, 27) 90%, rgb(255, 255, 255))";
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/sib/temp/");
        WebElement mapLegendElement = driver.findElement(By.cssSelector(".values.values-temp"));
        Assertions.assertEquals(expectedCSSValue, mapLegendElement.getCssValue("background-image"), "CSS does not match");
        driver.quit();
    }


    @Test
    public void temperatureFeruCheckURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/feru/temp/");
        Assertions.assertEquals("https://www.gismeteo.ru/maps/feru/temp/", driver.getCurrentUrl(), "https://www.gismeteo.ru/maps/feru/temp/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void checkFeruTimeList() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/feru/temp/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @Test
    public void takeFeruMapScreenshots() throws IOException {
        int screenshotcounter = 1;
        int expectedquantityofscreenshots = 21;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu:MM:dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/feru/temp/");
        WebElement currentMap = driver.findElement(MapsPageGismeteo.mapContainerSelector);
        WebElement currentTimeZone = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            timeZoneDifferenceElement.click();
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_temperature_feru_" + screenshotcounter + "_" + dateTimeFormatter.format(now) + ".png"));
            screenshotcounter++;
        }
        Assertions.assertEquals(expectedquantityofscreenshots, screenshotcounter, "Screenshot quantity does not match");
        driver.quit();
    }

    @Test
    public void temperatureFeruMapLegendGradient() {
        String expectedCSSValue = "linear-gradient(100deg, rgb(0, 0, 0), rgb(127, 37, 251) 10%, rgb(11, 36, 251) 20%, rgb(23, 131, 251) 30%, rgb(72, 192, 252) 40%, rgb(133, 255, 254) 50%, rgb(132, 253, 49) 60%, rgb(255, 253, 56) 70%, rgb(253, 128, 35) 80%, rgb(252, 13, 27) 90%, rgb(255, 255, 255))";
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/feru/temp/");
        WebElement mapLegendElement = driver.findElement(By.cssSelector(".values.values-temp"));
        Assertions.assertEquals(expectedCSSValue, mapLegendElement.getCssValue("background-image"), "CSS does not match");
        driver.quit();
    }
}
