// Group members: Tomiwa Aluko, Jalen Donald, Kentrell Hardemon-Pace

import java.util.*;
import java.io.*;

// Abstract class for all students
abstract class Student {
    private String id;

    public Student(String id) {
        this.id = id;
    }

    abstract public void addCourse(String courseId);

    abstract public void printInvoice(ArrayList<Course> newCourses);

    abstract public String getName();

    abstract public String getId();
}

// Abstract class for all graduate students
abstract class GraduateStudent extends Student {
    public GraduateStudent(String id) {
        super(id);
    }
}

// Class for undergraduate students
class UndergraduateStudent extends Student {
    private ArrayList<String> courses = new ArrayList<>();
    private boolean isStateResident;
    private double gpa;
    private String id;
    private String name;

    public UndergraduateStudent(String id, boolean isStateResident, double gpa, String name) {
        super(id);
        this.isStateResident = isStateResident;
        this.gpa = gpa;
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void addCourse(String courseId) {
        courses.add(courseId);
    }

    @Override
    public void printInvoice(ArrayList<Course> newCourses) {
        double tuitionFee = isStateResident ? 120.25 : 240.50; // Placeholder values
        double totalFee = tuitionFee * 3; // Assuming 3 credit hours as an example
        double healthFee = 35.00;
        totalFee += healthFee;
        if (gpa >= 3.5 && totalFee > 500) {
            totalFee *= 0.75; // 25% discount
        }
        System.out.println("VALENCE COLLEGE");
        System.out.println("ORLANDO FL 10101");
        System.out.println("---------------------");
        System.out.println(" ");
        System.out.println("Fee Invoice Prepared for Student:");
        System.out.println(getId() + "-" + getName());
        System.out.println(" ");
        System.out.println("1 Credit Hour = $" + String.format("%.2f", tuitionFee));
        System.out.println(" ");
        System.out.println("CRN\tCR_PREFIX\tCR_HOURS\tCOST");

        for (String course : courses) {
            for (Course newCourse : newCourses) {
                if (course.equals(newCourse.getId())) {
                    String coursePrefix = newCourse.getCode();
                    int creditHours = newCourse.getCredits();
                    double courseCost = creditHours * tuitionFee;
                    System.out.println(course + "\t" + coursePrefix + "\t\t" + creditHours + "\t\t" + String.format("\t$%.2f", tuitionFee));
                    totalFee += courseCost;
                }
            }
        }

        totalFee += healthFee;
        System.out.println(" ");
        System.out.println("\t\tHealth & id fees\t$" + String.format("%.2f", healthFee));
        System.out.println(" ");
        System.out.println("--------------------------------------");
        System.out.println("\t\tTOTAL PAYMENTS \t\t$" + String.format("%.2f", totalFee));
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }
}

// Class for MS students
class MsStudent extends GraduateStudent {
    private ArrayList<String> courses = new ArrayList<>();
    private String name;
    private String id;

    public MsStudent(String id, String name, ArrayList<String> courses) {
        super(id);
        this.courses = courses;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void addCourse(String courseId) {
        courses.add(courseId);
    }

    @Override
    public void printInvoice(ArrayList<Course> newCourses) {
        double tuitionFee = 300.00; // Placeholder values
        double totalFee = tuitionFee * 3; // Assuming 3 credit hours as an example
        double healthFee = 35.00;
        totalFee += healthFee;

        System.out.println("VALENCE COLLEGE");
        System.out.println("ORLANDO FL 10101");
        System.out.println("---------------------");
        System.out.println(" ");
        System.out.println("Fee Invoice Prepared for Student:");
        System.out.println(getId() + "-" + getName());
        System.out.println(" ");
        System.out.println("1 Credit Hour = $" + String.format("%.2f", tuitionFee));
        System.out.println(" ");
        System.out.println("CRN\tCR_PREFIX\tCR_HOURS\tCOST");

        for (String course : courses) {
            for (Course newCourse : newCourses) {
                if (course.equals(newCourse.getId())) {
                    String coursePrefix = newCourse.getCode();
                    int creditHours = newCourse.getCredits();
                    double courseCost = creditHours * tuitionFee;
                    System.out.println(course + "\t" + coursePrefix + "\t\t" + creditHours + "\t\t" + String.format("\t$%.2f", tuitionFee));
                    totalFee += courseCost;
                }
            }
        }

        totalFee += healthFee;
        System.out.println(" ");
        System.out.println("\t\tHealth & id fees\t$" + String.format("%.2f", healthFee));
        System.out.println(" ");
        System.out.println("--------------------------------------");
        System.out.println("\t\tTOTAL PAYMENTS \t\t$" + String.format("%.2f", totalFee));
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }
}

// Class for PhD students
class PhdStudent extends GraduateStudent {
    private String advisor;
    private String researchSubject;
    private ArrayList<String> labsSupervised;
    private String id;
    private String name;

