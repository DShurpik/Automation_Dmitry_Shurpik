package Task_9;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test(dataProvider = "login data", groups = "smoke", invocationCount = 2, priority = 1)
    public void loginTestPositiveAndNegative(String username, String password){
        new LoginPage()
                .open()
                .enterUsername(username)
                .enterPassword(password)
                .clickLogin()
                .verifyThatLoginPageIsClosed();
    }

    @DataProvider(name = "login data")
    public Object[][] getData(){
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "badPassword1"},
                {"problem_user", "badPassword2"},
                {"performance_glitch_user", "badPassword3"}
        };
    }
}
