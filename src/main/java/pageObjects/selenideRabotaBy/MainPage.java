package pageObjects.selenideRabotaBy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class MainPage {

    private SelenideElement searchField = $(xpath("//input[@data-qa='search-input']"));
    private SelenideElement searchBtn = $(xpath("//button[@data-qa='search-button']"));

    private SelenideElement titleOfWork = $(xpath("//h1"));
    private SelenideElement resultSearchField = $(xpath("//span[@data-qa='vacancies-total-found']//span[contains(text(),' вакансии')]"));

    public MainPage enter(String string){
        searchField.sendKeys(string);
        return this;
    }

    public MainPage clickSearchBtn(){
        searchBtn.click();
        return this;
    }

    public MainPage resultSearchJob(String string){
        titleOfWork.shouldHave(text(string));
        return this;
    }

    public MainPage resultSearch(String string){
        resultSearchField.getText();
        return this;
    }

    public MainPage equal(String string){
        resultSearchField.shouldHave(text(string));
        return this;
    }

}
