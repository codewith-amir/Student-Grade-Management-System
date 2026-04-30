package com.codealpha.gradetracker;

import java.util.List;

/**
 * Handles all console display / UI formatting.
 * Keeps output clean and separated from business logic.
 * Author: Muhammad Amir | GitHub: codewith-amir
 */
public class DisplayHelper {

    // ─── ANSI Colors ───────────────────────────────────────────────────────────
    public static final String RESET  = "\u001B[0m";
    public static final String BOLD   = "\u001B[1m";
    public static final String GREEN  = "\u001B[32m";
    public static final String RED    = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN   = "\u001B[36m";
    public static final String BLUE   = "\u001B[34m";
    public static final String WHITE  = "\u001B[37m";

    private static final int LINE_WIDTH = 65;

    // ─── Welcome Banner ────────────────────────────────────────────────────────
    public static void printBanner() {
        printLine('=');
        System.out.println(BOLD + CYAN +
            "        STUDENT GRADE TRACKER — CodeAlpha Internship" + RESET);
        System.out.println(CYAN +
            "            Java Developer Internship | Task 1" + RESET);
        System.out.println(WHITE +
            "         Author: Muhammad Amir | GitHub: codewith-amir" + RESET);
        printLine('=');
        System.out.println();
    }

    // ─── Main Menu ─────────────────────────────────────────────────────────────
    public static void printMenu() {
        System.out.println();
        printLine('-');
        System.out.println(BOLD + "                       MAIN MENU" + RESET);
        printLine('-');
        System.out.println("  " + CYAN + "1." + RESET + "  Add New Student");
        System.out.println("  " + CYAN + "2." + RESET + "  Add Grades for a Student");
        System.out.println("  " + CYAN + "3." + RESET + "  View Student Report");
        System.out.println("  " + CYAN + "4." + RESET + "  View All Students (Summary Table)");
        System.out.println("  " + CYAN + "5." + RESET + "  View Class Statistics");
        System.out.println("  " + CYAN + "6." + RESET + "  Remove a Student");
        System.out.println("  " + RED  + "0." + RESET + "  Exit");
        printLine('-');
        System.out.print(BOLD + "  Enter your choice: " + RESET);
    }

    // ─── Individual Student Report ─────────────────────────────────────────────
    public static void printStudentReport(Student s) {
        System.out.println();
        printLine('=');
        System.out.printf(BOLD + "  STUDENT REPORT%n" + RESET);
        printLine('-');
        String truncatedName = s.getName().length() > 30 ? 
            s.getName().substring(0, 27) + "..." : s.getName();
        System.out.printf("  %-15s : %s%n", "Name",        truncatedName);
        System.out.printf("  %-15s : %s%n", "Roll No",     s.getRollNumber());
        System.out.printf("  %-15s : %d%n", "Subjects",    s.getTotalSubjects());

        if (s.getTotalSubjects() == 0) {
            System.out.println(YELLOW + "  No grades added yet." + RESET);
        } else {
            // Print individual grades
            System.out.printf("  %-15s : ", "Grades");
            List<Double> grades = s.getGrades();
            for (int i = 0; i < grades.size(); i++) {
                System.out.printf("%.1f", grades.get(i));
                if (i < grades.size() - 1) System.out.print(" | ");
            }
            System.out.println();

            printLine('-');
            System.out.printf("  %-15s : %.2f%%%n", "Average",  s.calculateAverage());
            System.out.printf("  %-15s : %.2f%%%n", "Highest",  s.getHighestGrade());
            System.out.printf("  %-15s : %.2f%%%n", "Lowest",   s.getLowestGrade());
            System.out.printf("  %-15s : %s%n",     "Grade",    s.getLetterGrade());

            String status = s.getStatus();
            String color  = status.equals("PASS") ? GREEN : RED;
            System.out.printf("  %-15s : %s%s%s%n", "Status", BOLD + color, status, RESET);
        }
        printLine('=');
    }

    // ─── All Students Summary Table ────────────────────────────────────────────
    public static void printAllStudentsTable(List<Student> students) {
        System.out.println();
        printLine('=');
        System.out.println(BOLD + "  ALL STUDENTS — SUMMARY TABLE" + RESET);
        printLine('-');
        System.out.printf(BOLD + "  %-3s  %-18s  %-12s  %-10s  %-6s  %-8s  %s%n" + RESET,
            "No.", "Name", "Roll No", "Average", "Grade", "Subjects", "Status");
        printLine('-');

        if (students.isEmpty()) {
            System.out.println(YELLOW + "  No students found." + RESET);
        } else {
            int i = 1;
            for (Student s : students) {
                String statusColor = s.getStatus().equals("PASS") ? GREEN : RED;
                String truncatedName = s.getName().length() > 18 ? 
                    s.getName().substring(0, 15) + "..." : s.getName();
                System.out.printf("  %-3d  %-18s  %-12s  %-10s  %-6s  %-8d  %s%s%s%n",
                    i++,
                    truncatedName,
                    s.getRollNumber(),
                    s.getTotalSubjects() > 0 ? String.format("%.2f%%", s.calculateAverage()) : "N/A",
                    s.getTotalSubjects() > 0 ? s.getLetterGrade() : "N/A",
                    s.getTotalSubjects(),
                    statusColor + BOLD, s.getStatus(), RESET
                );
            }
        }
        printLine('=');
    }

    // ─── Class Statistics ──────────────────────────────────────────────────────
    public static void printClassStatistics(GradeTracker tracker) {
        System.out.println();
        printLine('=');
        System.out.println(BOLD + "  CLASS STATISTICS" + RESET);
        printLine('-');
        System.out.printf("  %-22s : %d%n", "Total Students",   tracker.getTotalStudents());
        System.out.printf("  %-22s : %.2f%%%n", "Class Average", tracker.getClassAverage());
        System.out.printf("  %-22s : %s%s%d%s%n", "Passed Students",
            GREEN, BOLD, tracker.getPassCount(), RESET);
        System.out.printf("  %-22s : %s%s%d%s%n", "Failed Students",
            RED, BOLD, tracker.getFailCount(), RESET);

        Student top = tracker.getTopStudent();
        Student low = tracker.getLowestStudent();

        printLine('-');
        if (top != null) {
            System.out.printf("  %-22s : %s (%.2f%%) [%s]%n",
                "Top Student", top.getName(), top.calculateAverage(), top.getLetterGrade());
        }
        if (low != null) {
            System.out.printf("  %-22s : %s (%.2f%%) [%s]%n",
                "Needs Improvement", low.getName(), low.calculateAverage(), low.getLetterGrade());
        }
        printLine('=');
    }

    // ─── Helpers ───────────────────────────────────────────────────────────────
    public static void printLine(char ch) {
        System.out.println("  " + String.valueOf(ch).repeat(LINE_WIDTH));
    }

    public static void printSuccess(String msg) {
        System.out.println(GREEN + "  ✔  " + msg + RESET);
    }

    public static void printError(String msg) {
        System.out.println(RED + "  ✘  " + msg + RESET);
    }

    public static void printInfo(String msg) {
        System.out.println(YELLOW + "  ➜  " + msg + RESET);
    }
}