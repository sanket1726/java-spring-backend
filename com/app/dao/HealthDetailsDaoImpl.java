package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.HealthDetails;

@Repository
@Transactional
public class HealthDetailsDaoImpl implements IHealthDetailsDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public HealthDetails addHealthDetails(HealthDetails health) {
		
		sf.getCurrentSession().persist(health);
		return health;
	}

}
