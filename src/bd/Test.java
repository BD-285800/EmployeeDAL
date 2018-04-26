package bd;

import dal.EmployeeDALtest;

public class Test {

	public static void main(String[] args) {
		registerDriver();
		OraConn.openConnection("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf", "anuszel", "anuszel");
		EmployeeDALtest.runAlltests();
		OraConn.closeConnection();
	}
	static private void registerDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Brak sterownika Oracle JDBC.");
		} 
	}
	
}
