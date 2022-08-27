package webpages.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webpages.defaultData.DefaultPage;

public class InfoPageGismeteo extends DefaultPage {
    public InfoPageGismeteo(WebDriver driver) {
        super(driver);
    }

    public static final By topLinksSelector = new By.ByCssSelector("body > section > nav > div");
    public static final By scrollerTableSelector = new By.ByClassName("b-j-scroller__table");
    public static final By offerConditionsSelector = new By.ByPartialLinkText("Условия использования");
    public static final By firstListSetForAllSitesSelector = new By.ByCssSelector("body > section > div:nth-child(4) > div > div > div > table > tbody > tr:nth-child(1)");
    public static final By secondListSetForAllSitesSelector = new By.ByCssSelector("body > section > div:nth-child(4) > div > div > div > table > tbody > tr:nth-child(2)");
    public static final By setForAnySiteLastSelector = new By.ByCssSelector(".iconLine.last");

    public static final By simpleInformersHeaderSelector = new By.ByCssSelector("body > section > div > div > div > div");


}
