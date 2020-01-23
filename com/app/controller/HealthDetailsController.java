package com.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IHealthDetailsDao;
import com.app.pojos.HealthDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@PostMapping
	public ResponseEntity<?> addHealthDetails(@RequestBody HealthDetails health){
		System.out.println("inside add hDetails controller");
		try {
			return new ResponseEntity<HealthDetails>(healthDao.addHealthDetails(health),HttpStatus.CREATED);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
