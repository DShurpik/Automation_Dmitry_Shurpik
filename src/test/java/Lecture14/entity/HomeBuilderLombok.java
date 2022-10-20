package Lecture14.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
// @Builder заменяет строки текста как было в классе Home на меньшее количество строк кода, что упрощает использование патерна Builder
@Builder(builderClassName = "HomeBuilder", setterPrefix = "with", buildMethodName = "create") // можно настраивать билдер, переназвали метод

public class HomeBuilderLombok {
    String doors;
    String color;
    String address;
    Integer winCount;
    Boolean old;

    // чтобы не было ошибки с доступом при вызове билдера, пересоздаем конструктор с публичным модификатором доступа
    // конструктор делается при работе не из одного пакета, т.к по умолчанию у билдера модификатор доступа протектед
    public static class HomeBuilder{
        public HomeBuilder(){
        }
    }
}
