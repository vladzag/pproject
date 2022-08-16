package webpages.gismeteo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webpages.defaultData.DefaultPage;

public class NewsPageGismeteo extends DefaultPage {
    public NewsPageGismeteo(WebDriver driver) {
        super(driver);
    }

    public static final By linksList = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap");
    public static final By readAlsoElementSelector = new By.ByCssSelector("body > section > div.content-column.column1 > section.section.section-content.section-visible > div.articles-items.js-articles-items");


}