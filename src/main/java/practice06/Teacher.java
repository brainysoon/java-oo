package practice06;

public class Teacher extends Person {

    private Integer klass;

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Integer getKlass() {
        return klass;
    }

    public void setKlass(Integer klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return String.format("%s I am a Teacher. I teach %s.",
                super.introduce(), this.klass == null ? "No Class" : "Class " + this.klass);
    }
}
