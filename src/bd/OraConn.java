package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OraConn {
	static private Connection connection; 
	static private String errorDescription;
	static private Integer errorNumber;
	
	
	static public boolean openConnection(String oracleUrl, String user, String password) {
		try { 
			connection = DriverManager.getConnection(oracleUrl, user, password);
		} catch (SQLException e) {
			errorDescription = e.getMessage();
			errorNumber = e.getErrorCode();
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	static public boolean closeConnection() {
		if (isConnectionEstablished()) {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
				errorDescription = ex.getMessage();
				errorNumber = ex.getErrorCode();
				return false;
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	static public boolean isConnectionEstablished() {
		return connection != null;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		OraConn.connection = connection;
	}

	public static String getErrorDescription() {
		return errorDescription;
	}

	public static void setErrorDescription(String errorDescription) {
		OraConn.errorDescription = errorDescription;
	}

	public static Integer getErrorNumber() {
		return errorNumber;
	}

	public static void setErrorNumber(Integer errorNumber) {
		OraConn.errorNumber = errorNumber;
	}
	
	

}
