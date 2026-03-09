import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class FilServidor extends Thread {
    private Socket socket;

    public FilServidor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // ENTRADA DE DADES
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = entrada.readLine();
            System.out.println("Cliente dice: " + mensaje);

            // SORTIDA DE DADES
            PrintStream salida = new PrintStream(socket.getOutputStream(), true);
            salida.println(mensaje);


            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}