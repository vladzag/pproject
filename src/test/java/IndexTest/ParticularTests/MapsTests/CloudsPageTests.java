package IndexTest.ParticularTests.MapsTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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

public class CloudsPageTests extends DefaultPageTest {
    @Test
    public void mapsEurCloudsCheckURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/eur/clou/");
        Assertions.assertEquals("https://www.gismeteo.ru/maps/eur/clou/", driver.getCurrentUrl(), "https://www.gismeteo.ru/maps/eur/clou/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void checkEurCloudsTimeList() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/eur/clou/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @Test
    public void takeEurCloudsMapScreenshots() throws IOException {
        int screenshotcounter = 1;
        int expectedquantityofscreenshots = 21;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu:MM:dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/eur/clou/");
        WebElement currentMap = driver.findElement(MapsPageGismeteo.mapContainerSelector);
        WebElement currentTimeZone = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            timeZoneDifferenceElement.click();
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_clouds_eur_" + screenshotcounter + "_" + dateTimeFormatter.format(now) + ".png"));
            screenshotcounter++;
        }
        Assertions.assertEquals(expectedquantityofscreenshots, screenshotcounter, "Screenshot quantity does not match");
        driver.quit();
    }

    @Test
    public void checkEurCloudsDateAndTimeList() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/eur/clou/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }


    @Test
    public void mapsSibCloudsCheckURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/sib/clou/");
        Assertions.assertEquals("https://www.gismeteo.ru/maps/sib/clou/", driver.getCurrentUrl(), "https://www.gismeteo.ru/maps/sib/clou/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void checkSibCloudsTimeList() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/sib/clou/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @Test
    public void takeSibCloudsScreenshots() throws IOException {
        int screenshotcounter = 1;
        int expectedquantityofscreenshots = 21;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu:MM:dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/sib/clou/");
        WebElement currentMap = driver.findElement(MapsPageGismeteo.mapContainerSelector);
        WebElement currentTimeZone = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            timeZoneDifferenceElement.click();
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_clouds_sib_" + screenshotcounter + "_" + dateTimeFormatter.format(now) + ".png"));
            screenshotcounter++;
        }
        Assertions.assertEquals(expectedquantityofscreenshots, screenshotcounter, "Screenshot quantity does not match");
        driver.quit();
    }

    @Test
    public void checkSibCloudsDateAndTimeList() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/sib/clou/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @Test
    public void mapsFeruCloudsCheckURL() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/feru/clou/");
        Assertions.assertEquals("https://www.gismeteo.ru/maps/feru/clou/", driver.getCurrentUrl(), "https://www.gismeteo.ru/maps/feru/clou/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @Test
    public void checkFeruCloudsTimeList() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/feru/clou/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @Test
    public void takeFeruCloudsScreenshots() throws IOException {
        int screenshotcounter = 1;
        int expectedquantityofscreenshots = 21;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu:MM:dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/feru/clou/");
        WebElement currentMap = driver.findElement(MapsPageGismeteo.mapContainerSelector);
        WebElement currentTimeZone = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            timeZoneDifferenceElement.click();
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_clouds_feru_" + screenshotcounter + "_" + dateTimeFormatter.format(now) + ".png"));
            screenshotcounter++;
        }
        Assertions.assertEquals(expectedquantityofscreenshots, screenshotcounter, "Screenshot quantity does not match");
        driver.quit();
    }

    @Test
    public void checkFeruCloudsDateAndTimeList() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/feru/clou/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }
}
