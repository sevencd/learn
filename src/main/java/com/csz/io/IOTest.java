package com.csz.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IOTest {
    Logger log = Logger.getLogger(IOTest.class);

    /*@Before
    public void before(){
        log.info("**************before*****************");
    }
    @After
    public void after(){
        log.info("***************after****************");
    }*/
    @Test
    public void BIOServer() throws IOException {
        new BIOServer(8084).listener();
    }

    @Test
    public void BIOClient() throws IOException {
        //BIOClient.send("localhost",8084);
        {
//1、创建客户端Socket，指定服务器地址和端口
            Socket socket = null;
            try {
                socket = new Socket("localhost", 8084);
                OutputStream os = socket.getOutputStream();//字节输出流
                PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流
//2、获取输出流，向服务器端发送信息
/*
            socket.shutdownOutput();
*/
                pw.write("用户名：admin；密码：123");
                log.info("客户端发送信息    用户名：admin；密码：123");
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
