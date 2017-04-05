package com.csz.dbpool;

import java.sql.SQLException;

public interface IDBPool {
	public MyDBPoolConnection getConnection() throws SQLException;
	public void createConnection(int poolSize);
}
