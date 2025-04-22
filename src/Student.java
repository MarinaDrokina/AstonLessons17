import java.util.List;

public class Student {
    private String name;
    private String group;
    private Integer course;
    private List<Integer> listMarks;

    Student(String name, String group, Integer course, List<Integer> listMarks) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.listMarks = listMarks;
    }

    public double averageMark() {
        int sum = 0;
        for (int num : listMarks) {
            sum += num;
        }
        return (double) sum / listMarks.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course= " + course +
                ", averageMark= " + averageMark() +
                '}';
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getListMarks() {
        return listMarks;
    }

    public void setListMarks(List<Integer> listMarks) {
        this.listMarks = listMarks;
    }
}

