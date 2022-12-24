package com.masai.Dao;

import java.util.List;

import com.masai.Exception.TenderException;
import com.masai.Exception.VendorException;
import com.masai.model.Tender;

public interface TenderDao {


    public List<Tender> getAllTenders()throws TenderException;
    
    public String addTender(Tender t);
    
}
