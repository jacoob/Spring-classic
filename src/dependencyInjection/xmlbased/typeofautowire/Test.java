package dependencyInjection.xmlbased.typeofautowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        //a autowired by name (b is autowired)
        System.out.println("------------------a autowire=\"byName\" (b is autowired)-------------------");
        A a1 = (A) applicationContext.getBean("a1");
        a1.display();

        //a1 autowired by Type(b is autowired)
        System.out.println("------------------a2 autowire=\"byType\"(b is autowired)-------------------");
        A a2 = (A) applicationContext.getBean("a2");
        String doSomething2 = a2.dosth();
        System.out.println(doSomething2);

        System.out.println("------------------a3 autowire=\"constructor\"r(b is autowired)-------------------");
        A a3 = (A) applicationContext.getBean("a3");
        String doSomething3 = a3.dosth();
        System.out.println(doSomething3);

        System.out.println("------------------a4 autowire=\"no\"-------------------");
        A a4 = (A) applicationContext.getBean("a4");
        String doSomething4 = a4.dosth();
        System.out.println(doSomething4);



    }
}
