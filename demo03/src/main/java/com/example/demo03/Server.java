package com.example.demo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server extends Thread {
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {

        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("等待远程连接, 端口号为: " + serverSocket.getLocalPort() + "....");
                Socket server = serverSocket.accept();
                System.out.println("远程主机地址: " + server.getRemoteSocketAddress());
                DataInputStream dataInputStream = new DataInputStream(server.getInputStream());
                System.out.println(dataInputStream.readUTF());
                DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream());
                dataOutputStream.writeUTF("谢谢连接我: " + server.getRemoteSocketAddress() + "\nGoodbye!");
                server.close();

            } catch (SocketTimeoutException e) {
                System.out.println("Socket timed out");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread server = new Server(port);
            server.run();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
