package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static common.ConfiguresAndConstants.IMPLICITLY_WAIT_TIME;
import static common.ConfiguresAndConstants.osAndBrowser;

public class CommonActivities {

    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch (osAndBrowser) {
            case "mac_chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/vlad.zag/IdeaProjects/pproject/src/main/resources/chromedriver");
                driver = new ChromeDriver();
                break;
            default:
                // Assertions.fail(osAndBrowser + " is an incorrect combination of OS and browser.");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_TIME));
        return driver;

    }
}