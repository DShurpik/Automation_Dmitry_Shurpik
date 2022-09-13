package Task_6;

import driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleDriver.getWebDriver;

public class Task6 {
    @BeforeTest
    public void precondition() {
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://www.saucedemo.com/");
        getWebDriver().navigate().refresh();
    }

    @BeforeMethod
    public void reload() {
        getWebDriver().get("https://www.saucedemo.com/");
        getWebDriver().navigate().refresh();
    }

    @Test
    public void test1() {

        WebElement userName = getWebDriver().findElement(By.id("user-name"));
        WebElement passUser = getWebDriver().findElement(By.name("password"));
        WebElement loginBtn = getWebDriver().findElement(By.name("login-button"));
        loginBtn.click();
        WebElement alert = getWebDriver().findElement(By.tagName("h3"));
        alert.isDisplayed();
        userName.sendKeys("standard_user");
        passUser.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement twitter = getWebDriver().findElement(By.linkText("Twitter"));
        twitter.isDisplayed();
        WebElement facebook = getWebDriver().findElement(By.partialLinkText("Face"));
        facebook.isDisplayed();

        WebElement addToCart = getWebDriver().findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        addToCart.click();
        WebElement openCart = getWebDriver().findElement(By.className("shopping_cart_link"));
        openCart.click();

        String expensiveNameProduct = "Sauce Labs Bolt T-Shirt";
        String expensivePrice = "$15.99";
        String expenciveAmt = "1";

        String actualNameProduct = getWebDriver().findElement(By.className("inventory_item_name")).getText();
        String actualPrice = getWebDriver().findElement(By.className("inventory_item_price")).getText();
        String actualAmt = getWebDriver().findElement(By.className("cart_quantity")).getText();

        Assert.assertEquals(expensiveNameProduct, actualNameProduct);
        Assert.assertEquals(expensivePrice, actualPrice);
        Assert.assertEquals(expenciveAmt, actualAmt);

        WebElement clearCart = getWebDriver().findElement(By.xpath("//button[text()='Remove']"));
        clearCart.click();

    }

    @Test
    public void test2xPath() {
        WebElement userName = getWebDriver().findElement(By.xpath("//input[@data-test='username']"));
        WebElement password = getWebDriver().findElement(By.xpath("//input[contains(@placeholder,'Pass')]"));
        WebElement loginBtn = getWebDriver().findElement(By.xpath("//input[@data-test='login-button']"));
        loginBtn.click();
        WebElement error = getWebDriver().findElement(By.xpath("//h3"));
        error.isDisplayed();
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginBtn.click();

        WebElement footerCopy = getWebDriver().findElement(By.xpath("//li[@class='social_twitter']/following::div[@class='footer_copy']"));
        footerCopy.isDisplayed();
        WebElement social = getWebDriver().findElement(By.xpath("//li[@class='social_linkedin']/parent::ul[@class='social']"));
        social.isDisplayed();
        WebElement twitter = getWebDriver().findElement(By.xpath("//li[@class='social_linkedin']/preceding::li[@class='social_twitter']"));
        twitter.isDisplayed();

        WebElement addToCart = getWebDriver().findElement(By.xpath("(//button[contains(text(),'Add')])[1]"));
        addToCart.click();

        WebElement openCart = getWebDriver().findElement(By.xpath("//a[@class='shopping_cart_link']"));
        openCart.click();

        String expensiveNameProduct = "Sauce Labs Backpack";
        String expensivePrice = "$29.99";
        String expenciveAmt = "1";

        String actualNameProduct = getWebDriver().findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        String actualPrice = getWebDriver().findElement(By.xpath("//div[text()='29.99']")).getText();
        String actualAmt = getWebDriver().findElement(By.xpath("//div[@class='cart_quantity']")).getText();

        Assert.assertEquals(expensiveNameProduct, actualNameProduct);
        Assert.assertEquals(expensivePrice, actualPrice);
        Assert.assertEquals(expenciveAmt, actualAmt);

        WebElement clearCart = getWebDriver().findElement(By.xpath("//button[text()='Remove']"));
        clearCart.click();

    }

    @Test
    public void test3css() {
        WebElement userName = getWebDriver().findElement(By.cssSelector("input#user-name.input_error.form_input"));
        WebElement password = getWebDriver().findElement(By.cssSelector("input#password.input_error.form_input"));
        WebElement loginBtn = getWebDriver().findElement(By.cssSelector("input#login-button.submit-button.btn_action"));
        loginBtn.click();
        WebElement error = getWebDriver().findElement(By.cssSelector("h3"));
        error.isDisplayed();
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginBtn.click();
        WebElement twitter = getWebDriver().findElement(By.cssSelector("li.social_twitter"));
        twitter.isDisplayed();
        WebElement addToCart = getWebDriver().findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack.btn.btn_primary.btn_small.btn_inventory"));
        addToCart.click();
        WebElement openCart = getWebDriver().findElement(By.cssSelector("a.shopping_cart_link"));
        openCart.click();

        String expensiveNameProduct = "Sauce Labs Backpack";
        String expensivePrice = "$29.99";
        String expenciveAmt = "1";

        String actualNameProduct = getWebDriver().findElement(By.cssSelector("div.inventory_item_name")).getText();
        String actualPrice = getWebDriver().findElement(By.cssSelector("div.inventory_item_price")).getText();
        String actualAmt = getWebDriver().findElement(By.cssSelector("div.cart_quantity")).getText();

        Assert.assertEquals(expensiveNameProduct, actualNameProduct);
        Assert.assertEquals(expensivePrice, actualPrice);
        Assert.assertEquals(expenciveAmt, actualAmt);

        WebElement clearCart = getWebDriver().findElement(By.cssSelector("button#remove-sauce-labs-backpack.btn.btn_secondary.btn_small.cart_button"));
        clearCart.click();
    }


}



