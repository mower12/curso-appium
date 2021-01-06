package testClases.cliente;


import pages.CarruselPage;
import pages.ClientePage;

public class TestCaseDos {

  CarruselPage carruselPage = new CarruselPage();
  ClientePage clientePage = new ClientePage();

  private String nombre = "Eduardo";
  private String producto = "Pantalla";
  private String cantidad = "2";


  public void frontEnd(){
      System.out.println("[Paso 1] - Reccorer carrusel");
      carruselPage.recorrerCarrusel();
      System.out.println("[Paso 2] - Dar clic boton hecho");
      carruselPage.clicHecho();
      System.out.println("[Paso 3] - Seleccionar cliente");
      clientePage.seleccionarCliente(nombre);
      System.out.println("[Paso 4] - Añadir venta");
      clientePage.aniadirVenta();
      System.out.println("[Paso 5] - Seleccionar producto");
      clientePage.seleccionarProducto(producto);
      System.out.println("[Paso 6] - Ingresar cantidad");
      clientePage.ingresarCantidad(cantidad);
      System.out.println("[Paso 7] - Confirmar venta");
      clientePage.confirmarDineroVenta();
      System.out.println("[Paso 8] - Validar monto");
      clientePage.validarValorVenta(cantidad,producto);


  }
}
