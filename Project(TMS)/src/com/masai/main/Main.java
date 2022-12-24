package com.masai.main;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Dao.VendorDao;
import com.masai.Dao.VendorDaoImpl;
import com.masai.Exception.AdminException;
import com.masai.Exception.VendorException;
import com.masai.UseCases.AddTender;
import com.masai.UseCases.Addbid;
import com.masai.UseCases.Listofbids;
import com.masai.UseCases.Listoftender;
import com.masai.UseCases.Listofvendor;
import com.masai.UseCases.VendorRegister;
import com.masai.model.Admin;
import com.masai.model.Vendor;

public class Main {
	public static void main(String[] args) {
		System.out.println("******Welcome to Tender Management System******");
		System.out.println("=======+=======+=======+=====+=====+=======+====");
		
		Scanner scanner = new Scanner(System.in);

		int c;
		do {
			System.out.println("1.Login as Admin");
			System.out.println("2.Login as Vendor");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			c = scanner.nextInt();

			switch (c) {
			case 1: {
				System.out.println("Enter email");
				String email = scanner.next();

				System.out.println("Enter password");
				String pass = scanner.next();

				AdminDao pj = new AdminDaoImpl();

				try {
					Admin ad = pj.LoginAdmin(email, pass);
					System.out.println("Welcome :" + ad.getEmail());

					int x;
					do {
						System.out.println("1.Register as Vendor");
						System.out.println("2.View all Tenders");
						System.out.println("3.Create new Tenders");
						System.out.println("4.view all the bids of a tender");
						System.out.println("5.view all vendors");
						System.out.println("6.Exit");
						System.out.println("Enter your choice");
						x = scanner.nextInt();

						switch (x) {
						case 1: {
							VendorRegister.VendorR();
							break;
						}
						case 2: {
							Listoftender.tender();
							break;
						}
						case 3: {
							AddTender.addt();
							break;
						}
						case 4: {
							Listofbids.bids();
							break;
						}
						case 5: {
							Listofvendor.vedor();
							break;
						}
						default:

							System.out.println("Please enter valid input");

							break;
						}

					} while (x != 6);

				} catch (AdminException e) {
					System.out.println(e.getMessage());
				}

				break;
			}
			case 2: {
				System.out.println("Enter Vendor email");
				String email = scanner.next();

				System.out.println("Enter password");
				String pass = scanner.next();

				VendorDao pj = new VendorDaoImpl();
				try {
					Vendor vr = pj.loginVendor(email, pass);

					System.out.println("Welcome :" + vr.getName());
					System.out.println("======+======+======+=====+=====");

					int x;
					do {
						System.out.println("1.View all the current Tender");
						System.out.println("2.Place a bid against a Tender");
						System.out.println("3.View status of a bid");
						System.out.println("4.Exit");
						System.out.println("Enter your choice");
						x = scanner.nextInt();

						switch (x) {
						case 1: {
							Listoftender.tender();
							break;
						}
						case 2: {
							Addbid.addb();
							break;
						}
						case 3: {
							Listofbids.bids();
							break;
						}
						default:

							System.out.println("Please enter valid input");

							break;
						}

					} while (x != 4);

				} catch (VendorException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			}
		} while (c != 3);
		System.out.println("Thank you for using.....");
	}

}
