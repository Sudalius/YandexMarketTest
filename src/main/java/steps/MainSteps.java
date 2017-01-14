package steps;

import com.codeborne.selenide.Selenide;
import pages.YandexPage;
import ru.yandex.qatools.allure.annotations.Step;


public class MainSteps extends BaseStep {

    YandexPage yandexPage = null;

    public MainSteps() {
        yandexPage = Selenide.page(YandexPage.class);
    }

    @Step("Open Yandex")
    public MainSteps openYandex() {
        super.yandexOpen();
        return this;
    }

    @Step("Choose market")
    public MainSteps clickMarket() {
        yandexPage.clickMarket();
        return this;
    }

    @Step("Choose electronic")
    public MainSteps chooseElectronic() {
        yandexPage.clickElectronic();
        return this;
    }

    @Step("Choose TV")
    public MainSteps chooseTV() {
        yandexPage.clickTv();
        return this;
    }

    @Step("Set price from")
    public MainSteps setPriceFrom(String price) {
        yandexPage.setPriceFrom(price);
        return this;
    }

    @Step("Check Samsing & LG")
    public MainSteps checkSamsungAndLg() {
        yandexPage.markSamsungAndLg();
        return this;
    }

    @Step("Click Apply button")
    public MainSteps clickApplyButton() {
        yandexPage.clickApplyButton();
        return this;
    }

    @Step("Check 12 elements on page")
    public MainSteps check12ElementsOnPage() {
        yandexPage.check12ElementsOnPage();
        return this;
    }

    @Step("Store first element")
    public MainSteps storeFirstElement() {
        yandexPage.storeFirstElement();
        return this;
    }

    @Step("Put first element to search field and assert it with search result")
    public MainSteps searchAndAssert() {
        yandexPage.searchAndAssert();
        return this;
    }
}