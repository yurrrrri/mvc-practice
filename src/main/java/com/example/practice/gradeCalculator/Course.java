package com.example.practice.gradeCalculator;

import lombok.Getter;

@Getter
public class Course {

    private final String subject;
    private final int credit;
    private final String grade;

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public double getGradeToNumber() {
        return switch (this.grade) {
            case "A+" -> 4.5;
            case "A" -> 4.0;
            case "B+" -> 3.5;
            case "B" -> 3.0;
            case "C+" -> 2.5;
            case "C" -> 2.0;
        };
    }

}
