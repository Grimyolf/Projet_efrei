package Projet.models;

import java.sql.Date;

public class Person {
	
	private int id;
	private String first_name;
	private String last_Name;
	private String password;
	private Date date_Of_Birth;
	private int address_Id;
	private String phone_no;
	private String genre;

	public Person(String first_name, String last_Name, String password, Date date_Of_Birth, int address_Id, String phone_no, String genre) {
		this.setName(first_name);
		this.setLastName(last_Name);
		this.setPassword(password);
		this.setDateOfBirth(date_Of_Birth);
		this.setAdressId(address_Id);
		this.setPhone(phone_no);
		this.setGenre(genre);
		
	}

	public Person (int id, String first_name, String last_Name, String password, Date date_Of_Birth, int address_Id, String phone_no, String genre) {
		this(first_name, last_Name, password, date_Of_Birth, address_Id, phone_no, genre);
		this.setPersonId(id);
	}

	public int getPersonId() {
		return id;
	}

	public void setPersonId(int id) {
		this.id = id;
	}

	public String getName() {
		return first_name;
	}

	public void setName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_Name;
	}

	public void setLastName(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getDateOfBirth() {
		return date_Of_Birth;
	}

	public void setDateOfBirth(Date date_Of_Birth) {
		this.date_Of_Birth = date_Of_Birth;
	}
	
	public int getAdressId() {
		return address_Id;
	}

	public void setAdressId(int address_Id) {
		this.address_Id = address_Id;
	}
	
	public String getPhone() {
		return phone_no;
	}

	public void setPhone(String phone_no) {
		this.phone_no = phone_no;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Personne : [Id= " + id + ", first_name= " + first_name + ", lastName= " + last_Name + ", password= " + password + ", dateOfBirth= " + date_Of_Birth +", adressId = " + address_Id +", phone= " + phone_no +", genre= " + genre +"]";
	}
 

}


