package ru.maruspim.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class AllureReportsTest extends TestBase {
    private static final String URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Feature("Checking Issues Tab in Repository")
    @Owner("Mary Pimenova")
    @Test
    @DisplayName("Basic test with allure+selenide integration")
    public void testIssueSearchWithListener(){


        open(URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);

    }

    @Feature("Checking Issues Tab in Repository")
    @Owner("Mary Pimenova")
    @Test
    @DisplayName("Test with lambda functions and steps")
    public void testLambdaStep(){


        step("Opening the main page: " + URL, () -> {
            open(URL);
        });
        step("Searching for the repository: " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Clicking on the repository link: " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Opening the tab Issues", () -> {
            $("#issues-tab").click();
        });
        step("Checking for the Issue with number " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });

    }
    @Feature("Checking Issues Tab in Repository")
    @Owner("Mary Pimenova")
    @Test
    @DisplayName("Test with annotated steps")
    public void testAnnotatedSteps(){

        WebSteps steps = new WebSteps();
        steps.openMainPage(URL);
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink( REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);
    }
}

