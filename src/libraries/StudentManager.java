package libraries;

import Class.Student;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import static jdk.jfr.FlightRecorder.register;

public class StudentManager {

    public static File directory;
    public static File archive;
    public static ArrayList<Student> students = new ArrayList<>();
    public static File editFile = new File(directory + File.separator + "register.txt");

    // Create the "files" directory and "register.txt" if they not exist.
    public static void createFolders() throws IOException {
        String projectPath = System.getProperty("user.dir") + File.separator + "files";
        directory = new File(projectPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        archive = new File(projectPath + File.separator + "register.txt");

        if (!archive.exists()) {
            try {
                archive.createNewFile();
            } catch (IOException ex) {
                System.err.println("Can't create the folder");
            }
        }

    }
    
    
    public static ArrayList<String> readStudentsFile() throws FileNotFoundException, IOException {

        ArrayList<String> data = new ArrayList<String>();
        FileReader fr = new FileReader(archive);
        BufferedReader br = new BufferedReader(fr);

        String linea = br.readLine();

        while (linea != null) {
            data.add(linea);
            linea = br.readLine();
        }

        br.close();

        return data;
    }

    public static void getStudents() throws IOException {

        ArrayList<String> studentsData = readStudentsFile();

        for (int i = 0; i < studentsData.size(); i++) {

            String[] parts = studentsData.get(i).split(";");

            Student s = new Student(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);

            students.add(s);
        }

    }

    // Adds a new student to the system and saves it to "register.txt".
    public static void addStudent(String name, String surname, int age, String grade, String dni) {
        /*
        System.out.println("Fisrt Name: ");
        String name = Scanners.scannerLine();
        System.out.println("Last Name: ");
        String surname = Scanners.scannerLine();
        System.out.println("Age: ");
        int age = Scanners.scannerInt();
        System.out.println("Grade: ");
        String grade = Scanners.scannerLine();
        System.out.println("dni: ");
        String dni = Scanners.scannerLine();
        */
        
        
        students.add(new Student(name, surname, age, grade, dni));
        System.out.println("\n<==== Student added Successfully ====>");

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            bw.write(name + "," + surname + "," + age + "," + grade + "," + dni + System.lineSeparator());
            bw.close();

        } catch (Exception e) {
            System.err.println("Error Writing to File");
        }


    }

    // Shows all registered students by reading "register.txt".
    public static void showStudents() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archive));
            String line;
            System.out.println("\n=== List of Students ===");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error Reading File");
        }

    }

    //Shows all students provided by the user. If exists, its eliminated.
    public static void deleteStudent(String dni) throws IOException {
        boolean found = false;

        ArrayList<Student> updatedList = new ArrayList<>();

        for (Student student : students)
        {
            if (!student.getDni().equalsIgnoreCase(dni))
            {
                updatedList.add(student);
            }
            else
            {
                found = true;
            }
        }

        if (found = true)
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(editFile, false));

            for (Student student : updatedList)
            {
                bw.write(student.toString() + System.lineSeparator());
            }

            bw.flush();
            bw.close();
            
            students = updatedList;

            System.out.println("The student was successfully deleted.");
        }
        else
        {
            System.out.println("There are no students with that DNI.");
        }

    }

    // Searches for a student using their DNI and displays their information if found.
    public static void searchStudentByDni() throws FileNotFoundException, IOException {
        System.out.print("\nType the DNI of the student you want to search: ");
        String dni = Scanners.scannerLine();
        boolean found = false;

        BufferedReader br = new BufferedReader(new FileReader(archive));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 5 && parts[4].equalsIgnoreCase(dni)) {
                System.out.println("\nStudent found:");
                System.out.println("Name: " + parts[0]);
                System.out.println("Surname: " + parts[1]);
                System.out.println("Age: " + parts[2]);
                System.out.println("Grade: " + parts[3]);
                System.out.println("DNI: " + parts[4]);
                found = true;
                break;
            }
        }

        br.close();

        if (found = false) {
            System.out.println("\nNo student found with that DNI.");
        }
    }
}

