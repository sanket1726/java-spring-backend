package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IAddressDao;
import com.app.pojos.AddressDetails;
import com.app.pojos.Agent;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private IAddressDao addressDao;
	
//add address details;
	@PostMapping
	public ResponseEntity<?> addAddressDetails(@RequestBody AddressDetails address){
		System.out.println("inside address add controller");
		try {
			
			return new ResponseEntity<AddressDetails>(addressDao.addAddressDetails(address),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
