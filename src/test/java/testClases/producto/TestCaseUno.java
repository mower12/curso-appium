package testClases.producto;


import pages.CarruselPage;
import pages.ProductoPage;

public class TestCaseUno {

  CarruselPage carruselPage = new CarruselPage();
  ProductoPage productoPage = new ProductoPage();

  private String nombreProducto = "Pantalla";
  private String precio = "1234";

  public void frontEnd(){
      System.out.println("[Paso 1] - Reccorer carrusel");
      carruselPage.recorrerCarrusel();
      System.out.println("[Paso 2] - Dar clic boton hecho");
      carruselPage.clicHecho();
      System.out.println("[Paso 3] - Seleccionar pestania producto");
      productoPage.seleccionarPestaniaProducto();
      System.out.println("[Paso 4] - Crear producto");
      productoPage.seleccionaCrearProducto();
      System.out.println("[Paso 5] - Completar datos requeridos para crear producto");
      productoPage.crearProducto(nombreProducto,precio);
      System.out.println("[Paso 6] - Validar producto creado");
      productoPage.validaProducto(nombreProducto);
      System.out.println("[Paso 7] - Validar precio del producto creado");
      productoPage.validaPrecio(precio);



  }
}
