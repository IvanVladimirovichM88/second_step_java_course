package ru.geekbrains.lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHendler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Server server;

    public ClientHendler(Server server, Socket socket) throws IOException {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            this.sendMessage( "клиент подключен к серверу");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String string = in.readUTF();

                            System.out.println("Клиент " + socket.toString()+ " >" + string  );

                            if (string.equals("/end")) {
                                out.writeUTF("Server Close");
                                System.out.println("Клиент отвалилися - " + socket.toString());
                                break;
                            }
                            server.broadcastMsg(string);
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }finally{
                        try{
                            in.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        try{
                            out.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //удаляем из вектора клиента с закрытым сокетом
                        server.deleteClientWithCloseSocket(socket);
                    }
                }
            }).start();


        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public void sendMessage(String msg){
        try {
            out.writeUTF(msg);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
