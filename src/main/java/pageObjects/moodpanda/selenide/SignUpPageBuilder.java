package pageObjects.moodpanda.selenide;

public class SignUpPageBuilder {

    String firstName;
    String lastNameInitial;
    String email;
    String password;

    public static class Builder{
        private SignUpPageBuilder signUpPageBuilder;

        public Builder withFirstName(String firstName){
            signUpPageBuilder.firstName = firstName;
            return this;
        }

        public Builder withLastNameInitial(String lastNameInitial){
            signUpPageBuilder.lastNameInitial = lastNameInitial;
            return this;
        }

        public Builder withEmail(String email){
            signUpPageBuilder.email = email;
            return this;
        }

        public Builder withPassword(String password){
            signUpPageBuilder.password = password;
            return this;
        }

        public Builder(){
            this.signUpPageBuilder = new SignUpPageBuilder();
        }

        public SignUpPageBuilder build(){
            return signUpPageBuilder;
        }
    }
}
