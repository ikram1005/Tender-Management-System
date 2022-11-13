package com.masai.UseCases;

import java.util.List;

import com.masai.Dao.ProjectDao;
import com.masai.Dao.ProjectDaoImp;
import com.masai.bean.bidder;

public class Listofbids {
   public static void biddert() {
	   ProjectDao pj=new ProjectDaoImp();
		try {
			List<bidder> bidders=pj.getAllbidder();
			
			bidders.forEach(s ->{
				System.out.println("bidder id"+s.getBid());
				System.out.println("vendor id"+s.getVid());
				System.out.println("Tender id"+s.getTid());
				System.out.println("bid amount"+s.getBidamount());
				System.out.println("deadline"+s.getDdate());
				System.out.println("status"+s.getStatus());
				System.out.println("=====+=====+=====+=====+======");
			});
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
}
}
