package webpages.defaultData;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.ConfiguresAndConstants.AWAIT_FOR_VISIBLE_ELEMENT;

public class DefaultPage {
    protected WebDriver driver;

    public DefaultPage(WebDriver driver) {

        this.driver = driver;
    }

    public void openWebPages(String url) {

        driver.get(url);
    }

    public WebElement awaitForVisibleElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(AWAIT_FOR_VISIBLE_ELEMENT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}