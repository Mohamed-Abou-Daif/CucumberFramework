package org.MG.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.CommonUtils;
import utilities.WebActions;

public class SubscribePage {
    private WebDriver driver;

    private WebActions webActions;
    // 2. Constructor of the page class:
    public SubscribePage(WebDriver driver) {
        webActions = new WebActions(driver);
        this.driver = driver;
    }
    // Locators
    private By countryDropdown = By.id("arrow");
//    WebElement dropdown = driver.findElement(countryDropdown);
    private By currentContryName = By.xpath("//span[@id='country-name']");
//    WebElement contryName = driver.findElement(currentContryName);

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
        webActions.clickOnElement(dropdown,CommonUtils.Explicit_WAIT_TIME,"clickable");
    }

    public String checkCountry() {
        // check the provided country
//        return driver.findElement(currentContryName).getText();
        WebElement contryName = driver.findElement(currentContryName);
        return webActions.getTextFromElement(contryName,CommonUtils.Explicit_WAIT_TIME,"visible");
    }


    public String checkPackageTypes(String  type) {

        WebElement packageType = driver.findElement(By.id("name-"+type));
        return webActions.getTextFromElement(packageType,CommonUtils.Explicit_WAIT_TIME,"visible").toLowerCase();
    }

    public String checkPrice(String  type) {

        WebElement price = driver.findElement(By.id("currency-"+type));
        return webActions.getTextFromElement(price,CommonUtils.Explicit_WAIT_TIME,"visible");
    }

    public String GetCurrency(String  type) {

        WebElement price = driver.findElement(By.id("currency-"+type));
        return trimCurrencyFromPrice(webActions.getTextFromElement(price, CommonUtils.Explicit_WAIT_TIME,"visible"));
    }

    public static String trimCurrencyFromPrice(String price) {
        int spaceIndex = price.indexOf("/");
        String[] currency = price.substring(0, spaceIndex).split(" ", 2);
        return currency[1];
    }
}
