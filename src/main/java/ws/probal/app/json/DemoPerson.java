package ws.probal.app.json;

public class DemoPerson {

    private String name;
    private int age;

    public DemoPerson() {
    }

    public DemoPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
