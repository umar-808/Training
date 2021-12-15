/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.independentsyncrequest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author kalsym
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8082);
            while (true) {
                Socket s = ss.accept();
                Handler handler = new Handler(s);
                Thread thread = new Thread(handler);
                thread.start();
            }

        } catch (IOException i) {
            System.out.print(i);
        }
    }
}
