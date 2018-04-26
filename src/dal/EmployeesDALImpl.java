package dal;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bd.OraConn;
import domain.Employee;

public class EmployeesDALImpl implements EmployeesDAL {
	
	//FIELDS ////////////////////////////
	SQLException ex;
	
	
	// METHODS ////////////////////////////
	@Override
	public List<Employee> getAll() {
		ArrayList<Employee> returnList = new ArrayList<>();
		try (Statement statement =
				OraConn.getConnection().createStatement();) {
				String query = "SELECT * FROM "+ Employee.getTableName();
				System.out.println(query);
				ResultSet resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					returnList.add(rs2Employee(resultSet)); }
				} catch (SQLException ex) {
					ex.printStackTrace();
					this.ex = ex;
				}
		return returnList;
	}

	@Override
	public Employee getById(int id) {
		try (Statement statement =
			OraConn.getConnection().createStatement();) {
			String query = "SELECT * FROM EMPLOYEES"
						 + "WHERE EMPLOYEE_ID =" + Integer.toString(id);
				System.out.println(query);
				ResultSet result = statement.executeQuery(query);
				if (result == null ) {
					return null;
				} else {
					return rs2Employee(result);
				}
		} catch (SQLException ex) {
			ex.printStackTrace();
			this.ex = ex;
		}
		return null;
	}

	@Override
	public void insert(Employee entity) {
		try (Statement statement =
				OraConn.getConnection().createStatement();) {
			StringBuilder into = new StringBuilder("");
			StringBuilder values = new StringBuilder("");
			into.append("INSERT INTO " + Employee.getTableName() + " ( EMPLOYEE_ID");
			values.append("VALUES (");
			values.append(entity.getId());
			
			if(entity.getFirstName() != null) {
				into.append(" ,FIRST_NAME ");
				values.append(" ," + "'" +entity.getFirstName() +"'"+" ");
			}
			
			if(entity.getJobTitle() != null) {
				into.append(" ,JOB ");
				values.append(" ," + "'" + entity.getJobTitle() +"'"+ " ");
			}
			
			if(entity.getManagerId() != null) {
				into.append(" ,MANAGER_ID ");
				values.append(" ," + "'"+ entity.getJobTitle() +"'" + " ");
			}
			
			if(entity.getHireDate()!=null) {
				into.append(" ,HIREDATE ");
				values.append(" ," + "to_date("+"'" + entity.getHireDate().toString() +"' ,"+ "'" + " ");
			}
			
			if(entity.getSalary() != null) {
				into.append(" ,SALARY ");
				values.append(" ," + "'" +entity.getSalary().toString() +"'" + " ");
			}
			
			if(entity.getDepartmentId() != null) {
				into.append(" ,DEPARTMENT_ID ");
				values.append(" ," + "'" + entity.getDepartmentId().toString()  + " ");
			}
			into.append(") ");
			values.append(") ");
				
			String query = into.toString() + values.toString();
			System.out.println(query);
			statement.executeQuery(query);
			
					
			} catch (SQLException ex) {
				ex.printStackTrace();
				this.ex = ex;
			}
	}

	@Override
	public void update(Employee entity) {
		try (Statement statement =
				OraConn.getConnection().createStatement();) {
				StringBuilder query = new StringBuilder("UPDATE " + Employee.getTableName() + " SET ");
					 
				if(entity.getFirstName() != null) {
					query.append("FIRST_NAME = " + "'" + entity.getFirstName() +"' "); 
				}else {
					query.append("FIRST_NAME = " + "NULL "); 
				}
				
				if(entity.getJobTitle() != null) {
					query.append(", JOB = " + "' "+entity.getJobTitle() +" ' "); 
					
				}else {
					query.append(", JOB = " + "NULL ");
				}
				
				if(entity.getManagerId() != null) {
					query.append(", MANAGER_ID = " + entity.getManagerId()); 
				}else {
					query.append(", MANAGER_ID = " + "NULL ");

				}
				
				if(entity.getHireDate() != null) {
					query.append(", HIREDATE = "  +"to_date(" +"' "+entity.getHireDate()+"', 'yyyyMMdd') ");
				}else {
					query.append(", HIREDATE = " + "NULL ");
				}
				
				if(entity.getSalary() != null) {
					query.append(", SALARY = " + entity.getSalary()); 
				}else {
					query.append(", SALARY = " + "NULL ");

				}
				query.append(" WHERE EMPLOYEE_ID = " + entity.getId());
				System.out.println(query.toString());
				statement.executeQuery(query.toString());
			} catch (SQLException ex) {
			ex.printStackTrace();
			this.ex = ex;
			}
	}

	@Override
	public void delete(int id) {
		try (Statement statement =
				OraConn.getConnection().createStatement();) {
				String query = "DELETE FROM "+Employee.getTableName()
							 + " WHERE EMPLOYEE_ID = " + Integer.toString(id);
				System.out.println(query);
				statement.executeQuery(query);
				
			} catch (SQLException ex) {
				ex.printStackTrace();
				this.ex = ex;
			}
	}
	
	private Employee rs2Employee(ResultSet resultSet){
		Employee emp = null;
		try {
			int col = 1;
			emp = new Employee(resultSet.getInt(col++));
			emp.setFirstName(resultSet.getNString(col++));
			emp.setJobTitle(resultSet.getNString(col++));
			emp.setManagerId(resultSet.getInt(col++));
			if(resultSet.getDate(col)!= null) {
				emp.setHireDate(resultSet.getDate(col++).toLocalDate());
			} else {
				col++;
			}
			emp.setSalary(resultSet.getInt(col++));
			col++;	// COMMISION
			emp.setDepartmentId(resultSet.getInt(col++));
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			this.ex = ex;
		}
		return emp;
	}
			
	
	// GET SET ///////////////////////////
	public SQLException getSQLException() { return ex; }
	
}
	