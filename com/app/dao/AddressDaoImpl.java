package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.AddressDetails;

@Repository
@Transactional
public class AddressDaoImpl implements IAddressDao {


	@Autowired
	private SessionFactory sf;
	
//add health details	
	@Override
	public AddressDetails addAddressDetails(AddressDetails address) {
		
		sf.getCurrentSession().persist(address);
		return address;
	}

}
