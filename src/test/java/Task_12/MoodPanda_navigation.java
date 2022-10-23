package Task_12;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.moodpanda.selenide.*;

import static com.codeborne.selenide.Configuration.baseUrl;

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
                .titleIsEnabled()
                .clickYourDiaryBtn();
        get(DiaryPage.class)
                .cardOfUserIsEnabled()
                .clickYouDashboard();
        get(DashboardPage.class)
                .dashboardIsdispalyed()
                .clickPatronsBtn();
        get(PatronsPage.class)
                .patronFieldIsDisplayed();
    }

    @Test
    public void navigation_test_without_authorization(){
        get(HomePage.class)
                .clickWhatBtn();
        get(WhatPage.class)
                .titleIsDisplayed()
                .clickHowBtn();
        get(HowPage.class)
                .titleIsDisplayed()
                .clickAboutBtn();
        get(AboutPage.class)
                .titleIsDisplayed()
                .clickOnContactBtn();
        get(ContackUsPage.class)
                .titleIsDisplayed();
    }
}
