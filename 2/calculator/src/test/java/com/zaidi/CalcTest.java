package com.zaidi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalcTest {

    @Test
    void testDivide() {

        int result = Calc.divide(50, 10);

        assertEquals(5, result);
    }
}