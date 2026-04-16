@echo off
setlocal

cd /d "%~dp0"

if not exist out (
    mkdir out
)

echo Compiling sources...
javac -d out com\codealpha\gradetracker\*.java
if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

echo Running Student Grade Tracker...
java -cp out com.codealpha.gradetracker.Main
if errorlevel 1 (
    echo Application exited with an error.
    pause
    exit /b 1
)

endlocal