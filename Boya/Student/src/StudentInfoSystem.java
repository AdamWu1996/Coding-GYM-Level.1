import java.util.Comparator;
import java.util.Scanner;

import static java.util.Arrays.sort;
import static java.util.Comparator.comparing;

public class StudentInfoSystem {
    private Student[] students;
    private static final Scanner INPUT = new Scanner(System.in);

    public void start() {
        setUpNumbersOfStudent();
        setUpStudentsInfo();
        sortStudents(comparing(Student::getGrade));
    }

    public void setUpNumbersOfStudent() {
        int numbers = INPUT.nextInt();
        students = new Student[numbers];
    }

    public void setUpStudentsInfo() {
        for (int i = 0; i < students.length; i++) {
            students[i] = createStudent();
        }
    }

    public Student createStudent() {
        int height = INPUT.nextInt();
        int weight = INPUT.nextInt();
        int grade = INPUT.nextInt();
        String studentNumber = INPUT.next();
        return new Student(height, weight, grade, studentNumber);
    }

    public void sortStudents(Comparator<Student> comparator) {
        sort(students, comparator);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : students) {
            stringBuilder.append(student)
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
