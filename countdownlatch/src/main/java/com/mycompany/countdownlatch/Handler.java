/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.countdownlatch;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author kalsym
 */
public class Handler implements Runnable {

    Socket socket;
    CountDownLatch cdl;

    public Handler(Socket socket, CountDownLatch cdl) {
        this.socket = socket;
        this.cdl = cdl;
    }

    @Override
    public void run() {

        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.println(dis.readUTF());
            Thread.sleep(5000);
            cdl.countDown();
            dos.writeUTF("I am ALIVE");
            System.out.println("RESPONSE SENT");
            dos.close();
        } catch (Exception e) {
        }

    }
}
