package PageObjectForTask7.sauceDemo;

import org.openqa.selenium.By;

import static Driver.SimpleDriver.getWebDriver;

public class CartPage {

    By removeBtn = By.xpath("//button[text()='Remove']");
    By checkAddProduct = By.xpath("//div[@class='cart_quantity']");
    By emptyCartAfterRemove = By.xpath("//div[@class='removed_cart_item']");

    public void checkAddProduct(){
        getWebDriver().findElement(checkAddProduct);
    }
    public void clickRemoveBtn(){
        getWebDriver().findElement(removeBtn).click();
    }
    public void checkEmptyCart(){
        getWebDriver().findElement(emptyCartAfterRemove).isDisplayed();
    }
}
