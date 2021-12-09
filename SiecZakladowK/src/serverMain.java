import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serverMain {
    public static void main(String [] args)
    {
        ArrayList<ServerThread> threadList=new ArrayList<>();
        try(ServerSocket serversocket=new ServerSocket(7777)){
            while (true)
            {
                Socket socket=serversocket.accept();
                ServerThread serverThread=new ServerThread(socket,threadList);
                threadList.add(serverThread);
                serverThread.run();
            }

        }catch (Exception e){
            System.out.println("Error Main" +e.getStackTrace());
        }
    }
}
