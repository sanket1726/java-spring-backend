package com.app.dao;

import java.util.List;

import com.app.pojos.AddressDetails;
import com.app.pojos.PolicyHolder;

public interface IPolicyHolder {

	List<PolicyHolder> policyHoldersList();
	PolicyHolder getPolicyHolderById(int policyHolderId);
	PolicyHolder addPolicyHolder(PolicyHolder pHolder);
	void deletePolicyHolder(PolicyHolder pHolder);
	void updatePolicyHOlder(int policyHolderId , PolicyHolder policyHolder);
}
