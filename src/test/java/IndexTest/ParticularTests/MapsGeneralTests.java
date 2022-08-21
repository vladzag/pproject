package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.MapsPageGismeteo;
import webpages.gismeteo.pages.NewsPageGismeteo;

/*import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
*/

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    public void checkTopLinks() {
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
        Assertions.assertEquals(exactDateAndTimeList.size(), expectedSize);
        driver.quit();
    }

    @Test
    public void takeMapScreenshots() throws IOException {
        int screenashotnumber = 1;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("uuuu:MM:dd_HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/");
        WebElement currentMap = driver.findElement(MapsPageGismeteo.currentMapSelector);
        WebElement currentTimeZone = driver.findElement(MapsPageGismeteo.timeZoneSelector);
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_" + screenashotnumber + "_" + dateTimeFormatter.format(now) + ".png"));
        screenashotnumber++;/*
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            timeZoneDifferenceElement.click();
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_" + screenashotnumber + "_" + dateTimeFormatter.format(now) + ".png"));
            screenashotnumber++;
        }*/
        driver.quit();

        /*
        List<WebElement> exactDateAndTimeList = currentTimeZone.findElements(By.className("date-time-list-item"));
        for (WebElement timeZoneDifferenceElement : exactDateAndTimeList) {
            clickElement((By) timeZoneDifferenceElement);
            File screenshot = currentMap.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/vlad.zag/Documents/Captures_d_ecran/screenshot_" + screenashotnumber + ".png"));
            screenashotnumber++;
        }
        */
    }
}
