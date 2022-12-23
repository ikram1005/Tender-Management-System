package com.masai.Dao;

import com.masai.Exception.VendorException;
import com.masai.model.Vendor;

public interface VendorDao {

	public String RegisterVendor(Vendor v);

	public Vendor loginVendor(String email, String pass) throws VendorException;
}
