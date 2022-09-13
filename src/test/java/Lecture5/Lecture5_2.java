package Lecture5;

import driver.SimpleDriver;
import org.openqa.selenium.By;
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

import static driver.SimpleDriver.getWebDriver;

public class Lecture5_2 {

    @BeforeTest
    public void preconditions(){
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");
    }
    @BeforeMethod
    public void reload() {
        getWebDriver().navigate().refresh();
    }
    @Test
    public void test1(){
        Select selectGender = new Select(getWebDriver().findElement(By.id("oSex")));
        selectGender.selectByValue("0");
        getWebDriver().findElement(By.id("oCr")).sendKeys("50");
        getWebDriver().findElement(By.id("oAge")).sendKeys("20");
        getWebDriver().findElement(By.id("oWeight")).sendKeys("50");
        getWebDriver().findElement(By.id("oHeight")).sendKeys("170");
        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']")).click();
        List<String> actualResult = new ArrayList<>();
        List<WebElement> result = getWebDriver().findElements(By.cssSelector("li div[id]"));
        result.forEach(webElement -> {
            actualResult.add(webElement.getText());
        });
        List<String> expectedResult = new ArrayList<>() {{   // Первый способ создания листа стринг значений
            add("MDRD: 196 (мл/мин/1,73кв.м)");
            add("ХБП: 1 стадия (при наличии почечного повреждения)");
            add("Cockroft-Gault: 148 (мл/мин)");
            add("Поверхность тела:1.57 (кв.м)");
        }};
        Assert.assertEquals(actualResult, expectedResult);
    }
    @AfterTest
    public void postconditions(){
        getWebDriver().close();
    }
    @Test
    public void test2(){
        Select selectGender = new Select(getWebDriver().findElement(By.id("oSex")));
        selectGender.selectByValue("1");
        enter("oCr","50");
        enter("oAge","30");
        enter("oWeight","80");
        enter("oHeight","180");
        submit();
        List<String> actualResult = getActualResult();
        List<String> expectedResult = Arrays.asList(  // Второй вариант создания листа стринг значений
            "MDRD: 134 (мл/мин/1,73кв.м)",
            "ХБП: 1 стадия (при наличии почечного повреждения)",
            "Cockroft-Gault: 176 (мл/мин)",
            "Поверхность тела:2 (кв.м)"
        );
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void test3() {
        Select selectGender = new Select(getWebDriver().findElement(By.id("oSex")));
        selectGender.selectByValue("1");
        enter("oCr", "80");
        enter("oAge", "38");
        enter("oWeight", "55");
        enter("oHeight", "163");
        submit();
        List<String> actualData = getActualResult();
        List<String> expectedData = Arrays.asList(
                "MDRD: 74 (мл/мин/1,73кв.м)",
                "ХБП: 2 стадия (при наличии почечного повреждения)",
                "Cockroft-Gault: 70 (мл/мин)",
                "Поверхность тела:1.58 (кв.м)"
        );
        Assert.assertEquals(actualData, expectedData);
    }
    private void enter(String id, String value){
        getWebDriver().findElement(By.id(id)).clear();
        getWebDriver().findElement(By.id(id)).sendKeys(value);
    }
    private void submit(){
        getWebDriver().findElement(By.cssSelector("[value='Рассчитать']")).click();
    }
    private List<String> getActualResult(){
        List<String> actualResult = new ArrayList<>();
        List<WebElement> result = getWebDriver().findElements(By.cssSelector("li div[id]"));
        result.forEach(webElement -> {
            actualResult.add(webElement.getText());
        });
        return actualResult;
    }
}