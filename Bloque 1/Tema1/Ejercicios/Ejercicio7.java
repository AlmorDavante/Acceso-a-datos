import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la posición inicial a consultar (ej. 5): ");
        int posicionInicial = scanner.nextInt();

        System.out.print("Introduce la cantidad de asientos a consultar (ej. 5): ");
        int cantidad = scanner.nextInt();

        try (RandomAccessFile raf = new RandomAccessFile("asientos.txt", "r")) {
            
            raf.seek(posicionInicial);
            
            byte[] buffer = new byte[cantidad];
            
            int bytesLeidos = raf.read(buffer, 0, cantidad);
            
            if (bytesLeidos > 0) {
                System.out.println("\nEstado de los asientos:");
                for (int i = 0; i < bytesLeidos; i++) {
                    char estado = (char) buffer[i];
                    System.out.println("Asiento " + (posicionInicial + i) + ": " + estado);
                }
            } else {
                System.out.println("No se ha podido leer ningún asiento (fin del fichero alcanzado).");
            }

        } catch (IOException e) {
            
            System.err.println("Error al acceder o leer el archivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
