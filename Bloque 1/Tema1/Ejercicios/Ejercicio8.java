import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MENÚ ===");
        System.out.println("1. Guardar");
        System.out.println("2. Imprimir");
        System.out.print("Elige una opción: ");
        
        int opcion = 0;
        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente
        } else {
            System.out.println("Error: Debes introducir un número.");
            return;
        }

        if (opcion == 1) {
            guardarDatos(scanner);
        } else if (opcion == 2) {
            imprimirDatos();
        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }

    private static void guardarDatos(Scanner scanner) {
        System.out.print("Nombre y Apellidos: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Fecha de Nacimiento: ");
        String fecha = scanner.nextLine();
        
        System.out.print("Género (Masculino / Femenino): ");
        String genero = scanner.nextLine();
        
        System.out.print("Titulación de Acceso (FP Grado Medio / FP Grado Superior / Bachillerato): ");
        String titulacion = scanner.nextLine();
        
        System.out.print("Observaciones: ");
        String observaciones = scanner.nextLine();

        // Construir el String con el formato exacto requerido
        String formulario = "----- Formulario de Matriculación -----\n" +
                            "Nombre y Apellidos: " + nombre + "\n" +
                            "Email: " + email + "\n" +
                            "Fecha de Nacimiento: " + fecha + "\n" +
                            "Género: " + genero + "\n" +
                            "Titulación de Acceso: " + titulacion + "\n" +
                            "Observaciones:\n" +
                            observaciones + "\n" +
                            "---------------------------------------\n";

        // Escribir en el archivo
        try (FileWriter fw = new FileWriter("matricula.txt")) {
            fw.write(formulario);
            System.out.println("\nDatos guardados correctamente en 'matricula.txt'.");
        } catch (IOException e) {
            System.out.println("\nError al escribir en el archivo: " + e.getMessage());
        }
    }

    private static void imprimirDatos() {
        System.out.println("\nLeyendo el contenido de 'matricula.txt'...\n");
        
        // Leer el archivo carácter a carácter
        try (FileReader fr = new FileReader("matricula.txt")) {
            int caracter;
            while ((caracter = fr.read()) != -1) {
                System.out.print((char) caracter);
            }
            System.out.println(); // Salto de línea al final
        } catch (IOException e) {
            System.out.println("Error al leer el archivo. Es posible que aún no exista o no tengas permisos.");
            System.out.println("Detalle del error: " + e.getMessage());
        }
    }
}
