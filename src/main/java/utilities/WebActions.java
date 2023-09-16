package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebActions {

    public WebActions(WebDriver driver) {
            this.driver = driver;
        }

    public WebDriver driver;
    public static WebDriverWait wait;
    private WebElement element;
    private List<WebElement> elements;


    /**
     * Find Element
     *
     * @param locator ex. by.xpath , by.id , by.name , etc...
     * @return Element
     */
    public WebActions findElementAndReturn(By locator) {

            element = driver.findElement(locator);
        return this;
    }

    /**
     * Find List of Elements
     *
     * @param locator
     * @return
     */
    public WebActions findListOfElements(By locator) {

            elements = driver.findElements(locator);
        return this;
    }

    /**
     * Send keys to a text field
     *
     * @param text String or Text
     * @param element element type Text
     * @param durationInSecond time to wait
     * @param typeOfWait type of the wait either "visible" or "clickable"
     */
    public void typeIntoElement(WebElement element,String text, long durationInSecond, String typeOfWait) {
        WebElement webElement = waitForElement(element,durationInSecond,typeOfWait);
        webElement.click();
        webElement.sendKeys(text);
    }

    /**
     * Handle type of waits either visible or clickable
     *
     * @param element    element to wait for
     * @param typeOfWait type of the wait either "visible" or "clickable"
     * @param durationInSecond time to wait
     */
    public WebElement waitForElement(WebElement element, long durationInSecond,String typeOfWait) {

        WebElement webElement = null;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSecond));
        try {
            switch (typeOfWait) {
                case "visible" -> webElement = wait.until(ExpectedConditions.visibilityOf(element));
                case "clickable" -> webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return webElement;
    }

    /**
     * Handle click on element after Condition ToBeClickable
     *
     * @param element to click
     * @param durationInSecond time to wait
     * @param typeOfWait type of the wait either "visible" or "clickable"
     */
    public void clickOnElement(WebElement element, long durationInSecond, String typeOfWait) {
        WebElement webElement = waitForElement(element,durationInSecond,typeOfWait);
        webElement.click();
    }

    /**
     * Handle click on element after Condition ToBeClickable
     *
     * @param element to click
     * @param visibleText to select
     * @param durationInSecond time to wait
     * @param typeOfWait type of the wait either "visible" or "clickable"
     */
    public void selectFromDropdoenMenu(WebElement element,String visibleText, long durationInSecond, String typeOfWait) {
        WebElement webElement = waitForElement(element,durationInSecond,typeOfWait);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Wait for Alert is Present
     *@param durationInSecond time to wait
     *
     * @return alert
     */
    public Alert waitForAlert(long durationInSecond) {
        Alert alert = null;
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSecond));
        try {
            alert = wait.until(ExpectedConditions.alertIsPresent());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return alert;
    }

    /**
     * Accept Alert
     *@param durationInSecond time to wait
     *
     */
    public void acceptAlert(long durationInSecond) {
        Alert alert = waitForAlert(durationInSecond);
        alert.accept();
    }

    /**
     * Dismiss Alert
     *@param durationInSecond time to wait
     *
     */
    public void dismissAlert(long durationInSecond) {
        Alert alert = waitForAlert(durationInSecond);
        alert.dismiss();
    }

    /**
     * Handle Hover on element and click
     *
     * @param element to click
     * @param durationInSecond time to wait
     * @param typeOfWait type of the wait either "visible" or "clickable"
     */
    public void mouseHoverAndClick(WebElement element, long durationInSecond, String typeOfWait) {
        WebElement webElement = waitForElement(element,durationInSecond,typeOfWait);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
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

    /**
     * Handle click on element after Condition ToBeClickable
     *
     * @param element that return the text
     * @param durationInSecond time to wait
     * @param typeOfWait type of the wait either "visible" or "clickable"
     * @return
     */
    public String getTextFromElement(WebElement element, long durationInSecond, String typeOfWait) {
        WebElement webElement = waitForElement(element,durationInSecond,typeOfWait);
        return webElement.getText();
    }

}
