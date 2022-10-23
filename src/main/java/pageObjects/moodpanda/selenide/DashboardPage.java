package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

import static com.codeborne.selenide.WebDriverConditions.*;
import static org.openqa.selenium.By.xpath;

@Log4j

public class DashboardPage {

    private SelenideElement patronsBtn = $(xpath("//a[text()=' Patrons ']"));
    private SelenideElement dashboard = $(xpath("//a[text()='Dashboard']"));


    public DashboardPage dashboardIsdispalyed(){
        log.debug("Element Dashboard is displayed on page");
        dashboard.should(enabled);
        return this;
    }


        public DashboardPage clickPatronsBtn(){
            log.debug("Click on " + patronsBtn);
            patronsBtn.should(enabled).click();
            return this;
        }

}
