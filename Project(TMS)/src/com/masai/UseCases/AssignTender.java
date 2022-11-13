package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.ProjectDao;
import com.masai.Dao.ProjectDaoImp;


public class AssignTender {
    public static void assignt() {
    	Scanner scanner=new Scanner(System.in);
    	
    	System.out.println("Enter Tender id");
         String tid=scanner.next();
    	
    	System.out.println("Enter Vendor id");
    	int vid=scanner.nextInt();
    	
    	ProjectDao pj=new ProjectDaoImp();
    	
    	try {
    		String result = pj.assigntender(tid, vid);
    		
    		System.out.println(result);
    		}catch(Exception e) {
    			
    			System.out.println(e.getMessage());
    			
    		}
    	
	}
}
