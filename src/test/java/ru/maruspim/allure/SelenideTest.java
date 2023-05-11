package ru.maruspim.allure;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    public void testIssueSearch(){

        open("https://github.com/");
        $(".search-input-container");
    }
}

