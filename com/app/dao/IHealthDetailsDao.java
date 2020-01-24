package com.app.dao;

import java.util.List;

import com.app.pojos.HealthDetails;

public interface IHealthDetailsDao {
		HealthDetails addHealthDetails(HealthDetails health, Integer custId);
}
