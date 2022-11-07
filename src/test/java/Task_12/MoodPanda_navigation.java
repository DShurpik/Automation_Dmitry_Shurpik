package Task_12;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.moodpanda.selenide.*;

public class MoodPanda_navigation extends SelenideBaseTest {


    @Parameters({"email1", "password1"})
    @Test
    public void navigation_test_with_authorization(String email1, String password1){
        get(HomePage.class)
                .clickGetStartedBtn();
        get(LoginPage.class)
                .enterEmail(email1)
                .enterPassword(password1)
                .clickLoginBtn()
                .verifyPageUri("global");
        get(NavigationPage.class)
                .clickNavigationItem("Your profile")
                .verifyPageUri("user");
        get(NavigationPage.class)
                .clickNavigationItem("Patrons")
                .verifyPageUri("patron");
    }

    @Test
    public void navigation_test_without_authorization(){
        get(NavigationPage.class)
                .verifyPageUri("https://moodpanda.com/");
        get(NavigationPage.class)
                .clickNavigationItem("What?")
                .verifyPageUri("monitor-your-mood");
        get(NavigationPage.class)
                .clickNavigationItem("How?")
                .verifyPageUri("how-to-use-a-mood-diary");
        get(NavigationPage.class)
                .clickNavigationItem("About")
                .verifyPageUri("about");
        get(NavigationPage.class)
                .clickNavigationItem("Contact us")
                .verifyPageUri("contact");
    }
}
