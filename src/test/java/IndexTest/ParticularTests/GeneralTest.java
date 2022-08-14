package IndexTest.ParticularTests;

import IndexTest.DefaultPageTest;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class GeneralTest extends DefaultPageTest {
    String defaultURL = "https://www.gismeteo.ru";

    @ParameterizedTest
    @ValueSource(strings = {"https://www.gismeteo.ru/", "https://www.gismeteo.ru/weather-syzran-4448/", "https://www.gismeteo.ru/news/", "https://www.gismeteo.ru/maps/", "https://www.gismeteo.ru/informers/", "https://www.gismeteo.ru/soft/"})
    public void Error400Test(String pageWeb) throws InterruptedException {
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        Thread.sleep(2500);
        driver.get(pageWeb);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            System.out.println(url);
            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
           /*if (!url.startsWith(pageWeb)) {
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }*/
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }

    @Test
    public void replaceYandexCookie() {
        defaultPage.openWebPages(defaultURL);
        Cookie cookieTest = new Cookie("yuidss", "8"); //original value = 1914338451625754248
        driver.manage().addCookie(cookieTest);
        driver.quit();
    }

    @Test
    public void deleteAllCookiesLoadingTime() {
        long startWithCookies = System.currentTimeMillis();
        defaultPage.openWebPages(defaultURL);
        long finishWithCookies = System.currentTimeMillis();
        long totalTimeWithCookies = finishWithCookies - startWithCookies;
        driver.manage().deleteAllCookies();
        long startWithoutCookies = System.currentTimeMillis();
        driver.navigate().refresh();
        long finishWithoutCookies = System.currentTimeMillis();
        long totalTimeWithoutCookies = finishWithoutCookies - startWithoutCookies;
        System.out.println(totalTimeWithCookies - totalTimeWithoutCookies + " миллисекунд разница между загрузкой с куками и без");
        driver.quit();
    }
}
