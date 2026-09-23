package com.zaidi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ShapesTest {

    ShapesTest() {
        System.out.println("Test obj is created before test method");
    }

    //beforeAll and afterAll doent need a class to invoke
    @BeforeAll //before all should invoke with static
    void beforeAll() {
        System.out.println("Before all tests");
    }

    //and no need of instance if the TestInstance helping us to create only once.

    @AfterAll 
    void afterAll() {
        System.out.println("After all tests");
    }

    Shapes shape;

    @BeforeEach 
    void init() {
        shape = new Shapes();
        System.out.println("Before test");
    }

    @Test 
    void testcomputeSqArea() {
        assertNotEquals(5765, shape.computeSqArea(24));
        System.out.println("Actual test running");
    }

    @Test 
    void testComputeCircleArea() {
        assertEquals(78.5, shape.computeCircleArea(5));
        System.out.println("Actual test running");    
    }

    @AfterEach 
    void destroy() {
        System.out.println("After test clean up");
    }
}
