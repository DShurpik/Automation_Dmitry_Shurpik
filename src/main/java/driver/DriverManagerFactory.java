package driver;

import io.github.bonigarcia.wdm.config.DriverManagerType;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverManagerType driverManagerType){
        // на вход метода придет drivermanagertype, и обратиться к соответствующему кейсу, и запишет соответсвующий браузер
        DriverManager driverManager = null;
        switch (driverManagerType){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
        }
        return driverManager;
    }
}
