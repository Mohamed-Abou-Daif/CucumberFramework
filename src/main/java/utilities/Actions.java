package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Actions {

    public Actions(WebDriver driver) {
            this.driver = driver;
        }

    public static WebDriver driver;
    public static WebDriverWait wait;
    private WebElement element;
    private List<WebElement> elements;


    /**
     * Find Element
     *
     * @param locator ex. by.xpath , by.id , by.name , etc...
     * @return Element
     */
    public Actions findElementAndReturn(By locator) {

            element = driver.findElement(locator);
        return this;
    }

    /**
     * Find List of Elements
     *
     * @param locator
     * @return
     */
    public Actions findListOfElements(By locator) {

            elements = driver.findElements(locator);
        return this;
    }

    /**
     * Send keys to a text field
     *
     * @param text String or keyword to search for
     * @return Element
     */
    public Actions sendKeysToElement(String text) {

            element.sendKeys(text);
        return this;
    }

    /**
     * Handle type of waits either visible or clickable
     *
     * @param locator    locator of element to wait for
     * @param typeOfWait type of the wait either "visible" or "clickable"
     */
    /*public UiActions waitForElement(By locator, String typeOfWait) {

        try {
            wait = new WebDriverWait(driver, 5);
            switch (typeOfWait) {
                case "visible":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                    break;
                case "clickable":
                    wait.until(ExpectedConditions.elementToBeClickable(locator));
                    break;
            }
        } catch (ElementNotInteractableException e) {
            HandleExceptions.ElementNotInteractableExceptionHandling(e);
        } catch (TimeoutException e) {
            HandleExceptions.TimeoutExceptionHandling(e);
        }
        return this;
    }*/

    /**
     * Handle type of actions performed on an element
     *
     * @param action takes type of action either "click" or "submit"
     */
    public void takeActionOnElement(String action) {

        switch (action) {
            case "click" -> element.click();
            case "submit" -> element.submit();
        }

    }

    /**
     * Get Size for list of elements have the same path
     *
     * @return elements size
     */
    public int getSizeOfElements() {
        return elements.size();
    }

    /**
     * Handle scroll Down action on the browser
     */
    public void scrollDownToBottom() {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollTo(0,700);");
    }

    public static String getTextFromElement(By Locator) {
        return driver.findElement(Locator).getText();
    }

}
