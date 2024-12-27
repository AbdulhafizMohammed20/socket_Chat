import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class Client_side {

  public static void main (String[] args) throws Exception {
      try (Socket socket = new Socket("localhost",5000)) {
          

  while(true){
        Scanner scanner = new Scanner(System.in); 
        String serverMessage = scanner.nextLine();
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          out.writeUTF(serverMessage);
          out.flush();

          DataInputStream is = new DataInputStream(socket.getInputStream());
          String message=is.readUTF();
          System.err.println("From Server: " + message);
         
      }
    }
   

  } 

}