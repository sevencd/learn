package com.csz.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IOTest {
	Logger log=Logger.getLogger(IOTest.class);
	/*@Before
	public void before(){
		log.info("**************before*****************");
	}
	@After
	public void after(){
		log.info("***************after****************");
	}*/
	@Test
	public void BIOServer() throws IOException{
		new BIOServer(8084).listener();
	}
	@Test
	public void BIOClient() throws IOException{
		Socket client=new Socket("localhost",8084);
		OutputStream os=client.getOutputStream();
		os.write("陈诗".getBytes());
		os.close();
		client.close();	}
}
