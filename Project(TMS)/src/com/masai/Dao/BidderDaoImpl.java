package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.masai.Utility.JdbcUtil;
import com.masai.model.Bidder;

public class BidderDaoImpl implements BidderDao {

	@Override
	public List<Bidder> getAllbidder() {

		List<Bidder> bidders = new ArrayList<>();
		try (Connection conn = JdbcUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Select * from bidder");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("bid");
				int vid = rs.getInt("vid");
				String tid = rs.getString("tid");
				int ba = rs.getInt("bidamount");
				Date dd = rs.getDate("dd");
				String st = rs.getString("status");

				Bidder bd = new Bidder(id, vid, tid, ba, dd, st);

				bidders.add(bd);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if (bidders.size() == 0) {
			System.out.println("bid not found");
		}

		return bidders;
	}

	@Override
	public String addbid(Bidder b) {

		String m = "not insert";

		try (Connection conn = JdbcUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into bidder values(?,?,?,?,?,?)");

			ps.setString(1, b.getId());
			ps.setInt(2, b.getVendorid());
			ps.setString(3, b.getTenderid());
			ps.setInt(4, b.getAmount());
			ps.setDate(5, (java.sql.Date) b.getDate());
			ps.setString(6, b.getStatus());

			int x = ps.executeUpdate();
			if (x > 0) {
				m = "bid placed successfully";
			}

		} catch (SQLException e) {
			m = e.getMessage();
		}
		return m;
	}

}
