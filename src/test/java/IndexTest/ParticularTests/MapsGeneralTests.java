package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.MapsPageGismeteo;

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
    public void someTestName() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "maps/");
        clickElement(MapsPageGismeteo.timeZoneSelector);
        List<WebElement> timeZoneOption = driver.findElements(MapsPageGismeteo.dropDownMenuItemsSelector);
        for (int i = 0; i == 3; i++) {
            timeZoneOption.remove(0);
        }
        List<String> stringList = new ArrayList<String>();
        for (WebElement element : timeZoneOption ) {

            stringList.add(element.getText().toString());
            //System.out.println(element.getText());
        }

        for (WebElement timeZoneObject : timeZoneOption) {
            int timeZoneValue = -12;
            Assertions.assertEquals(timeZoneValue, timeZoneObject.getAttribute("innerHTML"), "\n Something went wrong with timezones doest not match " + timeZoneObject.getAttribute("innerHTML"));
            timeZoneValue++;
        }
        //clickElement(MapsPageGismeteo.dropDownMenuItemsSelector);}


        //for (WebElement dropDownElement: someElementName){
        //  System.out.println(dropDownElement);
        // }
        // Select dropDownTimeZone = new Select(driver.findElement(MapsPageGismeteo.timeZoneSelector));
        //System.out.println(dropDownTimeZone);
        driver.quit();
/*
int maxAmountOfClicks = 100;
        int amountOfClicks = 0;
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "news/science/");
        WebElement moreNewsButton = driver.findElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
        while (moreNewsButton.isDisplayed() && amountOfClicks <= maxAmountOfClicks) {
            clickElement(NewsPageGismeteo.readMoreNewsFirstColumnTabSelector);
            amountOfClicks++;
        }
        WebElement someElement = driver.findElement(NewsPageGismeteo.firstColumnTabSelector);
        List<WebElement> someElements = someElement.findElements(By.className("article-item"));
        for (WebElement articleItem : someElements) {
            Assertions.assertEquals(ConfiguresAndConstants.defaultURL + "news/science/", articleItem.getAttribute("baseURI"), "URLs do not match");
            Assertions.assertEquals(articleItem.getAttribute("innerText"), articleItem.getAttribute("outerText"));
        }
        driver.quit();
 */
    }
}
