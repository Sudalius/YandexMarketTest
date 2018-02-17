package com.sudyarov.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class BaseStep {

    void yandexOpen(){
        Selenide.open("http://www.yandex.ru");
    }

    public static void beforeTest() {
        Configuration.timeout = 6000;
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        Configuration.browser = "chrome";
    }
}