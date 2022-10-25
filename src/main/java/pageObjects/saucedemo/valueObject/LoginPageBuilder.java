package pageObjects.saucedemo.valueObject;

import lombok.Builder;
import lombok.Data;

@Data

public class LoginPageBuilder {

    String userName;
    String password;

    public static class Builder{

        private LoginPageBuilder loginPageBuilder; // объект внешнего класса

        // заполнили данными значения объекта

        public Builder withUserName(String userName){
            loginPageBuilder.userName = userName;
            return this;
        }

        public Builder withPassword(String password){
            loginPageBuilder.password = password;
            return this;
        }

        public Builder(){
            this.loginPageBuilder = new LoginPageBuilder();
        }

        public LoginPageBuilder build(){
            return loginPageBuilder;
        }
    }
}
