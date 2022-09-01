package Task_7;

import PageObjectForTask7.BaseObject.BaseTest;
import PageObjectForTask7.sauceDemo.LoginPage;
import PageObjectForTask7.sauceDemo.ProductPage;
import org.testng.annotations.Test;

public class Task_7 extends BaseTest {

    @Test
    public void test1(){    // Успешная авторизация
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.sendUserName("standard_user");
        loginPage.sendPassword("secret_sauce");
        loginPage.clickLoginBtn();
        ProductPage productPage = new ProductPage();
        productPage.getElementProduct("Sauce Labs Onesie").isDisplayed();
        productPage.verifyProductPageUri();
    }
    @Test
    public void test2(){     // Попытка авторизации с пустыми полями username и password
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.clickLoginBtn();
        loginPage.errorFieldIsEmptyIsDisplayed();
    }
    @Test
    public void test3(){    // Попытка авторизации заблокированного пользователя
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.sendUserName("locked_out_user");
        loginPage.sendPassword("secret_sauce");
        loginPage.clickLoginBtn();
        loginPage.errorLockedUserIsDisplayed();
    }

}
