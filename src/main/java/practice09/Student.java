package practice09;

public class Student extends Person {

    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
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
