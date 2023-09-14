package org.MG.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Actions;

import java.util.Arrays;

public class SubscribePage {
    private WebDriver driver;

    // 2. Constructor of the page class:
    public SubscribePage(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private By countryDropdown = By.id("arrow");

    private By currentContryName = By.xpath("//span[@id='country-name']");
    private By subscriptionPackages = By.cssSelector(".subscription-package");
    private By packageType = By.cssSelector(".package-type");
    private By packagePrice = By.cssSelector(".package-price");
    private By packageCurrency = By.cssSelector(".package-currency");
    private By packageFeatures = By.cssSelector(".package-features");

    String[] packageTypes = new String[]{"lite", "classic", "premium"};

    public void selectCountry() {
        // select the provided country from the dropdown
        WebElement dropdown = driver.findElement(countryDropdown);
        dropdown.click();
    }

    public String checkCountry() {
        // check the provided country
        return driver.findElement(currentContryName).getText();
    }

    public String checkPackageTypes() {
        for (String type : packageTypes
        ) {
            driver.findElement(By.id("name-"+type)).getText();
        }
        return Arrays.toString(packageTypes);
    }

    public String GetCurrency() {
        String price = driver.findElement(By.id("currency-lite")).getText();
        return trimCurrencyFromPrice(price);
    }

    public static String trimCurrencyFromPrice(String price) {
        int spaceIndex = price.indexOf("/");
        String[] currency = price.substring(0, spaceIndex).split(" ", 2);
        return currency[1];
    }
}
