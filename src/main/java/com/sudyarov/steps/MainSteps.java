package com.sudyarov.steps;


import com.sudyarov.pages.YandexPage;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseStep{

    private YandexPage yandexPage;

    public MainSteps() {
        yandexPage = PageFactory.initElements(driver, YandexPage.class);
        driver.manage().window().maximize();
    }

    @Step("Open Yandex market")
    public MainSteps openYandexMarket(String url) {
        driver.get(url);
        return this;
    }

    @Step("Choose computers")
    public MainSteps chooseComputers() {
        yandexPage.clickComputers();
        return this;
    }

    @Step("Choose Laptops")
    public MainSteps chooseLaptops() {
        yandexPage.clickLaptops();
        return this;
    }

    @Step("Set price from")
    public MainSteps setPriceFrom(String price) {
        yandexPage.setPriceFrom(price);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Check Apple and Microsoft")
    public MainSteps markAppleAndMicrosoft() {
        yandexPage.markAppleAndMicrosoft(driver);
        return this;
    }

    @Step("Check founded titles quantity on page")
    public MainSteps checkFoundedTitlesQuantityOnPage(int expectedQuantity) {
        yandexPage.checkFoundedTitlesQuantity(expectedQuantity);
        return this;
    }

    @Step("Store first element")
    public MainSteps storeFirstElement() {
        yandexPage.storeFirstElement();
        return this;
    }

    @Step("Put first element to the search field and check it availability in search result")
    public MainSteps putElementAndCheckSearchResult() {
        yandexPage.searchAndAssert(driver);
        return this;
    }
}
