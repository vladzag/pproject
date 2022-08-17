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
    public static final By explainingRFTabSelector = new By.ByCssSelector("body > section > div.content-column.column2 > div > section:nth-child(1) > div.feed.feed-partner");
public static final By twentyFourSMITabSelector = new By.ByCssSelector("body > section > div.content-column.column2 > div > section:nth-child(2) > div.feed.feed-partner");
public static final By moscowTwentyFourTabSelector = new By.ByCssSelector("body > section > div.content-column.column3 > div > section.section.section-rss > div.feed.feed-partner");

public static final By firstColumnTabSelector = new By.ByCssSelector("body > section > div.content-column.column1 > section.section.section-content.section-visible > div.articles-items.js-articles-items");
}