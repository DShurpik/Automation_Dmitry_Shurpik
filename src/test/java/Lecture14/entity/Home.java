package Lecture14.entity;

public class Home {
    String doors;
    String color;
    String address;
    Integer winCount;
    Boolean old;

    public static class Builder{
        public Home home; // создается переменная внешнего класса

        public Builder(){
            this.home = new Home(); // инициализация внешний объект класса через внутренний конструктор, и наполняем через сеттеры
        }

        public Builder withDoors(String doors){
            // делаем Builder чтобы возвращать ссылку на объект паттерн chain
            // метод принимает строку и присваевает то значение которое зададим
            home.doors = doors;
            return this;
        }

        public Builder withColor(String color){
            home.color = color;
            return this;
        }

        public Builder withAddress(String address){
            home.address = address;
            return this;
        }

        public Builder withWinCount(Integer winCount){
            home.winCount = winCount;
            return this;
        }

        public Builder withOld(Boolean old){
            home.old = old;
            return this;
        }

        public Home build(){
            return home;
        }


    }

    @Override
    public String toString() {
        return "Home{" +
                "doors='" + doors + '\'' +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                ", winCount=" + winCount +
                ", old=" + old +
                '}';
    }
}
