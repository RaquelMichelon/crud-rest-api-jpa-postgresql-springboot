package com.raquelmichelon.crudrestapijpapostgresqlspringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity //@Entity annotation indicates that the class is a persistent Java class.
@Table(name = "users") //@Table annotation provides the table that maps this entity.
public class User {

	@Id //@Id annotation is for the primary key.
	@GeneratedValue(strategy = GenerationType.AUTO) //@GeneratedValue annotation is used to define generation strategy for the primary key. GenerationType.AUTO means Auto Increment field.
	private long id;

	@NotEmpty(message = "Name must not be empty") //@NotEmpty annotation is used to handle the empty value for that particular field.
	private String name;
	@NotEmpty(message = "Email must not be empty")
	private String email;
	@NotEmpty(message = "Mobile Nnumber must not be empty")
	private String mobNo;
	@NotEmpty(message = "Password must not be empty")
	private String password;

	public User() {
	}

	public User(long id, String name, String email, String mobNo, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobNo = mobNo;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
