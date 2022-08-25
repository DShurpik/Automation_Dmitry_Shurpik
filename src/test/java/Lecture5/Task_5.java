package Lecture5;
import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Driver.SimpleDriver.getWebDriver;

public class Task_5 {
    @BeforeTest
    public void precondition(){
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }
    @AfterTest
    public void postconditions(){
        getWebDriver().quit();
    }
    @BeforeMethod
    public void reload() {
        getWebDriver().navigate().refresh();
    }
    @Test
    public void test1(){
        WebElement setRoomWidth = findElement("calc_roomwidth");
        setRoomWidth.sendKeys(Keys.BACK_SPACE, "4.4");
        WebElement setRoomHeight = findElement("calc_roomheight");
        setRoomHeight.sendKeys(Keys.BACK_SPACE, "5.5");
        WebElement setLaminateWidth = findElement("calc_lamwidth");
        setLaminateWidth.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "1600");
        WebElement setLaminateHeigh = findElement("calc_lamheight");
        setLaminateHeigh.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "250");
        WebElement setIpack = findElement("calc_inpack");
        setIpack.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, "25");
        WebElement setPrice = findElement("calc_price");
        setPrice.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "850");
        Select selectDirec = new Select(getWebDriver().findElement(By.name("calc_direct")));
        selectDirec.selectByValue("toh");
        WebElement setBias = findElement("calc_bias");
        setBias.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "650");
        WebElement setWallDist = findElement("calc_walldist");
        setWallDist.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, "100");
        WebElement submit = getWebDriver().findElement(By.cssSelector("[value='Рассчитать']"));
        submit.click();
        List<String> expectedResult = Arrays.asList(
                "22.26 м2.", "62 шт.", "3 шт.", "25500 руб.", "13 шт.", "6 шт."
        );
        Assert.assertEquals(expectedResult, getActualResult());
    }
    @Test
    public void test2(){
        WebElement setRoomWidth = findElement("calc_roomwidth");
        setRoomWidth.sendKeys(Keys.BACK_SPACE, "12");
        WebElement setRoomHeight = findElement("calc_roomheight");
        setRoomHeight.sendKeys(Keys.BACK_SPACE, "9");
        WebElement setLaminateWidth = findElement("calc_lamwidth");
        setLaminateWidth.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "1800");
        WebElement setLaminateHeigh = findElement("calc_lamheight");
        setLaminateHeigh.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "300");
        WebElement setIpack = findElement("calc_inpack");
        setIpack.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, "9");
        WebElement setPrice = findElement("calc_price");
        setPrice.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "1000");
        Select selectDirec = new Select(getWebDriver().findElement(By.name("calc_direct")));
        selectDirec.selectByValue("tow");
        WebElement setBias = findElement("calc_bias");
        setBias.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "500");
        WebElement setWallDist = findElement("calc_walldist");
        setWallDist.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, "200");
        WebElement submit = getWebDriver().findElement(By.cssSelector("[value='Рассчитать']"));
        submit.click();
        List<String> expectedResult = Arrays.asList(
                "103.84 м2.", "203 шт.", "23 шт.", "111780 руб.", "4 шт.", "10 шт."
        );
        Assert.assertEquals(expectedResult, getActualResult());
    }
    @Test
    public void test3(){
        WebElement setRoomWidth = findElement("calc_roomwidth");
        setRoomWidth.sendKeys(Keys.BACK_SPACE, "14.5");
        WebElement setRoomHeight = findElement("calc_roomheight");
        setRoomHeight.sendKeys(Keys.BACK_SPACE, "9.5");
        WebElement setLaminateWidth = findElement("calc_lamwidth");
        setLaminateWidth.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "2500");
        WebElement setLaminateHeigh = findElement("calc_lamheight");
        setLaminateHeigh.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "400");
        WebElement setIpack = findElement("calc_inpack");
        setIpack.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, "5");
        WebElement setPrice = findElement("calc_price");
        setPrice.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "2000");
        Select selectDirec = new Select(getWebDriver().findElement(By.name("calc_direct")));
        selectDirec.selectByValue("tow");
        WebElement setBias = findElement("calc_bias");
        setBias.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "500");
        WebElement setWallDist = findElement("calc_walldist");
        setWallDist.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, "400");
        WebElement submit = getWebDriver().findElement(By.cssSelector("[value='Рассчитать']"));
        submit.click();
        List<String> expectedResult = Arrays.asList(
                "132.99 м2.", "140 шт.", "28 шт.", "280000 руб.", "0 шт.", "7 шт."
        );
        Assert.assertEquals(expectedResult, getActualResult());
    }


    private WebElement findElement(String name){
        getWebDriver().findElement(By.name(name));
        getWebDriver().findElement(By.name(name)).click();
        return getWebDriver().findElement(By.name(name));
    }
    private List<String> getActualResult(){
        String squareLam = getWebDriver().findElement(By.id("s_lam")).getText();
        String numPan = getWebDriver().findElement(By.id("l_count")).getText();
        String numPack = getWebDriver().findElement(By.id("l_packs")).getText();
        String allPrice = getWebDriver().findElement(By.id("l_price")).getText();
        String overEnd = getWebDriver().findElement(By.id("l_over")).getText();
        String trashEnd = getWebDriver().findElement(By.id("l_trash")).getText();
        List<String> actualResult = Arrays.asList(
                squareLam, numPan, numPack, allPrice, overEnd, trashEnd
        );
        return actualResult;
    }









}
