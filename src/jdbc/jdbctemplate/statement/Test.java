package jdbc.jdbctemplate.statement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContextjdbc.xml");

        EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");

        //save
        int status = dao.saveEmployee(new Employee(6, "mitra", 100000000));
        System.out.println(status);

        //update
        int status1 = dao.updateEmployee(new Employee(102, "maryam", 15411000));
        System.out.println(status1);

        //delete
        Employee e = new Employee();
        e.setId(102);
        int status2 = dao.deleteEmployee(e);
        System.out.println(status2);


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
