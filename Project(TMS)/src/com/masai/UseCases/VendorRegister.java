package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.ProjectDao;
import com.masai.Dao.ProjectDaoImp;
import com.masai.bean.Vendor;

public class VendorRegister {
     public static void VendorR() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter vid");
		int vid=scanner.nextInt();
		
		System.out.println("Enter password");
		String pass=scanner.next();
		
		System.out.println("Enter Vname");
		String vname=scanner.next();
		
		System.out.println("Enter Vmob");
		String vmob=scanner.next();
		
		System.out.println("Enter vemail");
		String vemail=scanner.next();
		
		System.out.println("Enter Company");
		String com=scanner.next();
		
		System.out.println("Enter address");
		String add=scanner.next();
		
		ProjectDao pj=new ProjectDaoImp();
		Vendor ven=new Vendor();
		ven.setVid(vid);
		ven.setPassword(pass);
		ven.setVname(vname);
		ven.setVmob(vmob);
		ven.setVemail(vemail);
		ven.setCompany(com);
		ven.setAddress(add);
		
		String result=pj.RegisterVendor(ven);
		System.out.println(result);
	}
}
