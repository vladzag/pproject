package webpages.gismeteo;

import org.openqa.selenium.By;

public class UXTests {
    public static final By watchLivePrecipitationSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(1) > div.teaser-wrap");
    public static final By buttonPressPrecipitationsPlaySelector = new By.ByCssSelector("#js-btn-play-pause");
    public static final By clickWeatherNowInMoscowSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.subnav > div > a:nth-child(1)");
    public static final By searchForStPetSelector = new By.ByCssSelector("body > header > div.header-subnav > div.header-container.wrap > div > div.search.js-search > div.search-form.js-search-form > div > input");
}