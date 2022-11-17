package Task_15;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.tableHTML.Table;

public class Task15_HTML_test extends BaseTest {


    @Test
    public void test1() throws InterruptedException {
        get(Table.class).open().sendText("ASdfasf");


    }

}
