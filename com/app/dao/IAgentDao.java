package com.app.dao;

import java.util.List;

import com.app.pojos.Agent;

public interface IAgentDao {
	List<Agent> agentsList();
	Agent getAgentById(int agentId);
	Agent addAgent(Agent a);
	void deleteAgent(Agent a);
	void updateAgent(int agentId , Agent agent);
	//Agent login(Agent a);
}
