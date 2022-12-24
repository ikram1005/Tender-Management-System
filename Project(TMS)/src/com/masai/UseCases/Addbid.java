package com.masai.UseCases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.masai.Dao.BidderDao;
import com.masai.Dao.BidderDaoImpl;
import com.masai.model.Bidder;

public class Addbid {
   public static void addb(){
	   Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter bidder id");
		String bid=scanner.next();
		
		System.out.println("Enter vendor id");
		int vid=scanner.nextInt();
		
		System.out.println("Enter tender id");
		String tid=scanner.next();
		
		System.out.println("Enter bidamount");
		int ba=scanner.nextInt();
	
	    System.out.println("Enter tender deadline in this format dd/MM/yyyy");
			
		String d=scanner.next();
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		try {
			date=format.parse(d);
		} catch (ParseException e) {
			System.out.println("Enter date in correct format");
			System.out.println();
			addb();
		}
		
		System.out.println("Enter status");
		String s=scanner.next();
		
		BidderDao pj=new BidderDaoImpl();
		
		Bidder bd=new Bidder();
		
		bd.setId(bid);
		bd.setVendorid(vid);
		bd.setTenderid(tid);
		bd.setAmount(ba);
		bd.setDate(date);
		bd.setStatus(s);
		
		
		String result=pj.addbid(bd);
		System.out.println(result);
}
   
}
