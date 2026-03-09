import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

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