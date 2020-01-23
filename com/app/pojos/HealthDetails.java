//----------------------??????????????????????  orphan removal to be done

package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "healthDetails")
public class HealthDetails {

	private Integer hSrNo;
	private float height;
	private float weight;
	private float bmi=height*weight;
	
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;
	private PolicyHolder policyHolder;
	
	
	//ctor
	public HealthDetails() {
		
	}


	public HealthDetails(float height, float weight, float bmi, BloodGroup bloodGroup) {
		super();
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.bloodGroup = bloodGroup;
	}

	
//getters and setters

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer gethSrNo() {
		return hSrNo;
	}


	public void sethSrNo(Integer hSrNo) {
		this.hSrNo = hSrNo;
	}


	public float getHeight() {
		return height;
	}


	public void setHeight(float height) {
		this.height = height;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}


	public float getBmi() {
		return bmi;
	}


	public void setBmi(float bmi) {
		this.bmi = bmi;
	}


	@Enumerated(EnumType.STRING)
	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "policyHolderId")
	public PolicyHolder getPolicyHolder() {
		return policyHolder;
	}


	public void setPolicyHolder(PolicyHolder policyHolder) {
		this.policyHolder = policyHolder;
	}
	
}
