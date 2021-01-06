package utils;

import conexion.DriverContext;
import io.appium.java_client.MobileElement;
import io.qameta.allure.model.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static reporte.Report.addStep;

public class Utils {

    public static boolean esperaObjeto(MobileElement elemento, int segundos){
        try{
            System.out.println("Buscamos elemento: "+elemento+", esoeramos: "+segundos+" segundos, hasta que aparezca");
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), segundos);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            System.out.println("Se encontro elemento: "+elemento);
            return true;
        }catch (Exception e){
            System.out.println("No se encontro el elemento: "+elemento);
            return false;
        }
    }

    public void validarElemento(MobileElement elemento,String nombre, int segundos){
        try{
            System.out.println("Buscamos elemento: "+elemento+", esoeramos: "+segundos+" segundos, hasta que aparezca");
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), segundos);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            if(elemento.isEnabled()){
                addStep("[Exitoso] Se despliega elemento: "+nombre, true, Status.PASSED,false);
            }else{
                addStep("[Fallado] No se despliega elemento: "+nombre, true, Status.FAILED,false);
            }
        }catch (Exception e){
            addStep("[Fallado] No se despliega elemento: "+nombre, true, Status.FAILED,false);
        }


    }

}
