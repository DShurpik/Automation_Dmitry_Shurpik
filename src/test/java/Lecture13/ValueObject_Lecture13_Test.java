package Lecture13;

import lombok.extern.log4j.Log4j;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.MoodPanda.HomePage;
import pageObjects.MoodPanda.NavigationPage;
import pageObjects.MoodPanda.SignUpPage;
import pageObjects.MoodPanda.valueObject.SignUp;
import pageObjects.MoodPanda.valueObject.SignUpBuilder;
import pageObjects.baseObjects.BaseTest;

@Log4j

public class ValueObject_Lecture13_Test extends BaseTest {


    @Test
    public void loginTest(){
        new HomePage().open();

        new NavigationPage().clickSignUp();

        SignUp signUp = new SignUp(){{ // создаем объект страницы с сеттерами
            setEmail(properties.getProperty("email"));
            setCheckbox(true);
            setFirstName("First name");
            setLastName("Last name");
            setPassword(properties.getProperty("password"));
        }};

        // создаем объект, в конце обязательно метод build который собирает
//        SignUpBuilder signUpBuilder1 = new SignUpBuilder.Builder().withLastName("S").withCheckbox(false).build();
//        SignUpBuilder signUpBuilder2 = new SignUpBuilder.Builder().withFirstName("Name").withLastName("LN").build();
//        SignUpBuilder signUpBuilder3 = new SignUpBuilder.Builder().withEmail(email).build();
//
//        System.out.println(signUpBuilder1);
//        System.out.println(signUpBuilder2);
//        System.out.println(signUpBuilder3);

//        new SignUpPage()
//                .enterData("First name"
//                        , "Last name"
//                        , email
//                        , password
//                        , true);// вводим сюда ВСЕ параметры для заполнения

        new SignUpPage().enterData(signUp); // используем метод где на вход подается объект и через гетеры получаем значения
    }

//    @Parameters({"email", "password"})
//    @Test
    public void loginBuilder_Test(String email, String password){
        new HomePage().open();
        new NavigationPage().clickSignUp();

        SignUpBuilder signUpBuilder = new SignUpBuilder.Builder() //Вызываем класс и вызываем у него ВНУТРЕННИЙ КЛАСС Builder
                // и далее идет перечислление полей необходимых для данного объекта
                .withEmail(email)
                .withLastName("S")
                .withFirstName("First name")
                .withCheckbox(false)
                .withPassword(password)
                .build(); // вызываем в конце чтобы собрать объект

        new SignUpPage().enterData(signUpBuilder);
    }

}