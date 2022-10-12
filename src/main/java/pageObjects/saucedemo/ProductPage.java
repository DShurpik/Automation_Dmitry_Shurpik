package pageObjects.saucedemo;

import pageObjects.baseObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static driver.SimpleDriver.getWebDriver;

public class ProductPage extends BasePage {

    private final By title = By.xpath("//span[@class='title']");

    private final By countInCart = By.xpath("//span[@class='shopping_cart_badge']");



    public WebElement getElementProduct(String productName) {
        return getWebDriver().findElement(By.xpath("//*[@class = 'inventory_item_name' and text() = '" + productName + "']//ancestor::div[@class='inventory_item']"));
    }

    private WebElement getProductPrice(String productName) {
        return getElementProduct(productName).findElement(By.className("inventory_item_price"));
    }

    public WebElement getAddToCartBtn(String productName) {
        return getElementProduct(productName).findElement(By.tagName("button"));
    }

    private WebElement getRemoveCartBtn(String productName){
        return getElementProduct(productName).findElement(By.xpath("//button[text()='Remove']"));
    }

    private WebElement countProductInBasket(){       //на главной странице показывает что продукт добавлен
        return getWebDriver().findElement(By.className("shopping_cart_badge"));
    }

    private WebElement basketBtn(){
        return getWebDriver().findElement(By.className("shopping_cart_link"));
    }

    public void openBasket(){
        System.out.println("open basket");
        click(basketBtn());

    }

    public ProductPage basketOnMainPageHaveProduct(){   // что в корзину добавлен продукт
        System.out.println("basket with product");
        countProductInBasket().isDisplayed();
        return this;
    }



    public ProductPage() {
        verifyPageUri();
    }



    public ProductPage verifyPageUri() {
        Assert.assertTrue(getWebDriver().getCurrentUrl().contains("inventory.html"));
        return this;
    }

    public ProductPage verifyPageTitle() {
        Assert.assertEquals(getText(title), "PRODUCTS");
        System.out.println("title is displayed");
        return this;
    }

    public ProductPage addProductToBasket(String productName) {
        System.out.println("add product to basket");
        click(getAddToCartBtn(productName));
        return this;
    }

    public ProductPage removeProductFromBaset(String productName) {
        click(getRemoveCartBtn(productName));
        System.out.println("product delete");
        return this;
    }

    public ProductPage countProductInCartIsDispalyedAfterAdd(){
        Assert.assertTrue(driver.findElement(countInCart).isDisplayed());
        return this;
    }

    public ProductPage removeProductFromCart(String productName){
        getWebDriver().findElement(By.xpath("//button[@data-test='remove-" + productName +"']")).click();
        return this;
    }



    public String getProductCost(String productName) {
        return getText(getProductPrice(productName));
    }
}
