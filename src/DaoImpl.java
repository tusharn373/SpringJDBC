import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DaoImpl implements DaoProvider {
	JdbcTemplate jtemp;

	public JdbcTemplate getJtemp() {
		return jtemp;
	}

	public void setJtemp(JdbcTemplate jtemp) {
		this.jtemp = jtemp;
	}

	@Override
	public void insertEmp(Employee e) {
		// TODO Auto-generated method stub
		int x=jtemp.update("insert into employee values(?,?,?,?)",e.getId(),e.getName(),e.getAddress(),e.getSalary());
		if(x>0)
			System.out.println("Record Inserted");
		else
			System.out.println("Failed to insert record");
	}

	@Override
	public void deletEmp(int id) {
		int x=jtemp.update("delete from employee where id=?",id);
		if(x>0)
			System.out.println("Deleted Successfully");
		else
			System.out.println("Unable to delete");
		
	}

	@Override
	public void updateEmp(Employee e) {
		// TODO Auto-generated method stub
		//int x=jtemp.update("update employee set name=? where ")
		
	}

	@Override
	public void getEmp(int id) {
		// TODO Auto-generated method stub
		Employee e=jtemp.queryForObject("select * from employee where Id=?", new Object[] {id}, new BeanPropertyRowMapper<>(Employee.class));
		System.out.println(e);
		
		
	}

	@Override
	public void getAllEmp() {
		// TODO Auto-generated method stub
		List<Employee> l=new ArrayList<Employee>();
		
		
		  List<Map<String,Object>> rows=jtemp.queryForList("select * from employee");
		  for(Map<String,Object> row : rows) { Employee employee = new Employee();
		  employee.setId(Integer.parseInt(String.valueOf(row.get("Id"))));
		  employee.setName(String.valueOf(row.get("Name")));
		  employee.setAddress(String.valueOf(row.get("Address")));
		  employee.setSalary(Float.parseFloat(String.valueOf(row.get("salary"))));
		  //student.setStudentAddress(String.valueOf(row.get("student_address")));
		  l.add(employee); }
		 
		/*
		 * List<Employee> l = jtemp.query("select * from employee", new
		 * BeanPropertyRowMapper(Employee.class));
		 */
		for(Employee i:l)
		{
			System.out.println(i);
		}
		
	}

	

}

