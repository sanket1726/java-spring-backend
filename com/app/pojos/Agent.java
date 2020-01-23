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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.springframework.format.annotation.DateTimeFormat;

import com.app.pojos.GENDER;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Entity
@Table(name = "agents")
public class Agent {

//===============DATA members=====================//

	private Integer agentId;
	
	@Column(name = "fName")
	private String fName;
	
	@Column(name = "mName")
	private String mName;
	
	@Column(name = "lName")
	private String lName;
	
	
	private GENDER gender;
	
	@Column(name = "email")
	private String email;
	

	private MSTATUS mStatus;
	
	@Column(name = "phNumber")
	private String phNumber;
	
	
	@Column(name = "aadharId")
	private String aadharID;
	
	@Column(name = "pancardId")
	private String pancardID;
	
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "IST")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "addressLine1")
	private String addressLine1;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "noOfCustomers")
	private Integer noOfCustomers;
	
	@Column(name = "noOfPolicies")
	private Integer noOfPolicies;
	
	@Column(name = "dlNumber")
	private String dlNumber;
	
	@Column(name = "role")
	private ROLE role;
	
	List<PolicyHolder> policyHolders = new ArrayList<>();
	
	private CLIA cliaId ;
	
//===================Constructors===============//
	public Agent() {
		
	}

	public Agent(String fName, String mName, String lName, GENDER gender, String email, MSTATUS mStatus,
			String phNumber, String aadharID, String pancardID, Date dob, String qualification, String addressLine1,
			String city, String district, String state, Integer noOfCustomers, Integer noOfPolicies, String dlNumber, ROLE role,CLIA cliaId) {
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
		this.addressLine1 = addressLine1;
		this.city = city;
		this.district = district;
		this.state = state;
		this.noOfCustomers = noOfCustomers;
		this.noOfPolicies = noOfPolicies;
		this.dlNumber = dlNumber;
		this.role = role;
		this.cliaId = cliaId;
	}

	
	
	//===================GETTERS & SETTERS===================//

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "agentId")
	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cliaId")
	public CLIA getCliaId() {
		return cliaId;
	}

	public void setCliaId(CLIA cliaId) {
		this.cliaId = cliaId;
	}

	
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}


	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	@Column(name = "mStatus")
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

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getNoOfCustomers() {
		return noOfCustomers;
	}

	public void setNoOfCustomers(Integer noOfCustomers) {
		this.noOfCustomers = noOfCustomers;
	}

	public Integer getNoOfPolicies() {
		return noOfPolicies;
	}

	public void setNoOfPolicies(Integer noOfPolicies) {
		this.noOfPolicies = noOfPolicies;
	}

	public String getDlNumber() {
		return dlNumber;
	}

	public void setDlNumber(String dlNumber) {
		this.dlNumber = dlNumber;
	}

	@OneToMany(mappedBy = "agentId",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	public List<PolicyHolder> getPolicyHolders() {
		return policyHolders;
	}

	
	public void setPolicyHolders(List<PolicyHolder> policyHolders) {
		this.policyHolders = policyHolders;
	}
	
	@Enumerated(EnumType.STRING)
	public ROLE getRole() {
		return role;
	}

	public void setRole(ROLE role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Agent [fName=" + fName + ", mName=" + mName + ", lName=" + lName + ", gender=" + gender + ", email="
				+ email + ", mStatus=" + mStatus + ", phNumber=" + phNumber + ", aadharID=" + aadharID + ", pancardID="
				+ pancardID + ", dob=" + dob + ", qualification=" + qualification + ", addressLine1=" + addressLine1
				+ ", city=" + city + ", district=" + district + ", state=" + state + ", noOfCustomers=" + noOfCustomers
				+ ", noOfPolicies=" + noOfPolicies + ", dlNumber=" + dlNumber + ", policyHolders=" + policyHolders
				+ "]";
	}



}
