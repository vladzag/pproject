package webpages.gismeteo;

import org.openqa.selenium.By;

public class UXTests {
    public static final By watchLivePrecipitationSelector = new By.ByCssSelector("body > section.content.wrap > div.content-column.column1 > section:nth-child(1) > div.teaser-wrap");
    public static final By buttonPressPrecipitationsPlaySelector = new By.ByCssSelector("#js-btn-play-pause > svg.btn-play");
}
