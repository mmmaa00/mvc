package Controller;
import Model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;    
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.RowMapper;    
  
public class EmployeeController {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate temp) {
		this.template = temp;
	}
	public int post(Employee emp) {
		 String sql = "insert into Emp99(name,salary,designation) values('"+ emp.getName()+"',"+emp.getSalary()+",'"+emp.getDesignation()+"')";
		 return template.update(sql);
	}
	public int update(Employee emp) {
		String sql = "update Emp99 set name='" + emp.getName() + "', salary=" + emp.getSalary() + ",designation='" + emp.getDesignation()+"' where id=" + emp.getId()+""; 
		return template.update(sql);
	}
	public int delete(int id){    
	    String sql = "delete from Emp99 where id=" + id + "";    
	    return template.update(sql);    
	}
	public Employee getEmpById(int id){    
	    String sql = "select * from Emp99 where id = ?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));    
	}    
	public List<Employee> getEmployees(){    
	    return template.query("select * from Emp99",new RowMapper<Employee>(){    
	        public Employee mapRow(ResultSet rs, int row) throws SQLException {    
	            Employee emp = new Employee();    
	            emp.setId(rs.getInt(1));    
	            emp.setName(rs.getString(2));    
	            emp.setSalary(rs.getFloat(3));    
	            emp.setDesignation(rs.getString(4));    
	            return emp;    
	        }    
	    });    
	}  
}
