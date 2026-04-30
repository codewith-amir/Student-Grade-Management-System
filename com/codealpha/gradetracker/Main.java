package com.codealpha.gradetracker;

import java.util.Scanner;

/**
 * ╔══════════════════════════════════════════════════════════════╗
 * ║       STUDENT GRADE TRACKER — CodeAlpha Java Internship     ║
 * ║                         TASK 1                              ║
 * ╠══════════════════════════════════════════════════════════════╣
 * ║  Features:                                                  ║
 * ║   • Add / Remove students                                   ║
 * ║   • Add grades per subject (0–100)                         ║
 * ║   • Calculate average, highest, lowest per student          ║
 * ║   • Letter grade + PASS/FAIL status                        ║
 * ║   • Summary table for all students                         ║
 * ║   • Class-wide statistics (top student, class avg, etc.)   ║
 * ║   • Full input validation                                   ║
 * ╠══════════════════════════════════════════════════════════════╣
 * ║  Author : Muhammad Amir                                     ║
 * ║  GitHub : codewith-amir                                     ║
 * ║  Program: BSCS — NUML University Lahore                     ║
 * ╚══════════════════════════════════════════════════════════════╝
 */
public class Main {

    private static final GradeTracker tracker = new GradeTracker();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DisplayHelper.printBanner();
            loadSampleData();   // pre-loads 3 demo students so output is visible immediately

            boolean running = true;
            while (running) {
                DisplayHelper.printMenu();
                String input = scanner.nextLine().trim();

                switch (input) {
                    case "1" -> addStudent(scanner);
                    case "2" -> addGradesForStudent(scanner);
                    case "3" -> viewStudentReport(scanner);
                    case "4" -> DisplayHelper.printAllStudentsTable(tracker.getAllStudents());
                    case "5" -> DisplayHelper.printClassStatistics(tracker);
                    case "6" -> removeStudent(scanner);
                    case "0" -> {
                        System.out.println();
                        DisplayHelper.printInfo("Thank you for using Student Grade Tracker. Goodbye!");
                        System.out.println();
                        running = false;
                    }
                    default  -> DisplayHelper.printError("Invalid choice. Please enter a number from the menu.");
                }
            }
        }
    }

    // ─── Menu Actions ──────────────────────────────────────────────────────────

    private static void addStudent(Scanner scanner) {
        System.out.println();
        System.out.print("  Enter Student Name     : ");
        String name = scanner.nextLine().trim();

        System.out.print("  Enter Roll Number      : ");
        String roll = scanner.nextLine().trim();

        if (name.isEmpty() || roll.isEmpty()) {
            DisplayHelper.printError("Name and Roll Number cannot be empty.");
            return;
        }

        try {
            tracker.addStudent(new Student(name, roll));
            DisplayHelper.printSuccess("Student '" + name + "' added successfully.");
        } catch (IllegalArgumentException e) {
            DisplayHelper.printError(e.getMessage());
        }
    }

    private static void addGradesForStudent(Scanner scanner) {
        System.out.println();
        System.out.print("  Enter Roll Number to add grades for : ");
        String roll = scanner.nextLine().trim();

        if (roll.isEmpty()) {
            DisplayHelper.printError("Roll Number cannot be empty.");
            return;
        }

        Student student = tracker.findStudent(roll);
        if (student == null) {
            DisplayHelper.printError("Student with Roll No '" + roll + "' not found.");
            return;
        }

        DisplayHelper.printInfo("Adding grades for: " + student.getName());
        System.out.print("  How many subjects/grades to add? : ");

        int count;
        try {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                DisplayHelper.printError("Please enter a number.");
                return;
            }
            count = Integer.parseInt(input);
            if (count <= 0) {
                DisplayHelper.printError("Must add at least 1 grade.");
                return;
            }
        } catch (NumberFormatException e) {
            DisplayHelper.printError("Invalid input. Please enter a valid integer.");
            return;
        }

        int added = 0;
        for (int i = 1; i <= count; i++) {
            System.out.printf("    Grade for Subject %d (0-100): ", i);
            try {
                String gradeInput = scanner.nextLine().trim();
                if (gradeInput.isEmpty()) {
                    DisplayHelper.printError("Skipping subject " + i + " (empty input).");
                    continue;
                }
                double grade = Double.parseDouble(gradeInput);
                student.addGrade(grade);
                added++;
            } catch (NumberFormatException e) {
                DisplayHelper.printError("Invalid grade format. Skipping subject " + i);
            } catch (IllegalArgumentException e) {
                DisplayHelper.printError(e.getMessage() + " Skipping subject " + i);
            }
        }
        if (added > 0) {
            DisplayHelper.printSuccess(added + " grade(s) added to " + student.getName() + ".");
        }
    }

    private static void viewStudentReport(Scanner scanner) {
        System.out.println();
        System.out.print("  Enter Roll Number : ");
        String roll = scanner.nextLine().trim();

        Student student = tracker.findStudent(roll);
        if (student == null) {
            DisplayHelper.printError("Student with Roll No '" + roll + "' not found.");
        } else {
            DisplayHelper.printStudentReport(student);
        }
    }

    private static void removeStudent(Scanner scanner) {
        System.out.println();
        System.out.print("  Enter Roll Number to remove : ");
        String roll = scanner.nextLine().trim();

        boolean removed = tracker.removeStudent(roll);
        if (removed) {
            DisplayHelper.printSuccess("Student with Roll No '" + roll + "' removed.");
        } else {
            DisplayHelper.printError("Student with Roll No '" + roll + "' not found.");
        }
    }

    // ─── Demo / Sample Data ────────────────────────────────────────────────────
    private static void loadSampleData() {
        try {
            Student s1 = new Student("Ali Hassan",    "BSCS-2023-01");
            s1.addGrade(88); s1.addGrade(92); s1.addGrade(79); s1.addGrade(95); s1.addGrade(85);

            Student s2 = new Student("Sara Khan",     "BSCS-2023-02");
            s2.addGrade(72); s2.addGrade(68); s2.addGrade(74); s2.addGrade(70); s2.addGrade(66);

            Student s3 = new Student("Usman Tariq",   "BSCS-2023-03");
            s3.addGrade(45); s3.addGrade(52); s3.addGrade(48); s3.addGrade(55); s3.addGrade(40);

            Student s4 = new Student("Fatima Noor",   "BSCS-2023-04");
            s4.addGrade(96); s4.addGrade(98); s4.addGrade(94); s4.addGrade(97); s4.addGrade(99);

            tracker.addStudent(s1);
            tracker.addStudent(s2);
            tracker.addStudent(s3);
            tracker.addStudent(s4);

            DisplayHelper.printInfo("4 sample students loaded for demo. You can add more or explore!");
        } catch (Exception e) {
            // silently skip if sample data fails
        }
    }
}