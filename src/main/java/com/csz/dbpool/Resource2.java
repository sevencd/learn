package com.csz.dbpool;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Resource2 {
	private boolean isSubTread=true;
	private long beginTime;
	private static DBPoolImpl poolImpl = PoolManager.getDBPoolImpl();
	static Logger slflog = LoggerFactory.getLogger(Resource.class);

	public Resource2(long beginTime) {
		// TODO Auto-generated constructor stub
		this.beginTime=beginTime;
	}

	public synchronized static void select() {
		MyDBPoolConnection poolConn;
		try {
			poolConn = poolImpl.getConnection();
			ResultSet rs = poolConn.queryBySql("select * from student");
			while (rs.next()) {
				slflog.info(Thread.currentThread().getName() + rs.getString("name"));
			}
			//rs.close();
			//poolConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public synchronized static void insert() {
		MyDBPoolConnection poolConn;
		try {
			poolConn = poolImpl.getConnection();
			int row = poolConn.insert("insert into student(name,age,sex) values(csz,11,1)");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public synchronized void testPool(){
		while(!isSubTread){
			try {
				wait();
				long endTime=System.currentTimeMillis();
				slflog.info("时间差"+(endTime-beginTime));

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				public void run() {
					select();
				}
			}).start();
			
		}
		isSubTread=false;

		notify();
	}
	public  synchronized void mainProcess(){
		while(isSubTread){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isSubTread=false;
		notify();
		slflog.info(Thread.currentThread().getName());
	}

}
