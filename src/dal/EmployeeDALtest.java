package dal;

import java.util.List;

import domain.Employee;

public class EmployeeDALtest {
	private static int testId = 188;
		static public void testCreate() {
			Employee employee = new Employee(testId);
			employee.setFirstName("PRIM");
			employee.setJobTitle("INS");
			EmployeesDAL employeeDAL = new EmployeesDALImpl();
			employeeDAL.insert(employee);
			
		}
		
		static public void testRead() {
			EmployeesDAL employeeDAL = new EmployeesDALImpl();
			List<Employee> list = employeeDAL.getAll();
			for (Employee e  : list) {
				System.out.println(e.getFirstName() + " - " + e.getJobTitle());
			}
		}
		
		static public void testUpdate() {
			Employee employee = new Employee(testId);
			employee.setFirstName("PRIM");
			employee.setJobTitle("UPT");
			EmployeesDAL employeeDAL = new EmployeesDALImpl();
			employeeDAL.update(employee);

		}
		
		static public void testDelete() {
			EmployeesDAL employeeDAL = new EmployeesDALImpl();
			employeeDAL.delete(testId);
		}
		
		public static void runAlltests() {
			System.out.println("INITIAL STATE");
			System.out.print("QUERY: ");
			EmployeeDALtest.testRead();
			printLine();
			printLine();
			System.out.println("CREATE FUNCION TEST");
			System.out.print("QUERY: ");
			EmployeeDALtest.testCreate();
			printLine();
			printLine();
			System.out.println("READ FUNCION TEST");
			System.out.print("QUERY: ");
			EmployeeDALtest.testRead();
			printLine();
			printLine();
			System.out.println("UPDATE FUNCION TEST");
			System.out.print("QUERY: ");
			EmployeeDALtest.testUpdate();
			printLine();
			printLine();
			System.out.println("READ FUNCION TEST");
			System.out.print("QUERY: ");
			EmployeeDALtest.testRead();
			printLine();
			printLine();
			System.out.println("DELETE FUNCION TEST");
			System.out.print("QUERY: ");
			EmployeeDALtest.testDelete();
			printLine();
			printLine();
			System.out.println("FINAL STATE");
			System.out.print("QUERY: ");
			EmployeeDALtest.testRead();
			printLine();
			printLine();
			printLine();
			System.out.println("OK!");
				
		}
		
		static private void printLine() {
			System.out.println("/////////////////////////////////////////////////////// ");
		}
}
