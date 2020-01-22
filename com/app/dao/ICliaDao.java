package com.app.dao;

import com.app.pojos.CLIA;

public interface ICliaDao {
	CLIA login(int cliaId , String phNumber); 
}
