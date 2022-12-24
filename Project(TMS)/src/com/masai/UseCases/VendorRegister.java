package com.masai.UseCases;

import java.util.Scanner;
import com.masai.Dao.VendorDao;
import com.masai.Dao.VendorDaoImpl;
import com.masai.model.Vendor;

public class VendorRegister {
     public static void VendorR() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter vendor id");
		int vid=scanner.nextInt();
		
		System.out.println("Enter password");
		String pass=scanner.next();
		
		System.out.println("Enter name");
		String vname=scanner.next();
		
		System.out.println("Enter mobile");
		String vmob=scanner.next();
		
		System.out.println("Enter email");
		String vemail=scanner.next();
		
		System.out.println("Enter Company");
		String com=scanner.next();
		
		System.out.println("Enter address");
		String add=scanner.next();
		
		VendorDao pj=new VendorDaoImpl();
		Vendor ven=new Vendor();
		ven.setVendorid(vid);
		ven.setPassword(pass);
		ven.setName(vname);
		ven.setMobile(vmob);
		ven.setEmail(vemail);
		ven.setCompany(com);
		ven.setAddress(add);
		
		String result=pj.RegisterVendor(ven);
		System.out.println(result);
	}
}
