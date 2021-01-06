package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.model.Status;
import utils.Utils;

import java.util.List;

import static reporte.Report.addStep;

public class CarruselPage extends Utils {

    private AppiumDriver driver;

    public CarruselPage(){
        this.driver= DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */
    @AndroidFindBy(id ="com.rodrigo.registro:id/imageView2")
    private MobileElement iconoVista1;
    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement tituloVista;
    @AndroidFindBy(id ="com.rodrigo.registro:id/textView")
    private MobileElement descripcion;
    @AndroidFindBy(id ="com.rodrigo.registro:id/next")
    private MobileElement btnFlecha;
    @AndroidFindBy(id ="com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement btnAllow;
    @AndroidFindBy(id ="com.rodrigo.registro:id/done")
    private MobileElement btnDone;

    public void recorrerCarrusel(){
        for (int i = 0; i <3 ; i++) {
            if(btnFlecha.isEnabled()){
                addStep("Se visualiza boton avanzar", true, Status.PASSED,false);
                btnFlecha.click();
            }else{
                addStep("No se visualiza boton avanzar", true, Status.FAILED,true);
            }
        }
    }
    public void clicHecho(){
        validarElemento(btnAllow,"Visualizar boton allow",4);
        try{
            if(btnAllow.isDisplayed()){
                btnAllow.click();
            }
        }catch (Exception e){ }
        btnDone.click();
    }
}
