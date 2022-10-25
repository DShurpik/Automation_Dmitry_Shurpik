package Lecture14.entity;

import lombok.*;

@Getter
@Setter
@ToString

// аннотации lombok заменяют сеттеры-геттеры и метод toString

@AllArgsConstructor // генерация всех типов конструкторов, заменяет написание конструкторов
@NoArgsConstructor

@Data // заменяет аннотации @Getter @Setter @ToString

public class Person {

    String firstName;
    String lastName;
    String address;
    Integer age;
    String sex;
    String id;

}