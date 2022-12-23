package com.masai.UseCases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exception.AdminException;
import com.masai.model.Admin;

public class AdminLogin {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter email");
		String email = scanner.next();

		System.out.println("Enter password");
		String pass = scanner.next();

		AdminDao pj = new AdminDaoImpl();

		try {
			Admin ad = pj.LoginAdmin(email, pass);
			System.out.println("Welcome :" + ad.getEmail());
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}

	}
}
