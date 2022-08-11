package common;

public class ConfiguresAndConstants {

    public static final Integer IMPLICITLY_WAIT_TIME = 20;
    public static final Integer AWAIT_FOR_VISIBLE_ELEMENT = 10;

    public static String osAndBrowser = "mac_chrome";

    public static String url = "https://www.gismeteo.ru/";

    public static String getOsAndBrowser() {
        return osAndBrowser;
    }

    public static void setOsAndBrowser(String osAndBrowser) {
        ConfiguresAndConstants.osAndBrowser = osAndBrowser;
    }

}
