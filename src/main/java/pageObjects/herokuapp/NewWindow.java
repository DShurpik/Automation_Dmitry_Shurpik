package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pageObjects.baseObjects.BasePage;
import static driver.SimpleDriver.*;

public class NewWindow extends BasePage {

    private By titleNewPage = By.xpath("//div[@class='example']");

    Actions actions = new Actions(getWebDriver());

    public NewWindow verifyOpenNewWindow(){
        System.out.println("Open page with text: New Window");
        driver.findElement(titleNewPage).isEnabled();
        System.out.println("New Window is Enabled");
        return this;
    }
    public void closeTabNewWindow(){
        actions.sendKeys(Keys.chord(Keys.CONTROL, "W"));
        System.out.println("New window was close");
    }
}
