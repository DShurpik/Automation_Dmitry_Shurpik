package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.openqa.selenium.By.xpath;

@Log4j

public class LoginPage {
    private SelenideElement emailField = $(xpath("//input[@placeholder]"));
    private SelenideElement passwordField = $(xpath("//input[@type='password']"));
    private SelenideElement loginBtn = $(xpath("//button"));
    private SelenideElement logOutBtn = $(xpath("//a[contains(text(),'Logout')]"));
    private SelenideElement title = $(xpath("//div[@class='hero has-navbar-spacer is-hidden-touch is-dark is-small']"));
    private SelenideElement yourDiaryBtn = $(xpath("//a[text()=' Your diary ']"));

    public LoginPage enterEmail(String firstName){
        log.debug("Enter: " + firstName);
        this.emailField.sendKeys(firstName);
        return this;
    }

    public LoginPage enterPassword(String password){
        log.debug("Enter: " + password);
        this.passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn(){
        log.debug("Click on: " + loginBtn);
        loginBtn.click();
        return this;
    }

   public LoginPage titleIsEnabled(){
        log.debug("Title in main page is enabled");
        title.should(enabled).isEnabled();
        return this;
   }

    public LoginPage verifyPageUri(String uri) {
        log.debug("Uri: " + uri + " equal expected result");
        webdriver().shouldHave(urlContaining(uri));
        return this;
    }

   public LoginPage clickYourDiaryBtn(){
        log.debug("Click on " + yourDiaryBtn);
        yourDiaryBtn.should(enabled).click();
        return this;
   }
}
