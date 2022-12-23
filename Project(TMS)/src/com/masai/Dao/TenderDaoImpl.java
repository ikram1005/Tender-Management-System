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
				Date td = rs.getDate("deadline");
				String tl = rs.getString("tlocation");

				Tender tr = new Tender(id, tn, tt, tp, td, tl);

				tenders.add(tr);
			}
		} catch (SQLException e) {
			throw new TenderException(e.getMessage());
		}
		if (tenders.size() == 0) {
			throw new TenderException("No tender found");
		}

		return tenders;
	}

	@Override
	public String assigntender(String tid, int vid) throws TenderException, VendorException {
		String message = "unable to assign";

		try (Connection connection = JdbcUtil.provideConnection()) {
			PreparedStatement ps = connection.prepareStatement("select * from tender where tid=?");
			ps.setString(1, tid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PreparedStatement ps2 = connection.prepareStatement("select * from vendor where vid=?");
				ps2.setInt(1, vid);
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next()) {
					PreparedStatement ps3 = connection.prepareStatement("insert into venten values(?,?)");
					ps3.setString(1, tid);
					ps3.setInt(2, vid);

					int x = ps3.executeUpdate();
					if (x > 0)
						message = "tender assigned successfully!";
					else
						throw new TenderException("technical error");

				} else
					throw new VendorException("invalid vendor id..");

			} else
				throw new TenderException("invalid tender id..");

		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}

		return message;

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
			ps.setDate(5, (java.sql.Date) t.getDeadline());
			ps.setString(6, t.getLocation());

			int x = ps.executeUpdate();
			if (x > 0) {
				m = "tender added successfully";
			}

		} catch (SQLException e) {
			m = e.getMessage();
		}
		return m;
	}

}
