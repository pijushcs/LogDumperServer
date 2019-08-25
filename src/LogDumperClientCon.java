import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

/**
 * Simple Client Handler
 */
public class LogDumperClientCon extends Thread {
    private DataInputStream dataInputStream;
    private Socket socket;

    public LogDumperClientCon(Socket socket, DataInputStream dataInputStream)
    {
        this.socket = socket;
        this.dataInputStream = dataInputStream;
    }

    @Override
    public void run()
    {
        String logMsg;
        while (true)
        {
            try {
                logMsg = dataInputStream.readUTF(); // read json message
                System.out.println(logMsg); // print json message
            } catch (IOException e) {
                try {
                    socket.close(); // close client socket on error!
                    dataInputStream.close();
                    break;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }
}
