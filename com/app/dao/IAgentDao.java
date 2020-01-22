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
	
	//To Do
	List<Agent> policyHoldersForAgent(int agentId);
	//Agent login(Agent a);
}
