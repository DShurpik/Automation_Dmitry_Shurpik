package Lecture13;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.MoodPanda.HomePage;
import pageFactory.MoodPanda.LoginPage;
import pageObjects.baseObjects.BaseTest;

@Log4j

public class PageFactory_Lecture13_Test extends BaseTest {


    @Test
    public void loginTest(){
        new HomePage()
                .open()
                .clickGetStarted();
        new LoginPage()
                .enterEmail(properties.getProperty("email"))
                .enterPassword(properties.getProperty("password"))
                .clickLogin()
                .verifyAlertMsg("Your email or password is wrong");
    }
}