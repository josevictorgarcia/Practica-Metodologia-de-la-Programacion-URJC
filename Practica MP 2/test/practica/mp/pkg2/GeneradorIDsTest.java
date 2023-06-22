/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package practica.mp.pkg2;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Alex
 */
public class GeneradorIDsTest {
    
    public GeneradorIDsTest() {
    }

    /**
     * Test of getID method, of class GeneradorIDs.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        GeneradorIDs instance = new GeneradorIDs();
        String expResult = "A00AA";
        String result = instance.getID();
        assertEquals(expResult, result);
    }
    
}
