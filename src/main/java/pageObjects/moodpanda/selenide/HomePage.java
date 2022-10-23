package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

@Log4j

public class HomePage {

    private SelenideElement getStartedBtn = $(xpath("//a[@href='/login'][text()=' Get started']"));
    private SelenideElement signUpBtn = $(xpath("//a[@href='/signup'][text()=' Sign up']"));
    private SelenideElement loginBtn = $(xpath("//a[@href='/login'][text()='Login']"));
    private SelenideElement whatBtn = $(xpath("//a[text()=' What? ']"));
    private SelenideElement howBtn = $(xpath("//a[text()=' How? ']"));
    private SelenideElement aboutBtn = $(xpath("//a[text()=' About ']"));
    private SelenideElement contactUsBtn = $(xpath("//a[text()=' Contact us ']"));

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
