package com.codealpha.gradetracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the collection of all students.
 * Provides search, class-wide statistics, and report generation.
 * Author: Muhammad Amir | GitHub: codewith-amir
 */
public class GradeTracker {

    private List<Student> students;

    public GradeTracker() {
        this.students = new ArrayList<>();
    }

    // ─── Student Management ────────────────────────────────────────────────────
    public void addStudent(Student student) {
        // Check for duplicate roll number
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(student.getRollNumber())) {
                throw new IllegalArgumentException(
                    "Student with Roll No '" + student.getRollNumber() + "' already exists.");
            }
        }
        students.add(student);
    }

    public boolean removeStudent(String rollNumber) {
        return students.removeIf(s -> s.getRollNumber().equalsIgnoreCase(rollNumber));
    }

    public Student findStudent(String rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(rollNumber)) return s;
        }
        return null;
    }

    // ─── Class-Wide Statistics ─────────────────────────────────────────────────
    public double getClassAverage() {
        if (students.isEmpty()) return 0.0;
        double total = 0;
        int count = 0;
        for (Student s : students) {
            if (s.getTotalSubjects() > 0) {
                total += s.calculateAverage();
                count++;
            }
        }
        return count == 0 ? 0.0 : total / count;
    }

    public Student getTopStudent() {
        if (students.isEmpty()) return null;
        Student top = null;
        double maxAvg = -1;
        for (Student s : students) {
            if (s.getTotalSubjects() > 0 && s.calculateAverage() > maxAvg) {
                maxAvg = s.calculateAverage();
                top = s;
            }
        }
        return top;
    }

    public Student getLowestStudent() {
        if (students.isEmpty()) return null;
        Student low = null;
        double minAvg = 101;
        for (Student s : students) {
            if (s.getTotalSubjects() > 0 && s.calculateAverage() < minAvg) {
                minAvg = s.calculateAverage();
                low = s;
            }
        }
        return low;
    }

    public int getTotalStudents() { return students.size(); }
    public List<Student> getAllStudents() { return students; }

    public int getPassCount() {
        int count = 0;
        for (Student s : students) {
            if (s.getTotalSubjects() > 0 && s.getStatus().equals("PASS")) count++;
        }
        return count;
    }

    public int getFailCount() {
        int count = 0;
        for (Student s : students) {
            if (s.getTotalSubjects() > 0 && s.getStatus().equals("FAIL")) count++;
        }
        return count;
    }
}