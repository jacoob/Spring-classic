package dependencyInjection.bymultipleconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        Student student = (Student) context.getBean("studentbean");
        student.displayInfo();
        System.out.println(student.getId());

        student = (Student) context.getBean("studentbean2");
        student.displayInfo();

        student = (Student) context.getBean("studentbean3");
        student.displayInfo();
        System.out.println(student.getAddress().getAddress());
    }
}
