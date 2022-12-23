package com.masai.Dao;

import com.masai.Exception.AdminException;
import com.masai.model.Admin;

public interface AdminDao {

	 public Admin LoginAdmin(String user,String pass) throws AdminException;
}
