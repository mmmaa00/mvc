package Model;

public class Employee {
	private int id;
	private String name;
	private String designation;
	private float salary;
	public Employee() {
		
	}
	public Employee(int empId, String empName, float empSalary, String empDesignation) {
		this.id = empId;
		this.name = empName;
		this.salary = empSalary;
		this.designation = empDesignation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}



