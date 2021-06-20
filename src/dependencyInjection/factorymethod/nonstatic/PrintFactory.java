package dependencyInjection.factorymethod.nonstatic;

public class PrintFactory {


    private PrintFactory() {
    }

    public Printable getPrintableA(){
        return new A();
    }

}
