package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.SimpleDriver.getWebDriver;

public class OpeningANewWindowPage extends BasePage {
    private By ClickHereBtn = By.xpath("//a[text()='Click Here']");
    private By title = By.xpath("//h3[text()='Opening a new window']");

    Actions actions = new Actions(getWebDriver());

    public OpeningANewWindowPage verifyPageOpen(){
        Assert.assertEquals(driver.findElement(title).getText(), "Opening a new window");
        System.out.println("Open page with text: Opening a new window");
        return this;
    }
    public OpeningANewWindowPage click(){
        click(ClickHereBtn);
        return this;
    }

    public void openTab(){
        actions.sendKeys(Keys.chord(Keys.CONTROL, Keys.NUMPAD2));
    }
}