package com.sudyarov.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class YandexPage {

    @FindBy(linkText = "Маркет") private SelenideElement market;
    @FindBy(linkText = "Электроника") private SelenideElement electronic;
    @FindBy(linkText = "Телевизоры") private SelenideElement tv;
    @FindBy(id = "glpricefrom") private WebElement priceFromField;
    @FindBy(xpath = "//span[@data-reactid = '129']") private SelenideElement samsung;
    @FindBy(xpath = "//span[@data-reactid = '101']")  private SelenideElement LG;
    @FindBy(id = "header-search") private SelenideElement searchField;
    @FindBy(className = "n-snippet-card2__title") private ElementsCollection quantityOfElements;
    @FindBy(className = "n-title__text") private SelenideElement searchResult;

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
        priceFromField.sendKeys(price);
    }

    public void markSamsungAndLg() {
        LG.scrollTo();
        samsung.click();
        LG.click();
    }

    public void check48ElementsOnPage() {
        Assert.assertEquals(quantityOfElements.size(), 48);
    }

    public String storeFirstElement() {
        return quantityOfElements.get(0).getText();
    }

    public void searchAndAssert()  {

        String firstFoundElement = storeFirstElement();

        searchField.setValue(firstFoundElement);
        searchField.sendKeys(Keys.ENTER);

        Selenide.sleep(2000);
        Assert.assertTrue(searchResult.getText().contains(firstFoundElement));

        System.out.println("Element in memory is equals to: " + firstFoundElement);
        System.out.println("Element in search result is equals to: " + searchResult);
    }
}