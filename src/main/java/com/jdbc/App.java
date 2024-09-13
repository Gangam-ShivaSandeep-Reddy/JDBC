package com.jdbc;

import java.sql.Connection;

/**
 * Hello world!
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class App {

	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	private static Connection conn;

	public static void main(String[] args) throws Exception {

		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		System.out.println("connection is opened");

		insertData();

		conn.close();
		System.out.println("connection is closed");
	}

	private static void insertData() throws Exception {

		String sqlQuery = "INSERT INTO STUDENT VALUES(?, ?, ?, ?)";

		//create PreparedStatement
		PreparedStatement ps = conn.prepareStatement(sqlQuery);

		//create Scanner 
		Scanner scan = new Scanner(System.in);

		//insert 3 records
		for ( int i = 1; i <= 3; i++ ) {
			System.out.println("enter sid : ");
			int sid = scan.nextInt();

			scan.nextLine();

			System.out.println("enter sname : ");
			String sname = scan.nextLine();
			System.out.println("enter section : ");
			String section = scan.nextLine();
			System.out.println("enter marks  : ");
			int marks = scan.nextInt();

			//set the values
			ps.setInt(1, sid);
			ps.setString(2, sname);
			ps.setString(3, section);
			ps.setInt(4, marks);

			int count = ps.executeUpdate();

			System.out.println( count + " :  row inserted");

		}
		ps.close();
		scan.close();

	}



}

