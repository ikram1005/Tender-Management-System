package com.masai.model;

public class Vendor {
	private int vendorid;
	private String password;
	private String name;
	private String mobile;
	private String email;
	private String company;
	private String address;

	public Vendor() {

	}

	public int getVendorid() {
		return vendorid;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress() {
		return address;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Vendor(int vendorid, String password, String name, String mobile, String email, String company,
			String address) {
		super();
		this.vendorid = vendorid;
		this.password = password;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.company = company;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Vendor [vendorid=" + vendorid + ", password=" + password + ", name=" + name + ", mobile=" + mobile
				+ ", email=" + email + ", company=" + company + ", address=" + address + "]";
	}

}