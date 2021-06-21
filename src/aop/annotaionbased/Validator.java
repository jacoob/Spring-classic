package aop.annotaionbased;

public class Validator {
    public void validate(int age)  {
        if (age < 18) {
            throw new ArithmeticException("Not Valid Age");
        } else {
            System.out.println("vote confirmed");
        }
    }
}