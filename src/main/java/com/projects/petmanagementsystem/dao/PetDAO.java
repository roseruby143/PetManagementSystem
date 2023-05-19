package com.projects.petmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.petmanagementsystem.model.Pet;


public interface PetDAO extends JpaRepository<Pet, Integer>{

}
