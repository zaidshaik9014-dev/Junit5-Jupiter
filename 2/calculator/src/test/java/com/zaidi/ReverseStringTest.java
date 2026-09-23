package com.zaidi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ReverseStringTest {

    //ReverseString reverse = new ReverseString();
    @Test 
    void testReverseString_OneWord() {
        ReverseString reverse = new ReverseString();

        assertEquals("avaJ", reverse.revStr("Java"));
    }

    @Test 
    void testReverseString_MultipleWords() {
        ReverseString reverse = new ReverseString(); //can be written outside this void method

        assertEquals(".ysae si avaJ", reverse.revStr("Java is easy."));
    }
}
