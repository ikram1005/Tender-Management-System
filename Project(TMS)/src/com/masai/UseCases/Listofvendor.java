package com.masai.UseCases;

import java.util.List;

import com.masai.Dao.VendorDao;
import com.masai.Dao.VendorDaoImpl;
import com.masai.model.Vendor;

public class Listofvendor {

	 public static void vedor() {
			VendorDao pj=new VendorDaoImpl();
			try {
				List<Vendor> vendors=pj.getAllVendors();
				
				vendors.forEach(s ->{
					System.out.println("Vendor Id :"+s.getVendorid());
					System.out.println("Vendor password :"+s.getPassword());
					System.out.println("Vendor name :"+s.getName());
					System.out.println("Vendor mobile :"+s.getMobile());
					System.out.println("Vendor email :"+s.getEmail());
					System.out.println("Vendor company :"+s.getCompany());
					System.out.println("Vendor address :"+s.getAddress());
					System.out.println("=====+=====+=====+=====+======");
				});
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
