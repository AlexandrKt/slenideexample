package com.selenideexample.pages;
import com.codeborne.selenide.Selenide;

public abstract class BasePage {
    public void open(String url) {
        Selenide.open(url);
    }
}
