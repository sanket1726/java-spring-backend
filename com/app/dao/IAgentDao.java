package com.app.dao;

import java.util.List;

import com.app.pojos.Agent;
import com.app.pojos.PolicyHolder;

public interface IAgentDao {
	List<Agent> agentsList();
	Agent getAgentById(int agentId);
	Agent addAgent(Agent a);
	void deleteAgent(Agent a);
	void updateAgent(int agentId , Agent agent);
	
	
	//To do
	List<Agent> policyHoldersForAgent(int agentId);
	
//agent login	
	Agent login(int agentId , String phNumber);
	void updateCountOfCustomers(int agentId);
	
//update no of cutomers
	
}
