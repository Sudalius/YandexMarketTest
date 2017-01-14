package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class YandexPage {

    @FindBy(linkText = "Маркет")SelenideElement market;
    @FindBy(linkText = "Электроника")SelenideElement electronic;
    @FindBy(linkText = "Телевизоры")SelenideElement tv;
    @FindBy(id = "glf-pricefrom-var") SelenideElement priceFromField;
    @FindBy(className = "n-filter-panel-aside__apply") SelenideElement applyButton;
    @FindBy(className = "checkbox__label") ElementsCollection checkBoxes;
    @FindBy(id = "header-search") SelenideElement searchField;

    public void clickMarket() {
        market.shouldBe(Condition.appear).click();
    }

    public void clickElectronic() {
        electronic.shouldBe(Condition.appear).click();
    }

    public void clickTv() {
        tv.shouldBe(Condition.appear).click();
    }

    public void setPriceFrom(String price) {
        priceFromField.setValue(price);
    }

    public void markSamsungAndLg() {
        checkBoxes.get(5).click();
        Selenide.sleep(1000);
        checkBoxes.get(9).click();
    }

    public void clickApplyButton(){
        applyButton.shouldBe(Condition.appear).click();
        Selenide.sleep(3000);
    }

    public void check12ElementsOnPage() {
        int quantity = $$(By.className("snippet-card__header-text")).size();
        org.testng.Assert.assertEquals(quantity, 12);
    }

    public String storeFirstElement() {
        String firstFoundElement = $$(By.className("snippet-card__header-text")).get(0).getText();
        return firstFoundElement;
    }

    public void searchAndAssert()  {
        String firstFoundElement = storeFirstElement();
        searchField.setValue(firstFoundElement);
        searchField.sendKeys(Keys.ENTER);
        Selenide.sleep(2000);
        String searchResult = $(By.cssSelector(".n-product-title > h1:nth-child(1)")).getText();
        org.testng.Assert.assertEquals(searchResult, firstFoundElement);

        System.out.println("Element in memory is equals to: " + firstFoundElement);
        System.out.println("Element in search result is equals to: " + searchResult);
    }
}