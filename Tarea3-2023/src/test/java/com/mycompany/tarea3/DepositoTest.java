package com.mycompany.tarea3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class DepositoTest {

    
    @Test
    @DisplayName("Test size Deposito sin depositar nada")
    public void testSizeDeposito() throws Exception{
        Deposito<Bebida> depSizeTest= new Deposito<>();
        
        assertNotNull(depSizeTest.sizeDeposito());
    }
    
    @Test
    @DisplayName("Test size Deposito depositando varios productos")
    public void testSizeDepositoProductos() throws Exception{
        Deposito<Bebida> depSizeTest = new Deposito<>();
        CocaCola coca1 = new CocaCola(101);
        depSizeTest.addDeposito(coca1);
        CocaCola coca2 = new CocaCola(102);
        depSizeTest.addDeposito(coca2);
        Sprite sprite1 = new Sprite(201);
        depSizeTest.addDeposito(sprite1);
        Sprite sprite2 = new Sprite(202);
        depSizeTest.addDeposito(sprite2);
        
        assertNotNull(depSizeTest.sizeDeposito(),"Error el tamanio no es nulo");
        assertEquals(4,depSizeTest.sizeDeposito(),"El tamanio no es el correcto");
        
       
    }

    @Test
    @DisplayName("Test deposito vacio o sin Depositar ningun producto")
    public void testSinDepositarProducto(){
        Deposito<Bebida> depBebidaTest = new Deposito<>();
        Sprite sprite = new Sprite(200);

        int tamDep = depBebidaTest.sizeDeposito();

        assertEquals(0,tamDep,"Hubo un error en el almacenamiento");

    }

    @Test
    @DisplayName("Test depositar un producto")
    public void testDepositarProductoBebida() throws Exception{
        Deposito<Bebida> depBebidaTest = new Deposito<>();
        Sprite sprite = new Sprite(200);
        depBebidaTest.addDeposito(sprite);
        int tamDep = depBebidaTest.sizeDeposito();
    
        assertEquals(1, tamDep, "No se deposito correctamente el producto Bebida");
    }
    
    @Test
    @DisplayName("Test depositar dos productos")
    public void testDepositar2ProductosBebidas() throws Exception{
        Deposito<Bebida> depBebidaTest = new Deposito<>();
        Sprite sprite1 = new Sprite(201);
        depBebidaTest.addDeposito(sprite1);
        Sprite sprite2 = new Sprite(202);
        depBebidaTest.addDeposito(sprite2);
        
        int tamDep = depBebidaTest.sizeDeposito();
        
        assertEquals(2, tamDep, "No se depositaron correctamente los productos Bebidas");
    }
    
    @Test
    @DisplayName("Test Deposito de Dulces")
    public void testDepositarProductoDulce() throws Exception{
        Deposito<Dulce> depDulceTest = new Deposito<>();
        Super8 super8 = new Super8(300);
        depDulceTest.addDeposito(super8);
        
        int tamDep = depDulceTest.sizeDeposito();
        
        assertEquals(1,tamDep, "No se deposito correctamente el producto Dulce");
    }
    
    @Test
    @DisplayName("Test Deposito de Moneda")
    public void testDepositarMoneda() throws Exception{
        Deposito<Moneda> depMonedaTest = new Deposito<>();
        Moneda500 m500 = new Moneda500();
        depMonedaTest.addDeposito(m500);
        
        int tamDep = depMonedaTest.sizeDeposito();
        
        assertEquals(1,tamDep, "No se deposito correctamente la moneda");
    }
    
    @Test
    @DisplayName("Test getDeposito con Deposito vacio")
    public void testGetDepositoVacio() throws Exception{
        Deposito<Bebida> depBebidaTest = new Deposito<>();
        
        assertNull(depBebidaTest.getDeposito());
       
    }
    
    @Test
    @DisplayName("Test getDeposito con 1 producto")
    public void testGetDeposito1Producto() throws Exception {
        Deposito<Bebida> depBebidaTest = new Deposito<>();
        Sprite sprite1 = new Sprite(200);
        depBebidaTest.addDeposito(sprite1);
        
        assertNotNull(depBebidaTest.getDeposito());
    }
    
    @Test
    @DisplayName("Test getDeposito con varios productos")
    public void testGetDepositoVariosProductos() throws Exception{
        Deposito<Bebida> depBebidaTest = new Deposito<>();
        Sprite sprite1 = new Sprite(200);
        depBebidaTest.addDeposito(sprite1);
        CocaCola coca1 = new CocaCola(101);
        depBebidaTest.addDeposito(coca1);
        Sprite sprite2 = new Sprite(201);
        depBebidaTest.addDeposito(sprite2);
        
        assertNotNull(depBebidaTest.getDeposito());
        assertNotNull(depBebidaTest.getDeposito());
        assertNotNull(depBebidaTest.getDeposito());
    }
    
    @Test
    @DisplayName("Test getDeposito donde se piden mas productos de los que hay")
    public void testGetDepositoMenosProductos() throws Exception{
        Deposito<Bebida> depBebidaTest = new Deposito<>();
        Sprite sprite1 = new Sprite(200);
        depBebidaTest.addDeposito(sprite1);
        CocaCola coca1 = new CocaCola(101);
        depBebidaTest.addDeposito(coca1);
        Sprite sprite2 = new Sprite(201);
        depBebidaTest.addDeposito(sprite2);
        
        
        assertNotNull(depBebidaTest.getDeposito());
        assertNotNull(depBebidaTest.getDeposito());
        assertNotNull(depBebidaTest.getDeposito());
        assertNull(depBebidaTest.getDeposito());
       
    }
    
}


