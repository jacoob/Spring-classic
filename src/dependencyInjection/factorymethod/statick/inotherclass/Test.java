package dependencyInjection.factorymethod.statick.inotherclass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContextFactoryMethod.xml");
        Printable a = (A) context.getBean("printablebeanA");
        a.print();
        Printable b = (B) context.getBean("printablebeanB");
        b.print();

    }
}
