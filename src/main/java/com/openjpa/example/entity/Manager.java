package com.openjpa.example.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
//@NamedQueries({ @NamedQuery(name = "findAllEmployees", query = "select e from Employee e") })//Java Persistence Query Language (JPQL)
//@Table(name="EMPLOYEE")
public class Manager implements Serializable {
	private static final long serialVersionUID = -6910489845078980950L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String firstname;

	public Manager() {
	}

	private String lastname;


	public Manager(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Manager(Long id, String firstname, String lastname) {
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

