package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="clia")
public class CLIA 
{
	//===============DATA members=====================//

	
	private Integer cliaId;
	
	private String fName;
	
	@Column(name = "mName")
	private String mName;
	
	@Column(name = "lName")
	private String lName;
	
	
	private GENDER gender;
	
	@Column(name = "email",unique = true)
	private String email;
	
	private MSTATUS mStatus;
	
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "IST")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	
	@Column(name = "phNumber")
	private String phNumber;
	

	@Column(name = "aadharId")
	private String aadharID;
	
	@Column(name = "pancardId")
	private String pancardID;
	
	
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
	
	@Column(name = "noOfAgents")
	private Integer noOfAgents;
	
	
	@Column(name = "dlNumber")
	private String dlNumber;
	
	List<Agent> agents = new ArrayList<>();

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private ROLE role;
	//==========================  CONSTRUCTORS=============================//
	
	public CLIA() 
	{
	System.out.println("In CLIA ctor");
	}

	
	public CLIA(String fName, String mName, String lName, GENDER gender, String email, MSTATUS mStatus,
			String phNumber, String aadharID, String pancardID, String qualification,Date dob, String addressLine1, String city,
			String district, String state, Integer noOfAgents, String dlNumber,ROLE role){
		super();
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.gender = gender;
		this.email = email;
		this.mStatus = mStatus;
		this.dob = dob;
		this.phNumber = phNumber;
		this.aadharID = aadharID;
		this.pancardID = pancardID;
		this.qualification = qualification;
		this.addressLine1 = addressLine1;
		this.city = city;
		this.district = district;
		this.state = state;
		this.noOfAgents = noOfAgents;
		this.dlNumber = dlNumber;
		this.role = role;
		
	}


	//==========================  GETTERS AND SETTERS=============================//



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliaId")
	public Integer getCliaId() {
		return cliaId;
	}

	public void setCliaId(Integer cliaId) {
		this.cliaId = cliaId;
	}


	@Column(name = "fName",nullable = false)
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

	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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



	public Integer getNoOfAgents() {
		return noOfAgents;
	}



	public void setNoOfAgents(Integer noOfAgents) {
		this.noOfAgents = noOfAgents;
	}



	public String getDlNumber() {
		return dlNumber;
	}



	public void setDlNumber(String dlNumber) {
		this.dlNumber = dlNumber;
	}


	@OneToMany(mappedBy = "cliaId",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	public List<Agent> getAgents() {
		return agents;
	}



	public void setAgents(List<Agent> agents) {
		this.agents = agents;
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
		return "CLIA [ fName=" + fName + ", mName=" + mName + ", lName=" + lName + ", gender="
				+ gender + ", email=" + email + ", mStatus=" + mStatus + ", dob=" + dob + ", phNumber=" + phNumber
				+ ", aadharID=" + aadharID + ", pancardID=" + pancardID + ", qualification=" + qualification
				+ ", addressLine1=" + addressLine1 + ", city=" + city + ", district=" + district + ", state=" + state
				+ ", noOfAgents=" + noOfAgents + ", dlNumber=" + dlNumber + ", agents=" + agents + "]";
	}
	
	
	

}