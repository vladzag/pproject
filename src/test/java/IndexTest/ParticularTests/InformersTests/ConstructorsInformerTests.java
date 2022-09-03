package IndexTest.ParticularTests.InformersTests;

import IndexTest.DefaultPageTest;
import common.ConfiguresAndConstants;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webpages.gismeteo.pages.InfoPageGismeteo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class ConstructorsInformerTests extends DefaultPageTest {

    @BeforeEach
    public void beforeEachMethod() {
        defaultPage.openWebPages(ConfiguresAndConstants.defaultURL + "informers/constructor");
    }

    @AfterEach
    public void AfterEachMethod() {
        driver.quit();
    }

    @Test
    public void constructorsCheckURL() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.gismeteo.ru/informers/constructor/#"));
    }

    @Test
    public void simpleInformerCheckTopLinks() {
        ArrayList<String> topLinksSet = new ArrayList<String>();
        topLinksSet.add("Простой информер");
        topLinksSet.add("Условия использования");
        WebElement topLinks = driver.findElement(InfoPageGismeteo.topLinksSelector);
        List<WebElement> topLinksNames = topLinks.findElements(new By.ByCssSelector(".subnav_item.nolink"));
        ArrayList<String> someStringList = new ArrayList<String>();
        for (WebElement elementName : topLinksNames) {
            someStringList.add(elementName.getText());
        }
        Assertions.assertEquals(someStringList.containsAll(topLinksSet), topLinksSet.containsAll(someStringList));
    }

    @Test
    public void checkForLanguagesClickable() {
        WebElement generalListOfLanguages = driver.findElement(InfoPageGismeteo.informersLanguageSelector);
        String locatorID = "languageLabel";
        int clickedTimes = 0;
        List<String> cityList = new ArrayList();
        for (int i = 1; i < 9; i++) {
            String secondLocator = locatorID + i;
            generalListOfLanguages.findElement(By.id(secondLocator)).click();
            clickedTimes++;
        }
        Assertions.assertTrue(clickedTimes == 8);
    }

    @Test
    public void checkForLanguages() {
        WebElement generalListOfLanguages = driver.findElement(InfoPageGismeteo.informersLanguageSelector);
        HashMap<String, String> LanguageCityMap = new HashMap<>() {{
            put("Русский", "Москва");
            put("Английский", "Moscow");
            put("Латышский", "Maskava");
            put("Литовский", "Maskva");
            put("Немецкий", "Moskau");
            put("Польский", "Moskwa");
            put("Румынский", "Moscova");
            put("Украинский", "Москва");
        }};
        String locatorID = "languageLabel";
        for (int i = 1; i < 9; i++) {
            String secondLocator = locatorID + i;
            String verifyString = generalListOfLanguages.findElement(By.id(secondLocator)).getText();
           Assertions.assertTrue(LanguageCityMap.containsKey(verifyString));
        }
    }
    @Test
    public void checkForLanguagesAndCities() {
        WebElement generalListOfLanguages = driver.findElement(InfoPageGismeteo.informersLanguageSelector);
        HashMap<String, String> LanguageCityMap = new HashMap<>() {{
            put("Русский", "Москва");
            put("Английский", "Moscow");
            put("Латышский", "Maskava");
            put("Литовский", "Maskva");
            put("Немецкий", "Moskau");
            put("Польский", "Moskwa");
            put("Румынский", "Moscova");
            put("Украинский", "Москва");
        }};
        String locatorID = "languageLabel";
        for (int i = 1; i < 9; i++) {
            String secondLocator = locatorID + i;
            generalListOfLanguages.findElement(By.id(secondLocator)).click();
            String verifyString = generalListOfLanguages.findElement(InfoPageGismeteo.cityNameSelector).getText();
            Assertions.assertTrue(LanguageCityMap.containsValue(verifyString));
        }
    }

    @Test
    public void verifyParameters(){

    }
}
