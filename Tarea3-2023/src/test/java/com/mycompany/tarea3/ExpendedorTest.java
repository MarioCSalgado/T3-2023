package com.mycompany.tarea3;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpendedorTest {

    private Expendedor expTest;

    @BeforeEach
    public void setUp() {
        expTest = new Expendedor(3);
    }

    
    @Test
    @DisplayName("Test Un Producto")
    public void testComprarUnProducto() throws Exception {
        Moneda m = new Moneda1000();

        assertNotNull(expTest.comprarProducto(m, Expendedor.COCA));
    }

    @Test
    @DisplayName("Test Tres Productos")
    public void testComprarTresProductos() throws Exception {
        Moneda m = new Moneda1000();

        assertNotNull(expTest.comprarProducto(m, Expendedor.COCA));
        assertNotNull(expTest.comprarProducto(m, Expendedor.COCA));
        assertNotNull(expTest.comprarProducto(m, Expendedor.COCA));
    }

    @Test
    @DisplayName("Test NoHayProductoException")
    public void testComprarCuatroBebidas() {
        Moneda m = new Moneda1500();
        Exception exception = assertThrows(NoHayProductoException.class,()->{
            expTest.comprarProducto(m, Expendedor.COCA);
            expTest.comprarProducto(m, Expendedor.COCA);
            expTest.comprarProducto(m, Expendedor.COCA);
            expTest.comprarProducto(m, Expendedor.COCA);
        });
    }

    @Test
    @DisplayName("Test NoHayProductoException")
    public void testComprarCuatroDulcesy1Bebida() {
        Moneda m = new Moneda1500();
        Exception exception = assertThrows(NoHayProductoException.class,()->{
            expTest.comprarProducto(m, Expendedor.TRENCITO);
            expTest.comprarProducto(m, Expendedor.TRENCITO);
            expTest.comprarProducto(m, Expendedor.COCA);
            expTest.comprarProducto(m, Expendedor.TRENCITO);
            expTest.comprarProducto(m, Expendedor.TRENCITO);
        });
    }

    
    
    @Test
    @DisplayName("Test Comprar Producto y comprobar el vuelto")
    public void testCompradorConDineroJusto() throws Exception{
        Moneda m = new Moneda1000();

        expTest.comprarProducto(m, Expendedor.SPRITE);
        Moneda m100 = new Moneda100();
        assertEquals(m100.getValor(),expTest.getVuelto().getValor(),"No retorno la cantidad de vuelto exacta");
    }


    @Test
    @DisplayName("Test Comprobar vuelto sumando las monedas")
    public void TestGetVueltoConDinero() throws Exception{
        Moneda m = new Moneda1500();

        expTest.comprarProducto(m, Expendedor.SPRITE);

        int vuelto=0;
        Moneda monedaOut= expTest.getVuelto();
        while(monedaOut != null){
            vuelto= vuelto + monedaOut.getValor();
            monedaOut=expTest.getVuelto();
        }

        assertEquals(600, vuelto,"No se obtuvo el vuelto correcto");
    }



    @Test
    @DisplayName("Test PagoInsuficienteException")
    public void testCompradorConDineroInsuficiente(){
        Moneda m = new Moneda100();
   
        Exception exception = assertThrows(PagoInsuficienteException.class,()->{
            expTest.comprarProducto(m, Expendedor.COCA);
        });
    }
    
     
   @Test
   @DisplayName("Test PagoIncorrectoException")
   public void TestCompradorPagoIncorrecto(){
        Moneda m = null;
        
        Exception exception = assertThrows(PagoIncorrectoException.class, ()->{
           expTest.comprarProducto(m, Expendedor.COCA);
        });
   }
   
   @Test
   @DisplayName("Test Producto Invalido")
   public void TestComprador(){
       Moneda m= new Moneda1000();
       
       Exception exception = assertThrows(NoHayProductoException.class, ()->{
           expTest.comprarProducto(m, 5);
       });
   }

    
}
