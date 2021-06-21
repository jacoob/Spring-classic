package jdbc.jdbctemplate.preparedstatement;

import jdbc.jdbctemplate.statement.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoPreparedStatement {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean saveEmployee(Employee employee) {
        String query = "insert into employee values(?,?,?)";
        return (Boolean) jdbcTemplate.execute(query, new PreparedStatementCallback() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1, employee.getId());
                ps.setString(2, employee.getName());
                ps.setFloat(3, employee.getSalary());

                return ps.execute();

            }
        });
    }

    public boolean updateEmployee(Employee employee) {
        String sql = "update employee set name =? where id=?";
        return (boolean) jdbcTemplate.execute(sql, new PreparedStatementCallback() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setString(1, employee.getName());
                preparedStatement.setInt(2, employee.getId());
                return preparedStatement.execute();
            }
        });

    }

    public boolean deleteEmployee(int id) {
        String sql = "delete from employee where id=?";
        return (boolean) jdbcTemplate.execute(sql, new PreparedStatementCallback() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setInt(1, id);
                return preparedStatement.execute();
            }
        });
    }

    public List<Employee> getAll() {
        String sql = "select * from Employee";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("salary")
                )
        );
    }

    public Employee getEmployeeById ( int id){
        String sql = "select * from employee where id =?";
//        return jdbcTemplate.query(sql,new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setInt(1,id);
//            }
//        },(rs,rowNum)->{
//           new Employee(
//                   rs.getInt("id"),
//                   rs.getString("name"),
//                   rs.getInt("salary")
//           ) ;
//        });

        return (Employee) jdbcTemplate.queryForObject(sql,new Object[]{id},(rs, rowNum)->
                new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("salary")
                ));
    }
}
