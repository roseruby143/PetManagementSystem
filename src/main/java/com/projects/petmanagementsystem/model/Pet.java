package com.projects.petmanagementsystem.model;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Pet {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String breed;
	private int weight;
	private int age;
	private Date memberSince;
	
	@OneToOne
	private Owner owner;

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Pet(int id) {
		super();
		this.id = id;
	}

	public Pet(int petId, String name, String breed, int weight, int age, Date memberSince, int ownerId) {
		super();
		this.id = petId;
		this.name = name;
		this.breed = breed;
		this.weight = weight;
		this.age = age;
		this.memberSince = memberSince;
		this.owner = new Owner(ownerId);
	}

	public int getPetId() {
		return id;
	}

	public void setPetId(int petId) {
		this.id = petId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + id + ", name=" + name + ", breed=" + breed + ", weight=" + weight + ", age=" + age
				+ ", memberSince=" + memberSince + ", owner=" + owner + "]";
	}

}
