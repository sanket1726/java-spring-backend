package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.AddressDetails;
import com.app.pojos.Agent;
import com.app.pojos.PolicyHolder;

@Repository
@Transactional
public class PolicyHolderDaoImpl implements IPolicyHolder {
	
	@Autowired
	private SessionFactory sf;
	
//list policyHolders	
	@Override
	public List<PolicyHolder> policyHoldersList() {
		System.out.println("inside daoImpl of policyHolder");
		String jpql = "select p from PolicyHolder p";
		return sf.getCurrentSession().createQuery(jpql, PolicyHolder.class).getResultList();
	}

//select policyHolder by id method	
	@Override
	public PolicyHolder getPolicyHolderById(int policyHolderId) {
		return sf.getCurrentSession().get(PolicyHolder.class, policyHolderId);

	}

//add policyHolder	
	@Override
	public PolicyHolder addPolicyHolder(PolicyHolder pHolder) {
		sf.getCurrentSession().persist(pHolder);
		return pHolder;
	}

//delete policy holder	
	@Override
	public void deletePolicyHolder(PolicyHolder pHolder) {
		sf.getCurrentSession().delete(pHolder);
	}

//edit policyHolder	(ONLY phnNumber and address details)
	@Override
	public void updatePolicyHOlder(int policyHolderId, PolicyHolder policyHolder) {
		PolicyHolder oldPolicyHolder= sf.getCurrentSession().byId(PolicyHolder.class).load(policyHolderId);
		
	//address and phNumber	
		oldPolicyHolder.setPhNumber(policyHolder.getPhNumber());
		oldPolicyHolder.getAddressDetails().setAddressLine1(policyHolder.getAddressDetails().getAddressLine1());
		oldPolicyHolder.getAddressDetails().setAddressLine2(policyHolder.getAddressDetails().getAddressLine2());
		oldPolicyHolder.getAddressDetails().setCity(policyHolder.getAddressDetails().getCity());
		oldPolicyHolder.getAddressDetails().setDistrict(policyHolder.getAddressDetails().getDistrict());
		
		sf.getCurrentSession().flush();
	//	sf.getCurrentSession().update(policyHolder);
	
	}

}
