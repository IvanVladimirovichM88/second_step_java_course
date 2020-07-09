package ru.geekbrains.lesson6.client;

import jdk.internal.org.objectweb.asm.commons.JSRInlinerAdapter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    final String IP_ADDRESS = "localhost";
    final int PORT = 8189;

    Scanner consoleIn;

    public Client() {
        try {
            socket = new Socket(IP_ADDRESS,PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            // поток для получения сообщений
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        while(true){
                            String string = in.readUTF();
                            if ( string.equals("Server Close") ){
                                break;
                            }
                            System.out.println("echo server > " + string);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            // поток для чтения сообщения с консоли
            // и отправки его на сервер
            new Thread(new Runnable() {
                @Override
                public void run() {
                    consoleIn = new Scanner(System.in);
                    while(true){
                        String string = consoleIn.nextLine();
                        try {
                            out.writeUTF(string);
                            if (string.equals("/end")){
                                break;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }).start();

        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
