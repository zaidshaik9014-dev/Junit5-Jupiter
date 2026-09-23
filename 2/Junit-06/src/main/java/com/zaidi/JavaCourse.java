package com.zaidi;

public class JavaCourse implements Course {
    @Override 
    public boolean coursePurchased() {
        System.out.println("Java course purchased");
        System.out.println("Its not actually connecting to db hence results in false");
        return false;
    }
}