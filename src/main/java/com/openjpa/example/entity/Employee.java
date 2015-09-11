package com.openjpa.example.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee implements Serializable {
	private static final long serialVersionUID = 4929091802296699091L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String firstname;

	public Employee() {
	}

	private String lastname;


	public Employee(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Employee(Long id, String firstname, String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname;
	}
}

