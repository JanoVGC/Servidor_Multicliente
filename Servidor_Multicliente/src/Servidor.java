import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor esperando conexión...");

            while (true) {
                Socket socket = servidor.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());


                // CADA CLIENT S'EXECUTA EN UNA CLASSE DIFERENT SEMPRE QUE S'EXECUTA EL METODE RUN
                FilClient fil = new FilClient(socket);
                fil.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



