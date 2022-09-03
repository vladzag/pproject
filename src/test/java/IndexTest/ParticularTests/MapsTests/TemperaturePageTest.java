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

public class TemperaturePageTest extends DefaultPageTest {

    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void temperatureCheckURL(String region) {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/"+region+"/temp/");
        Assertions.assertEquals("https://www.gismeteo.ru/maps/eur/temp/", driver.getCurrentUrl(), "https://www.gismeteo.ru/maps/eur/temp/" + driver.getCurrentUrl() + " не соответствуют");
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void checkTimeList(String region) {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/"+region+"/temp/");
        int expectedSize = 20;
        WebElement dateTimeList = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = dateTimeList.findElements(By.className("date-time-list-item"));
        Assertions.assertEquals(expectedSize, exactDateAndTimeList.size());
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void takeMapScreenshots(String region) throws IOException {
        int screenshotcounter = 1;
        int expectedquantityofscreenshots = 21;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu:MM:dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/"+region+"/temp/");
        WebElement currentMap = driver.findElement(MapsPageGismeteo.mapContainerSelector);
        WebElement currentTimeZone = driver.findElement(MapsPageGismeteo.dateAndTimeListSelector);
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            timeZoneDifferenceElement.click();
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_temperature_"+region+"_" + screenshotcounter + "_" + dateTimeFormatter.format(now) + ".png"));
            screenshotcounter++;
        }
        Assertions.assertEquals(expectedquantityofscreenshots, screenshotcounter, "Screenshot quantity does not match");
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"eur", "sib", "feru"})
    public void temperatureMapLegendGradient(String region) {
        String expectedCSSValue = "linear-gradient(100deg, rgb(0, 0, 0), rgb(127, 37, 251) 10%, rgb(11, 36, 251) 20%, rgb(23, 131, 251) 30%, rgb(72, 192, 252) 40%, rgb(133, 255, 254) 50%, rgb(132, 253, 49) 60%, rgb(255, 253, 56) 70%, rgb(253, 128, 35) 80%, rgb(252, 13, 27) 90%, rgb(255, 255, 255))";
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/"+region+"/temp/");
        WebElement mapLegendElement = driver.findElement(By.cssSelector(".values.values-temp"));
        Assertions.assertEquals(expectedCSSValue, mapLegendElement.getCssValue("background-image"), "CSS does not match");
        driver.quit();
    }
}
