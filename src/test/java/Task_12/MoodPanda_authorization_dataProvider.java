package Task_12;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.moodpanda.selenide.HomePage;
import pageObjects.moodpanda.selenide.LoginPage;

public class MoodPanda_authorization_dataProvider extends SelenideBaseTest {

    @Test(dataProvider = "login value")
    public void authorization_test1(String email, String password){
        get(HomePage.class)
                .clickGetStartedBtn();
        get(LoginPage.class)
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginBtn()
                .verifyPageUri("global");
    }

    @DataProvider(name = "login value")
    public Object[][] getData() {
        return new Object[][]{
                {"jaxego6618@cadolls.com", "Password"},
                {"fiyipe7996@evilant.com", "Password"},
                {"dehix80143@cadolls.com", "Password"},
        };
    }
}
