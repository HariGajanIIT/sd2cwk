import java.io.FileWriter;
import java.util.*;
import java.io.*;

public class StudentManager {

    static final int maxIntake = 100; //Stating Max university intake

    static String storageFileName = "Student Information.txt"; //Name of file to be stored

    static int registeredStudentCount = 0; //Current Registered Student  counter
//    static Student[] student = new Student[maxIntake]; //Initializing Student array (yet to instantiate objects)

    static String[] studentIDs = new String[maxIntake];

    static Scanner scanner = new Scanner(System.in); //Initializing a Static scanner just once


    public static void main(String[] args) {

        //Populating empty strings on StudentIDs array
        for (int i = 0; i < studentIDs.length; i++) {
            studentIDs[i] = "";
        }

        int choice = -1; //To avoid reader bugs in case its set to -1

        //Switch case to match choice with methods
        while (choice != 0) {
            menu();
            choice = InputHelpers.getInt();
            switch (choice) {
                case 1:
                    checkAvailableSeats();
                    break;
                case 2:
                    registerStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    storeDetails();
                    break;
                case 6:
                    loadDetails();
                    break;
                case 7:
                    viewStudents();
                    break;
                case 0:
                    System.out.print("Thank you for using the Student manager! \n");
                    break;
                default:
                    System.out.print("Please enter a valid menu option!\n");
            }
        }
    }

    public static void checkAvailableSeats() {
        int remainingSeats = maxIntake - registeredStudentCount;
        System.out.println(remainingSeats + " Seats are remaining");
    }

    public static void registerStudent() {
        if (registeredStudentCount >= 100) { //Allowing only upto 100 Student registers
            System.out.println("Maximum numbers of students Already registered");
        } else {
            String studentID = InputHelpers.getString("Enter Student ID: ");
            studentIDs[registeredStudentCount] = studentID;
            registeredStudentCount++;
        }
    }

    public static void deleteStudent() {

    }

    public static void findStudent() {

    }

    public static void storeDetails() {
        try (FileWriter textFileWriter = new FileWriter(storageFileName)) {
            for (String studentID : studentIDs) {
                if (!studentID.isEmpty()) { //Storing only non-empty student IDs
                    textFileWriter.write(studentID + "\n");
                }
            }
            System.out.println("Successfully saved to file");

        } catch (IOException e) {
            System.out.println("An error occurred saving the file");
            e.printStackTrace();
        }
    }

    public static void loadDetails() {
        try {
            File textFileReader = new File(storageFileName);
            Scanner textFileScanner = new Scanner(textFileReader);

            while (textFileScanner.hasNextLine()) {
                String studentID = textFileScanner.nextLine();
//                String[] parts = lineContents.split("\n");
//                String studentID = parts[0]; //Holds the studentID


                //Writing StudentID to StudentIDs array
                studentIDs[registeredStudentCount] = studentID;
                registeredStudentCount++;

            }

            textFileScanner.close();
            System.out.println("Successfully Loaded File");
        } catch (FileNotFoundException e) {
            System.out.println("File" + storageFileName + "not found");
        }
    }

    public static void viewStudents() {

    }


    public static void menu() {
        System.out.print(""" 
                \n************** Student Activity Management System **************
                1. Check available seats
                2. Register student (with ID)
                3. Delete student
                4. Find student (with student ID)
                5. Store student details into a file
                6. Load student details from the file to the system
                7. View the list of students based on their names
                                
                Select a option (0 to exit) : """);
    }
}
