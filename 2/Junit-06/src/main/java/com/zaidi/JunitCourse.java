package com.zaidi;

public class JunitCourse implements Course {
    @Override 
    public boolean coursePurchased() {
        System.out.println("JunitCourse course purchased");
        return true;
    }
}