package com.app.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Agent;
import com.app.pojos.CLIA;
import com.app.pojos.PolicyHolder;

@Repository
@Transactional
public class CLIAImpl implements ICliaDao {

	@Autowired
	private SessionFactory sf;

//list clia method
		@Override
		public List<CLIA> cliaList() {
			System.out.println("inside  clia daoImpl");
			String jpql = "select a from CLIA a";
			return sf.getCurrentSession().createQuery(jpql, CLIA.class).getResultList();
		
		}
	
	
	
//login	
	@Override
	public CLIA login(int cliaId, String phNumber) {
		String jpql = "select a from CLIA a where a.cliaId=:cliaId and a.phNumber=:phNumber";
		CLIA clia = sf.getCurrentSession().createQuery(jpql,CLIA.class).setParameter("cliaId", cliaId).setParameter("phNumber", phNumber).getSingleResult();
		 
		if(clia != null)
			return clia;
		return null;
	}

//edit Details
	@Override
	public void updateCLIA(int cliaId , CLIA clia) {
		CLIA oldClia=sf.getCurrentSession().byId(CLIA.class).load(cliaId);
		oldClia.setAddressLine1(clia.getAddressLine1());
		oldClia.setCity(clia.getCity());
		oldClia.setDistrict(clia.getDistrict());
		oldClia.setState(clia.getState());
		oldClia.setPhNumber(clia.getPhNumber()); 
		sf.getCurrentSession().flush();
//		sf.getCurrentSession().update(agent);		
	}


//increase  no. of agetns by 1
	@Override
	public void updateCountOfAgent() {
		CLIA oldCount=sf.getCurrentSession().byId(CLIA.class).load(1);
		int i = oldCount.getNoOfAgents()+1;
		oldCount.setNoOfAgents(i);
		System.out.println("count"+i);
		sf.getCurrentSession().flush();
	}


}
