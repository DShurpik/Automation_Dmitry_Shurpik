package Lecture8;


import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class Lecture8_1 extends BaseTest {

    @Test
    public void login1(){

        new LoginPage()
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin()
                .verifyThatLoginPageIsClosed();
        new ProductPage().verifyPageTitle();

    }

    @Test
    public void login1withProperty(){

        new LoginPage()
                .open()
                .userName("AAA")
                .userPassword("FFF")
                .clickLogin()
                .verifyThatLoginPageIsClosed();
        new ProductPage().verifyPageTitle();

    }
}
