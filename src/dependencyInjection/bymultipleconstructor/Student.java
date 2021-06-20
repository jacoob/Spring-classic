package dependencyInjection.bymultipleconstructor;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    private String name;
    private int id;
    private Address address;

    public Student(Address address) {
        this.address = address;
    }

    public Student(String name, int id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Hello: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
