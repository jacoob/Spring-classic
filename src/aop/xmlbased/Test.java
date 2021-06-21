package aop.xmlbased;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class Test {
    public static void main(String[] args) {
        Resource resource=  new ClassPathResource("META-INF/applicationContext_AOP_XmlBased.xml");
        BeanFactory beanFactory=new XmlBeanFactory(resource);

        System.out.println("\n------ Proxy ------");
        A a=beanFactory.getBean("proxy",A.class);
        a.m();

        System.out.println("\n------proxy After Returning------");
        A proxyAfterReturning = beanFactory.getBean("proxyAfterReturning", A.class);
        proxyAfterReturning.m();

        System.out.println("\n------proxy Method Invocation------");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext_AOP_XmlBased.xml");
        A proxyMethodInvocation = applicationContext.getBean("proxyMethodInvocation", A.class);
        proxyMethodInvocation.m();

        System.out.println("\n------Proxy throws Advisor------");
        Validator validator = applicationContext.getBean("throwsAdvisorProxy", Validator.class);
        try {
            validator.validate(10);
        }catch (Exception e){

        }
    }
}
