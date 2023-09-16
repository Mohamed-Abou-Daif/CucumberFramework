package org.MG.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Actions;
import utilities.DriverFactory;

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
    String[] priceList = new String[]{"15 SAR/month","15 SAR/month","15 SAR/month"};

    public void navigateToURL(String country){

        switch (country) {
            case "KSA" -> driver.navigate().to("https://subscribe.stctv.com/sa-en");
            case "Bahrain" -> driver.navigate().to("https://subscribe.stctv.com/bh-en");
            case "Kuwait" -> driver.navigate().to("https://subscribe.stctv.com/kw-en");
            default -> System.out.println("Can not reach to the navigation url");
        }
    }
    public void selectCountry() {
        // select the provided country from the dropdown
        WebElement dropdown = driver.findElement(countryDropdown);
        dropdown.click();
    }

    public String checkCountry() {
        // check the provided country
        return driver.findElement(currentContryName).getText();
    }

    public String checkPackageTypes(String  type) {

       return driver.findElement(By.id("name-"+type)).getText().toLowerCase();
    }

    public String checkPrice(String  type) {

        return driver.findElement(By.id("currency-"+type)).getText();
    }

    public String GetCurrency(String  type) {

        return trimCurrencyFromPrice(driver.findElement(By.id("currency-"+type)).getText());
    }

    public static String trimCurrencyFromPrice(String price) {
        int spaceIndex = price.indexOf("/");
        String[] currency = price.substring(0, spaceIndex).split(" ", 2);
        return currency[1];
    }
}
