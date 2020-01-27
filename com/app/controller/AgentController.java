package com.app.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IAgentDao;
import com.app.dao.ICliaDao;
import com.app.pojos.Agent;

@CrossOrigin
@RestController
@RequestMapping("/agents")
public class AgentController {

	@Autowired
	private IAgentDao agentDao;
		

//List All Agents	
	@GetMapping
	public ResponseEntity<?> listAgents(){
		System.out.println("inside list agents");
		List<Agent> allAgents = agentDao.agentsList();
//		System.out.println(allAgents.toString());
		if (allAgents.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Agent>>(allAgents,HttpStatus.OK);
	}
	
//Get agent by agentId
	@GetMapping("/{agentId}")
	public ResponseEntity<?> getAgentByAgentId(@PathVariable int agentId){
		System.out.println("in agent by id"+agentId);
		Agent a = agentDao.getAgentById(agentId);
			if(a == null)
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Agent>(a,HttpStatus.OK);
	}
	
//add agent
	@PostMapping
	public ResponseEntity<?> addNewAgent(@RequestBody Agent a){
		System.out.println("inside add emp controller");
		try {
			
			return new ResponseEntity<Agent>(agentDao.addAgent(a),HttpStatus.CREATED);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//delete Agent by Id	
	@DeleteMapping("/{agentId}")
	public void deleteAgentbyId(@PathVariable int agentId){
		System.out.println("inside delete method of controller "+agentId);
		Agent a = agentDao.getAgentById(agentId);
		agentDao.deleteAgent(a);
	}
	
//Edit Agent by Id
	@PutMapping("/edit-agent/{agentId}")
	public  ResponseEntity<?> update(@PathVariable("agentId") int agentId,@RequestBody Agent agent){
		agentDao.updateAgent(agentId, agent);
		return ResponseEntity.ok().body("Agent has edited");
	}
	
//login for agent
	@GetMapping("/login/{agentId}/{phNumber}")
	public ResponseEntity<?> agentLogin(@PathVariable int agentId , @PathVariable String phNumber) {
		try {
			Agent agentLogin = agentDao.login(agentId, phNumber);
				return new ResponseEntity<Agent>(agentLogin,HttpStatus.OK);
		} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
