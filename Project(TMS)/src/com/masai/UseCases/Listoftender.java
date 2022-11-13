package com.masai.UseCases;

import java.util.List;

import com.masai.Dao.ProjectDao;
import com.masai.Dao.ProjectDaoImp;
import com.masai.bean.tender;

public class Listoftender {
    public static void tender() {
		ProjectDao pj=new ProjectDaoImp();
		try {
			List<tender> tenders=pj.getAllTender();
			
			tenders.forEach(s ->{
				System.out.println("Tender id"+s.getTid());
				System.out.println("Tender name"+s.getTname());
				System.out.println("Tender type"+s.getTtype());
				System.out.println("Tender price"+s.getTprice());
				System.out.println("Tender deadline"+s.getTdeadline());
				System.out.println("Tender Location"+s.getTlocation());
				System.out.println("=====+=====+=====+=====+======");
			});
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
