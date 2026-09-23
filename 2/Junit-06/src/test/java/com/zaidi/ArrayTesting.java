package com.zaidi;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class ArrayTesting {
    @Test 
    void test() {
        int[] expected = {2, 4, 6, 8};
        int[] actual = {4, 8, 6, 2};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
        /*assertEquals(expected, actual); this wont wrok and fails,
        in java the each array stored in heap compared as two diff
        objects and the elements in arrays are not use for compare*/
    }
}