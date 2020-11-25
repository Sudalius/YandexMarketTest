package com.sudyarov.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class BaseStep {

    public static WebDriver driver = new ChromeDriver();

    public static Properties loadProperties() throws IOException {
        Properties props = new Properties();
        URL url = ClassLoader.getSystemResource("config.properties");
        props.load(url.openStream());
        return props;
    }
}
