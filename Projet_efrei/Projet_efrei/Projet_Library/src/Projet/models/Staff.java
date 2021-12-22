package Projet.models;

public class Staff {
	private int id;
	private String type;
	private Double salary;
	private int desk_no;
	private int office_no;

	public Staff(String type, Double salary, int desk_no, int office_no) {
		this.setType(type);
		this.setSalary(salary);
		this.setDesk_no(desk_no);
		this.setOffice_no(office_no);
	}
	
	public Staff(int id, String type, Double salary, int desk_no, int office_no) {
		this.setType(type);
		this.setId(id);
		this.setSalary(salary);
		this.setDesk_no(desk_no);
		this.setOffice_no(office_no);
	}
	 ////////////////
	
	public int getId () {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getType () {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public Double getSalary () {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	public int getDesk_no () {
		return desk_no;
	}

	public void setDesk_no(int desk_no) {
		this.desk_no = desk_no;
	}
	
	
	public int getOffice_no () {
		return office_no;
	}

	public void setOffice_no(int office_no) {
		this.office_no = office_no;
	}
	
	@Override
	public String toString() {
		return "Staff [id=" + id + ", type=" + type + ", salary=" + salary + ", desk_no=" + desk_no + ", office_no=" +office_no+ "]";
	}
}
