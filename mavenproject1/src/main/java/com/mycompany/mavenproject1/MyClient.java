/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author kalsym
 */
public class MyClient {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 8081);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String message = dis.readLine();
            System.out.print(message);
            dis.close();
            s.close();
        } catch (IOException e) {
            System.out.print(e);
        }

    }
}
