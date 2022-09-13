package Lecture8;

import PageObjectForTask7.BaseObject.BaseTest;
import org.testng.annotations.Test;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class Lecture8_1 extends BaseTest {

    @Test
    public void login(){

        new LoginPage()
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin()
                .verifyThatLoginPageIsClosed();
        new ProductPage().verifyPageTitle();

    }
}
