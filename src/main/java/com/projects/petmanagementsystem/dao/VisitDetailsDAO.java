package com.projects.petmanagementsystem.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.petmanagementsystem.model.VisitDetails;

public interface VisitDetailsDAO extends JpaRepository<VisitDetails, Integer> {
	
	public List<VisitDetails> findByPetId(int id, Sort s);
}
