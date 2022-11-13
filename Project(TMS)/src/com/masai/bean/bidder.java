package com.masai.bean;

public class bidder {
   private String bid;
   private int vid;
   private String tid;
   private int bidamount;
   private String ddate;
   private String status;
   
   public bidder() {
	   
   }

public bidder(String bid, int vid, String tid, int bidamount, String ddate, String status) {
	super();
	this.bid = bid;
	this.vid = vid;
	this.tid = tid;
	this.bidamount = bidamount;
	this.ddate = ddate;
	this.status = status;
}

public String getBid() {
	return bid;
}

public void setBid(String bid) {
	this.bid = bid;
}

public int getVid() {
	return vid;
}

public void setVid(int vid) {
	this.vid = vid;
}

public String getTid() {
	return tid;
}

public void setTid(String tid) {
	this.tid = tid;
}

public int getBidamount() {
	return bidamount;
}

public void setBidamount(int bidamount) {
	this.bidamount = bidamount;
}

public String getDdate() {
	return ddate;
}

public void setDdate(String ddate) {
	this.ddate = ddate;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

@Override
public String toString() {
	return "bidder [bid=" + bid + ", vid=" + vid + ", tid=" + tid + ", bidamount=" + bidamount + ", ddate=" + ddate
			+ ", status=" + status + "]";
}
   
   
}
