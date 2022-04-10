public class Person1 {
    String name;

    public Person1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
