import java.io.File;

public class Ejemplo1 {
    public static void main(String[] args) {
        
    try {
        File fichero = new File(".\\tema1\\Ejemplos\\crearFichero.txt");
        if (fichero.createNewFile()) {
            System.out.println("Fichero creado: " + fichero.getName());
        } else {
            System.out.println("El fichero ya existe.");
        }
    } catch (Exception e) {
        System.out.println("Sa rompio: " + e.getMessage());
    }
        
    }
}
