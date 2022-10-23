package Task_12;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.moodpanda.selenide.HomePage;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.moodpanda.selenide.LoginPage;

import static com.codeborne.selenide.Configuration.baseUrl;

public class MoodPanda_authorization extends SelenideBaseTest {
    @BeforeTest
    public void precondition(){
        baseUrl = "https://moodpanda.com/";
    }

    @Parameters({"email1", "password1"})
    @Test
    public void authorization_test1(String email1, String password1){
        get(HomePage.class)
                .clickGetStartedBtn();
        get(LoginPage.class)
                .enterEmail(email1)
                .enterPassword(password1)
                .clickLoginBtn()
                .titleIsEnabled();
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
                .titleIsEnabled();
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
                .titleIsEnabled();
    }
}
