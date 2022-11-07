package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

@Log4j

public class HomePage {

    private SelenideElement getStartedBtn =$(linkText("Get started. It's free."));
    private SelenideElement signUpBtn = $(linkText("Sign up"));
    private SelenideElement loginBtn = $(linkText("Login"));
    private SelenideElement whatBtn = $(linkText("What?"));
    private SelenideElement howBtn = $(linkText("How?"));
    private SelenideElement aboutBtn = $(linkText("About"));
    private SelenideElement contactUsBtn = $(linkText("Contact us"));

    public HomePage clickGetStartedBtn(){
        log.debug("click on" + getStartedBtn);
        getStartedBtn.click();
        return this;
    }

    public HomePage clickSignUpBtn(){
        log.debug("click on" + signUpBtn);
        signUpBtn.click();
        return this;
    }

    public HomePage clickLoginBtn(){
        log.debug("click on" + loginBtn);
        loginBtn.click();
        return this;
    }

    public HomePage clickWhatBtn(){
        log.debug("Click on " + whatBtn);
        whatBtn.should(enabled).click();
        return this;
    }
}
