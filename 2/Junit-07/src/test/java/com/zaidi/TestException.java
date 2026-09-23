package com.zaidi;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class TestException {

    @Test 
    void testSortingArray_Exception() {

        // try {

        SortingArray array = new SortingArray();
        
        // int[] unsorted = {5, 6, 3, 90, -1};

        // int[] sortedArray = array.sortingArray(unsorted);//occur exception for null valuse sort
        // for (int ele : sortedArray) {
        //     System.out.print(ele + " ");
        // }

        // System.out.println("Statements below exception");
        // //Above line wont execute bcoz its after the exception statement.

        // fail();
        // }

        // catch(NullPointerException e) {
        //     System.out.println("Exception generated");
        // }
        
        int[] unsorted = null;
        assertThrows(NullPointerException.class, () -> {
            array.sortingArray(unsorted);
        });
    }
}