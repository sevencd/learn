package com.csz.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.chainsaw.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NIOServer {
	Logger slflog=LoggerFactory.getLogger(NIOServer.class);

	private ServerSocketChannel server;
	private Selector selector;
	private ByteBuffer receiveBuffer=ByteBuffer.allocate(1024);
	private ByteBuffer sendBuffer=ByteBuffer.allocate(1024);
	
	Map<SelectionKey,String> sessionMsg=new HashMap<SelectionKey,String>();

	public NIOServer(int port) {
		try {
			server=ServerSocketChannel.open();
			server.socket().bind(new InetSocketAddress(port));
			server.configureBlocking(false);
			
			selector=Selector.open();
			server.register(selector, SelectionKey.OP_ACCEPT);
			slflog.info("NIO服务器准备好了,等待客户端连接"+port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 监听请求
	 */
	public void listener() throws IOException{
		while(true){
			int i=selector.select();
			if(i==0){
				continue;
			}
			Set<SelectionKey> keys=selector.selectedKeys();
			Iterator<SelectionKey > iter=keys.iterator();
			while (iter.hasNext()) {
				SelectionKey selectionKey = (SelectionKey) iter.next();
				//轮询
				this.process(selectionKey);
				iter.remove();
			}
			
		}
	}
	private void process(SelectionKey key) throws IOException {
		// TODO Auto-generated method stub
		if(key.isAcceptable()){
			SocketChannel client=server.accept();
			client.configureBlocking(false);
			client.register(selector, SelectionKey.OP_READ);
		}else if(key.isReadable()){
			receiveBuffer.clear();
			SocketChannel client=(SocketChannel)key.channel();
			int len=client.read(receiveBuffer);
			if(len>0){
				String s=new String(receiveBuffer.array(),0,len);
				sessionMsg.put(key, s);
				slflog.info("来自客户的请求"+s);
			}
			client.register(selector,SelectionKey.OP_WRITE);
		}else if(key.isWritable()){
			if(!sessionMsg.containsKey(key)){
				return;
			}
			SocketChannel client=(SocketChannel)key.channel();
			
			sendBuffer.clear();
			sendBuffer.put(new String(sessionMsg.get(key)+",您好,您的请求已处理完成").getBytes());
			sendBuffer.flip();
			client.write(sendBuffer);
			client.register(selector,SelectionKey.OP_READ);
		}
		
	}
	public static void main(String[] args) throws IOException {
		new NIOServer(8085).listener();
	}

}
