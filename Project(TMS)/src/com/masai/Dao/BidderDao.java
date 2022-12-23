package com.masai.Dao;

import java.util.List;

import com.masai.model.Bidder;

public interface BidderDao {

	public List<Bidder> getAllbidder();

	public String addbid(Bidder b);
}
