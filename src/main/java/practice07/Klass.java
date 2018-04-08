package practice07;

public class Klass {

    private Integer number;

    public Klass(int number) {
        this.number = number;
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
}
