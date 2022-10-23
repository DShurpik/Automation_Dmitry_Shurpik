package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

@Log4j

public class HowPage {

    private SelenideElement title = $(xpath("//p[@class='subtitle']"));
    private SelenideElement whatBtn = $(xpath("//a[text()=' What? ']"));
    private SelenideElement howBtn = $(xpath("//a[text()=' How? ']"));
    private SelenideElement aboutBtn = $(xpath("//a[text()=' About ']"));
    private SelenideElement contactUsBtn = $(xpath("//a[text()=' Contact us ']"));

    public HowPage titleIsDisplayed(){
        log.debug("How to use a mood diary on page is displayed");
        title.should(enabled);
        return this;
    }

    public HowPage clickAboutBtn(){
        log.debug("Click on " + aboutBtn);
        aboutBtn.should(enabled).click();
        return this;
    }

}