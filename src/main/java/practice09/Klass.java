package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass {

    private Integer number;
    private Student leader;
    private List<Student> member;

    public Klass(int number) {
        this.number = number;
        this.member = new ArrayList<>();
    }

    public Integer getNumber() {
        return number;
    }

    public String getDisplayName() {
        return String.format("Class %s", this.number);
    }

    public boolean isSameClassOf(Klass klass) {
        return this.number.equals(klass.getNumber());
    }

    public Student getLeader() {
        return leader;
    }

    public void assignLeader(Student student) {
        if (!member.contains(student)) {
            this.leader = new Student(-1, "It's not a student", -1, this);
            System.out.println("It is not one of us.");
        } else {
            this.leader = student;
        }
    }

    public void appendMember(Student student) {
        this.member.add(student);
    }
}
