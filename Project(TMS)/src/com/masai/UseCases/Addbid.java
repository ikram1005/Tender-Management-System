package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.ProjectDao;
import com.masai.Dao.ProjectDaoImp;
import com.masai.bean.bidder;

public class Addbid {
   public static void addb(){
	   Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter bidder id");
		String tid=scanner.next();
		
		System.out.println("Enter vendor id");
		int vid=scanner.nextInt();
		
		System.out.println("Enter tender id");
		String t=scanner.next();
		
		System.out.println("Enter bidamount");
		int ba=scanner.nextInt();
		
		System.out.println("Enter tender deadline");
		String d=scanner.next();
		
		System.out.println("Enter status");
		String s=scanner.next();
		
		ProjectDao pj=new ProjectDaoImp();
		
		bidder bd=new bidder();
		
		bd.getBid();
		bd.getVid();
		bd.getTid();
		bd.getBidamount();
		bd.getDdate();
		bd.getStatus();
		
		String result=pj.addbid(bd);
		System.out.println(result);
}
}
