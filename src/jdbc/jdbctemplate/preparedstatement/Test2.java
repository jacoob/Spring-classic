package jdbc.jdbctemplate.preparedstatement;

import jdbc.jdbctemplate.statement.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContextjdbc.xml");

        EmployeeDaoPreparedStatement dao = (EmployeeDaoPreparedStatement) ctx.getBean("edaoPS");

        boolean status = dao.saveEmployee(new Employee(2, "Maman Tahereh", 15874322));
        System.out.println("save status:" + status);

        boolean status1 = dao.updateEmployee(new Employee(3, "baba Mreza", 15000000));
        System.out.println("update status:" + status1);

//        Employee e = new Employee();
//        boolean status2 = dao.deleteEmployee(2);
//        System.out.println("delete status :"+ status2);

        //select all
        List<Employee> employeeList = dao.getAll();
        for (Employee employee : employeeList) {
            System.out.println(employee.getId() + " | " + employee.getName() + " | " + employee.getSalary());
        }

        //select by id
        Employee employee = dao.getEmployeeById(1);
        System.out.println("select by id :" + employee.getId() + " | " + employee.getName() + " | " + employee.getSalary());

    }
}
