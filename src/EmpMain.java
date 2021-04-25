import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ApplicationContext context=new ClassPathXmlApplicationContext("SpringConfig.xml");
		ApplicationContext context=new ClassPathXmlApplicationContext("SpringConfig.xml");
		Employee e=(Employee)context.getBean("e1");
		DaoImpl d=(DaoImpl)context.getBean("impl");
		d.getEmp(104);

	}
	//Student student = jdbcTemplate.queryForObject(SQL_STUDENT_SELECT_SINGLE, new StudentDaoMapper(),
    //new Object[] { studentId });

}
