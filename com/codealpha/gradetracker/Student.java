package com.codealpha.gradetracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student with their name, roll number, and list of grades.
 * Author: Muhammad Amir | GitHub: codewith-amir
 * CodeAlpha Java Internship — Task 1: Student Grade Tracker
 */
public class Student {

    private String name;
    private String rollNumber;
    private List<Double> grades;

    // ─── Constructor ───────────────────────────────────────────────────────────
    public Student(String name, String rollNumber) {
        this.name       = name;
        this.rollNumber = rollNumber;
        this.grades     = new ArrayList<>();
    }

    // ─── Grade Management ──────────────────────────────────────────────────────
    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        grades.add(grade);
    }

    // ─── Calculations ──────────────────────────────────────────────────────────
    public double calculateAverage() {
        if (grades.isEmpty()) return 0.0;
        double total = 0;
        for (double g : grades) total += g;
        return total / grades.size();
    }

    public double getHighestGrade() {
        if (grades.isEmpty()) return 0.0;
        double max = grades.get(0);
        for (double g : grades) if (g > max) max = g;
        return max;
    }

    public double getLowestGrade() {
        if (grades.isEmpty()) return 0.0;
        double min = grades.get(0);
        for (double g : grades) if (g < min) min = g;
        return min;
    }

    // ─── Letter Grade ──────────────────────────────────────────────────────────
    public String getLetterGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A+";
        else if (avg >= 85) return "A";
        else if (avg >= 80) return "A-";
        else if (avg >= 75) return "B+";
        else if (avg >= 70) return "B";
        else if (avg >= 65) return "B-";
        else if (avg >= 60) return "C+";
        else if (avg >= 55) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }

    // ─── Status ────────────────────────────────────────────────────────────────
    public String getStatus() {
        return calculateAverage() >= 50 ? "PASS" : "FAIL";
    }

    // ─── Getters ───────────────────────────────────────────────────────────────
    public String getName()       { return name; }
    public String getRollNumber() { return rollNumber; }
    public List<Double> getGrades() { return grades; }
    public int getTotalSubjects()   { return grades.size(); }
}