package practice10;

public class Student extends Person {

    private BasicKlass klass;

    public Student(int id, String name, int age, BasicKlass klass) {
        super(id, name, age);
        this.klass = klass;
        klass.appendMember(this);
    }

    public BasicKlass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        boolean isLeader = this.klass.getLeader() != null && this.equals(this.klass.getLeader());

        return String.format("%s I am %s %s.",
                this.basicIntroduce(), isLeader ? "Leader of" : "at", this.klass.getDisplayName());
    }

    private String basicIntroduce() {
        return String.format("%s I am a Student.", super.introduce());
    }
}
