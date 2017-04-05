package com.csz.dbpool;

public class PoolManager {
	private static class CreatPool{
		private static DBPoolImpl poolImpl=new DBPoolImpl();
	}
	public static DBPoolImpl getDBPoolImpl(){
		return CreatPool.poolImpl;
	}
}
