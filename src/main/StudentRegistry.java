package main;

import java.util.Scanner;
import Class.Student;
import frames.MainMenu;
import java.io.IOException;
import libraries.StudentManager;

public class StudentRegistry {

    public static void main(String[] args) throws IOException {

        MainMenu menu = new MainMenu();
        menu.setVisible(true);

        libraries.StudentManager.createFolders();

        /*
        int option;

        do {
            
            System.out.println("\n==== Main Menu ====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student By DNI");
            System.out.println("5. Exit");

            option = libraries.Scanners.scannerInt();
            switch (option) {
                case 1:
                    libraries.StudentManager.addStudent();
                    break;
                case 2:
                    libraries.StudentManager.showStudents();
                    break;
                case 3:
                    libraries.StudentManager.deleteStudent();
                    break;
                case 4:
                    libraries.StudentManager.searchStudentByDni();
                    break;
                case 5:
                    System.out.println("Exiting the pogram....");
                    return;
                default:
                    System.out.println("Invalid Option, Please Try Again");
            }

        } while (option != 5);

*/
    }


}

