package PageObject.BaseObject;

import Driver.SimpleDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static Driver.SimpleDriver.closeWebDriver;

public abstract class BaseTest {
    @BeforeTest
    public void preconditions() {
        System.out.println("I'm started new wed driver!");
        new SimpleDriver();
    }

    @AfterTest
    public void postconditions(){
        System.out.println("I'm close wed driver!");
        closeWebDriver();
    }
}
