package Lecture4;

import Driver.SimpleDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import static Driver.SimpleDriver.getWebDriver;
public class BMICalculator {
    @BeforeTest
    public void preconditions(){
        SimpleDriver simpleDriver = new SimpleDriver();
        getWebDriver().get("https://healthunify.com/bmicalculator/");
    }
    @Test
    public void test1() {
        getWebDriver().findElement(By.name("wg")).sendKeys("80");
        getWebDriver().findElement(By.name("ht")).sendKeys("180");
        getWebDriver().findElement(By.name("cc")).click();
        String expectedResult = "24.69";
        Assert.assertEquals(getWebDriver().findElement(By.name("si")).getAttribute("value"), expectedResult);
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getWebDriver().navigate().refresh();
    }
    @Test
    public void test2() {
        getWebDriver().findElement(By.name("wg")).sendKeys("90");
        getWebDriver().findElement(By.name("ht")).sendKeys("190");
        getWebDriver().findElement(By.name("cc")).click();
        String expectedResult = "Your category is Normal";
        Assert.assertEquals(getWebDriver().findElement(By.name("desc")).getAttribute("value"), expectedResult);
        getWebDriver().navigate().refresh();
    }
    @Test
    public void test3() {
        getWebDriver().findElement(By.name("wg")).sendKeys("100");
        getWebDriver().findElement(By.name("ht")).sendKeys("190");
        getWebDriver().findElement(By.name("cc")).click();
        String expectedResult = "Your category is Overweight";
        Assert.assertEquals(getWebDriver().findElement(By.name("desc")).getAttribute("value"), expectedResult);
        getWebDriver().navigate().refresh();
    }
    @Test
    public void test4() {
        getWebDriver().findElement(By.name("wg")).sendKeys("50");
        getWebDriver().findElement(By.name("ht")).sendKeys("190");
        getWebDriver().findElement(By.name("cc")).click();
        String expectedResult = "Your category is Starvation";
        Assert.assertEquals(getWebDriver().findElement(By.name("desc")).getAttribute("value"), expectedResult);
        getWebDriver().navigate().refresh();
    }
    @Test
    public void test5(){
        getWebDriver().findElement(By.name("wg")).sendKeys("84");
        Select selectWeight = new Select(getWebDriver().findElement(By.name("opt1")));
        selectWeight.selectByValue("pounds");
        Select selectHeight1 = new Select(getWebDriver().findElement(By.name("opt2")));
        selectHeight1.selectByValue("6");
        Select selectHeight2 = new Select(getWebDriver().findElement(By.name("opt3")));
        selectHeight2.selectByValue("4");
        getWebDriver().findElement(By.name("cc")).click();
        String expectedResult = "Your category is Obese";
        Assert.assertEquals(getWebDriver().findElement(By.name("desc")).getAttribute("value"), expectedResult);
        getWebDriver().quit();
    }
}
