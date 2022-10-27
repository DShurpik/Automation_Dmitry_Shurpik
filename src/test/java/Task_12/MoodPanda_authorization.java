package Task_12;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.moodpanda.selenide.HomePage;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.moodpanda.selenide.LoginPage;

public class MoodPanda_authorization extends SelenideBaseTest {

    @Parameters({"email1", "password1"})
    @Test
    public void authorization_test1(String email1, String password1){
        get(HomePage.class)
                .clickGetStartedBtn();
        get(LoginPage.class)
                .enterEmail(email1)
                .enterPassword(password1)
                .clickLoginBtn()
                .verifyPageUri("global");
    }

    @Parameters({"email2", "password2"})
    @Test
    public void authorization_test2(String email2, String password2){
        get(HomePage.class)
                .clickGetStartedBtn();
        get(LoginPage.class)
                .enterEmail(email2)
                .enterPassword(password2)
                .clickLoginBtn()
                .verifyPageUri("global");
    }

    @Parameters({"email3", "password3"})
    @Test
    public void authorization_test3(String email3, String password3){
        get(HomePage.class)
                .clickGetStartedBtn();
        get(LoginPage.class)
                .enterEmail(email3)
                .enterPassword(password3)
                .clickLoginBtn()
                .verifyPageUri("global");
    }
}
