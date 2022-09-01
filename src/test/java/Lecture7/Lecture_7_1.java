package Lecture7;

import PageObject.BaseObject.BaseTest;
import PageObject.saucedemo.LoginPage;
import PageObject.saucedemo.ProductPage;
import org.testng.annotations.Test;

public class Lecture_7_1 extends BaseTest {


    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        ProductPage productPage = new ProductPage();
        productPage.verifyPageTitle();
    }
}
