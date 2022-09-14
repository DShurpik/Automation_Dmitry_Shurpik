package Task_9;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class BasketOnMainPageTest extends BaseTest {




    @Test(dataProvider = "produts", groups = "smoke", invocationCount = 1, priority = 2)
    public void addRemoveProductFromMainPage(String productName){
        new LoginPage()
                .open()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLogin()
                .verifyThatLoginPageIsClosed();
        new ProductPage()
                .addProductToBasket(productName)
                .basketOnMainPageHaveProduct()
                .removeProductFromBaset(productName);
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
