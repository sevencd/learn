package com.csz.dbpool;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Resource {
	private boolean isSubTread = true;
	//static Logger log = Logger.getLogger(Resource.class);
	private static DBPoolImpl poolImpl = PoolManager.getDBPoolImpl();
	static Logger slflog = LoggerFactory.getLogger(Resource.class);

	public synchronized static void select() {
		MyDBPoolConnection poolConn;
		try {
			poolConn = poolImpl.getConnection();
			ResultSet rs = poolConn.queryBySql("select * from student");
			while (rs.next()) {
				slflog.info(Thread.currentThread().getName() + rs.getString("name"));
			}
			// rs.close();
			// poolConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public synchronized void subProcess(int a) {
		while (!isSubTread) {
			try {
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		select();

		isSubTread = false;

		notifyAll();
	}

	public synchronized void mainProcess(long beginTime) {
		while (isSubTread) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		slflog.info("主线程" + Thread.currentThread().getName());
		long endTime=System.currentTimeMillis();
		slflog.info("时间差"+(endTime-beginTime));
		isSubTread = true;
		notifyAll();
	}

}
