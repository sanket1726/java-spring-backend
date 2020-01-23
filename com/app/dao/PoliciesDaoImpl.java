package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.PolicyDetails;
import com.app.pojos.PolicyHolder;

@Repository
@Transactional
public class PoliciesDaoImpl implements IPoliciesDao {

	@Autowired
	private SessionFactory sf;
	
	@Autowired
	private IPolicyHolder policyHolderDao;
	
//list policies	
	@Override
	public List<PolicyDetails> polciesList() {
		System.out.println("inside policies dao");
		String policiesListJpql = "select po from PolicyDetails po";
		return sf.getCurrentSession().createQuery(policiesListJpql, PolicyDetails.class).getResultList();
	}

//getPolicy By PolicyNumber	
	@Override
	public PolicyDetails getPolicyBypolicyNumber(int policyNumber) {
		return sf.getCurrentSession().get(PolicyDetails.class, policyNumber);
	}

//add policy details	
	@Override
	public PolicyDetails addPolicy(int custId , PolicyDetails po) {
		
	//method calling for increasing no of policies of customer
		policyHolderDao.updateCountOfPolicies(custId);
		
		sf.getCurrentSession().persist(po);
		return po;
	}

//add policydetails from custId
	public PolicyDetails addPolicyWithCustId(int custId , PolicyDetails po) {
		
		sf.getCurrentSession().persist(po);
		return po;
	}
	

}
