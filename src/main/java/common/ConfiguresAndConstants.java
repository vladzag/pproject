package common;

public class ConfiguresAndConstants {

    public static final Integer IMPLICITLY_WAIT_TIME = 20;
    public static final Integer AWAIT_FOR_VISIBLE_ELEMENT = 10;

    public static String osAndBrowser = "mac_chrome";

    public static String defaultURL = "https://www.gismeteo.ru/";

    public static class City {
        private String cityName = null;
        private Integer cityID = null;

        public String cityRadar(String cityName, Integer cityID) {
            return ConfiguresAndConstants.defaultURL + "nowcast-" + cityName + "-" + cityID + "/";
        }

        public String cityDairy(Integer cityID) {
            return ConfiguresAndConstants.defaultURL + "diary/" + cityID + "/";
        }

        public City(String cityName, Integer cityID) {
            this.cityName = cityName;
            this.cityID = cityID;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public Integer getCityID() {
            return cityID;
        }

        public void setCityID(Integer cityID) {
            this.cityID = cityID;
        }
    }

    public static String getOsAndBrowser() {
        return osAndBrowser;
    }

    public static void setOsAndBrowser(String osAndBrowser) {
        ConfiguresAndConstants.osAndBrowser = osAndBrowser;
    }

}