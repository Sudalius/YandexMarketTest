package com.sudyarov.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class YandexPage {
    @FindBy(xpath = "//span[contains(@class,'_3z8GfB4w3a')and text()='Компьютеры']")
    private WebElement computers;
    @FindBy(xpath = "//*[@href='/catalog--noutbuki/54544/list?hid=91013']")
    private WebElement laptops;
    @FindBy(xpath = "//*[@data-range-input-type='from']//*[@id='glpricefrom']")
    private WebElement priceFromField;
    @FindBy(xpath = "//*[@data-autotest-id='7893318']//*[@for='7893318_153043']")
    private WebElement appleCheckbox;
    @FindBy(xpath = "//*[@data-autotest-id='7893318']//*[@for='7893318_704572']")
    private WebElement microsoftCheckbox;
    @FindBy(id = "header-search")
    private WebElement searchField;
    @FindBy(xpath = "//*[@data-zone-name='title']")
    private List<WebElement> quantityOfTitleElements;

    public void clickComputers() {
        computers.click();
    }

    public void clickLaptops() {
        laptops.click();
    }

    public void setPriceFrom(String price) {
        priceFromField.sendKeys(price);
    }

    public void markAppleAndMicrosoft(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(appleCheckbox)).click();
        microsoftCheckbox.click();
    }

    public void checkFoundedTitlesQuantity(int expectedQuantity) {
        Assert.assertEquals(quantityOfTitleElements.size(), expectedQuantity);
    }

    public String storeFirstElement() {
        return quantityOfTitleElements.get(0).getText();
    }

    public void searchAndAssert(WebDriver driver) {
        driver.navigate().refresh();
        String firstFoundElement = storeFirstElement();
        searchField.sendKeys(firstFoundElement);
        searchField.sendKeys(Keys.ENTER);
        try {
            Assert.assertTrue(quantityOfTitleElements.get(0).getText().contains(firstFoundElement));
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            Assert.assertTrue(quantityOfTitleElements.get(0).getText().contains(firstFoundElement));
        }
    }
}
