# CodeAlpha_StudentGradeTracker

> **CodeAlpha Java Developer Internship — Task 1**
> Author: Muhammad Amir | GitHub: [codewith-amir](https://github.com/codewith-amir)

---

##  Project Overview

A console-based **Student Grade Tracker** built in Java.  
Allows adding students, recording grades per subject, and generating detailed academic reports with class-wide statistics.

---

## ✅ Features

 * Feature            |        Description 
 * Add Students       | Name + Roll Number with duplicate check 
 * Add Grades         | Multiple grades per student (0–100 validation) 
 * Individual Report  | Average, Highest, Lowest, Letter Grade, PASS/FAIL 
 * Summary Table      | All students with their stats at a glance 
 * Class Statistics   | Class average, top student, pass/fail count 
 * Remove Student     | By Roll Number 
 * Sample Data        | 4 demo students pre-loaded on startup 
 * Input Validation   | All inputs validated with clear error messages 
 * Colored Console UI | ANSI color codes for clean, readable output 


##  Project Structure

```
CodeAlpha_StudentGradeTracker/
└── com/
	└── codealpha/
		└── gradetracker/
			├── Main.java           ← Entry point + menu logic
			├── Student.java        ← Student model (OOP)
			├── GradeTracker.java   ← Collection manager
			└── DisplayHelper.java  ← Console UI / formatting
```

##  How to Run

### Option 1 — Command Line (JDK required)

```bash
# 1. Clone / open the project folder
# 2. Compile
javac -d out com/codealpha/gradetracker/*.java

# 3. Run
java -cp out com.codealpha.gradetracker.Main
```

### Option 2 — IntelliJ IDEA / Eclipse
1. Open the project folder as a Java project
2. Set `com.codealpha.gradetracker.Main` as the run configuration
3. Press ▶ Run

### Option 3 — Windows Batch Launcher
1. Double-click `run.bat` from the project root
2. The script compiles the sources and launches the app automatically

---

## Letter Grade Scale

| Marks | Grade |
|---|---|
| 90–100 | A+ |
| 85–89  | A  |
| 80–84  | A- |
| 75–79  | B+ |
| 70–74  | B  |
| 65–69  | B- |
| 60–64  | C+ |
| 55–59  | C  |
| 50–54  | D  |
| 0–49   | F  |

---

## Technologies Used

- **Java** (JDK 17+)
- **ArrayList** for dynamic grade/student storage
- **OOP** — Encapsulation, separation of concerns
- **ANSI escape codes** for colored terminal output

---

## Copyright

Copyright (c) 2026 Muhammad Amir. All rights reserved.
See the `COPYRIGHT` file for full terms.

---

*CodeAlpha Internship | Java Developer | Task 1 Student Grade Tracker
