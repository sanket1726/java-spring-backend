package com.app.dao;

import java.util.List;

import com.app.pojos.Agent;
import com.app.pojos.CLIA;

public interface ICliaDao {
	CLIA login(int cliaId , String phNumber);

	List<CLIA> cliaList();

	void updateCLIA(int cliaId, CLIA clia); 
	
	void updateCountOfAgent();
}
