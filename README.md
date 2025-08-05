# Fee Invoice Management System - Valence College

A comprehensive Java-based fee invoice application designed for Valence College to automate student billing and course management. This system calculates student fees based on residency status, course load, and academic performance while providing robust student and course administration capabilities.

## Project Overview

This application demonstrates advanced object-oriented programming principles through a real-world student billing system. The system handles different student types (Undergraduate, MS, PhD) with unique fee structures and provides comprehensive course management functionality.

## Key Features

### Student Management

- **Multi-tier Student System**: Support for Undergraduate, MS, and PhD students
- **Dynamic Fee Calculation**:
  - Undergraduate: Residency-based tuition rates with GPA-based discounts
  - MS Students: Graduate-level tuition structure
  - PhD Students: Research fees with lab supervision discounts
- **Student Registration**: Add, delete, and manage student records
- **Invoice Generation**: Professional fee invoices with detailed breakdowns

### Course Management

- **Course Administration**: Add, search, and delete courses
- **Lab Management**: Associate laboratory sessions with courses
- **Multiple Modalities**: Support for F2F, Online, and Mixed delivery modes
- **Credit Hour Tracking**: Flexible credit hour assignments

### Advanced Features

- **Custom Exception Handling**: ID validation with custom `IdException`
- **File I/O Integration**: Course data loading from external files
- **Interactive Menu System**: User-friendly command-line interface
- **Data Persistence**: Course and student data management

## System Architecture

### Core Classes

- **Abstract `Student`**: Base class for all student types
- **`UndergraduateStudent`**: Implements residency-based fee calculation
- **`GraduateStudent`**: Abstract class for graduate-level students
- **`MsStudent`**: MS-specific fee structure and course management
- **`PhdStudent`**: Research-focused billing with lab supervision benefits
- **`Course`**: Comprehensive course data management
- **`College`**: Central repository for all courses and labs

### Design Patterns

- **Inheritance Hierarchy**: Clean separation of student types
- **Polymorphism**: Unified invoice printing across student types
- **Exception Handling**: Custom validation for data integrity
- **File Processing**: Structured data import capabilities

## Getting Started

### Prerequisites

- Java 8 or higher
- Text editor or IDE (IntelliJ IDEA, Eclipse, VS Code)

### Installation & Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/tomiwaaluko/Fee-Invoice-Project.git
   cd Fee-Invoice-Project
   ```

2. Update the file path in `ProjectDriver.java` (line 240):

   ```java
   File newFile = new File("path/to/your/lec.txt");
   ```

3. Compile and run:
   ```bash
   javac ProjectDriver.java
   java ProjectDriver
   ```

## Usage Guide

### Main Menu Options

1. **Student Management**

   - Add students (Undergraduate/MS/PhD)
   - Delete student records
   - Print fee invoices
   - Display student lists by category

2. **Course Management**
   - Search courses and labs
   - Delete courses
   - Add laboratories to existing courses

### Student Data Formats

- **Undergraduate**: `Name|Residency(YES/NO)|GPA|Course1,Course2,...`
- **MS**: `Name|Course1,Course2,...`
- **PhD**: `Name|Advisor|ResearchSubject|Lab1,Lab2,...`

### Sample Fee Structure

- **Undergraduate**: $120.25 (resident) / $240.50 (non-resident) per credit hour
- **MS Students**: $300.00 per credit hour
- **PhD Students**: $700.00 research fee (with lab supervision discounts)
- **Health & ID Fee**: $35.00 (all students)

## Sample Data

The system includes sample course data (`lec.txt`) with various course types:

- Graduate courses (COT6578, COP5698, LOG5578)
- Undergraduate courses (DIG2158, CDL2587, SOF2058)
- Multiple delivery modalities and laboratory sessions

## Contributors

- **Tomiwa Aluko**
- **Jalen Donald**
- **Kentrell Hardemon-Pace**

## Technical Requirements

- **Language**: Java
- **Paradigm**: Object-Oriented Programming
- **Input/Output**: Console-based interface with file integration
- **Data Structures**: ArrayList, Array manipulation
- **Error Handling**: Custom exception classes

## Future Enhancements

- Database integration for persistent storage
- GUI implementation for improved user experience
- Advanced reporting and analytics
- Integration with external payment systems
- Multi-semester billing capabilities

## Documentation

For detailed project specifications and requirements, please refer to the `Fee Invoice Project Details.docx` file included in this repository.

---

_This project showcases object-oriented design principles, inheritance hierarchies, polymorphism, and real-world application development for academic billing systems._
