package Task_7;

import PageObjectForTask7.BaseObject.BaseTest;
import PageObjectForTask7.sauceDemo.CartPage;
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
    @Test
    public void test4(){   // Добавление товара в корзину
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.sendUserName("standard_user");
        loginPage.sendPassword("secret_sauce");
        loginPage.clickLoginBtn();
        ProductPage productPage = new ProductPage();
        productPage.getElementProduct("Sauce Labs Onesie").isDisplayed();
        productPage.getAddToCartBtn("Sauce Labs Onesie").click();
        productPage.countProductInCartIsDispalyedAfterAdd();
    }
    @Test
    public void test5(){   // Добавление товара в корзину и удаление товара с главной страницы используя кнопку "Remove"
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.sendUserName("standard_user");
        loginPage.sendPassword("secret_sauce");
        loginPage.clickLoginBtn();
        ProductPage productPage = new ProductPage();
        productPage.getElementProduct("Sauce Labs Onesie").isDisplayed();
        productPage.getAddToCartBtn("Sauce Labs Onesie").click();
        productPage.countProductInCartIsDispalyedAfterAdd();
        productPage.removeProductFromCart("Sauce Labs Onesie").click();
    }
    @Test
    public void test6(){
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.sendUserName("standard_user");
        loginPage.sendPassword("secret_sauce");
        loginPage.clickLoginBtn();
        ProductPage productPage = new ProductPage();
        productPage.getElementProduct("Sauce Labs Onesie").isDisplayed();
        productPage.getAddToCartBtn("Sauce Labs Onesie").click();
        productPage.openCart();
        CartPage cartPage = new CartPage();

    }

}
