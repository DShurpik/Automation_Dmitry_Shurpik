package cucumberSteps.moodPanda;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.selenideMoodPanda.NavigationPage;

public class NavigationSteps extends SelenideBaseTest {


    @Given("open home page") // с этой аннотации начинаются тесты в cucumber, в скобках описание что делаем
    public void openHomePage() {
        get(NavigationPage.class);
    }

    @When("i click on menu item {string}") // в скобках аннотации пробрасываем string, оттуда в параметр метода
    public void clickOnMenuItem(String string) {
        get(NavigationPage.class).clickNavigationItem(string);
    }

    @Then("i check that uri {string}")
    public void checkPageUri(String uri) {
        get(NavigationPage.class).verifyPageUri(uri);
    }
}
