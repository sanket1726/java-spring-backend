package com.app.dao;

import java.util.List;

import com.app.pojos.PolicyDetails;

public interface IPoliciesDao {
	List<PolicyDetails> polciesList();
	PolicyDetails getPolicyBypolicyNumber(int policyNumber);
	PolicyDetails addPolicy(PolicyDetails p);
}
