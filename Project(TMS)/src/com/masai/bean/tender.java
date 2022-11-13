package com.masai.bean;


public class tender {
   private String tid;
   private String tname;
   private String ttype;
   private int tprice;
   private String tdeadline;
   private String tlocation;
   
   
   
   public tender() {
	   
   }



public tender(String tid, String tname, String ttype, int tprice, String tdeadline, String tlocation) {
	super();
	this.tid = tid;
	this.tname = tname;
	this.ttype = ttype;
	this.tprice = tprice;
	this.tdeadline = tdeadline;
	this.tlocation = tlocation;
}



public String getTid() {
	return tid;
}



public void setTid(String tid) {
	this.tid = tid;
}



public String getTname() {
	return tname;
}



public void setTname(String tname) {
	this.tname = tname;
}



public String getTtype() {
	return ttype;
}



public void setTtype(String ttype) {
	this.ttype = ttype;
}



public int getTprice() {
	return tprice;
}



public void setTprice(int tprice) {
	this.tprice = tprice;
}



public String getTdeadline() {
	return tdeadline;
}



public void setTdeadline(String tdeadline) {
	this.tdeadline = tdeadline;
}



public String getTlocation() {
	return tlocation;
}



public void setTlocation(String tlocation) {
	this.tlocation = tlocation;
}



@Override
public String toString() {
	return "tender [tid=" + tid + ", tname=" + tname + ", ttype=" + ttype + ", tprice=" + tprice + ", tdeadline="
			+ tdeadline + ", tlocation=" + tlocation + "]";
}
   
   


   
}
