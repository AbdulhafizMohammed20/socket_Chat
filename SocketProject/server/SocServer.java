
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class SocServer {

  public static void main(String[] args) throws Exception {
    ServerSocket ss=new ServerSocket(5000);
    System.out.println("Server is waiting for the client's request....");
    Socket sock=ss.accept();
    System.out.println("Connection is established successfully");
    while (true) { 
      DataInputStream is = new DataInputStream(sock.getInputStream());
      String message=is.readUTF();
      System.err.println("From client: " + message);

      
        Scanner scanner = new Scanner(System.in); 
        String serverMessage = scanner.nextLine();
          DataOutputStream out = new DataOutputStream(sock.getOutputStream());
          out.writeUTF(serverMessage);
          out.flush();
    }
    
  }
}