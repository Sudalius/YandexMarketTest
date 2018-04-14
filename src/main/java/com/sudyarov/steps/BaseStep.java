package com.sudyarov.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BaseStep {

    BaseStep() throws IOException {}

    private Properties props = loadProperties();

    void yandexOpen(){
        Selenide.open(props.getProperty("baseURL"));
    }

    public static void beforeTest(String driverName) {
        Configuration.timeout = 6000;
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
        Configuration.browser = driverName;
    }

    public static Properties loadProperties() throws IOException {
        Properties props = new Properties();
        URL url = ClassLoader.getSystemResource("config.properties");
        props.load(url.openStream());

        return props;
    }
}