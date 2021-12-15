/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author kalsym
 */
public class MyServer {

    public static void main(String[] args) {
        String message = "I am ALIVE";
        try {
            ServerSocket ss = new ServerSocket(8081);
            while (true) {
                Socket s = ss.accept();
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeBytes(message);
                dos.close();
            }
            
        } catch (IOException i) {
            System.out.print(i);
        }
    }
}
