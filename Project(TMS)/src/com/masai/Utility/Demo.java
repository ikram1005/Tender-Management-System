package com.masai.Utility;

import java.sql.Connection;

public class Demo {
   public static void main(String[] args) {
	Connection conn=JdbcUtil.provideConnection();
	System.out.println(conn);
}
}
