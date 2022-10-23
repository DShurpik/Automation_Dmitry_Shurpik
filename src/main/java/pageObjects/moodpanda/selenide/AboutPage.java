package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

@Log4j

public class AboutPage {

    private SelenideElement title = $(xpath("//p[text()='About MoodPanda']"));
    private SelenideElement whatBtn = $(xpath("//a[text()=' What? ']"));
    private SelenideElement howBtn = $(xpath("//a[text()=' How? ']"));
    private SelenideElement aboutBtn = $(xpath("//a[text()=' About ']"));
    private SelenideElement contactUsBtn = $(xpath("//a[text()=' Contact us ']"));

    public AboutPage titleIsDisplayed(){
        log.debug("About MoodPanda on page is displayed");
        title.should(enabled);
        return this;
    }

    public AboutPage clickOnContactBtn(){
        log.debug("Click on " + contactUsBtn);
        contactUsBtn.should(enabled).click();
        return this;
    }

}
