package cucumberSteps.rabotaBy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.selenideRabotaBy.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

@Log4j

public class MainSteps extends SelenideBaseTest {

    SelenideElement changeCityBtn = $(xpath("//span[text()='Выбрать другой']"));

    public SelenideElement getNavigationLink(String linkText) {
        return $(By.xpath("//div[@class='area-switcher-column']//li//a[text()='" + linkText + "']"));
    }

    @Given("open main page")
    public void openHomePage() {
        log.debug("Driver open " + Configuration.baseUrl);
        get(MainPage.class);
    }

    @When("i wait subscribe city")
    public void changeCity(){
        changeCityBtn.should(Condition.exist).click();
    }

    @When("i change city {string}")
    public void changeCity(String string){
        log.debug("Driver change city " + string);
        getNavigationLink(string).click();
    }


    @When("i send on search field name job {string}")
    public void enter(String string){
        log.debug("Driver send in search field " + string);
        get(MainPage.class).enter(string);
    }

    @And("i click on search button")
    public void click(){
        log.debug("Driver click on Search button");
        get(MainPage.class).clickSearchBtn();
    }

    @And("i check on title have name {string} of jobs")
    public void check(String string){
        log.debug("On title is name of job " + string);
        get(MainPage.class).resultSearchJob(string);
    }

    @Then("i equal count of work {string} on result and count of work {string} from feature file")
    public void checkCountOfWork(String string1, String string2){
        log.debug("Driver get actual result " + string1 + " and equal with expected result " + string2);
        get(MainPage.class).resultSearch(string1).equal(string2);
    }

}
