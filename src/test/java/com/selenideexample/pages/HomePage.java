package com.selenideexample.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import com.selenideexample.commonconfigurations.ConfigManager;

public class HomePage extends BasePage{
    private SelenideElement searchInput = $("[name='search']");
    private SelenideElement searchButton = $x("//button[contains(@class, 'search-form__submit')]");
    public void openHomePage() {
        open(ConfigManager.getInstance().getProperty("base.url"));
    }

    public HomePage searchForProduct(String productName) {
        $("[name='search']").setValue(productName).pressEnter();
        return this;
    }

    public void enterSearchQuery(String query) {
        searchInput.setValue(query);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
