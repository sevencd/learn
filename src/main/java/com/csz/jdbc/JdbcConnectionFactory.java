package com.csz.jdbc;

import com.csz.domain.Student;
import com.csz.util.PropertiesUtil;
import com.mysql.jdbc.Statement;

import baseclass.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class JdbcConnectionFactory {
	private static String driver;
	private static String url;
	private static String userName;
	private static String password;
	static {
		Properties pro = new Properties();
		FileInputStream in;
		String jdbcSuffix = "/src/main/resources/jdbc.properties";
		String log4jSuffix = "/src/main/resources/log4j.properties";
		//PropertyConfigurator.configure(getFilePathByKeyName("user.dir") + log4jSuffix);
		Logger logger = Logger.getLogger(JdbcConnectionFactory.class);
		try {
			in = new FileInputStream(getFilePathByKeyName("user.dir") + jdbcSuffix);
			pro.load(in);
			driver = pro.getProperty("jdbc.driverClassName");
			url = pro.getProperty("jdbc.url");
			userName = pro.getProperty("jdbc.username");
			password = pro.getProperty("jdbc.password");
			logger.info(driver);
			logger.info(url);
			logger.info(userName);
			logger.info(password);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Properties readJVMProperties() {
		Properties pps = System.getProperties();
		pps.list(System.out);
		return pps;
	}

	private static String getFilePathByKeyName(String name) {
		return readJVMProperties().getProperty(name);
	}

	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] str) {
		Connection conn=getConn();
		java.sql.Statement s=null;
		try {
			s = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs=null;
		try {
			rs = s.executeQuery("select * from student");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}