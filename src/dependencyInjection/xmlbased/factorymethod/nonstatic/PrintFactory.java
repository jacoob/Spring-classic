package dependencyInjection.xmlbased.factorymethod.nonstatic;

public class PrintFactory {


    private PrintFactory() {
    }

    public Printable getPrintableA(){
        return new A();
    }

}
