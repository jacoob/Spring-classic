package dependencyInjection.xmlbased.typeofautowire;

public class B {
    public int id;
    public String name;

    public B() {
        System.out.println("b is created");
    }

    void print(){System.out.println("hello b");}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return id + " "+ name;
    }
}
