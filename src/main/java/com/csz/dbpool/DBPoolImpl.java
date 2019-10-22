package com.csz.dbpool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

import org.apache.log4j.chainsaw.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBPoolImpl implements IDBPool {
	Logger slflog = LoggerFactory.getLogger(DBPoolImpl.class);
	private static String driverClassName;
	private static String url;
	private static String username;
	private static String password;
	private static int poolSize;
	private static int stepSize;
	private static int maxSize;

	private Vector<MyDBPoolConnection> poolConnection = new Vector<MyDBPoolConnection>();

	public DBPoolImpl() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void init()
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		InputStream in = IDBPool.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties prop = new Properties();
		prop.load(in);
		if (in == null) {
			System.out.println("加载流失败");
		} else {
			driverClassName = prop.getProperty("driverClassName");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			poolSize = Integer.valueOf(prop.getProperty("poolSize"));
			stepSize = Integer.valueOf(prop.getProperty("stepSize"));
			maxSize = Integer.valueOf(prop.getProperty("maxSize"));

			Driver driver = (Driver) Class.forName(driverClassName).newInstance();
			DriverManager.registerDriver(driver);
			this.createConnection(poolSize);

		}

	}


	public  MyDBPoolConnection getConnection() throws SQLException {
		if (poolConnection.size() <= 0) {
			throw new RuntimeException("连接池为空");
		}
		MyDBPoolConnection poolConn=this.getRealConnection();
		while(poolConn==null){
			//扩容
			createConnection(stepSize);
			poolConn=this.getRealConnection();
		}
		return poolConn;
	}
	private synchronized MyDBPoolConnection getRealConnection() throws SQLException{
		for (Iterator<MyDBPoolConnection> iterator = poolConnection.iterator(); iterator.hasNext();) {
			MyDBPoolConnection myDBPoolConnection = (MyDBPoolConnection) iterator.next();
			if (!myDBPoolConnection.isBusy()) {
				Connection conn = myDBPoolConnection.getConn();
				if (!conn.isValid(2000)) {
					Connection validConn = DriverManager.getConnection(driverClassName, username, password);
					myDBPoolConnection.setConn(validConn);
				}
			}
			myDBPoolConnection.setBusy(true);
			return myDBPoolConnection;
		}
		return null;
	}

	public synchronized void createConnection(int poolSize) {
		if (poolSize + poolConnection.size() > maxSize) {
			throw new RuntimeException("超过连接上限");
		}
		for (int i = 0; i < poolSize; i++) {
			Connection conn;
			try {
				conn = DriverManager.getConnection(url, username, password);
				MyDBPoolConnection poolConn = new MyDBPoolConnection(conn, false);
				poolConnection.add(poolConn);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
			throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		new DBPoolImpl();
	}
}
