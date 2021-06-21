package dependencyInjection.xmlbased.typeofautowire;


public class A {

    B b;

    public A(B b) {
        this.b = b;
    }

    public A() {
        System.out.println("a is created");
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String dosth(){
        return b.getInfo();
    }

    void print(){System.out.println("hello a");}
    void display(){
        print();
        b.print();
    }
}
