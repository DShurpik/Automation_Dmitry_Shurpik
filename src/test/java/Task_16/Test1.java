package Task_16;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.onliner.MainPage;

public class Test1 extends BaseTest {

    @Test
    public void test1() {
        get(MainPage.class);
    }


}
