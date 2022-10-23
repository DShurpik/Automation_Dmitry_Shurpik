package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

@Log4j

public class DiaryPage {
    private SelenideElement cardOfUser = $(xpath("//div[@class='card is-dark']"));
    private SelenideElement youDashboardBtn = $(xpath("//a[text()=' Your dashboard ']"));

    public DiaryPage cardOfUserIsEnabled(){
        log.debug("User card on page " + cardOfUser);
        cardOfUser.should(enabled);
        return this;
    }

    public DiaryPage clickYouDashboard(){
        log.debug("Click on " + youDashboardBtn);
        youDashboardBtn.should(enabled).click();
        return this;
    }
}
