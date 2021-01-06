package testClases.cliente;


import pages.CarruselPage;
import pages.ClientePage;

public class TestCaseUltimaClase {

  CarruselPage carruselPage = new CarruselPage();
  ClientePage clientePage = new ClientePage();

  private String nombre = "Eduardo";
  private String id = "123";
  private String telefono = "912345678";
  private String direccion = "Calle falsa";
  private String notas = "Esto es un test";


  public void frontEnd(){
      System.out.println("[Paso 1] - Reccorer carrusel");
      carruselPage.recorrerCarrusel();
      System.out.println("[Paso 2] - Dar clic boton hecho");
      carruselPage.clicHecho();
      System.out.println("[Paso 3] - Validar boton cliente y producto");
      clientePage.validaBtnClienteYProducto();
      System.out.println("[Paso 4] - Agregar usuario");
      clientePage.agregarUsuario();
      System.out.println("[Paso 5] - Completar datos requeridos para crear usuario");
      clientePage.completarDatosUsuario(nombre,id,telefono,direccion,notas);
      System.out.println("[Paso 6] - Dar clic en boton guardad");
      clientePage.clicGuardar();
      System.out.println("[Paso 7] - Validar cliente creado");
      clientePage.validarCliente(nombre);
  }
}
