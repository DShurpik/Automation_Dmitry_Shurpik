package Lecture17;

import org.testng.annotations.Test;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.rw.HomePage;
import pageObjects.rw.SearchResultPage;

public class RW_Test extends SelenideBaseTest {

    @Test
    public void checkResultSearch_test(){
        get(HomePage.class)
                .enterFrom("Витебск")
                .enterTo("Минск")
                .enterCalendar("1")
                .clickSearch();
        get(SearchResultPage.class)
                .checkResultCount(5);
    }

}
