package com.mycompany.tarea3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

public class MonedaTest {
    @Test
    @DisplayName("Test getValor moneda") 
    public void TestGetValor() throws Exception {
        Moneda100 m100 = new Moneda100();
        
        int test= m100.getValor();
        
        assertNotNull(test);
        assertEquals(100, test, "El valor obtenido para moneda no es correcto");
    }
   
}
