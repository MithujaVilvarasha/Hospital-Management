package com.project.cloud.application;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity

public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long patid;
	private String firstname;
	private String lastname;
	private Date dob;
	private Date registerdate;
	private int age;
	private int contnum;	
	private String doctname;
	
	
	private String medicines;


	public Long getPatid() {
		return patid;
	}


	public void setPatid(Long patid) {
		this.patid = patid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Date getRegisterdate() {
		return registerdate;
	}


	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getContnum() {
		return contnum;
	}


	public void setContnum(int contnum) {
		this.contnum = contnum;
	}


	public String getDoctname() {
		return doctname;
	}


	public void setDoctname(String doctname) {
		this.doctname = doctname;
	}


	public String getMedicines() {
		return medicines;
	}


	public void setMedicines(String medicines) {
		this.medicines = medicines;
	}


	public Patient(Long patid, String firstname, String lastname, Date dob, Date registerdate, int age, int contnum,
			String doctname, String medicines) {
		super();
		this.patid = patid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.registerdate = registerdate;
		this.age = age;
		this.contnum = contnum;
		this.doctname = doctname;
		this.medicines = medicines;
	}


	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

	
	
	
	
	

	
	

	

	
}
