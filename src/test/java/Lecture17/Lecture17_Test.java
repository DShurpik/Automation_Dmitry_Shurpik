package Lecture17;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.*;

@Log4j

public class Lecture17_Test {

    @BeforeTest
    public void precondition(){
        baseUrl = "https://www.rw.by/";
    }

    @Test
    public void openPage_test(){
        open(baseUrl);
        $("#acFrom").sendKeys("Витебск");
        $(byId("acTo")).sendKeys("Минск");
        $("#yDate").click();
        $(byXpath("//*[contains(@class, 'group-middle')]"))
                .find(byXpath("table"))
                .find(byLinkText("1")).click();

        SelenideElement button = $("[class=std-button]");
        button.should(enabled) //проверка что кнопка enabled
                .click();

        // $$ работа с элементами и обработка их в коллекции
        ElementsCollection collection = $$("[class=sch-table__body-wrap] [class=sch-table__row]");
        collection.should(sizeGreaterThan(0));
        log.debug(collection.filterBy(matchText("Санкт-Петербург-Витеб")).texts());
    }
}
