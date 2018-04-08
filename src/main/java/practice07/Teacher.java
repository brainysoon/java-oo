package practice07;

public class Teacher extends Person {

    private Klass klass;

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return String.format("%s I teach %s.",
                this.basicIntroduce(), this.klass == null ? "No Class" : this.klass.getDisplayName());
    }

    public String introduceWith(Student student) {
        return String.format("%s I%s teach Jerry.", this.basicIntroduce(),
                this.klass.isSameClassOf(student.getKlass()) ? "" : " don't");
    }

    private String basicIntroduce() {
        return String.format("%s I am a Teacher.", super.introduce());
    }
}
