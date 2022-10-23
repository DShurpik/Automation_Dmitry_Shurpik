package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

@Log4j

public class WhatPage {

    private SelenideElement title = $(xpath("//p[text()=' Monitor your mood ']"));
    private SelenideElement homebtn = $(xpath("//a[text()=' Home ']"));
    private SelenideElement whatBtn = $(xpath("//a[text()=' What? ']"));
    private SelenideElement howBtn = $(xpath("//a[text()=' How? ']"));
    private SelenideElement aboutBtn = $(xpath("//a[text()=' About ']"));
    private SelenideElement contactUsBtn = $(xpath("//a[text()=' Contact us ']"));

    public WhatPage titleIsDisplayed(){
        log.debug("Monitor your mood on what? page is displayed");
        title.should(enabled);
        return this;
    }

    public WhatPage clickHowBtn(){
        log.debug("Click on " + howBtn);
        homebtn.should(enabled).click();
        return this;
    }

}
