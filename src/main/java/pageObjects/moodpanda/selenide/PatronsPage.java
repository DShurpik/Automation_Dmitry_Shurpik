package pageObjects.moodpanda.selenide;

import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Label;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

@Log4j

public class PatronsPage {

    private SelenideElement patronField = $(xpath("//p[text()='Patron center']"));

    public PatronsPage patronFieldIsDisplayed(){
        log.debug("Element " + patronField + " is displayed on page");
        patronField.should(enabled);
        return this;
    }

}
