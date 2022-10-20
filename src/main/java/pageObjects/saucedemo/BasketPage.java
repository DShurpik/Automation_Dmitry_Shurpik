package pageObjects.saucedemo;

import pageObjects.baseObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static driver.DriverManager.getWebDriver;

public class BasketPage extends BasePage {
    private WebElement getElementCartItem(String productName) {
        return getWebDriver().findElement(By.xpath("//*[@class = 'inventory_item_name' and text() = '" + productName + "']//ancestor::div[@class='cart_item']"));
    }
    private WebElement removeFromBasketBtn() {
        return getWebDriver().findElement(By.xpath("//button[text()='Remove']"));
    }

    private WebElement removedCartItem(){
        return getWebDriver().findElement(By.className("removed_cart_item"));
    }

    private WebElement getElementProductCost(String productName) {
        return getElementCartItem(productName).findElement(By.className("inventory_item_price"));
    }

    private WebElement getElementCartQuantity(String productName){
        return getElementCartItem(productName).findElement(By.className("cart_quantity"));
    }

    public String getProductCost(String productName) {
        return getText(getElementProductCost(productName));
    }

    public BasketPage removeFromBasket(){
        System.out.println("delete product from basket");
        click(removeFromBasketBtn());
        return this;
    }

    public void basketIsEmpty(){
        System.out.println("basket is empty");
        removedCartItem().isDisplayed();
    }

    public String enterCartQuantity(String productName) {
        return getText(getElementCartQuantity(productName));
    }



}
