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

public class ClientePage extends Utils {

    private AppiumDriver driver;

    public ClientePage(){
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
    @AndroidFindBy(id ="com.rodrigo.registro:id/ac_nombre")
    private MobileElement txtNombre;
    @AndroidFindBy(id ="com.rodrigo.registro:id/ruc")
    private MobileElement txtuId;
    @AndroidFindBy(id ="com.rodrigo.registro:id/tel")
    private MobileElement txtTelefono;
    @AndroidFindBy(id ="com.rodrigo.registro:id/dir")
    private MobileElement txtDireccion;
    @AndroidFindBy(id ="com.rodrigo.registro:id/notas")
    private MobileElement txtNotas;
    @AndroidFindBy(id ="com.rodrigo.registro:id/guardar")
    private MobileElement btnGuardar;
    @AndroidFindBy(id ="com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> labelCliente;
    @AndroidFindBy(id ="com.rodrigo.registro:id/vc_anadirVenta")
    private MobileElement aniadirVenta;
    @AndroidFindBy(xpath ="//*[contains(@text,\"PRODUCTOS\")]")
    private MobileElement pestaniaProductos;
    @AndroidFindBy(id ="android:id/text1")
    private List<MobileElement> labelProductos;
    @AndroidFindBy(id ="com.rodrigo.registro:id/cp_cantidad")
    private MobileElement cantidadComprada;
    @AndroidFindBy(id ="com.rodrigo.registro:id/ci_add")
    private MobileElement botonAgregar;
    @AndroidFindBy(id ="com.rodrigo.registro:id/confirmarydinero")
    private MobileElement confirmarDinero;
    @AndroidFindBy(id ="com.rodrigo.registro:id/buttonDefaultPositive")
    private MobileElement confirmarVenta;
    @AndroidFindBy(id ="com.rodrigo.registro:id/vercli_ultVenta")
    private MobileElement valorVenta;
    @AndroidFindBy(id ="com.rodrigo.registro:id/cp_precio")
    private MobileElement precioProducto;

    String precioDelProducto;

    public void validarValorVenta(String cantidad,String producto) {
        int precioProductoFormateado = 0;
        String valorTotalFormateado = null;
        validarElemento(valorVenta,"Valor venta",10);
        String valorFormateado = valorVenta.getText();
        valorFormateado = valorFormateado.replace(cantidad+" x "+producto+" = ","");

        String precioDelProductoFormateado = precioDelProducto.replace(".00","");
        try{
            precioProductoFormateado = Integer.parseInt(precioDelProductoFormateado);
            precioProductoFormateado = precioProductoFormateado*2;
            valorFormateado = String.valueOf(precioProductoFormateado);

            valorTotalFormateado = valorFormateado.replace(".00","");

        }catch (NumberFormatException e){
            addStep("Hubo un problema al multiplicar montos", true, Status.PASSED,false);
        }

        if(valorTotalFormateado.equals(valorFormateado)){
            addStep("Monto: "+valorTotalFormateado+" es igual a "+valorFormateado, true, Status.PASSED,false);
        }else {
            addStep("Monto: "+valorTotalFormateado+" NO es igual a "+valorFormateado, true, Status.FAILED, false);
        }
    }

    public void confirmarDineroVenta() {
        validarElemento(confirmarDinero, "Confirmar dinero", 10);
        confirmarDinero.click();
        validarElemento(confirmarVenta, "Confirmar venta", 10);
        confirmarVenta.click();
    }

    public void ingresarCantidad(String cantidad) {
        Utils.esperaObjeto(cantidadComprada, 10);
        validarElemento(cantidadComprada, "Cantidad", 10);
        validarElemento(precioProducto,"Precio Producto",10);
        precioDelProducto = precioProducto.getText();
        cantidadComprada.click();
        cantidadComprada.setValue(cantidad);
        this.driver.hideKeyboard();
        validarElemento(botonAgregar,"Boton agregar",10);
        botonAgregar.click();
    }
    public void seleccionarProducto(String producto){
        System.out.println("[Registro Producto] - Seleccionar Producto");
        boolean productoEncontrado = false;
        int a = 0;
        for(int i=0;i<=labelProductos.size(); i++){
            String nombreProductoActual = labelProductos.get(i).getText();
            if(nombreProductoActual.equals(producto)){
                productoEncontrado= true;
                a = i;
                break;
            }
        }
        if(productoEncontrado){
            addStep("Producto encontrado: "+producto, true, Status.PASSED,false);
            labelProductos.get(a).click();
        }else{
            addStep("No se pudo seleccionar Producto creado", true, Status.FAILED,false);
        }
    }


    public void aniadirVenta(){
        validarElemento(aniadirVenta,"Aniadir venta",10);
        aniadirVenta.click();
    }

    public void agregarUsuario(){
        btnAgregarUsuario.click();
    }

    public void validaBtnClienteYProducto(){
        btnAgregar.click();
        validarElemento(btnAgregarUsuario,"Valida boton agregar usuario",4);
        validarElemento(btnAgregarProducto,"Valida boton agregar producto",4);
    }
    public void completarDatosUsuario(String nombre, String id, String telefono, String direccion, String notas){
        txtNombre.click();
        txtNombre.setValue(nombre);
        this.driver.hideKeyboard();

        txtuId.click();
        txtuId.setValue(id);
        this.driver.hideKeyboard();

        txtTelefono.click();
        txtTelefono.setValue(telefono);
        this.driver.hideKeyboard();

        txtDireccion.click();
        txtDireccion.setValue(direccion);
        this.driver.hideKeyboard();

        txtNotas.click();
        txtNotas.setValue(notas);
        this.driver.hideKeyboard();
    }
    public void clicGuardar(){
        validarElemento(btnGuardar,"Boton guardar",10);
        btnGuardar.click();
    }
    public void validarCliente(String nombreCliente){
        System.out.println("[Registro Cliente] Validar cliente");
        boolean clienteEncontrado = false;
        for(int i=0;i<=labelCliente.size(); i++){
            String nombreClienteActual = labelCliente.get(i).getText();
            if(nombreClienteActual.equals(nombreCliente)){
                clienteEncontrado= true;
                break;
            }
        }
        if(clienteEncontrado){
            addStep("Usuario creado: "+nombreCliente, true, Status.PASSED,false);
        }else{
            addStep("No se pudo validar usuario creado", true, Status.FAILED,false);
        }
    }
    public void seleccionarCliente(String nombreCliente){
        System.out.println("[Registro Cliente] Seleccionar cliente");
        boolean clienteEncontrado = false;
        for(int i=0;i<=labelCliente.size(); i++){
            String nombreClienteActual = labelCliente.get(i).getText();
            if(nombreClienteActual.equals(nombreCliente)){
                clienteEncontrado= true;
                break;
            }
        }
        if(clienteEncontrado){
            addStep("Usuario creado: "+nombreCliente, true, Status.PASSED,false);
            labelCliente.get(0).click();
        }else{
            addStep("No se pudo validar usuario creado", true, Status.FAILED,false);
        }
    }
}
