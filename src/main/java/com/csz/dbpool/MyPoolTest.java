package com.csz.dbpool;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;

public class MyPoolTest {
	public static void main(String[] args) {
		long beginTime=System.currentTimeMillis();
		final Resource r=new Resource();
		//启动100个线程,从连接池拿连接
		for (int i = 0; i <100; i++) {
			new Thread(new Runnable() {
				public void run() {
					r.subProcess(0);
				}
			}).start();
		}
		r.mainProcess(beginTime);

	}
}
