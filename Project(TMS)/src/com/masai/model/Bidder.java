package com.masai.model;

import java.util.Date;

public class Bidder {
	private String id;
	private int vendorid;
	private String tenderid;
	private int amount;
	private Date date;
	private String status;

	public Bidder() {

	}

	public String getId() {
		return id;
	}

	public int getVendorid() {
		return vendorid;
	}

	public String getTenderid() {
		return tenderid;
	}

	public int getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setVendorid(int vid) {
		this.vendorid = vid;
	}

	public void setTenderid(String tid) {
		this.tenderid = tid;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "bidder [id=" + id + ", vendorid=" + vendorid + ", tenderid=" + tenderid + ", amount=" + amount
				+ ", date=" + date + ", status=" + status + "]";
	}

	public Bidder(String id, int vendorid, String tenderid, int amount, Date date, String status) {
		super();
		this.id = id;
		this.vendorid = vendorid;
		this.tenderid = tenderid;
		this.amount = amount;
		this.date = date;
		this.status = status;
	}

}
