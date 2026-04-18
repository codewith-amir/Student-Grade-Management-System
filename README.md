1. StudentGradeTracker README
markdown# Student Grade Tracker

> **CodeAlpha Java Developer Internship — Task 1**  
> Author: Muhammad Amir | GitHub: [@codewith-amir](https://github.com/codewith-amir)

---

## 📋 Project Overview

A console-based **Student Grade Tracker** built in Java that allows teachers to manage student records, track grades across multiple subjects, and generate detailed academic reports with class statistics.

---

## ✨ Features

- ✅ **Add Students** — Name + Roll Number with duplicate validation
- ✅ **Add Grades** — Multiple grades per student (0–100 validation)
- ✅ **Individual Reports** — Average, Highest, Lowest, Letter Grade, PASS/FAIL status
- ✅ **Summary Table** — View all students with their stats at a glance
- ✅ **Class Statistics** — Class average, top student, pass/fail count
- ✅ **Remove Students** — By Roll Number
- ✅ **Sample Data** — 4 demo students pre-loaded on startup
- ✅ **Input Validation** — All inputs validated with clear error messages
- ✅ **Colored Console UI** — ANSI color codes for clean, readable output

---

## 🎯 Letter Grade Scale

| Marks | Grade |
|-------|-------|
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

## 📂 Project Structure
CodeAlpha_StudentGradeTracker/
└── com/codealpha/gradetracker/
├── Main.java              ← Entry point + menu
├── Student.java           ← Student model (OOP)
├── GradeTracker.java      ← Student collection manager
└── DisplayHelper.java     ← Console UI / formatting

---

## 🚀 How to Run

### Option 1: Command Line (Recommended)

```bash
# 1. Clone the repository
git clone https://github.com/codewith-amir/CodeAlpha_StudentGradeTracker.git
cd CodeAlpha_StudentGradeTracker

# 2. Compile
javac -d out com/codealpha/gradetracker/*.java

# 3. Run
java -cp out com.codealpha.gradetracker.Main
```

### Option 2: Windows Batch File

```bash
# Double-click run.bat from project root
run.bat
```

### Option 3: IDE (IntelliJ IDEA / Eclipse)

1. Open project folder
2. Set `com.codealpha.gradetracker.Main` as run configuration
3. Press ▶ Run

---

## 💻 Technologies Used

- **Java** (JDK 11+)
- **OOP** — Encapsulation, separation of concerns
- **ArrayList** — Dynamic storage
- **ANSI Colors** — Terminal styling

---

## 📸 Screenshot
═══════════════════════════════════════════════════════════════
STUDENT GRADE TRACKER — CodeAlpha Internship
Java Developer Internship | Task 1
Author: Muhammad Amir | GitHub: codewith-amir
═══════════════════════════════════════════════════════════════
─────────────────────────────────────────────────────────────
MAIN MENU
─────────────────────────────────────────────────────────────

Add New Student
Add Grades for a Student
View Student Report
View All Students (Summary Table)
View Class Statistics
Remove a Student
Exit
─────────────────────────────────────────────────────────────
Enter your choice:


---

## 🎓 Learning Outcomes

This project demonstrates:
- ✅ Object-Oriented Programming (OOP)
- ✅ ArrayList and data management
- ✅ Input validation and error handling
- ✅ Console UI design with ANSI colors
- ✅ Statistical calculations (average, min, max)

---

## 📝 License

Copyright © 2026 Muhammad Amir. All rights reserved.

---

## 🔗 Connect

- **GitHub:** [@codewith-amir](https://github.com/codewith-amir)
- **LinkedIn:** [muhammad-amir-pk](https://linkedin.com/in/muhammad-amir-pk)
- **Email:** muhammadamir191491@gmail.com

---

**Built with ❤️ by Muhammad Amir | BSCS @ NUML University, Lahore**