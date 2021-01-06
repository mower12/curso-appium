package testSuites;

import conexion.DriverContext;
import junit.framework.TestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.cliente.TestCaseDos;
import testClases.cliente.TestCaseUltimaClase;
import testClases.producto.TestCaseUno;
import static reporte.Report.finalAssert;

public class EjecucionCasos extends DriverContext {

    @BeforeMethod
    public void iniciarSession(){
        setUp("emulator-5554","android","/Users/carlosfuentes/Downloads/registroDeUsuarios.apk","",true);
    }

    @Test(priority = 1 , description = "TestCase Ultima clase")
    public void testCaseUltimaClase(){
        TestCaseUltimaClase testCaseUltimaClase = new TestCaseUltimaClase();
        testCaseUltimaClase.frontEnd();
        finalAssert();

    }
    @Test(priority = 2, description = "TestCase Uno")
    public void testCaseUno(){
        TestCaseUno testCaseUno = new TestCaseUno();
        testCaseUno.frontEnd();
        finalAssert();

    }
    @Test(priority = 3, description = "TestCase Dos")
    public void testCaseDos(){
        TestCaseDos testCaseDos = new TestCaseDos();
        testCaseDos.frontEnd();
        finalAssert();

    }

    @AfterMethod
    public void cerrarSession(){
        DriverContext.quitDriver();
    }

}
