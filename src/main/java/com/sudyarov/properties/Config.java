package com.sudyarov.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public Config() throws FileNotFoundException {
    }

    InputStream inputStream = new FileInputStream("config.properties");
    Properties prop = new Properties();

    public String loadTvPrice(String priceFrom) throws IOException {
        prop.load(inputStream);
        return prop.getProperty(priceFrom);
    }
}