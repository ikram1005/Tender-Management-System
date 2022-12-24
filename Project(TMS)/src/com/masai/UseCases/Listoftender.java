package com.masai.UseCases;

import java.util.List;
import com.masai.Dao.TenderDao;
import com.masai.Dao.TenderDaoImpl;
import com.masai.model.Tender;

public class Listoftender {
    public static void tender() {
		TenderDao pj=new TenderDaoImpl();
		try {
			List<Tender> tenders=pj.getAllTenders();
			
			tenders.forEach(s ->{
				System.out.println("Tender id :"+s.getTendorid());
				System.out.println("Tender name :"+s.getTendorName());
				System.out.println("Tender type :"+s.getTendortype());
				System.out.println("Tender price :"+s.getTendorprice());
				System.out.println("Tender deadline :"+s.getDeadline());
				System.out.println("Tender Location :"+s.getLocation());
				System.out.println("=====+=====+=====+=====+======");
			});
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
