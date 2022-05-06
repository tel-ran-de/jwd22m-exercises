package date_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {
    public static void main(String[] args) {
        String hostName ="localhost";
        int port=6666;

        try(Socket socket= new Socket(hostName,port)){
            InputStream input =socket.getInputStream();
            BufferedReader reader= new BufferedReader(new InputStreamReader(input));

            String date = reader.readLine();
            System.out.println(date);

        }catch (UnknownHostException e){
            System.out.println("Server not found "+e.getMessage());
        }catch (IOException e){
            System.out.println("I/O error: "+e.getMessage());
        }
    }
}
