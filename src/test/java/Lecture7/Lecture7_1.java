package Lecture7;

import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;
import org.testng.annotations.Test;

public class Lecture7_1 extends BaseTest {


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
