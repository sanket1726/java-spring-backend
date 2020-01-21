package com.app.pojos;

public enum BloodGroup {

	 	A_POSITIVE("A+"),
	    A_NEGATIVE("A-"),
	    O_NEGATIVE("O-"),
	    o_POSITIVE("O+"),
	    B_POSITIVE("B+"),
	    B_NEGATIVE("B-"),
	    AB_POSITIVE("AB+"),
	    AB_NEGATIVE("AB-");
	
	    private final String label;
	 
	    private BloodGroup(String label) { this.label = label; }
	 
	    @Override
	    public String toString() { return label; }
}
