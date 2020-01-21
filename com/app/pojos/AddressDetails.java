//----------------------??????????????????????  orphan removal to be done

package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "AddressDetails")
public class AddressDetails {

	private Integer addrSrNo;
	private String addressLine1;
	private String addressLine2;
	private String district;
	private String state;
	private String city;
	private int zipCode;
	private PolicyHolder policyHolderFor;
	
	
	//=============================ctor===============================//
	public AddressDetails() {
		
	}

	public AddressDetails(String addressLine1, String addressLine2, String district, String state, String city,
			int zipCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.district = district;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
	}



	//======================getters==============================//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getAddrSrNo() {
		return addrSrNo;
	}

	@Column(name = "addressLine1")
	public String getAddressLine1() {
		return addressLine1;
	}

	@Column(name = "addressLine2")
	public String getAddressLine2() {
		return addressLine2;
	}

	@Column(name = "district")
	public String getDistrict() {
		return district;
	}

	@Column(name = "state")
	public String getState() {
		return state;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	@Column(name = "zipCode",length = 6,nullable = false)
	public int getZipCode() {
		return zipCode;
	}
	
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "policyHolderId")
	public PolicyHolder getPolicyHolderFor() {
		return policyHolderFor;
	}
	
	
	//===============================SETTERs=========================//
	public void setAddrSrNo(Integer addrSrNo) {
		this.addrSrNo = addrSrNo;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public void setPolicyHolderFor(PolicyHolder policyHolderFor) {
		this.policyHolderFor = policyHolderFor;
	}
}
