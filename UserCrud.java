package jdbc2.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

import jdbc2.dto.User;

public class UserCrud {
	Scanner sc=new Scanner(System.in);
	public void register(User user) throws SQLException, IOException {
		DriverManager.registerDriver(new Driver());
		FileInputStream stream=new 	FileInputStream("DBconfig.properties");
		Properties pr=new Properties();
		pr.load(stream);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", pr);
		PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmial());
		ps.setInt(3,  user.getPhno());
		ps.setString(4, user.getPassword());
		ps.setInt(5, user.getWallet());
		ps.setInt(6, user.getAge());
		ps.setString(7,user.getGender());
		ps.execute();
		ps.close();
		con.close();
		System.out.println("inserted............");
	}
	public boolean login(User user) throws Throwable {
		boolean bool=false;
		DriverManager.registerDriver(new Driver());
		FileInputStream stream=new 	FileInputStream("DBconfig.properties");
		Properties pr=new Properties();
		pr.load(stream);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", pr);
		PreparedStatement ps = con.prepareStatement("select * from user where email=? AND password=?");
		ps.setString(1,user.getEmial() );
		ps.setString(2,user.getPassword());
		ResultSet res = ps.executeQuery();		
		while(res.next()) {
			bool=true;
		}
		ps.close();
		con.close();
		res.close();
		return bool;
		
	}
	public  void items() throws Throwable {
		DriverManager.registerDriver(new Driver());
		FileInputStream stream=new 	FileInputStream("DBconfig.properties");
		Properties pr=new Properties();
		pr.load(stream);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", pr);
		PreparedStatement ps1 = con.prepareStatement("select * from items");
		ResultSet res1 = ps1.executeQuery();		
		while(res1.next()) {
			System.out.print(" "+res1.getInt(1));
			System.out.print(" "+res1.getString(2));
			System.out.print(" "+res1.getDouble(3));
			System.out.println();
		}
		ps1.close();
		con.close();
		
		
	}
	public double Bill(int id,int quantity)throws Throwable {
		double sum=0;
		DriverManager.registerDriver(new Driver());
		FileInputStream stream=new 	FileInputStream("DBconfig.properties");
		Properties pr=new Properties();
		pr.load(stream);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", pr);
		PreparedStatement ps1 = con.prepareStatement("select price from items where id=?");
		ps1.setInt(1, id);
		ResultSet res1 = ps1.executeQuery();
		while(res1.next()) {
			sum=res1.getDouble(1)*quantity;
		}
		ps1.close();
		con.close();
		return sum;
		
	}
	public double wallet(String email) throws Throwable {
		double wallet=0;
		DriverManager.registerDriver(new Driver());
		FileInputStream stream=new 	FileInputStream("DBconfig.properties");
		Properties pr=new Properties();
		pr.load(stream);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", pr);
		PreparedStatement ps = con.prepareStatement("select wallet from user where email=?");
		ps.setString(1, email);
		ResultSet res = ps.executeQuery();
		while(res.next()) {
			wallet=res.getDouble(1);
		}
		ps.close();
		con.close();
		return wallet;
		
	}
	public void updatePrice(double wallet,String email) throws Throwable {
		DriverManager.registerDriver(new Driver());
		FileInputStream stream=new 	FileInputStream("DBconfig.properties");
		Properties pr=new Properties();
		pr.load(stream);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food", pr);
		PreparedStatement ps = con.prepareStatement("UPDATE `food`.`user` SET `wallet`=? where `email`=?");
		ps.setDouble(1, wallet);
		ps.setString(2, email);
		ps.execute();
		ps.close();
		con.close();
	}
}
