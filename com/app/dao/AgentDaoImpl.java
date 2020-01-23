package com.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Agent;
import com.app.pojos.CLIA;
import com.app.pojos.PolicyHolder;
import com.fasterxml.jackson.databind.ObjectWriter.GeneratorSettings;

@Repository
@Transactional
public class AgentDaoImpl implements IAgentDao{

//Dependency Injection
	@Autowired
	private SessionFactory sf;
	
	
	@Autowired
	private ICliaDao cliaDao;
//list agents method	
	@Override
	public List<Agent> agentsList() {
		System.out.println("inside daoImpl");
		String jpql = "select a from Agent a";
		return sf.getCurrentSession().createQuery(jpql, Agent.class).getResultList();
	}
	
//select agent by id method
	@Override
	public Agent getAgentById(int agentid) {
		//varify before playing
// String jpql = "select a from Agent a where a.agentId=:agentid";
// return sf.getCurrentSession().createQuery(jpql,Agent.class).getSingleResult();
		return sf.getCurrentSession().get(Agent.class, agentid);
	} 

//To Do	
	@Override
	public List<Agent> policyHoldersForAgent(int agentId) {
		
		return null;
	}
	
//add agents method
	@Override
	public Agent addAgent(Agent a) {
		
		cliaDao.updateCountOfAgent();
		sf.getCurrentSession().save(a);
		return a;
	}

//delete agent method	
	@Override
	public void deleteAgent(Agent a) {
		sf.getCurrentSession().delete(a);
	}

//Edit agent method	
	@Override
	public void updateAgent(int agentId , Agent agent) {
		Agent oldAgent=sf.getCurrentSession().byId(Agent.class).load(agentId);
		oldAgent.setAddressLine1(agent.getAddressLine1());
		oldAgent.setCity(agent.getCity());
		oldAgent.setDistrict(agent.getDistrict());
		oldAgent.setState(agent.getState());
		oldAgent.setPhNumber(agent.getPhNumber()); 
		sf.getCurrentSession().flush();
//		sf.getCurrentSession().update(agent);		
	}
 
//login	
	@Override
	public Agent login(int agentId, String phNumber) {
		System.out.println("inside agent login");
		String jpql = "select a from Agent a where a.agentId=:agentId and a.phNumber=:phNumber";
		Agent agent= sf.getCurrentSession().createQuery(jpql,Agent.class).setParameter("agentId", agentId).setParameter("phNumber", phNumber).getSingleResult();
		 
		if(agent != null)
			return agent;
		return null;
	}

//update number of customers 
	@Override
	public void updateCountOfCustomers(int agentId) {
		Agent oldCount=sf.getCurrentSession().byId(Agent.class).load(agentId);
		oldCount.setNoOfCustomers(oldCount.getNoOfCustomers()+1);
//		int icount = oldCount.getNoOfCustomers()+1;
//		oldCount.setNoOfCustomers(icount);
//		sf.getCurrentSession().update(agent);		
	}

}
