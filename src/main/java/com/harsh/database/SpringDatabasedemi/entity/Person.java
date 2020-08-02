package com.harsh.database.SpringDatabasedemi.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private Date birthDate;
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
}
