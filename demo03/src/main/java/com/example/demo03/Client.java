package com.example.demo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            String serverName = args[0];
            int port = Integer.parseInt(args[1]);
            System.out.println("连接到主机: " + serverName + ", 端口号: " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址: " + client.getRemoteSocketAddress());
            OutputStream outputStream = client.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            dataOutputStream.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inputStream = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println("服务器响应: " + dataInputStream.readUTF());
            client.close();

        } catch (Exception e) {
            System.out.println("你遇到了一个错误");
        }

    }
}
