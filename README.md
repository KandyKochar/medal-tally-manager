# Medal Tally Manager

A Java console application for tracking and displaying Olympic medal counts by country.

## Overview
Manages a medal tally system where countries earn gold, silver, and bronze medals. Supports sorting countries by total medal count and displaying ranked results.

## Features
- Add and update medal counts per country
- Sort countries by gold, silver, bronze, or total medals
- Display formatted medal tally table
- Array utility operations for data manipulation

## Technologies Used
- **Language:** Java (JDK 8+)
- **Build:** Apache Ant (NetBeans)

## Project Structure
```
src/
+-- ArrayUtilities.java      # Sorting and array helper methods
+-- MedalTallyManager.java   # Core medal tracking logic
+-- Tester.java              # Main entry point and test cases
```

## Usage
```bash
javac src/*.java -d out/
java -cp out/ Tester
```

## Author
Kandy Kochar
