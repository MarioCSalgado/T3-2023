package com.mycompany.tarea3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.DisplayName;

public class ProductoTest {

    
    @Test
    @DisplayName("Test getSerie")
    public void testGetSerie() throws Exception{
        Sprite sprite1 = new Sprite(200);
        assertEquals(200, sprite1.getSerie());
        
        CocaCola coca1 = new CocaCola(101);
        assertEquals(101, coca1.getSerie());
    }
    
    @Test
    @DisplayName("Test queDegustaste")
    public void testQueDegustaste() throws Exception{
        Sprite sprite1 = new Sprite(201);
        assertEquals("sprite",sprite1.degustar());
    }
}
