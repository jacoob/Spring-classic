package dependencyInjection.xmlbased.factorymethod.statick.inotherclass;

public class PrintFactory {
    private static Printable printable =new A();

    private PrintFactory() {
    }

    public static Printable getPrintableA(){
        return printable;
    }

    public static Printable getPrintableB(){
        return new B();
    }
}
