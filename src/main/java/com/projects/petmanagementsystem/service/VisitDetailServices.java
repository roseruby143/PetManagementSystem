package com.projects.petmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.projects.petmanagementsystem.dao.VisitDetailsDAO;
import com.projects.petmanagementsystem.model.VisitDetails;

@Service
public class VisitDetailServices {

	@Autowired VisitDetailsDAO visitsDao;
	
	public List<VisitDetails> getVisitDetailsByPet(int petId) {
		List<String> sortColumn = new ArrayList<String>();
		sortColumn.add("date");
		List<VisitDetails> vData = new ArrayList<VisitDetails>();
		
		visitsDao.findByPetId(petId,Sort.by(Sort.Direction.ASC, "date")).forEach(vData::add);
		//System.out.println("*********** \nbData is: "+bData);
		return vData;
		
	}

}
