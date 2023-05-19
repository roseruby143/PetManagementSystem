package com.projects.petmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.petmanagementsystem.model.Owner;

public interface OwnerDAO extends JpaRepository<Owner, Integer> {

}
