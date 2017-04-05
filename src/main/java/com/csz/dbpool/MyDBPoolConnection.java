package com.csz.dbpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDBPoolConnection {
	private Connection conn;
	private boolean isBusy=false;
	public MyDBPoolConnection(Connection conn, boolean isBusy) {
		this.conn = conn;
		this.isBusy = isBusy;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public boolean isBusy() {
		return isBusy;
	}
	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}
	public void close(){
		isBusy=false;
	}
	public ResultSet queryBySql(String sql){
		Statement sm=null;
		ResultSet rs=null;
		try {
			sm = conn.createStatement();
			rs=sm.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int insert(String sql){
		Statement sm=null;
		int row=-1;
		try {
			sm = conn.createStatement();
			row=sm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
}
