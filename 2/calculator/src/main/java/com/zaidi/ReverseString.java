package com.zaidi;

public class ReverseString {
    public static String revStr(String str) {
        char[] a = str.toCharArray();
        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            char temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            left++;
            right--;
        }

        return new String(a);
    }
}
