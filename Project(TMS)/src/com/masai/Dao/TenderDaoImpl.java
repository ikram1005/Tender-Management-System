package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.masai.Exception.TenderException;
import com.masai.Exception.VendorException;
import com.masai.Utility.JdbcUtil;
import com.masai.model.Tender;

public class TenderDaoImpl implements TenderDao {

	@Override
	public List<Tender> getAllTenders() throws TenderException {

		List<Tender> tenders = new ArrayList<>();
		try (Connection conn = JdbcUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("Select * from tender");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString("tid");
				String tn = rs.getString("tname");
				String tt = rs.getString("ttype");
				int tp = rs.getInt("tprice");
				Date td = rs.getDate("tdeadline");
				String tl = rs.getString("tlocation");

				Tender tr = new Tender(id, tn, tt, tp, td, tl);

				tenders.add(tr);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if (tenders.size() == 0) {
			throw new TenderException("No tenders found");
		}

		return tenders;
	}


	@Override
	public String addTender(Tender t) {
		String m = "not inserted";

		try (Connection conn = JdbcUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into tender values(?,?,?,?,?,?)");

			ps.setString(1, t.getTendorid());
			ps.setString(2, t.getTendorName());
			ps.setString(3, t.getTendortype());
			ps.setInt(4, t.getTendorprice());
			Date dd=t.getDeadline();
			java.sql.Date jd=new java.sql.Date(dd.getTime());
			ps.setDate(5,jd);
			ps.setString(6, t.getLocation());

			int x = ps.executeUpdate();
			if (x > 0) {
				m = "tender added successfully";
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return m;
	}

}
