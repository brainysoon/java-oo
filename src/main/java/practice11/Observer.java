package practice11;

public interface Observer {

    void notifyLeaderJoin(Klass klass, Student leader);

    void notifyStudentJoin(Klass klass, Student student);
}
