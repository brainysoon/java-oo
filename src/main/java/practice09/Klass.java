package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass implements BasicKlass {
    private Integer number;
    private int leader = -1;
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

    public boolean isSameClassOf(BasicKlass klass) {
        return this.number.equals(klass.getNumber());
    }

    public Student getLeader() {
        if (this.member.size() == 0 || this.leader < 0) return new Student(-1, "It's not a student", -1, this);
        return this.member.get(leader);
    }

    public void assignLeader(Student student) {
        if (!member.contains(student)) {
            System.out.println("It is not one of us.");
        } else {
            this.leader = member.indexOf(student);
        }
    }

    public void appendMember(Student student) {
        this.member.add(student);
    }
}
