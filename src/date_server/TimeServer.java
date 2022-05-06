package date_server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TimeServer {

    public static void main(String[] args) {
        int port =6666;

        try (ServerSocket serverSocket=new ServerSocket(port)){
            System.out.println("Server is listening on port "+port);

            while (true){
                Socket socket =serverSocket.accept();
                System.out.println("new client connected");

                OutputStream output =socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output,true);

                writer.println(LocalDateTime.now().toString());
            }


        } catch (IOException e){
            System.out.println("Server exception "+e.getMessage());
            e.printStackTrace();
        }
    }
}
