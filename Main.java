import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("students.txt");

        RegistryManager manager = new RegistryManager();

        manager.loadStudentsFromFile(file.getAbsolutePath());
        manager.displayAllStudents();
        manager.groupStudentsByMajor();
    }
}