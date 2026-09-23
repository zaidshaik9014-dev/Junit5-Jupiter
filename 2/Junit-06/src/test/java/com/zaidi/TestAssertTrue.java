package com.zaidi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TestAssertTrue {
    @Test 
    void test() {

        String str1 = "Junit5";
        assertTrue(str1.equals("Junit5"));

        String str = "Junit5";
        assertFalse(str.length() < 5);
    }
}