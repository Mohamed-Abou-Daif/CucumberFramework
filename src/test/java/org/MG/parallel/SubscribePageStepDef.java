package org.MG.parallel;

import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
import org.MG.pages.SubscribePage;
import org.testng.Assert;
import utilities.DriverFactory;


public class SubscribePageStepDef {

    private SubscribePage subscribePage = new SubscribePage(DriverFactory.getDriver());

    @Given("user navigate to the stc tv website {string}")
    public void navigateToSubscribePage(String Country) {
        // navigate to the stc tv website
       subscribePage.navigateToURL(Country);
    }

    @When("user on the selected {string}")
    public void selectCountry()  {
        subscribePage.selectCountry();
    }

    @Then("I should see the subscription {string}")
    public void verifySubscriptionPage(String packageType) {
        Assert.assertEquals(subscribePage.checkPackageTypes(packageType),packageType);
    }

    @Then("I should see the features included in each package")
    public void verifyPackageFeatures() {

        }

    @When("user loaded successfully to {string} page")
    public void userLoadedSuccessfullyToPage(String Country) {
        Assert.assertEquals(subscribePage.checkCountry(), Country);
    }

    @Then("verify Price List")
    public void verifyPriceList() {
//        subscribePage.checkPrice();
    }

    @Then("I should see the subscription {string}, {string} and {string}")
    public void iShouldSeeTheSubscriptionPackageTypePriceAndCurrency(String packageType, String Price, String currency) {
        Assert.assertEquals(subscribePage.checkPackageTypes(packageType),packageType);
        Assert.assertEquals(subscribePage.checkPrice(packageType),Price);
        Assert.assertEquals(subscribePage.GetCurrency(packageType),currency);

    }
}