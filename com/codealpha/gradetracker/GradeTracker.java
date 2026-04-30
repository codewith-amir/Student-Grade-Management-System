package com.codealpha.gradetracker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manages the collection of all students.
 * Provides search, class-wide statistics, and report generation.
 * Author: Muhammad Amir | GitHub: codewith-amir
 */
public class GradeTracker {

    private final List<Student> students;

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

    public double getClassAverage() {
        List<Student> withGrades = students.stream()
            .filter(s -> s.getTotalSubjects() > 0)
            .collect(Collectors.toList());
        if (withGrades.isEmpty()) return 0.0;
        return withGrades.stream()
            .mapToDouble(Student::calculateAverage)
            .average()
            .orElse(0.0);
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
        return (int) students.stream()
            .filter(s -> s.getTotalSubjects() > 0 && s.getStatus().equals("PASS"))
            .count();
    }

    public int getFailCount() {
        return (int) students.stream()
            .filter(s -> s.getTotalSubjects() > 0 && s.getStatus().equals("FAIL"))
            .count();
    }
}