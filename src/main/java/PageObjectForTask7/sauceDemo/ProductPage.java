package PageObjectForTask7.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static driver.SimpleDriver.getWebDriver;

public class ProductPage {

    By countProductInCart = By.xpath("//span[@class='shopping_cart_badge']");
    By cart = By.xpath("//a[@class='shopping_cart_link']");

    public void verifyProductPageUri(){
        getWebDriver().getCurrentUrl().contains("inventory.html");
        System.out.println("Uri: " + getWebDriver().getCurrentUrl());
    }
    public WebElement getElementProduct(String productName) {
        return getWebDriver().findElement(By.xpath("//*[@class = 'inventory_item_name' and text() = '" + productName + "']//ancestor::div[@class='inventory_item']"));
    }
    public WebElement getAddToCartBtn(String productname){
        return getElementProduct(productname).findElement(By.tagName("button"));
    }
    public void countProductInCartIsDispalyedAfterAdd(){
        System.out.println("In cart " + getWebDriver().findElement(countProductInCart).getText() + " product");
        getWebDriver().findElement(countProductInCart).isDisplayed();
    }
    public WebElement removeProductFromCart(String productName){
        System.out.println("remove product from cart from main page");
        return getElementProduct(productName).findElement(By.xpath("//button[text()='Remove']"));
    }
    public void openCart(){
        getWebDriver().findElement(cart).click();
    }

}
