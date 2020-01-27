package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IPolicyHolder;
import com.app.pojos.Agent;
import com.app.pojos.PolicyHolder;

@CrossOrigin
@RestController
@RequestMapping("/policyHolders")
public class PolicyHolderController {

	@Autowired
	private IPolicyHolder policyHoldersDao;

	// List All policyHolders

	@GetMapping
	public ResponseEntity<?> listPolicyHolders() {
		System.out.println("inside list policyHolders");
		List<PolicyHolder> allPolicyHolders = policyHoldersDao.policyHoldersList();
		
		if (allPolicyHolders.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<PolicyHolder>>(allPolicyHolders, HttpStatus.OK);
	}

	// Get policy Holder by policyHolderId

	@GetMapping("/{policyHolderId}")
	public ResponseEntity<?> getPolicyHolderBycustId(@PathVariable int policyHolderId) {
		System.out.println("in policyHolder by id" + policyHolderId);
		PolicyHolder ph = policyHoldersDao.getPolicyHolderById(policyHolderId);
		if (ph == null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<PolicyHolder>(ph, HttpStatus.OK);
	}


// add policyHolder with increment of no of customers;
	@PutMapping(value="/addCustomer/{agentId}",consumes= "application/json",produces = "application/json")
	public ResponseEntity<?> addNewPolicyHolder(@PathVariable Integer agentId,@RequestBody PolicyHolder ph) {
		System.out.println("inside add policyHolder controller"+agentId);
		//int aId = agentId;
		try {
			return new ResponseEntity<PolicyHolder>(policyHoldersDao.addPolicyHolder(agentId,ph), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// delete policyHolder by Id

/*	@DeleteMapping("/{policyHolderId}")
	public void deletePolicyHolderById(@PathVariable int policyHolderId) {
		System.out.println("inside delete method of controller " + policyHolderId);
		PolicyHolder ph = policyHoldersDao.getPolicyHolderById(policyHolderId);
		policyHoldersDao.deletePolicyHolder(ph);
	}
	*/
	
	//Edit PolicyHolder by Id
	
	@PutMapping("/{policyHolderId}")
	public ResponseEntity<?> update(@PathVariable("policyHolderId") int policyHolderId,@RequestBody PolicyHolder policyHolder){
			policyHoldersDao.updatePolicyHOlder(policyHolderId, policyHolder);
		return ResponseEntity.ok().body("POlicy Holder has Edited");
	}

//Login for customer
	@GetMapping("/login/{custId}/{phNumber}")
	public ResponseEntity<?> policyHolder(@PathVariable int custId , @PathVariable String phNumber) {
		try {
			PolicyHolder customerLogin = policyHoldersDao.login(custId, phNumber);
				return new ResponseEntity<PolicyHolder>(customerLogin,HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		}
	}
	
//get policyHolder by agentId
	@GetMapping("/getCustomersByAgentId/{agentId}") 
	public ResponseEntity<?> listPolicyHoldersByAgentId(@PathVariable int agentId) {
		System.out.println("inside list policyHolders");
		List<PolicyHolder> allPolicyHolders = policyHoldersDao.policyHoldersByAgentId(agentId);
		
		if (allPolicyHolders.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<PolicyHolder>>(allPolicyHolders, HttpStatus.OK);
	}	
	
	
}
