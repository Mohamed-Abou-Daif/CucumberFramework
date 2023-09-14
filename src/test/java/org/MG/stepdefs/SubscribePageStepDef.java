package org.MG.stepdefs;

import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
import org.MG.pages.SubscribePage;
import org.testng.Assert;
import utilities.DriverFactory;


public class SubscribePageStepDef {

    private SubscribePage subscribePage = new SubscribePage(DriverFactory.getDriver());

    @Given("user navigate to the stc tv website {string}")
    public void navigateToSubscribePage(String url) {
        // navigate to the stc tv website
        DriverFactory.getDriver().get("https://subscribe.stctv.com/"+url+"-en");
    }

    @When("user on the selected {string}")
    public void selectCountry()  {
        subscribePage.selectCountry();
    }

    @Then("I should see the subscription packages")
    public void verifySubscriptionPage() {
        Assert.assertEquals(subscribePage.checkPackageTypes(),"[lite, classic, premium]");
    }

    @Then("I should see the features included in each package")
    public void verifyPackageFeatures() {

        }

    @When("user loaded successfully to {string} page")
    public void userLoadedSuccessfullyToPage(String Country) {
        Assert.assertEquals(subscribePage.checkCountry(), Country);
    }
}