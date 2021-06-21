package aop.annotaionbased;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TrackOperation {

    //    @Pointcut("execution(* Operation.*(..))")  //before all method (from operation class) Aspect is called
    @Pointcut("execution(* aop.annotaionbased.Operation.m*(..))")
    //before all method which start with m (from operation class) Aspect is called
    public void k() {
    }

    @Before("k()")
    public void myAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("before " + methodName + " method is called(all methods)");
    }

    @Pointcut("execution(* aop.annotaionbased.Operation.*(..))")
    //before all method which start with m (from operation class) Aspect is called
    public void A() {
    }


    @After("A()")
    public void myAfterAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After " + methodName + " method is called");
    }

    @Pointcut("execution(* aop.annotaionbased.Operation.D(..))")
    //before all method which start with m (from operation class) Aspect is called
    public void around() {
    }

    @Around("around()")
    public void aroundBody() {
        System.out.println("bagh baghoo");
    }


    @AfterReturning(pointcut = "execution(* Operation.*(..))", returning = "result")
    public void myAdvice(JoinPoint joinPoint, Object result) {
        System.out.println("additional concern");
        System.out.println("Method Signature: " + joinPoint.getSignature());
        System.out.println("Result in advice: " + result);
        System.out.println("end of after returning advice...");
    }

    @AfterThrowing(pointcut = "execution(* Validator.*(..))", throwing = "error")

    public void myadvice(JoinPoint joinPoint, Throwable error)//it is advice
    {
        System.out.println("After throwing  exception in " + joinPoint.getSignature().getName() + " method.");
        System.out.println("Exception is: " + error);
    }


    // TODO: 6/21/2021 check the priority of run aop pointcut

}
