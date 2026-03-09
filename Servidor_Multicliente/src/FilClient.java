import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * CLASSE FILCLIENT (Manejador de Clients)
 * * Aquesta classe estén de la classe 'Thread' de Java, permetent l'execució en paral·lel.
 * Cada vegada que un client es connecta, es crea una instància d'aquesta classe.
 * La seva responsabilitat és gestionar el flux d'entrada i sortida de dades
 * (BufferedReader i PrintWriter) de forma aïllada.
 * D'aquesta manera, si un client triga a respondre o té una connexió lenta,
 * no afecta el rendiment ni la disponibilitat dels altres clients connectats.
 */
public class FilClient extends Thread {
    private Socket socket;

    public FilClient(Socket socket) {
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