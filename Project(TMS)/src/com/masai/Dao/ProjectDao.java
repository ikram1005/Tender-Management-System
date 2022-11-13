package com.masai.Dao;

import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.TenderException;
import com.masai.Exception.VendorException;
import com.masai.bean.Admin;
import com.masai.bean.Vendor;
import com.masai.bean.bidder;
import com.masai.bean.tender;

public interface ProjectDao {
    public Admin LoginAdmin(String user,String pass) throws AdminException;
    
    public String RegisterVendor(Vendor v);
    
    public Vendor loginVendor(String vname,String pass)throws VendorException;
    
    public List<tender> getAllTender()throws TenderException;
    
    public String addTender(tender t);
    
    public String assigntender(String tid,int vid)throws TenderException,VendorException;
    
    public List<bidder> getAllbidder();
    
    public String addbid(bidder b);
}
