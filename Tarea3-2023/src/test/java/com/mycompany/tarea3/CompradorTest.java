package com.mycompany.tarea3;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
class CompradorTest {
    private Expendedor exp;
    private Moneda mon1500,mon1000,mon500,mon100,monnull;
    private Comprador c;

    @BeforeEach
    public void setUp() {
        exp = new Expendedor(4);
        mon1500 = new Moneda1500();
        mon1000= new Moneda1000();
        mon500 = new Moneda500();
        mon100 = new Moneda100();
        monnull=null;
    }

    @Test
    @DisplayName("prueba cuantoVuelto,casos normales,coca")
    public void testCuantoVuelto1() throws Exception {
        //casos coca
        c = new Comprador(mon1500, Expendedor.COCA, exp);
        assertEquals(600, c.cuantoVuelto());
        c = new Comprador(mon1000, Expendedor.COCA, exp);
        assertEquals(100, c.cuantoVuelto());
    }
    @Test
    @DisplayName("prueba cuantoVuelto,casos normales, Super8")
    public void testCuantoVuelto2() throws Exception {
        //casos super8
        c = new Comprador(mon1500, Expendedor.SUPER8, exp);
        assertEquals(1200, c.cuantoVuelto());
        c = new Comprador(mon1000, Expendedor.SUPER8, exp);
        assertEquals(700, c.cuantoVuelto());
        c = new Comprador(mon500, Expendedor.SUPER8, exp);
        assertEquals(200, c.cuantoVuelto());
    }
    @Test
    @DisplayName("test cuantoVuelto, con PagoInsuficienteException")
    public void testCuantoVuelto3(){
        Exception exception=assertThrows(PagoInsuficienteException.class,()->{
            c = new Comprador(mon500,Expendedor.TRENCITO,exp);
        });
    }
    @Test
    @DisplayName("test cuantoVuelto, con PagoIncorrectoException")
    public void testCuantoVuelto4(){
        Exception exception=assertThrows(PagoIncorrectoException.class,()->{
            c=new Comprador(monnull,Expendedor.COCA,exp);
        });
    }
    @Test
    @DisplayName("que Degustaste,casos normales Super8")
    public void testqueDegustaste1() throws Exception{
        c = new Comprador(mon1500, Expendedor.SUPER8, exp);
        assertEquals("Super8",c.queDegustaste(),"error");
    }
    @Test
    @DisplayName("que Degustaste,casos normales Coca")
    public void testqueDegustaste2() throws Exception{
        c = new Comprador(mon1500, Expendedor.COCA, exp);
        assertEquals("cocacola",c.queDegustaste(),"error");
    }
}


