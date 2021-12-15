/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.multithreaded;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author kalsym
 */
public class Handler implements Runnable {

    Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeBytes("I am ALIVE");
            dos.close();
        } catch (Exception e) {
        }

    }
}
