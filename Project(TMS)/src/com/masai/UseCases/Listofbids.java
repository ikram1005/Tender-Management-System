package com.masai.UseCases;

import java.util.List;

import com.masai.Dao.BidderDao;
import com.masai.Dao.BidderDaoImpl;
import com.masai.model.Bidder;

public class Listofbids {
	public static void bids() {
		BidderDao pj = new BidderDaoImpl();
		try {
			List<Bidder> bidders = pj.getAllbidder();

			bidders.forEach(s -> {
				System.out.println("bidder id" + s.getId());
				System.out.println("vendor id" + s.getVendorid());
				System.out.println("Tender id" + s.getTenderid());
				System.out.println("bid amount" + s.getAmount());
				System.out.println("deadline" + s.getDate());
				System.out.println("status" + s.getStatus());
				System.out.println("=====+=====+=====+=====+======");
			});

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
