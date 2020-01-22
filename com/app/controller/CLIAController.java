package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ICliaDao;
import com.app.pojos.CLIA;

@RestController
@CrossOrigin
@RequestMapping("/clia")
public class CLIAController {

	@Autowired
	private ICliaDao cliaDao;
	
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
}
