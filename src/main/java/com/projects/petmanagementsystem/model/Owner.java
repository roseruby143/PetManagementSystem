package com.projects.petmanagementsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Owner {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String phone;
	private String email;
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(int ownerId, String name, String phone, String email) {
		super();
		this.id = ownerId;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public Owner(int ownerId) {
		super();
		this.id = ownerId;
	}

	public int getOwnerId() {
		return id;
	}

	public void setOwnerId(int ownerId) {
		this.id = ownerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Owner [ownerId=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
}
