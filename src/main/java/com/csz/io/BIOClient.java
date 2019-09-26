package com.csz.io;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class BIOClient {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket client = new Socket("localhost", 8081);
        OutputStream os = client.getOutputStream();
        os.write("报到".getBytes());
        os.close();
        client.close();
    }

    public static void send(String ip, int port) {
//1、创建客户端Socket，指定服务器地址和端口
        Socket socket = null;
        try {
            socket = new Socket(ip, port);
            OutputStream os = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流
//2、获取输出流，向服务器端发送信息
/*
            socket.shutdownOutput();
*/
            pw.write("用户名：admin；密码：123");
           // pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
