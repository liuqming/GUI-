package emp;

import java.util.List;



/**
 * @author Administrator
 * @version 1.0
 * @created 04-����-2012 16:49:09
 */
public interface EmployeeService {

	/**
	 * 
	 * @param e
	 */
	public void addEmployee(Employee e);

	/**
	 * 
	 * @param e
	 */
	public void delEmployee(Employee e);

	/**
	 * 
	 * @param e
	 */
	public void editEmpployee(Employee e);

	public List<Employee> listAllEmployees();

}