package aop.annotaionbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext_AOP_AnnotationBased.xml");
        Operation operation = (Operation) applicationContext.getBean("operationBean");
        operation.D();
        operation.m();
        operation.msg();

        Validator validator = (Validator) applicationContext.getBean("validator");
        try {
            validator.validate(10);
        }catch (Exception e){

        }

        try {
            validator.validate(9);
        }catch (Exception e){

        }
    }
}
