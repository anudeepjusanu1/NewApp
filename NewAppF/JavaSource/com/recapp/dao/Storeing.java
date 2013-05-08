package com.recapp.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Storeing {
	public static void main(String[] args) {

		try {

			Class<?> c = Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/NewApp", "root", "123456");

			PreparedStatement s = con
					.prepareStatement("insert into Mp3File values(?,?)");

			s.setInt(1, 1);

			File f = Files1.fileRead();
			FileInputStream fs = new FileInputStream(f);
			s.setBinaryStream(2, fs, fs.available());
			int i = s.executeUpdate();
			if (i > 0) {
				System.out.println("executed successfully");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
