package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

@Log4j

public class ContackUsPage {

    private SelenideElement title = $(xpath("//img[@class='login-logo']"));
    private SelenideElement whatBtn = $(xpath("//a[text()=' What? ']"));
    private SelenideElement howBtn = $(xpath("//a[text()=' How? ']"));
    private SelenideElement aboutBtn = $(xpath("//a[text()=' About ']"));
    private SelenideElement contactUsBtn = $(xpath("//a[text()=' Contact us ']"));

    public ContackUsPage titleIsDisplayed(){
        log.debug("Mood panda img on page is displayed");
        title.should(enabled);
        return this;
    }
}
