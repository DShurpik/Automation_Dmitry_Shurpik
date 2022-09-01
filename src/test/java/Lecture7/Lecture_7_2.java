package Lecture7;

import PageObject.BaseObject.BaseTest;
import PageObject.saucedemo.BasketPage;
import PageObject.saucedemo.HeaderPage;
import PageObject.saucedemo.LoginPage;
import PageObject.saucedemo.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Lecture_7_2 extends BaseTest {
    @BeforeClass
    public void login() {
        new LoginPage()
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin();
    }

    @Test
    public void productTest() {
        String productName = "Sauce Labs Backpack";
        ProductPage productPage = new ProductPage();
        productPage.verifyPageTitle();
        String productCost = productPage.getProductCost(productName);
        productPage.addProductToBasket(productName);
        HeaderPage headerPage = new HeaderPage();
        headerPage.clickBasketBtn();
        BasketPage basketPage = new BasketPage();
        String cartProductCost = basketPage.getProductCost(productName);
        Assert.assertEquals(productCost, cartProductCost);
        Assert.assertEquals(basketPage.enterCartQuantity(productName), "1");
    }
}
