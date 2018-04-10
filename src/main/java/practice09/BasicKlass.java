package practice09;

public interface BasicKlass {
    Student getLeader();

    String getDisplayName();

    void appendMember(Student student);

    Integer getNumber();

    boolean isSameClassOf(BasicKlass basicKlass);
}
