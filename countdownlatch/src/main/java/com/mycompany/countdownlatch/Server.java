/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.countdownlatch;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kalsym
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8082);
            CountDownLatch cdl = new CountDownLatch(1);
            while (true) {
                Socket s = ss.accept();
                Handler handler = new Handler(s, cdl);
                Thread thread = new Thread(handler);
                thread.start();
                cdl.await();
            }

        } catch (IOException i) {
            System.out.print(i);
        } catch (InterruptedException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
