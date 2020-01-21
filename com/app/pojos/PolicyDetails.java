package com.app.pojos;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "policies")
public class PolicyDetails {

	private PolicyHolder policyHolderForPolicies;
	private Integer policyNumber;
	private int planNo;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "IST")
	private Date dateOfCommencement;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "IST")
	private Date dateOfMaturity;
	private float premiumAmount;
	private PremiumType premiumType;
	private double sumAssured;
	private PolicyStatus policyStatus;
	
	
	//=====================constructor=========================//
	public PolicyDetails() {
		
	}


	public PolicyDetails(Integer policyNumber, int planNo, Date dateOfCommencement, Date dateOfMaturity,
			float premiumAmount, PremiumType premiumType, double sumAssured, PolicyStatus policyStatus) {
		super();
		this.policyNumber = policyNumber;
		this.planNo = planNo;
		this.dateOfCommencement = dateOfCommencement;
		this.dateOfMaturity = dateOfMaturity;
		this.premiumAmount = premiumAmount;
		this.premiumType = premiumType;
		this.sumAssured = sumAssured;
		this.policyStatus = policyStatus;
	}



	//===============+Getters====================================//
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "policyHolderId")
	public PolicyHolder getPolicyHolderForPolicies() {
		return policyHolderForPolicies;
	}

	@Id
	public Integer getPolicyNumber() {
		return policyNumber;
	}

	@Column(name = "planNo")
	public int getPlanNo() {
		return planNo;
	}

	@Column(name = "dateOfCommencement")
	@Temporal(TemporalType.DATE)
	public Date getDateOfCommencement() {
		return dateOfCommencement;
	}

	@Column(name = "dateOfMaturity")
	@Temporal(TemporalType.DATE)
	public Date getDateOfMaturity() {
		return dateOfMaturity;
	}

	@Column(name = "premiumAmount")
	public float getPremiumAmount() {
		return premiumAmount;
	}

	@Column(name = "premiumType")
	@Enumerated(EnumType.STRING)
	public PremiumType getPremiumType() {
		return premiumType;
	}

	@Column(name = "sumAssured")
	public double getSumAssured() {
		return sumAssured;
	}

	@Column(name = "policyStatus")
	@Enumerated(EnumType.STRING)
	public PolicyStatus getPolicyStatus() {
		return policyStatus;
	}


	//=====================SETTERS=====================//
	public void setPolicyHolderForPolicies(PolicyHolder policyHolderForPolicies) {
		this.policyHolderForPolicies = policyHolderForPolicies;
	}


	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}


	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}


	public void setDateOfCommencement(Date dateOfCommencement) {
		this.dateOfCommencement = dateOfCommencement;
	}


	public void setDateOfMaturity(Date dateOfMaturity) {
		this.dateOfMaturity = dateOfMaturity;
	}


	public void setPremiumAmount(float premiumAmount) {
		this.premiumAmount = premiumAmount;
	}


	public void setPremiumType(PremiumType premiumType) {
		this.premiumType = premiumType;
	}


	public void setSumAssured(double sumAssured) {
		this.sumAssured = sumAssured;
	}


	public void setPolicyStatus(PolicyStatus policyStatus) {
		this.policyStatus = policyStatus;
	}
	
	
	
}
