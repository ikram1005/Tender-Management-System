package com.masai.UseCases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.masai.Dao.TenderDao;
import com.masai.Dao.TenderDaoImpl;
import com.masai.model.Tender;

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
		
		System.out.println("Enter tender deadline in this format dd/MM/yyyy");
        String d=scanner.next();
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		try {
			date=format.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("Enter tender location");
		String l=scanner.next();
		
		TenderDao pj=new TenderDaoImpl();
		
		Tender tr=new Tender();
		
		tr.setTendorid(tid);
		tr.setTendorName(tn);
		tr.setTendortype(t);
		tr.setTendorprice(p);
		tr.setDeadline(date);
		tr.setLocation(l);
		
		String result=pj.addTender(tr);
		System.out.println(result);
	
	}

}
