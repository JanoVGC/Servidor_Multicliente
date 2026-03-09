import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * CLASSE SERVIDOR
 * * Aquesta classe actua com a node central del sistema.
 * Implementa un bucle infinit per escoltar el port 5000 de manera constant.
 * La seva funció principal és acceptar connexions de nous clients i,
 * en lloc de gestionar la comunicació directament (el que bloquejaria el servidor),
 * delega cada connexió a un fil independent (FilServidor).
 * Això permet que el servidor sigui MULTICLIENT i pugui atendre
 * diverses peticions simultàniament.
 */
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



