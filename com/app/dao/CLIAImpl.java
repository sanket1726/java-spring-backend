package com.app.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.CLIA;
import com.app.pojos.PolicyHolder;

@Repository
@Transactional
public class CLIAImpl implements ICliaDao {

	@Autowired
	private SessionFactory sf;

	
//login	
	@Override
	public CLIA login(int cliaId, String phNumber) {
		String jpql = "select a from CLIA a where a.cliaId=:cliaId and a.phNumber=:phNumber";
		CLIA clia = sf.getCurrentSession().createQuery(jpql,CLIA.class).setParameter("cliaId", cliaId).setParameter("phNumber", phNumber).getSingleResult();
		 
		if(clia != null)
			return clia;
		return null;
	}



}
