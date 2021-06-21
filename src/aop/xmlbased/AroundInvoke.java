package aop.xmlbased;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundInvoke implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before method call");
        Object o= methodInvocation.proceed();
        System.out.println("after method call");
        return o;
    }
}
