public class Main {

    public static void main(String[] args) {
        // 1.Create a server socket and bind it to a specific port number
        // 2.Listen for a connection and accept it. Client socket is created
        //3.Read Client data  via InputStream obtained from the client socket
        //4.Send data to the client via the OutputStream
        //5.Close the connection with the client

        //   ServerSocket(int port);
        //   ServerSocket(int port,int n);
        //   ServerSocket(int port,int n,InetAddress addr);
        //ServerSocket serverSocket = new ServerSocket(5555)
        //Socket socket = serverSocket.accept()
        // InputStream input =socket.getInputStream()
        //  OutputStream output = socket.getOutputStream()
        //  socket.close()
        //serverSocket.close()

        //while (true){
        // Server socket =serverSocket.accept()}
        //read data
        // send data

        //1.implement a server (and client) that returns the current date time for every new client
        //2.implement server (and client) that echoes anything sent from the client in reversed form hello->olleH
        //3.Modify the 2 task to handle each socket client in a new thread


    }
}
