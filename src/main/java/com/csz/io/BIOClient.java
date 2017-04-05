package com.csz.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class BIOClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client=new Socket("localhost",8081);
		OutputStream os=client.getOutputStream();
		os.write("报到".getBytes());
		os.close();
		client.close();
	}

}
