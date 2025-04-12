import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    String name;
    String group;
    Integer course;
    Double averageMark;

    Student(String name, String group, Integer course, List<Integer> listMarks) {
        this.name = name;
        this.group = group;
        this.course = course;
        int sum = 0;
        for (int num : listMarks) {
            sum += num;
        }
        this.averageMark = (double) (sum / listMarks.size());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course= " + course +
                ", averageMark= " + averageMark +
                '}';
    }

    public static void removeStudents(HashSet<Student> student) {
        student.removeIf(x -> x.averageMark < 3);
    }

    public static void upgradeCourse(HashSet<Student> student) {
        for (Student s : student) {
            if (s.averageMark >= 3) s.course++;
        }
    }

    public static void printStudents(Set<Student> student, int course) {
        for (Student s : student) {
            if (s.course == course) {
                System.out.println("Student{" +
                        "name='" + s.name + '\'' +
                        '}');
            }
        }
    }
}

