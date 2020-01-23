package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IPoliciesDao;
import com.app.pojos.PolicyDetails;
import com.app.pojos.PolicyHolder;

@CrossOrigin
@RestController
@RequestMapping("/policies")
public class PoliciesController {

	@Autowired
	private IPoliciesDao policiesDao;
	
//list all policies
	@GetMapping
	public ResponseEntity<?> listPolicies() {
		System.out.println("inside policies controller");
		List<PolicyDetails> allPolicies = policiesDao.polciesList();
		
		if(allPolicies.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<PolicyDetails>>(allPolicies,HttpStatus.OK);
	}
	
//get policy policy number	
	@GetMapping("/{policyNumber}")
	public ResponseEntity<?> getPoliciesByPolicyNumber(@PathVariable int policyNumber) {
		System.out.println("in policies by policy number" + policyNumber);
		PolicyDetails po = policiesDao.getPolicyBypolicyNumber(policyNumber);
		if (po == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<PolicyDetails>(po, HttpStatus.OK);
	}
	
	
//add policy with noOfPolicies increment in policyHolder
//	@PostMapping
	@PutMapping("/addPolicy/{custId}")
	public ResponseEntity<?> addNewPolicy(@PathVariable int custId ,  @RequestBody PolicyDetails po) {
		System.out.println("inside add policy controller"+custId);
		try {
			return new ResponseEntity<PolicyDetails>(policiesDao.addPolicy(custId,po), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
