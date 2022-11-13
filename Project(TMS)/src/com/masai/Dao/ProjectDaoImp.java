package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Exception.AdminException;
import com.masai.Exception.TenderException;
import com.masai.Exception.VendorException;
import com.masai.Utility.JdbcUtil;
import com.masai.bean.Admin;
import com.masai.bean.Vendor;
import com.masai.bean.bidder;
import com.masai.bean.tender;
import com.masai.exceptions.buyerException;
import com.masai.exceptions.itemException;
import com.masai.utility.JDBCUtil;

public class ProjectDaoImp implements ProjectDao{

	@Override
	public Admin LoginAdmin(String user, String pass) throws AdminException {
		Admin ad=null;
		
		try(Connection conn=JdbcUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("Select * from admin where username=? and password=?");
			
			ps.setString(1,user);
			ps.setString(2,pass);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				String u=rs.getString("username");
				String p=rs.getString("password");
				
				ad=new Admin(u,p);
			}else {
				throw new AdminException("Invalid username and password");
			}
			
			
			
		} catch (SQLException e) {
			throw new AdminException(e.getMessage());
		}
		
		
		return ad;
	}

	@Override
	public String RegisterVendor(Vendor v) {
		String m="not register";
		
		try (Connection conn=JdbcUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("insert into vendor values(?,?,?,?,?,?,?)");
			
			ps.setInt(1,v.getVid());
			ps.setString(2,v.getPassword());
			ps.setString(3,v.getVname());
			ps.setString(4,v.getVmob());
			ps.setString(5,v.getVemail());
			ps.setString(6,v.getCompany());
			ps.setString(7,v.getAddress());
			
			int x=ps.executeUpdate();
			if(x>0) {
				m="registered successfully";
			}
		} catch (SQLException e) {
			m=e.getMessage();
		}
		
		
		
		return m;
	}

	@Override
	public Vendor loginVendor(String vname, String pass) throws VendorException {
		Vendor vr=null;
		
		
		try (Connection conn=JdbcUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("Select * from Vendor where vname=? and password=?");
			
			ps.setString(1,vname);
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				int v=rs.getInt("vid");
				String p=rs.getString("password");
				String vn=rs.getString("vname");
				String m=rs.getString("vmob");
				String e=rs.getString("vemail");
				String c=rs.getString("company");
				String a=rs.getString("address");
				
				vr=new Vendor(v,p,vn,m,e,c,a);
			}else {
				throw new VendorException("invalid vname and password");
			}
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		
		return vr;
	}

	@Override
	public List<tender> getAllTender() throws TenderException {
		
		List<tender> tenders=new ArrayList<>();
		try(Connection conn=JdbcUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("Select * from tender");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String id=rs.getString("tid");
				String tn=rs.getString("tname");
				String tt=rs.getString("ttype");
				int tp=rs.getInt("tprice");
				String td=rs.getString("tdeadline");
				String tl=rs.getString("tlocation");
				
				tender tr=new tender(id,tn,tt,tp,td,tl);
				
				tenders.add(tr);
			}
		} catch (SQLException e) {
			throw new TenderException(e.getMessage());
		}
		if(tenders.size()==0) {
			throw new TenderException("No tender found");
		}
		
		
		return tenders;
	}

	@Override
	public String addTender(tender t) {
		String m="not inserted";
		
		try (Connection conn=JdbcUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("insert into tender values(?,?,?,?,?,?)");
			
			ps.setString(1,t.getTid());
			ps.setString(2,t.getTname());
			ps.setString(3,t.getTtype());
			ps.setInt(4,t.getTprice());
			ps.setString(5,t.getTdeadline());
			ps.setString(6,t.getTlocation());
			
			int x=ps.executeUpdate();
			if(x>0) {
				m="tender added successfully";
			}
			
		} catch (SQLException e) {
			m=e.getMessage();
		}
		return m;
	}

	@Override
	public String assigntender(String tid, int vid) throws TenderException, VendorException {
           String message="unable to assign";
		
		try (Connection connection=JdbcUtil.provideConnection()){
			PreparedStatement ps=connection.prepareStatement("select * from tender where tid=?");
			ps.setString(1, tid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				PreparedStatement ps2=connection.prepareStatement("select * from vendor where vid=?");
				ps2.setInt(1, vid);
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next()) {
					PreparedStatement ps3=connection.prepareStatement("insert into venten values(?,?)");
					ps3.setString(1, tid);
					ps3.setInt(2, vid);
					
					int x=ps3.executeUpdate();
					if(x>0)
						message="tender assigned successfully!";
					else 
						throw new TenderException("technical error");
					
				}else 
					throw new VendorException("invalid vendor id..");
				
			}else 
				throw new TenderException("invalid tender id..");
			
			
		} catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		
		return message;
		
	
	}

	@Override
	public List<bidder> getAllbidder() {
		
		List<bidder> bidders=new ArrayList<>();
		try(Connection conn=JdbcUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("Select * from bidder");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String id=rs.getString("bid");
				int vid=rs.getInt("vid");
				String tid=rs.getString("tid");
				int ba=rs.getInt("bidamount");
				String dd=rs.getString("deadline");
				String st=rs.getString("status");
				
				bidder bd=new bidder(id,vid,tid,ba,dd,st);
				
				bidders.add(bd);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		if(bidders.size()==0) {
			System.out.println("bid not found");
		}
		
		
		return bidders;
	}

	@Override
	public String addbid(bidder b) {
		
        String m="not insert";
		
		try (Connection conn=JdbcUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("insert into bidder values(?,?,?,?,?,?)");
			
			ps.setString(1,b.getBid());
			ps.setInt(2,b.getVid());
			ps.setString(3,b.getTid());
			ps.setInt(4,b.getBidamount());
			ps.setString(5,b.getDdate());
			ps.setString(6,b.getStatus());
			
			int x=ps.executeUpdate();
			if(x>0) {
				m="bid placed successfully";
			}
			
		} catch (SQLException e) {
			m=e.getMessage();
		}
		return m;
	}

}
