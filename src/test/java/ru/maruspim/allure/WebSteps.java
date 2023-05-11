package ru.maruspim.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Opening the main page: ")
    public void openMainPage(){

        open("/");
    }
    @Step("Searching for the repository: {repository}")
    public void searchForRepository(String repository) {

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }
    @Step("Clicking on the repository link: {repository}")
    public void clickOnRepositoryLink (String repository) {
        $(linkText(repository)).click();
    }
    @Step("Opening the tab Issues")
    public void openIssuesTab () {
        $("#issues-tab").click();
    }
    @Step("Checking for the Issue with number {issue}")
    public void shouldSeeIssueWithNumber (int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}
