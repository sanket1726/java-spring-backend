

package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "policyHolders")
public class PolicyHolder {

	private Integer custId;
	private Agent agentId;
	private String fName;
	private String mName;
	private String lName;
	private GENDER gender;
	private String email;
	private MSTATUS mStatus;
	private String phNumber;
	private String aadharID;
	private String pancardID;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "IST")
	private Date dob;
	private String qualification;
	private String dlNumber;
	private HealthDetails healthDetails;
	private AddressDetails addressDetails;
	private List<PolicyDetails> policies = new ArrayList<>();
	
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private ROLE role;
	//============================ctor=================//
	public PolicyHolder() {
		
	}


	public PolicyHolder(String fName, String mName, String lName, GENDER gender, String email, MSTATUS mStatus,
			String phNumber, String aadharID, String pancardID, Date dob, String qualification, ROLE role,AddressDetails addressDetails,List<PolicyDetails> policies,HealthDetails healthDetails) {
		super();
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.gender = gender;
		this.email = email;
		this.mStatus = mStatus;
		this.phNumber = phNumber;
		this.aadharID = aadharID;
		this.pancardID = pancardID;
		this.dob = dob;
		this.qualification = qualification;
		this.role = role;
		this.addressDetails = addressDetails;
		this.policies = policies;
		this.healthDetails = healthDetails;
	}

	
	//============================================+++GETTERS AND SETTERS===================================================//
	@Id
	@Column(name = "custId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCustId() {
		return custId;
	}

	@Enumerated(EnumType.STRING)
	public ROLE getRole() {
		return role;
	}
	
	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "agentId")
	public Agent getAgentId() {
		return agentId;
	}


	public void setAgentId(Agent agentId) {
		this.agentId = agentId;
	}

	@Column(name = "fName")
	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}

	@Column(name = "mName")
	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}

	@Column(name = "lName")
	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	@Enumerated(EnumType.STRING)
	public GENDER getGender() {
		return gender;
	}


	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Enumerated(EnumType.STRING)
	public MSTATUS getmStatus() {
		return mStatus;
	}


	public void setmStatus(MSTATUS mStatus) {
		this.mStatus = mStatus;
	}


	public String getPhNumber() {
		return phNumber;
	}


	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}


	public String getAadharID() {
		return aadharID;
	}


	public void setAadharID(String aadharID) {
		this.aadharID = aadharID;
	}


	public String getPancardID() {
		return pancardID;
	}


	public void setPancardID(String pancardID) {
		this.pancardID = pancardID;
	}

	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getDlNumber() {
		return dlNumber;
	}


	public void setDlNumber(String dlNumber) {
		this.dlNumber = dlNumber;
	}


	@OneToOne(mappedBy = "policyHolder",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	public HealthDetails getHealthDetails() {
		return healthDetails;
	}


	public void setHealthDetails(HealthDetails healthDetails) {
		this.healthDetails = healthDetails;
	}

	@OneToOne(mappedBy = "policyHolderFor",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	public AddressDetails getAddressDetails() {
		return addressDetails;
	}


	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

	@OneToMany(mappedBy = "policyHolderForPolicies",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	public List<PolicyDetails> getPolicies() {
		return policies;
	}


	public void setPolicies(List<PolicyDetails> policies) {
		this.policies = policies;
	}
	
	public void setRole(ROLE role) {
		this.role = role;
	}
	
}