    public PhdStudent(String id, String name, String advisor, String researchSubject,
        ArrayList<String> labsSupervised) {
        super(id);
        this.id = id;
        this.name = name;
        this.advisor = advisor;
        this.researchSubject = researchSubject;
        this.labsSupervised = labsSupervised;
    }

    @Override
    public void printInvoice(ArrayList<Course> newCourses) {
        double researchFee = 700.00;
        double totalFee = labsSupervised.size() >= 3 ? 35.00
                : (labsSupervised.size() == 2 ? researchFee * 0.50 : researchFee);
        System.out.println("VALENCE COLLEGE");
        System.out.println("ORLANDO FL 10101");
        System.out.println("---------------------");
        System.out.println(" ");
        System.out.println("Fee Invoice Prepared for Student:");
        System.out.println(id + " - " + name);
        System.out.println(" ");
        System.out.println("RESEARCH");
        System.out.println(researchSubject + "\t\t\t  $700.00");
        System.out.println(" ");
        System.out.println("\t\tHealth & id fees  $35.00");
        System.out.println(" ");
        System.out.println("--------------------------------------");
        System.out.println("\t\tTotal Payments" + String.format("\t  $%.2f", totalFee));
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addCourse(String courseId) {
        //jk;
    }
}

// Custom exception class for ID verification
class IdException extends Exception {
    public IdException(String message) {
        super(message);
    }
}

// class to store courses
class College {
    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(String[] values) {
        Course course = new Course(values);
        courses.add(course);
    }

    public void addLab(String id, String[] values) {
        Course foundCourse = null;
        for (Course course : courses) {
            if (course.getId() == id) {
                foundCourse = course;
                break;
            }
        }

        // Check if the course was found
        if (foundCourse == null) {
            System.out.println("No course with that id exists");
            return;
        }

        foundCourse.addLab(values);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}

class Course {
    private int studentCount;
    private String id;
    private String code;
    private String name;
    private String level;
    private String modality;
    private String location;
    private boolean lab;
    private int credits;

    private ArrayList<String[]> labs = new ArrayList<>();

    public Course(String[] values) {
        if (values.length == 8) {
            this.studentCount = 0;
            this.id = values[0];
            this.code = values[1];
            this.name = values[2];
            this.level = values[3];
            this.modality = values[4];
            this.location = values[5];

            if (values[6].toLowerCase().compareTo("yes") == 0) {
                this.lab = true;
            } else {
                this.lab = false;
            }
            // For debugging
            // System.out.printf("%s %s %s %s %s\n", id, code, name, level, modality);
            this.credits = Integer.parseInt(values[7]);
        } else if (values.length == 6) {
            this.studentCount = 0;
            this.id = values[0];
            this.code = values[1];
            this.name = values[2];
            this.level = values[3];
            this.modality = values[4];
            // For debugging
            // System.out.printf("%s %s %s %s %s\n", id, code, name, level, modality);

            if (!modality.toLowerCase().equals("online")) {
                this.location = values[5];
                this.credits = Integer.parseInt(values[6]);
            }
            this.credits = Integer.parseInt(values[5]);
        }
    }

