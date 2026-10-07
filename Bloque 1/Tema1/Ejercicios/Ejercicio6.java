package Ejercicios;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.lang.StringBuilder;


public class Ejercicio6 {
    public static void main(String[] args) {
        try {
            RandomAccessFile asientos = new RandomAccessFile("./asientos.txt", "rw");
            System.out.print("Introduce el número de asiento que quieres comprar (0-19): ");
            int asiento = new Scanner(System.in).nextInt();

            if (asiento < 0 || asiento > 19) {
                System.out.println("Ese asiento no existe/no está disponible.");
            } else {
                asientos.seek(asiento);
                char estado = (char) asientos.readByte();
                if (estado == 'C') {
                    System.out.println("Ese asiento ya está ocupado.");
                } else {
                    asientos.seek(asiento);
                    asientos.writeByte('C');
                    System.out.println("Asiento " + asiento + " comprado correctamente.");
                }
            }

            // Mostrar el estado actual de los asientos
            asientos.seek(0);
            StringBuilder estadoAsientos = new StringBuilder();
            for (int i = 0; i < 20; i++) {
                estadoAsientos.append((char) asientos.readByte());
            }
            System.out.println("Estado actual de los asientos: " + estadoAsientos.toString());
        
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
