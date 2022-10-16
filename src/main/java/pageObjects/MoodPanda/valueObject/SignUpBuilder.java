package pageObjects.MoodPanda.valueObject;

public class SignUpBuilder {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean checkbox;


    public static class Builder{
        private SignUpBuilder signUpBuilder; // объект внешнего класса

        public Builder withFirstName(String firstName) {
            signUpBuilder.firstName = firstName;
            return this;
        }

        // через сеттеры происходит наполнение данными

        public Builder withLastName(String lastName) {
            signUpBuilder.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            signUpBuilder.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            signUpBuilder.password = password;
            return this;
        }

        public Builder withCheckbox(Boolean checkbox) {
            signUpBuilder.checkbox = checkbox;
            return this;
        }

        public Builder(){ // создается конструктор статического класса
            this.signUpBuilder = new SignUpBuilder();
        }

        public SignUpBuilder build(){ // вызывается в конце и возвращает собранный объект с помощью сеттеров
            return signUpBuilder;
        }
    }
    @Override
    public String toString() {
        return "SignUpBuilder{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", checkbox=" + checkbox +
                '}';
    }


}
