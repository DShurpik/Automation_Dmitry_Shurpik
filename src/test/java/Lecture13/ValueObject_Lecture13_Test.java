package Lecture13;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.MoodPanda.HomePage;
import pageObjects.MoodPanda.NavigationPage;
import pageObjects.MoodPanda.SignUpPage;
import pageObjects.MoodPanda.valueObject.SignUp;
import pageObjects.MoodPanda.valueObject.SignUpBuilder;
import pageObjects.baseObjects.BaseTest;

public class ValueObject_Lecture13_Test extends BaseTest {

    @Parameters({"url","email", "password" })
    @Test
    public void loginTest(String url, String email, String password){
        new HomePage()
                .open(url);

        new NavigationPage()
                .clickSignUp();

        SignUp signUp = new SignUp(){{ // создаем объект страницы с сеттерами
            setEmail(email);
            setCheckbox(true);
            setFirstName("First name");
            setLastName("Last name");
            setPassword(password);
        }};

        // создаем объект, в конце обязательно метод build который собирает
        SignUpBuilder signUpBuilder1 = new SignUpBuilder.Builder().withLastName("S").withCheckbox(false).build();
        SignUpBuilder signUpBuilder2 = new SignUpBuilder.Builder().withFirstName("Name").withLastName("LN").build();
        SignUpBuilder signUpBuilder3 = new SignUpBuilder.Builder().withEmail(email).build();

        System.out.println(signUpBuilder1);
        System.out.println(signUpBuilder2);
        System.out.println(signUpBuilder3);

//        new SignUpPage()
//                .enterData("First name"
//                        , "Last name"
//                        , email
//                        , password
//                        , true);// вводим сюда ВСЕ параметры для заполнения

        new SignUpPage()
                .enterData(signUp); // используем метод где на вход подается объект и через гетеры получаем значения
    }
}