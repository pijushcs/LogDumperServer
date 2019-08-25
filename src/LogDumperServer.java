import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LogDumperServer {
    public static void main(String[] args) throws IOException {
        int port = 5000;
        if(args.length==1) port = Integer.parseInt(args[0]);

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Started Simple Dumper Server");

        while (true)
        {
            Socket clientSocket = null;
            try
            {
                clientSocket = serverSocket.accept();  // Accept new clients
                DataInputStream socketDataInputStream = new DataInputStream(clientSocket.getInputStream());

                // Start client handler on a new thread
                Thread t = new LogDumperClientCon(clientSocket, socketDataInputStream);
                t.start();

            }
            catch (Exception e){
                serverSocket.close(); // Close server on error!
                e.printStackTrace();
                return;
            }
        }
    }
}
