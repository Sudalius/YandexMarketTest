package com.sudyarov.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class YandexPage {

    // FIELDS

    @FindBy(linkText = "Маркет") SelenideElement market;
    @FindBy(linkText = "Электроника") SelenideElement electronic;
    @FindBy(linkText = "Телевизоры") SelenideElement tv;
    @FindBy(id = "glf-pricefrom-var") SelenideElement priceFromField;
    @FindBy(className = "n-filter-panel-aside__apply") SelenideElement applyButton;
    @FindBy(className = "checkbox__label") ElementsCollection checkBoxes;
    @FindBy(id = "header-search") SelenideElement searchField;
    @FindBy(className = "n-snippet-card2__title") ElementsCollection quantityOfElements;
    @FindBy(className = "n-title__text") SelenideElement searchResult;

    // METHODS

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
        checkBoxes.get(8).click();
        Selenide.sleep(1000);
        checkBoxes.get(11).click();
    }

    public void clickApplyButton(){
        applyButton.shouldBe(Condition.appear).click();
        Selenide.sleep(3000);
    }

    public void check12ElementsOnPage() {
        Assert.assertEquals(quantityOfElements.size(), 12);
    }

    public String storeFirstElement() {
        return quantityOfElements.get(0).getText();
    }

    public void searchAndAssert()  {

        String firstFoundElement = storeFirstElement();

        searchField.setValue(firstFoundElement);
        searchField.sendKeys(Keys.ENTER);

        Selenide.sleep(2000);
        Assert.assertEquals(searchResult.getText(), firstFoundElement);

        System.out.println("Element in memory is equals to: " + firstFoundElement);
        System.out.println("Element in search result is equals to: " + searchResult);
    }
}