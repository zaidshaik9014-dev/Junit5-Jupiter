package com.zaidi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import com.zaidi.service.PurchaseCourse;

class TestPurchaseCourse {
    @Test 
    void testProceedWithCourse() {
        PurchaseCourse pc = new PurchaseCourse();

        boolean status = pc.proceedWithCourse(new JavaCourse());
        // assertTrue(status, "It failed bcoz unit results in true");
        assertFalse(status, "It failed bcoz unit results in true");
    }
}