package Task_7;

import Task_7.steps.LoginStep;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;


public class Task_7 extends BaseTest {


    @Parameters({"username", "password"})
    @Test
    @Description("sucessfull autorization")
    @Step("Login and check product page")

    public void test01(String username, String password){
        get(LoginStep.class).login(username, password);
        ProductPage productPage = new ProductPage();
        productPage.getElementProduct("Sauce Labs Onesie").isDisplayed();
    }




    @Test(description = "sucessfull autorization")
    public void test1(){    // Успешная авторизация
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        ProductPage productPage = new ProductPage();
        productPage.getElementProduct("Sauce Labs Onesie").isDisplayed();
        productPage.verifyPageUri();
    }
    @Test(description = "autorization with void forms")
    public void test2(){     // Попытка авторизации с пустыми полями username и password
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.clickLogin();
        loginPage.verifyError();
    }
    @Test(description = "autorization banned user")
    public void test3(){    // Попытка авторизации заблокированного пользователя
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        loginPage.errorLockedUserIsDisplayed();
    }
    @Test(description = "add product on cart")
    public void test4(){   // Добавление товара в корзину
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        ProductPage productPage = new ProductPage();
        productPage.getElementProduct("Sauce Labs Onesie").isDisplayed();
        productPage.getAddToCartBtn("Sauce Labs Onesie").click();
        productPage.countProductInCartIsDispalyedAfterAdd();
    }
    @Test(description = "add product on cart and remove product from main page")
    public void test5(){   // Добавление товара в корзину и удаление товара с главной страницы используя кнопку "Remove"
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        ProductPage productPage = new ProductPage();
        productPage.getElementProduct("Sauce Labs Onesie").isDisplayed();
        productPage.getAddToCartBtn("Sauce Labs Onesie").click();
        productPage.countProductInCartIsDispalyedAfterAdd();
        productPage.removeProductFromCart("Sauce Labs Onesie");
    }
    @Test
    public void test6(){
        LoginPage loginPage = new LoginPage(); //  1 тест на оплату
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        ProductPage productPage = new ProductPage();
        productPage.getElementProduct("Sauce Labs Onesie").isDisplayed();
        productPage.getAddToCartBtn("Sauce Labs Onesie").click();
    }
}
