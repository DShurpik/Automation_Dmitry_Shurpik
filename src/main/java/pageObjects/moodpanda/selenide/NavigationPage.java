package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

@Log4j

public class NavigationPage {

    public SelenideElement getNavigationLink(String linkText) {
        return $(By.partialLinkText(linkText));
    }


    public NavigationPage clickNavigationItem(String linkText) {
        log.debug("Click on button with text " + linkText);
        getNavigationLink(linkText).click();
        return this;
    }

    public NavigationPage verifyPageUri(String uri) {
        log.debug("Uri: " + uri + " equal expected result");
        webdriver().shouldHave(urlContaining(uri));
        return this;
    }
}
