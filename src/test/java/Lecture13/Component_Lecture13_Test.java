package Lecture13;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.MoodPanda.HomePage;
import pageFactory.MoodPanda.LoginPage;
import pageObjects.baseObjects.BaseTest;

public class Component_Lecture13_Test extends BaseTest {

    @Parameters({"url","email", "password" })
    @Test
    public void loginTest(String url, String email, String password){
        new HomePage()
                .open(url)
                .clickGetStarted();
        new LoginPage()
                .enterEmail(email)
                .enterPassword(password)
                .clickLogin()
                .verifyAlertMsg("Your email or password is wrong");
    }
}