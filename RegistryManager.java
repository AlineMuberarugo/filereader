import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistryManager {
    private List<Student> students = new ArrayList<>();

    public void loadStudentsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                double gpa = Double.parseDouble(data[2].trim());
                String major = data[3].trim();

                Student student = new Student(id, name, gpa, major);
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void displayAllStudents() {
        System.out.println("ALL STUDENTS");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void groupStudentsByMajor() {
        System.out.println("\nSTUDENTS GROUPED BY MAJOR");

        for (Student student : students) {
            boolean alreadyDisplayed = false;

            for (Student previous : students) {
                if (previous == student) {
                    break;
                }

                if (previous.getMajor().equals(student.getMajor())) {
                    alreadyDisplayed = true;
                    break;
                }
            }

            if (!alreadyDisplayed) {
                System.out.println("\n" + student.getMajor());

                for (Student s : students) {
                    if (s.getMajor().equals(student.getMajor())) {
                        System.out.println(s.getName());
                    }
                }
            }
        }
    }
}
