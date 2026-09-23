package com.zaidi.service;

import com.zaidi.Course;

public class PurchaseCourse {
    private Course course;

    public boolean proceedWithCourse(Course course) {
        return course.coursePurchased();
    }
}