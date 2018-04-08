package practice10;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Teacher extends Person {

    private Set<Klass> classes;

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.classes = new HashSet<>();
        this.classes.add(klass);
    }

    public Teacher(int id, String name, int age, HashSet<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.classes = new HashSet<>();
    }

    public Set<Klass> getClasses() {
        return classes;
    }

    public void setClasses(Set<Klass> classes) {
        this.classes = classes;
    }

    @Override
    public String introduce() {
        return String.format("%s I teach %s.",
                this.basicIntroduce(), this.classes.size() > 0 ? this.classesDisplayName() : "No Class");
    }

    public String introduceWith(Student student) {
        return String.format("%s I%s teach Jerry.", this.basicIntroduce(),
                this.classes.stream()
                        .flatMap(students -> students.getMember()
                                .stream()).anyMatch(student::equals) ? "" : " don't");
    }

    private String basicIntroduce() {
        return String.format("%s I am a Teacher.", super.introduce());
    }

    public boolean isTeaching(Student student) {
        return this.classes.stream()
                .anyMatch(klass -> klass.isIn(student));
    }

    private String classesDisplayName() {
        String semanticClasses = this.classes.stream()
                .sorted(Comparator.comparing(Klass::getNumber))
                .reduce("Class ", (str, klass) -> str + klass.getNumber() + ", ", String::concat);
        return semanticClasses.substring(0, semanticClasses.length() - 2);
    }
}
