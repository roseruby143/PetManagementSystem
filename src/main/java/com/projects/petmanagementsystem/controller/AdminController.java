package com.projects.petmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projects.petmanagementsystem.dao.OwnerDAO;
import com.projects.petmanagementsystem.dao.PetDAO;
import com.projects.petmanagementsystem.dao.VisitDetailsDAO;
import com.projects.petmanagementsystem.model.Owner;
import com.projects.petmanagementsystem.model.Pet;
import com.projects.petmanagementsystem.model.VisitDetails;
import com.projects.petmanagementsystem.service.VisitDetailServices;



@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired private PetDAO petDao;
	@Autowired private OwnerDAO ownerDao;
	@Autowired private VisitDetailsDAO visitDao;
	@Autowired private VisitDetailServices visitServices;
	
	/************ ADMIN PETS CONTROLLER ************/
	@GetMapping("/pets")
	@ResponseBody
	public List<Pet> getAllPets(){
		List<Pet> allPets = petDao.findAll();
		System.out.println("----------- All Pets are : "+allPets.toString());
		return allPets;
	}
	
	@GetMapping("/pet/{petId}")
	@ResponseBody
	public Optional<Pet> getPetsById(@PathVariable int petId){
		Optional<Pet> petDetail = petDao.findById(petId);
		System.out.println("----------- Pet by id : "+petId+" is : "+petDetail.toString());
		return petDetail;
	}
	
	@PostMapping("/pet")
	@ResponseBody
	public Pet savePets(@RequestBody Pet petData){
		Pet petDetail = petDao.save(petData);
		System.out.println("----------- Saved Pet data is : "+petDetail.toString());
		return petDetail;
	}
	
	@PutMapping("/pet/{petId}")
	@ResponseBody
	public Pet updatePets(@RequestBody Pet petData, @PathVariable int petId){
		petData.setPetId(petId);
		Pet petDetail = petDao.save(petData);
		System.out.println("----------- Saved Pet data is : "+petDetail.toString());
		return petDetail;
	}
	
	@DeleteMapping("/pet/{petId}")
	@ResponseBody
	public Boolean deletePets(@RequestBody Pet petData, @PathVariable int petId){
		try{
			System.out.println("----------- Pet data to be deleted is : "+petData);
			petDao.delete(petData);
			return true;
		}catch(Exception e) {
			System.out.println("----------- Error while deleting Pet data is : "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	/************ ADMIN VISIT DETAILS CONTROLLER ************/
	@GetMapping("/visits")
	@ResponseBody
	public List<VisitDetails> getAllVisitDetails(){
		
		List<VisitDetails> allVisits = visitDao.findAll();
		System.out.println("----------- All Visit are : "+allVisits.toString());
		return allVisits;
	}
	@GetMapping("/pet/{petId}/visits")
	@ResponseBody
	public List<VisitDetails> getAllVisitDetailsByPetId(@PathVariable int petId){
		
		List<VisitDetails> allVisitsByPetId = visitServices.getVisitDetailsByPet(petId);
		System.out.println("----------- All Visit by Pet Id "+petId+" are : "+allVisitsByPetId.toString());
		return allVisitsByPetId;
	}
	
	@GetMapping("/visit/{visitId}")
	@ResponseBody
	public Optional<VisitDetails> getVisitDetailById(@PathVariable int visitId){
		Optional<VisitDetails> visitDetail = visitDao.findById(visitId);
		System.out.println("----------- Visit by id : "+visitId+" is : "+visitDetail.toString());
		return visitDetail;
	}
	
	@PostMapping("/visit")
	@ResponseBody
	public VisitDetails createVisitDetail(@RequestBody VisitDetails visitData){
		VisitDetails visitDetail = visitDao.save(visitData);
		System.out.println("----------- Saved Visit data is : "+visitDetail.toString());
		return visitDetail;
	}
	
	@PutMapping("/visit/{visitId}")
	@ResponseBody
	public VisitDetails updateVisitDetail(@RequestBody VisitDetails vData, @PathVariable int visitId){
		vData.setVisitId(visitId);
		VisitDetails visitDetail = visitDao.save(vData);
		System.out.println("----------- Saved Visit data is : "+visitDetail.toString());
		return visitDetail;
	}
	
	@DeleteMapping("/visit/{visitId}")
	@ResponseBody
	public Boolean deleteVisitDetail(@RequestBody VisitDetails vData, @PathVariable int visitId){
		try{
			System.out.println("----------- Visit data to be deleted is : "+vData);
			visitDao.delete(vData);
			return true;
		}catch(Exception e) {
			System.out.println("----------- Error while deleting Visit data is : "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	/************ ADMIN OWNER CONTROLLER ************/
	@GetMapping("/owners")
	@ResponseBody
	public List<Owner> getAllOwners(){
		List<Owner> allOwner = ownerDao.findAll();
		System.out.println("----------- All Owners are : "+allOwner.toString());
		return allOwner;
	}
	
	@GetMapping("/owner/{id}")
	@ResponseBody
	public Optional<Owner> getOwnerById(@PathVariable int id){
		Optional<Owner> ownerDetail = ownerDao.findById(id);
		System.out.println("----------- Owner by id : "+id+" is : "+ownerDetail.toString());
		return ownerDetail;
	}
	
	@PostMapping("/owner")
	@ResponseBody
	public Owner saveOwner(@RequestBody Owner ownerData){
		Owner ownerDetail = ownerDao.save(ownerData);
		System.out.println("----------- Saved Owner data is : "+ownerDetail.toString());
		return ownerDetail;
	}
	
	@PutMapping("/owner/{id}")
	@ResponseBody
	public Owner updateOwner(@RequestBody Owner ownerData, @PathVariable int id){
		ownerData.setOwnerId(id);
		Owner ownerDetail = ownerDao.save(ownerData);
		System.out.println("----------- Saved Owner data is : "+ownerDetail.toString());
		return ownerDetail;
	}
	
	@DeleteMapping("/owner/{id}")
	@ResponseBody
	public Boolean deleteOwner(@RequestBody Owner ownerData, @PathVariable int id){
		try{
			System.out.println("----------- Owner data to be deleted is : "+ownerData);
			ownerDao.delete(ownerData);
			return true;
		}catch(Exception e) {
			System.out.println("----------- Error while deleting Pet data is : "+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

}
