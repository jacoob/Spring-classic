package jdbc.jdbctemplate.statement;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveEmployee(Employee e) {
        String query = "insert into Employee (id , name,salary) values(" + e.getId() + ",'" + e.getName() + "'," + e.getSalary() + ");";
        return jdbcTemplate.update(query);
    }


    public int updateEmployee(Employee e) {
        String query = "update employee set name='" + e.getName() + ",salary=" + e.getSalary() + "' where id='" + e.getId() + "' ";
        return jdbcTemplate.update(query);
    }

    public int deleteEmployee(Employee e) {
        String query = "delete from employee where id='" + e.getId() + "' ";
        return jdbcTemplate.update(query);
    }

    public List<Employee> getAll() {
        String query = "select * from employee";
        return jdbcTemplate.query(query, (rs, rowNum) ->
                new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("salary"))
        );
    }

    public Employee getEmployeeById(int id) {
        String query = "select * from employee where id=?";
        return (Employee) jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) ->
                new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("salary")
                )
        );
    }

}
