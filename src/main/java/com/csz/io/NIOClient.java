package com.csz.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NIOClient {
	Logger slflog=LoggerFactory.getLogger(NIOClient.class);

	SocketChannel client;

	private Selector selector;
	
	private ByteBuffer receiveBuffer=ByteBuffer.allocate(1024);
	private ByteBuffer sendBuffer=ByteBuffer.allocate(1024);

	public NIOClient(int port) throws IOException {
		client=SocketChannel.open();
		client.configureBlocking(false);
		client.connect(new InetSocketAddress("localhost",port));
		selector=Selector.open();
		client.register(selector, SelectionKey.OP_CONNECT);
		
	}
	public void session() throws IOException{
		if(client.isConnectionPending()){
			client.finishConnect();
			slflog.info("请在控制台登记姓名");

			client.register(selector, SelectionKey.OP_WRITE);
		}
		Scanner scan=new Scanner(System.in);
		while(scan.hasNextLine()){
			String name=scan.nextLine();
			if("".equals(name)){
				continue;
			}
			this.process(name);
		}
	}
	private void process(String name) throws IOException {
		boolean unfinesh=true;
		while(unfinesh){
			int i=selector.select();
			if(i==0){
				continue;
			}
			Set<SelectionKey> keys=selector.selectedKeys();
			Iterator<SelectionKey > iter=keys.iterator();
			while (iter.hasNext()) {
				SelectionKey key = (SelectionKey) iter.next();
				if(key.isWritable()){
					sendBuffer.clear();
					sendBuffer.put(name.getBytes());
					sendBuffer.flip();
					client.write(sendBuffer);
					client.register(selector, SelectionKey.OP_READ);

				}else if(key.isReadable()){
					receiveBuffer.clear();
					int len=client.read(receiveBuffer);
					if(len>0){
						receiveBuffer.flip();
						slflog.info("获取到服务器返回的消息"+new String(receiveBuffer.array(),0,len));
						client.register(selector, SelectionKey.OP_WRITE);
						unfinesh=false;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		new NIOClient(8085).session();
	}

}
