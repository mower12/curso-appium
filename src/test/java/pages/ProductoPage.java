package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.List;

import static reporte.Report.addStep;

public class ProductoPage extends Utils {

    private AppiumDriver driver;

    public ProductoPage(){
        this.driver= DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /**
     * Objetos
     */

    @AndroidFindBy(id ="com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnAgregar;
    @AndroidFindBy(id ="com.rodrigo.registro:id/action_cliente")
    private MobileElement btnAgregarUsuario;
    @AndroidFindBy(id ="com.rodrigo.registro:id/action_producto")
    private MobileElement btnAgregarProducto;
    @AndroidFindBy(xpath ="//*[contains(@text,\"PRODUCTOS\")]")
    private MobileElement pestaniaProductos;
    @AndroidFindBy(id ="com.rodrigo.registro:id/action_cliente")
    private MobileElement opcionCliente;
    @AndroidFindBy(id ="com.rodrigo.registro:id/action_producto")
    private MobileElement opcionProducto;
    @AndroidFindBy(id ="com.rodrigo.registro:id/nombre_producto")
    private MobileElement nombreProducto;
    @AndroidFindBy(id ="com.rodrigo.registro:id/precio")
    private MobileElement precio;
    @AndroidFindBy(id ="com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;
    @AndroidFindBy(id ="com.rodrigo.registro:id/nombre_producto")
    private List<MobileElement> labelProducto;
    @AndroidFindBy(id ="com.rodrigo.registro:id/precio_producto")
    private List<MobileElement> labelPrecio;


    public void validaProducto(String producto){
        System.out.println("[Registro Producto] - Validar Producto");
        boolean productoEncontrado = false;
        for(int i=0;i<=labelProducto.size(); i++){
            String nombreProductoActual = labelProducto.get(i).getText();
            if(nombreProductoActual.equals(producto)){
                productoEncontrado= true;
                break;
            }
        }
        if(productoEncontrado){
            addStep("Producto creado: "+producto, true, Status.PASSED,false);
        }else{
            addStep("No se pudo validar Producto creado", true, Status.FAILED,false);
        }
    }

    public void validaPrecio(String precio){
        System.out.println("[Registro precio] - Validar precio");
        boolean precioEncontrado = false;
        precio=precio+".00";
        for(int i=0;i<=labelPrecio.size(); i++){
            String precioActual = labelPrecio.get(i).getText();
            if(precioActual.equals(precio)){
                precioEncontrado= true;
                break;
            }
        }
        if(precioEncontrado){
            addStep("Precio: "+precio, true, Status.PASSED,false);
        }else{
            addStep("No se pudo validar precio", true, Status.FAILED,false);
        }
    }

    public void crearProducto(String nombreDelProducto, String precioProducto){
        Utils.esperaObjeto(nombreProducto,10);
        validarElemento(nombreProducto,"Nombre del producto",10);
        nombreProducto.click();
        nombreProducto.setValue(nombreDelProducto);
        this.driver.hideKeyboard();

        validarElemento(precio,"Precio del producto",10);
        precio.click();
        precio.setValue(precioProducto);
        this.driver.hideKeyboard();

        validarElemento(btnConfirmar,"Boton confirmar",10);
        btnConfirmar.click();
    }


    public void seleccionaCrearProducto(){
        validarElemento(btnAgregar,"Agregar",10);
        btnAgregar.click();
        validarElemento(opcionCliente,"Crear cliente",10);
        validarElemento(opcionProducto,"Crear producto",10);
        opcionProducto.click();
    }

    public void seleccionarPestaniaProducto(){
        validarElemento(pestaniaProductos,"Pestania productos",10);
        pestaniaProductos.click();
    }

}
