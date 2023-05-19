package com.projects.petmanagementsystem.model;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class VisitDetails {

	@Id
	@GeneratedValue
	private int visitId;
	private String notes;
	private Date date;
	
	@OneToOne
	private Pet pet;
	
	public VisitDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VisitDetails(int visitId, String notes, Date date, int petId) {
		super();
		this.visitId = visitId;
		this.notes = notes;
		this.date = date;
		this.pet = new Pet(petId);
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "VisitDetails [visitId=" + visitId + ", notes=" + notes + ", date=" + date + ", pet=" + pet + "]";
	}
	
}
