package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.ProjectDao;
import com.masai.Dao.ProjectDaoImp;
import com.masai.bean.Admin;

public class AdminLogin {
   public static void main(String[] args) {
	   
	      Scanner scanner=new Scanner(System.in);
	     System.out.println("Enter userName");
		String uName=scanner.next();
		
		System.out.println("Enter password");
		String pass=scanner.next();
		
		ProjectDao pj=new ProjectDaoImp();
		
		try {
			Admin ad=pj.LoginAdmin(uName, pass);
			System.out.println(ad.getUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