    public String getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCrn(String id) {
        this.id = id;
    }

    public String getCrn() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getModality() {
        return modality;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setLab(Boolean lab) {
        this.lab = lab;
    }

    public Boolean getLab() {
        return lab;
    }

    public void setStudentCount(int newCount) {
        this.studentCount = newCount;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public ArrayList<String[]> getLabs() {
        return labs;
    }

    public void addLab(String[] labValues) {
        // System.out.println("Lab Values: " + labValues[0] + labValues[1]);
        labs.add(labValues);
        lab = true;
    }

}

public class ProjectDriver {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static College valenceCollege = new College();

    // loadCourses();
    // C:\\Users\\gokug\\OneDrive\\Desktop\\COP3300\\project\\lec.txt
    // C:\Users\gokug\OneDrive\Desktop\COP3300\project

    public static void main(String[] args) {
        try {
            // REPLACE FILEPATH WITH FILEPATH IN YOUR COMPUTER
            File newFile = new File("C:\\Users\\gokug\\OneDrive\\Desktop\\COP3300\\projecthelp\\lec.txt");
            Scanner fileScanner = new Scanner(newFile);
            String currentLab = "-1";
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // System.out.println(line);
                String[] values = line.split(",");
                // trim all the spaces
                for (int i = 0; i < values.length; i++)
                    values[i] = values[i].trim();

                if (values.length > 2) {
                    valenceCollege.addCourse(values); // add course to call function
                    currentLab = values[0]; // set new course lab id

                } else if (values.length == 2) {
                    // Add Labs to needed course
                    valenceCollege.addLab(currentLab, values);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        boolean running = true;
        while (running) {
            System.out.println("\nMain Menu\n");
            System.out.println("1 : Student Management");
            System.out.println("2 : Course Management");
            System.out.println("0 : Exit");
            System.out.print("\nEnter your selection: ");
            String selection = scanner.nextLine();

            switch (selection) {
                case "1":
                    manageStudents();
                    break;
                case "2":
                    manageCourses();
                    break;
                case "0":
                    System.out.println("Take Care!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static boolean isCourseListed(String number) {
        ArrayList<Course> courses = valenceCollege.getCourses();
        return courses.stream().anyMatch(course -> course.getId().equals(number));
    }

    private static void manageStudents() {
        boolean inStudentMenu = true;
        while (inStudentMenu) {
            System.out.println("\nStudent Management Menu:");
            System.out.println("A - Add a student");
            System.out.println("B - Delete a Student");
            System.out.println("C - Print Fee Invoice");
            System.out.println("D - Print List of Students");
            System.out.println("X - Back to Main Menu");
            System.out.print("\nEnter your selection: ");
            String option = scanner.nextLine();

            switch (option.toUpperCase()) {
                case "A":
                    addStudent();
                    break;
                case "B":
                    deleteStudent();
                    break;
                case "C":
                    ArrayList<Course> courses = valenceCollege.getCourses();
                    printStudentInvoice(courses);
                    break;
                case "D":
                    printStudentList();
                    break;
                case "X":
                    inStudentMenu = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void addStudent() {
        try {
            System.out.print("Enter Student's ID (format LLdddd, e.g., ab1234): ");
            String id = scanner.nextLine();
            if (!id.matches("[a-zA-Z]{2}\\d{4}")) {
                throw new IdException("Invalid ID format.");
            }

            for (Student student : students) {
                if (student.getId().equalsIgnoreCase(id)) {
                    throw new IdException("This ID already exists.");
                }
            }

            System.out.print("Enter Student Type (PhD, MS or Undergraduate): ");
            String type = scanner.nextLine();

            Student student = null;
            switch (type.toLowerCase()) {
                case "phd":
                    System.out.print(
                            "Enter details in the format (name|advisor|researchSubject|Lab1,Lab2,... ): ");
                    String input = scanner.nextLine();
                    String[] parts = input.split("\\|");

                    if (parts.length != 4) {
                        System.out.println(
                                "Invalid format. Please ensure you follow the format: name|advisor|researchSubject|Lab1,Lab2,... ");
                        return;
                    }

                    String name = parts[0];
                    String advisor = parts[1];
                    String researchSubject = parts[2];
                    ArrayList<String> labsSupervised = new ArrayList<>(Arrays.asList(parts[3].split(",")));

                    student = new PhdStudent(id, name, advisor, researchSubject, labsSupervised);
                    students.add(student);
                    System.out.println(name + " added!"); // Customized message for PhD students
                    return; // Ensure no further processing after adding

                case "ms":
                    System.out.println("Enter remaining information in the following order [ Name|Course1,Course2,... ]: ");
                    input = scanner.nextLine();
                    parts = input.split("\\|");
                    
                    if (parts.length != 2) {
                        System.out.println(
                                "Invalid format. Please ensure you follow the format: name|Course1,Course2,...");
                        return;
                    }

                    name = parts[0];
                    ArrayList<String> courses = new ArrayList<>(Arrays.asList(parts[1].split(",")));

                    student = new MsStudent(id, name, courses);
                    students.add(student);
                    System.out.println(name + " added!"); // Customized message for PhD students
                    return; // Ensure no further processing after adding

                
                case "undergraduate":
                    System.out.println(
                            "Enter remaining information in the following order [ Name|is resident(YES/NO)?|GPA|Course1,Course2,... ]: ");
                    scanner.reset();
                    String preInfo = scanner.nextLine();
                    String[] info = preInfo.split("\\|");
                    String[] studentCourses = info[3].split(",");

                    if (info.length != 4) {
                        System.out.print(
                                "Invalid format. Please ensure you follow the format: [ Name|is resident(YES/NO)?|GPA|Course1,Course2,... ]");
                        return;
                    }
                    boolean isStateResident;
                    name = info[0];
                    if (info[1].compareToIgnoreCase("yes") == 0)
                        isStateResident = true;
                    else
                        isStateResident = false;

                    double gpa = Double.parseDouble(info[2]);
                    student = new UndergraduateStudent(id, isStateResident, gpa, name);
                    for (String course : studentCourses) {
                        student.addCourse(course);
                    }
                    break;
                    
                default:
                    System.out.println("Invalid student type entered.");
                    return;
            }

            if (student != null) {
                students.add(student);
                System.out.println("Student added successfully.");
            }
        } catch (IdException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student's ID to delete: ");
        String id = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(id)) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with ID: " + id);
        }
    }

    private static void printStudentInvoice(ArrayList<Course> courses) {
        System.out.print("Enter Student's ID to print the invoice: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                student.printInvoice(courses);
                return;
            }
        }
        System.out.println("No student found with ID: " + id);
    }

    private static void printStudentList() {
        // Lists to hold students by type
        ArrayList<String> phdStudents = new ArrayList<>();
        ArrayList<String> msStudents = new ArrayList<>();
        ArrayList<String> undergraduateStudents = new ArrayList<>();

        // Sorting students into their respective lists
        for (Student student : students) {
            if (student instanceof PhdStudent) {
                phdStudents.add(student.getName());
            } else if (student instanceof MsStudent) {
                msStudents.add(student.getName());
            } else if (student instanceof UndergraduateStudent) {
                undergraduateStudents.add(student.getName());
            }
        }

        // Printing the lists
        System.out.println("PhD Students");
        System.out.println("------------");
        for (String name : phdStudents) {
            System.out.println(name);
        }

        System.out.println("\nMS Students");
        System.out.println("-----------");
        for (String name : msStudents) {
            System.out.println(name);
        }

        System.out.println("\nUndergraduate Students");
        System.out.println("----------------------");
        for (String name : undergraduateStudents) {
            System.out.println(name);
        }

        if (phdStudents.isEmpty() && msStudents.isEmpty() && undergraduateStudents.isEmpty()) {
            System.out.println("No students are currently registered.");
        }
    }

    private static void manageCourses() {
        boolean inCourseMenu = true;
        while (inCourseMenu) {
            System.out.println("\nCourse Management Menu:");
            System.out.println("\nChoose one of:");
            System.out.println(" ");
            System.out.println("A - Search for a class or lab using the class/lab number");
            System.out.println("B - Delete a class");
            System.out.println("C - Add a lab to a class");
            System.out.println("X - Back to main menu");
            System.out.print("\nEnter your selection: ");
            String option = scanner.nextLine();

            switch (option.toUpperCase()) {
                case "A":
                    searchClassLab();
                    break;
                case "B":
                    deleteClass();
                    break;
                case "C":
                    addLabToClass();
                    break;
                case "X":
                    inCourseMenu = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void searchClassLab() {
        System.out.print("Enter the Class/Lab Number: ");
        String classLabNumber = scanner.nextLine();
        boolean found = false;
        ArrayList<Course> courses = valenceCollege.getCourses();
        // Example to search through a list or another data structure where classes and
        // labs are stored
        for (Course course : courses) { // Assuming 'courses' is a list of Course objects
            String id = course.getId();
            // System.out.println("Id: " + id);
            if (course.getId().equals(classLabNumber)) {
                System.out.println("[ " + course.getCrn() + ", " + course.getCode() + ", " + course.getName() + " ]");
                return;
            } else {
                ArrayList<String[]> labs = course.getLabs();
                for (String[] lab : labs) {
                    if (lab[0].equals(classLabNumber)) {
                        System.out.println(
                                "\nLab For [ " + course.getCrn() + ", " + course.getCode() + ", " + course.getName()
                                        + " ]");
                        System.out.println("Lab Room: " + lab[1]);
                        return;
                    }

                }
            }
        }
        // System.out.println("No class or lab found with the number: " + classLabNumber);
        System.out.println(" [ ] ");
        return;

    }

    private static void deleteClass() {
        System.out.print("Enter the Class/Lab Number to delete: ");
        String classLabNumber = scanner.nextLine();
        boolean found = false;
        ArrayList<Course> courses = valenceCollege.getCourses();
        // int i = 0; i < courses.size(); i++
        for (Course course : courses) {
            if (course.getId().equals(classLabNumber)) {
                courses.remove(course);
                valenceCollege.setCourses(courses);
                System.out.println("[ " + course.getCrn() + ", " + course.getCode() + ", " + course.getName() + " ] deleted!" );
                // System.out.println("Class/Lab deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            // System.out.println("No class/lab found with the number: " + number);
            System.out.println("[ ]");
        }
    }

    private static void addLabToClass() {
        System.out.print("Enter Lab or Lecture: ");
        String ans = scanner.nextLine();
        if (ans.toLowerCase().equals("lecture")){
            System.out.println("Enter the Lecture Number to a Lab to: ");
            String line = scanner.nextLine();
            if (line.length() == 5) {
                System.out.println(line + " is valid. Enter the rest of the information: ");
                line = scanner.nextLine();
                String[] values = line.split(",");
                // trim all the spaces
                for (int i = 0; i < values.length; i++)
                    values[i] = values[i].trim();

                valenceCollege.addCourse(values); // add course to call function

                System.out.println("Lecture added successfully!");
                return;  
            }
            System.out.println("No Such Lecture Exists!");
            return;
   
        } 

        else {
            System.out.print("Enter the Class Number to add a lab to: ");
            String classNumber = scanner.nextLine();
            ArrayList<Course> courses = valenceCollege.getCourses();
            for (Course classOrLab : courses) {
                if (classOrLab.getId().equals(classNumber)) {
                    System.out.println("Enter lab information [Id|location]");
                    String info = scanner.nextLine();
                    String[] newInfo = info.split("\\|");
                    classOrLab.addLab(newInfo);
                    System.out.println("Lab added succesfully");
                    return;
                }
            }
            System.out.println("No class found with the number: " + classNumber);
        }
    }
}
