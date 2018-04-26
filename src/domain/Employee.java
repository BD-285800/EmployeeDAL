package domain;

import java.time.LocalDate;

public class Employee extends AbstractEntity{
	
	// TABLE NAME
	private static final String TABLE_NAME = "EMPLOYEES";
	
	// FIELDS
	private String firstName;
	private Integer managerId;
	private String JobTitle;
	private Integer departmentId;
	private LocalDate hireDate;
	private Integer salary;
	
	
	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Employee(){}
	
	public Employee(Integer id) {
		this.setId(id);
	}
	
	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getJobTitle() {
		return JobTitle;
	}

	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}

	public static String getTableName() {
		return TABLE_NAME;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
}
