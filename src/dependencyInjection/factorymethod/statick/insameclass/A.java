package dependencyInjection.factorymethod.statick.insameclass;

public class A implements Printable {

    static A a = new A();

    @Override
    public void print() {
        System.out.println( "A is printed");
    }

    private A(){

    }

    static A getA(){
        return a;
    }
}
