package com.csz.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BIOServer {
    Logger slflog = LoggerFactory.getLogger(BIOServer.class);

    private ServerSocket server;

    public BIOServer(int port) {
        try {
            server = new ServerSocket(port);
            slflog.info("服务器准备好了,等待客户端连接" + port);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * 监听请求
     */
    public void listener() throws IOException {
        while (true) {
            Socket socket = server.accept();
            InputStream in = socket.getInputStream();
/*            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            String info = null;
            while ((info = br.readLine())!=null) {
                System.out.println("我是服务器，客户端说：" + info);
            }*/
            byte[] buff=new byte[128];
            int len=in.read(buff);
            if(len>0){
                String s=new String(buff,0,len);
                slflog.info("来自客户的请求"+s);

            }
        }
    }

}
