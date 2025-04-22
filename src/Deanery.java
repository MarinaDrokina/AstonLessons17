import java.util.HashSet;
import java.util.Set;

public class Deanery {

    public static void removeStudents(HashSet<Student> student) {
        student.removeIf(x -> x.averageMark() < 3);
    }

    public static void upgradeCourse(HashSet<Student> student) {
        for (Student s : student) {
            if (s.averageMark() >= 3) s.setCourse(s.getCourse() + 1);
        }
    }

    public static void printStudents(Set<Student> student, int course) {
        for (Student s : student) {
            if (s.getCourse() == course) {
                System.out.println("Student{" +
                        "name='" + s.getName() + '\'' +
                        '}');
            }
        }
    }
}
