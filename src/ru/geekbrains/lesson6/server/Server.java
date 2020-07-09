package ru.geekbrains.lesson6.server;

import ru.geekbrains.lesson6.client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Server {
    private Vector<ClientHendler> clients;

    public Server() {

        final Server SERVER = this;


        // поток для подключения клиентов,
        // получения и отправки им назад сообщения
        new Thread(new Runnable() {

            ServerSocket serverSocket = null;
            Socket socket = null;

            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(8189);
                    System.out.println("Сервер запущен!");
                    clients = new Vector<>();

                    while (true){
                        socket = serverSocket.accept();
                        System.out.println("Клиент подключился " + socket.toString());
                        clients.add(new ClientHendler(SERVER, socket));
                    }

                } catch (IOException e){
                    e.printStackTrace();
                } finally {
                    try{
                        socket.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    try{
                        serverSocket.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //поток для чтения с клавиатуры
        // и отправки сообщения всем клиентам
        new Thread(new Runnable() {
            Scanner consoleIn;

            @Override
            public void run() {
                consoleIn = new Scanner(System.in);
                while(true){
                    String string = consoleIn.nextLine();
                    broadcastMsg(string);
                }
            }
        }).start();

    }

    public void broadcastMsg(String msg){

        for (ClientHendler o: clients) {
            o.sendMessage(msg);
        }
    }

    public void deleteClientWithCloseSocket(Socket socket){
        Iterator<ClientHendler> iterator = clients.iterator();
        while (iterator.hasNext()){
            ClientHendler ch = iterator.next();
            if(ch.getSocket() == socket){
                System.out.println("Клиент с сокетом"+ ch.getSocket().toString() + " будет удален ");
                iterator.remove();
            }
        }
    }

}
