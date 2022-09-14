package Task_9;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.BasketPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class BasketPageTest extends BaseTest {


    @Test(enabled = true, dataProvider = "produts")
    public void addProductFromMainPageToBasketRemoveProductFromBasket(String productName){
        new LoginPage()
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin()
                .verifyThatLoginPageIsClosed();
        new ProductPage()
                .addProductToBasket(productName)
                .openBasket();
        new BasketPage()
                .removeFromBasket()
                .basketIsEmpty();

    }

    @DataProvider(name = "produts")
    public Object[][] getProduct(){
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"}
        };
    }
}
