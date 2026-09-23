package com.zaidi;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import org.junit.jupiter.api.Test;

public class TestingPerformance {

    @Test 
    void testSortingMethod_Performance() {
        SortingArray array = new SortingArray();

        int[] unsorted = {10, 5, 6, 2};

        assertTimeout(Duration.ofMillis(10), () -> array.sortingArray(unsorted));
    }
}