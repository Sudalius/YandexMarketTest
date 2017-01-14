package steps;

import com.codeborne.selenide.Selenide;

public class BaseStep {

    public void yandexOpen(){
        Selenide.open("http://www.yandex.ru");
    }
}