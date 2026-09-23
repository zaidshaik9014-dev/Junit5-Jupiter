package com.zaidi;

public class SpringBootCourse implements Course {
    @Override 
    public boolean coursePurchased() {
        System.out.println("SpringBoot course purchased");
        return true;
    }
}