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

}
