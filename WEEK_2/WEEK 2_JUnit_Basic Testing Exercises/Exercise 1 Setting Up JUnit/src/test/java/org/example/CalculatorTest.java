package org.example;

import org.junit.Test;
import static org.junit.Assert.*;


public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        System.out.println("Result of 2 + 3 = " + result);  
        assertEquals(5, result);
    }
}
