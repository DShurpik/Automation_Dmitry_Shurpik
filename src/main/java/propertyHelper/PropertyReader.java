package propertyHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    // Для того чтобы получать property, которую дальше будем пробрасывать через getProperty

    private static Properties properties; // создаем статическую переменную

    // реализуем конструктор, который будет отвечать за работу с загрузкой property

    public PropertyReader(String propertyName){ //на вход подаем имя property
        properties = new Properties(); // инициализация объекта propertyes
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/" + propertyName + ".properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
