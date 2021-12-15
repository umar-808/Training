/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.delayed;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author kalsym
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 8082);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Are you Alive?");
            System.out.println("Waiting for response...");
            String message = dis.readUTF();
            System.out.print(message);
            dis.close();
            s.close();
        } catch (IOException e) {
            System.out.print(e);
        }

    }
}
