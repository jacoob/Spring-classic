package aop.annotaionbased;

public class Operation {
    public void msg() {
        System.out.println("msg method invoked");
    }

    public int m() {
        System.out.println("m method invoked");
        return 2;
    }


    public int D() {
        System.out.println("D method invoked");
        return 3;
    }
}
