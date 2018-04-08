package practice11;

import com.google.common.collect.Sets;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Teacher extends Person implements Observer {
    private Set<Klass> classes;

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.setClasses(Sets.newHashSet(klass));
    }

    public Teacher(int id, String name, int age, HashSet<Klass> classes) {
        super(id, name, age);
        this.setClasses(classes);
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.setClasses(new HashSet<>());
    }

    public Set<Klass> getClasses() {
        return classes;
    }

    private void setClasses(Set<Klass> classes) {
        this.classes = classes;
        this.classes.forEach(klass -> klass.subscribe(this));
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

    @Override
    public void notifyLeaderJoin(Klass klass, Student leader) {
        System.out.println(String.format("I am %s. I know %s become Leader of Class %s.",
                super.getName(), leader.getName(), klass.getNumber()));
    }

    @Override
    public void notifyStudentJoin(Klass klass, Student student) {
        System.out.println(String.format("I am %s. I know %s has joined Class %s.",
                super.getName(), student.getName(), klass.getNumber()));
    }
}
