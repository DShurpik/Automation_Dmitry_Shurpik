package Task_12;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.moodpanda.selenide.HomePage;
import pageObjects.moodpanda.selenide.SignUpPage;
import pageObjects.baseObjects.SelenideBaseTest;
import pageObjects.moodpanda.selenide.SignUpPageBuilder;

import static com.codeborne.selenide.Configuration.baseUrl;

public class MoodPanda_registration extends SelenideBaseTest {

    @BeforeTest
    public void precondition(){
        baseUrl = "https://moodpanda.com/";
    }

    @Parameters({"firstName1", "lastNameInitial1", "email1", "password1"})
    @Test(enabled = true)
    public void registration_test1(String firstName1, String lastNameInitial1, String email1, String password1){
        get(HomePage.class)
                .clickSignUpBtn();
        get(SignUpPage.class)
                .enterFirstName(firstName1)
                .enterLastNameInitial(lastNameInitial1)
                .enterEmail(email1)
                .enterPassword(password1)
                .clickCheckBox()
                .clickSignUpBtn()
                .alertMessageIsDisplayed()
                .clickYesSignMeUpBtn()
                .verify()
                .equalText(firstName1);
    }

    @Parameters({"firstName2", "lastNameInitial2", "email2", "password2"})
    @Test(enabled = true)
    public void registration_test2(String firstName2, String lastNameInitial2, String email2, String password2){
        SignUpPage signUpPage = new SignUpPage(){{
            setFirstName(firstName2);
            setLastNameInitial(lastNameInitial2);
            setEmail(email2);
            setPassword(password2);
        }};


        get(HomePage.class)
                .clickSignUpBtn();
        get(SignUpPage.class)
                .enterData(signUpPage)
                .clickCheckBox()
                .clickSignUpBtn()
                .alertMessageIsDisplayed()
                .clickYesSignMeUpBtn()
                .verify()
                .equalText(firstName2);
    }

    @Parameters({"firstName3", "lastNameInitial3", "email3", "password3"})
    @Test(enabled = true)
    public void registration_test3(String firstName3, String lastNameInitial3, String email3, String password3){

        SignUpPageBuilder signUpPageBuilder = new SignUpPageBuilder
                .Builder()
                .withFirstName(firstName3)
                .withLastNameInitial(lastNameInitial3)
                .withEmail(email3)
                .withPassword(password3)
                .build();

        get(HomePage.class)
                .clickSignUpBtn();
        get(SignUpPage.class)
                .enterData(signUpPageBuilder)
                .clickCheckBox()
                .clickSignUpBtn()
                .alertMessageIsDisplayed()
                .clickYesSignMeUpBtn()
                .verify()
                .equalText(firstName3);
    }
}
