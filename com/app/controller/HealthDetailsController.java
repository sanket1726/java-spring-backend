package com.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IHealthDetailsDao;
import com.app.pojos.HealthDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@RestController
@RequestMapping("/healthDetails")
public class HealthDetailsController {
	@Autowired
	private IHealthDetailsDao healthDao;
	
//add health details
	@PostMapping(value="/{custId}",consumes= "application/json",produces = "application/json")
	public ResponseEntity<?> addHealthDetails(@RequestBody HealthDetails health,@PathVariable Integer custId){
		System.out.println("inside add hDetails controller");
		System.out.println(health.toString());
		try {
			return new ResponseEntity<HealthDetails>(healthDao.addHealthDetails(health,custId),HttpStatus.CREATED);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
