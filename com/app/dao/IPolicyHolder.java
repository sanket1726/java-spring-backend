package com.app.dao;

import java.util.List;

import com.app.pojos.AddressDetails;
import com.app.pojos.PolicyHolder;

public interface IPolicyHolder {

	List<PolicyHolder> policyHoldersList();
	
	PolicyHolder getPolicyHolderById(int policyHolderId);
	
	//PolicyHolder addPolicyHolder(PolicyHolder pHolder);
	
	
//tried and work successfully
	PolicyHolder addPolicyHolder(Integer agentId , PolicyHolder pHolder);
	
	void deletePolicyHolder(PolicyHolder pHolder);
	
//update  and phNumber address details
	void updatePolicyHOlder(int policyHolderId , PolicyHolder policyHolder);
	
//count increase
	void updateCountOfPolicies(int custId);
	
//login 
	PolicyHolder login(int custId , String phNumber);

	List<PolicyHolder> policyHoldersByAgentId(int agentId);
	
//select policy Holders by agentid
	
}
