package Lecture8;

import PageObject.saucedemo.LoginPage;
import PageObject.saucedemo.ProductPage;
import org.testng.annotations.Test;

public class Lecture8_1 {

    @Test
    public void test(){
        new LoginPage()
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();
        new ProductPage().verifyPageTitle();

    }
}
