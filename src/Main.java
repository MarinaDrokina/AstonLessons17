import java.util.*;

public class Main {
    public static void main(String[] args) {


        // Задание 2

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("4452234", "Kivrin");
        phoneBook.addContact("4432145", "Kovrov");
        phoneBook.addContact("4231866", "Sharapov");
        phoneBook.addContact("4656090", "Bochkov");
        phoneBook.addContact("4821369", "Mishina");
        phoneBook.addContact("4458090", "Mihailov");
        phoneBook.addContact("4441334", "Kovrov");

        phoneBook.searchSurnameTel("Kovrov");


// Задание 1

        HashSet<Student> student = new HashSet<>(Set.of());
        student.add(new Student("Lavrov", "A", 4, List.of(1, 2, 3)));
        student.add(new Student("Ivanova", "B", 3, List.of(5, 4, 5)));
        student.add(new Student("Gromov", "C", 1, List.of(4, 2, 3)));
        student.add(new Student("Petrova", "B", 3, List.of(2, 2, 2)));
        student.add(new Student("Medvedev", "A", 2, List.of(3, 1, 1)));
        student.add(new Student("Belkin", "B", 2, List.of(4, 5, 4)));

        for (Student s : student) {
            System.out.println(s);
        }

        System.out.println("Обновленный список без удаленных студентов\n");
        Student.removeStudents(student);
        for (Student s : student) {
            System.out.println(s);
        }

        System.out.println("Список студентов, перешедших на следующий курс: \n");
        Student.upgradeCourse(student);
        for (Student s : student) {
            System.out.println(s);
        }
        Student.printStudents(student, 2);

    }
}