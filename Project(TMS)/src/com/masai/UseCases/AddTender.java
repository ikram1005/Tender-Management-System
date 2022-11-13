package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.ProjectDao;
import com.masai.Dao.ProjectDaoImp;
import com.masai.bean.tender;

public class AddTender {
	
	public static void addt() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter tender id");
		String tid=scanner.next();
		
		System.out.println("Enter tender name");
		String tn=scanner.next();
		
		System.out.println("Enter tender type");
		String t=scanner.next();
		
		System.out.println("Enter tender price");
		int p=scanner.nextInt();
		
		System.out.println("Enter tender deadline");
		String d=scanner.next();
		
		System.out.println("Enter tender location");
		String l=scanner.next();
		
		ProjectDao pj=new ProjectDaoImp();
		
		tender tr=new tender();
		
		tr.setTid(tid);
		tr.setTname(tn);
		tr.setTtype(t);
		tr.setTprice(p);
		tr.setTdeadline(d);
		tr.setTlocation(l);
		
		String result=pj.addTender(tr);
		System.out.println(result);
	
	}

}
