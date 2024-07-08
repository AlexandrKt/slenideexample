package com.selenideexample.steps;

import com.selenideexample.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;

public class SearchSteps {
    private HomePage homePage = new HomePage();

    @Given("I am on the Rozetka homepage")
    public void iAmOnTheRozetkaHomepage() {
        homePage.openHomePage();
    }

    @When("I enter {string} in the search bar")
    public void iEnterInTheSearchBar(String query) {
        homePage.enterSearchQuery(query);
    }

    @When("I click the search button")
    public void iClickTheSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("I should see search results for {string}")
    public void iShouldSeeSearchResultsFor(String query) {
        String resultsText = $x("//h1[contains(text(),'" + query + "')]").getText();
        Assert.assertTrue(resultsText.contains(query), "Expected to see search results containing: " + query);
    }

    @Then("I should see a message saying {string}")
    public void iShouldSeeAMessageSaying(String message) {
        String noResultsText = $x("//span[contains(text(),'" + message + "')]").getText();
        Assert.assertEquals(noResultsText, message, "Expected to see a message saying: " + message);
    }
}
