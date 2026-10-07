package Tema2.Ejercicios;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        // Usamos try-with-resources para asegurar el cierre de Scanner y LineNumberReader
        try (Scanner scanner = new Scanner(System.in);
             LineNumberReader lnr = new LineNumberReader(new FileReader("./Tema2/Ejercicios/entrada.txt"))) {
            
            System.out.print("Indica qué línea quieres leer: ");
            int lineaDeseada = scanner.nextInt();
            
            String linea;
            boolean encontrada = false;
            
            // readLine() lee la línea y automáticamente incrementa el número de línea
            while ((linea = lnr.readLine()) != null) {
                if (lnr.getLineNumber() == lineaDeseada) {
                    System.out.println("Contenido de la línea número " + lineaDeseada + ":");
                    System.out.println(linea);
                    encontrada = true;
                    break; // Salimos del bucle una vez encontrada
                }
            }
            
            if (!encontrada) {
                System.out.println("Aviso: La línea " + lineaDeseada + " no existe en el archivo.");
            }
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: Asegúrate de que 'entrada.txt' existe.");
        } catch (Exception e) {
            System.out.println("Error de entrada: Por favor, introduce un número válido.");
        }
    }
}
