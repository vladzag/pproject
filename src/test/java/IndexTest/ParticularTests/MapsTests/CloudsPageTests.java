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
import webpages.gismeteo.pages.MapsPageGismeteo;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CloudsPageTests extends DefaultPageTest {
    /*
    @BeforeEach
    public void BeforeEachMethod() {defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/eur/clou/");}

    @AfterEach
    public void AfterEachMethod() {
        driver.quit();
    }*/
    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void mapsCloudsCheckURL(String region) {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/" + region + "/clou/");
        Assertions.assertEquals("https://www.gismeteo.ru/maps/" + region + "/clou/", driver.getCurrentUrl(), "https://www.gismeteo.ru/maps/eur/clou/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void checkCloudsTimeList(String region) {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/" + region + "/clou/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void takeCloudsMapScreenshots(String region) throws IOException {
        int screenshotcounter = 1;
        int expectedquantityofscreenshots = 21;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu:MM:dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/" + region + "/clou/");
        WebElement currentMap = driver.findElement(MapsPageGismeteo.mapContainerSelector);
        WebElement currentTimeZone = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            timeZoneDifferenceElement.click();
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_clouds_" + region + "_" + screenshotcounter + "_" + dateTimeFormatter.format(now) + ".png"));
            screenshotcounter++;
        }
        Assertions.assertEquals(expectedquantityofscreenshots, screenshotcounter, "Screenshot quantity does not match");
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void checkCloudsDateAndTimeList(String region) {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/" + region + "/clou/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }
}