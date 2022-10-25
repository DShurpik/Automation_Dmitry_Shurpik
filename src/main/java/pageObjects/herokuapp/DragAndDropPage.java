package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.baseObjects.BasePage;

import static driver.DriverManager.*;

public class DragAndDropPage extends BasePage {

    private WebElement elementAA = getWebDriver().findElement(By.xpath("//div[@class='column' and @id='column-a']"));

    private WebElement elementBB = getWebDriver().findElement(By.xpath("//div[@class='column' and @id='column-b']"));

    private WebElement elementAB = getWebDriver().findElement(By.xpath("//div[@id='column-a']//header[text()='B']"));

    private WebElement elementBA = getWebDriver().findElement(By.xpath("//div[@id='column-b']//header[text()='A']"));


    private WebElement elementA = getWebDriver().findElement(By.id("column-a"));
    private WebElement elementB = getWebDriver().findElement(By.id("column-b"));

    private WebElement fieldA = getWebDriver().findElement(By.id("column-a"));
    private WebElement fieldB = getWebDriver().findElement(By.id("column-b"));

    private Actions actions = new Actions(getWebDriver());
    Actions act = new Actions(driver);

    public DragAndDropPage elementsIsDisplayed(){
        System.out.println("Element A on field A");
        System.out.println("Element B on field B");
        isDisplayed(elementAA);
        isDisplayed(elementBB);
        return this;
    }



    public DragAndDropPage elementABIsDisplayed(){
        System.out.println("Element A on field B");
        isDisplayed(elementAB);
        return this;
    }

    public DragAndDropPage elementBAIsDisplayed(){
        System.out.println("Element B on field A");
        isDisplayed(elementBA);
        return this;
    }

    public DragAndDropPage moveElement(){ // ??????????????????
        act.moveToElement(elementAA).clickAndHold().moveToElement(elementBB).release().build().perform();
        //act.moveToElement(elementA).click().clickAndHold().moveToElement(elementB).perform();
        //act.clickAndHold(elementAA).moveToElement(elementBB).release(elementBB).build().perform();
        //Action dragAndDrop = act.clickAndHold(elementAA).moveToElement(elementBB).release(elementBB).build();
        //dragAndDrop.perform();
        //actions.dragAndDrop(elementAA, elementBB).perform();
        //act.dragAndDrop(elementAA,elementBB).perform();

        return this;
    }









}
