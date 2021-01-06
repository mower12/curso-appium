package conexion;

import io.appium.java_client.AppiumDriver;

public class DriverContext {
    private static DriverManagger driverManager = new DriverManagger();

    public static void setUp(String nombreDispositivo,String SO, String app,String udid, boolean emulador){
        driverManager.iniciarSession(nombreDispositivo,SO,app,udid,emulador);
    }
    public static AppiumDriver getDriver(){
        return driverManager.getDriver();
    }
    public static void quitDriver(){
        driverManager.getDriver().quit();
    }
}
