package com.masai.model;

import java.util.Date;

public class Tender {
	private String tendorid;
	private String tendorName;
	private String tendortype;
	private int tendorprice;
	private Date deadline;
	private String location;

	public Tender() {

	}
	

	public Tender(String tendorid, String tendorName, String tendortype, int tendorprice, Date deadline,
			String location) {
		super();
		this.tendorid = tendorid;
		this.tendorName = tendorName;
		this.tendortype = tendortype;
		this.tendorprice = tendorprice;
		this.deadline = deadline;
		this.location = location;
	}


	public String getTendorid() {
		return tendorid;
	}

	public String getTendorName() {
		return tendorName;
	}

	public String getTendortype() {
		return tendortype;
	}

	public int getTendorprice() {
		return tendorprice;
	}

	public Date getDeadline() {
		return deadline;
	}

	public String getLocation() {
		return location;
	}

	public void setTendorid(String tendorid) {
		this.tendorid = tendorid;
	}

	public void setTendorName(String tendorName) {
		this.tendorName = tendorName;
	}

	public void setTendortype(String tendortype) {
		this.tendortype = tendortype;
	}

	public void setTendorprice(int tendorprice) {
		this.tendorprice = tendorprice;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Tender [tendorid=" + tendorid + ", tendorName=" + tendorName + ", tendortype=" + tendortype
				+ ", tendorprice=" + tendorprice + ", deadline=" + deadline + ", location=" + location + "]";
	}
	
	
}