public class Student implements Comparable<Student> {
    private int height;
    private int weight;
    private int grade;
    private String id;
    public Student(int height, int weight, int grade, String id) {
        this.height = height;
        this.weight = weight;
        this.grade = grade;
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Student [height=%d, weight=%d, grades=%d, id= %s]", height, weight, grade, id);
    }

    @Override
    public int compareTo(Student student) {
        return getGrade() - student.getGrade();
    }
}
