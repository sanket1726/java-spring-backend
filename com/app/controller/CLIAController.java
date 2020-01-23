package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ICliaDao;
import com.app.pojos.Agent;
import com.app.pojos.CLIA;

@RestController
@CrossOrigin
@RequestMapping("/clia")
public class CLIAController {

	@Autowired
	private ICliaDao cliaDao;
	
//clia details	
	@GetMapping
	public ResponseEntity<?> listCLIA() {
		System.out.println("inside clia controller");
		List<CLIA> cliaDetails = cliaDao.cliaList();
		
		System.out.println(cliaDetails.toString());
			if(cliaDetails.size() == 0)
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			return new ResponseEntity<List<CLIA>>(cliaDetails,HttpStatus.OK);
	}
	
//login
	@GetMapping("/login/{cliaId}/{phNumber}")
	public ResponseEntity<?> cliaLogin(@PathVariable int cliaId,@PathVariable String phNumber) {
		try {
		CLIA cliaLogin =  cliaDao.login(cliaId, phNumber);
				return new ResponseEntity<CLIA>(cliaLogin,HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}	
	}
	
	
	//Edit Clia by Id
		@PutMapping("/{cliaId}")
		public  ResponseEntity<?> update(@PathVariable("cliaId") int cliaId,@RequestBody CLIA clia){
			cliaDao.updateCLIA(cliaId, clia);
			return ResponseEntity.ok().body("CLIA has edited");
		}
		
}
