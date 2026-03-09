import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


/**
 * CLASSE CLIENTE
 * * Aquesta classe representa el costat del client en l'arquitectura socket.
 * S'encarrega d'establir una connexió amb l'adreça IP del servidor (127.0.0.1)
 * i el port acordat (5000).
 * La seva funció és enviar una petició de dades al servidor i esperar una resposta.
 * En una arquitectura multiclient, podem executar moltes instàncies d'aquesta
 * classe alhora per verificar que el servidor les gestiona totes en paral·lel.
 */
public class Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 5000);
            System.out.println("Conectando servidor multicliente...");

            // SORTIDA DE DADES
            PrintStream salida = new PrintStream(socket.getOutputStream(), true);
            salida.println("Cliente conectado");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String respuesta = entrada.readLine();

            System.out.println("Respuesta: " + respuesta);

            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}