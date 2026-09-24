import java.io.File;

public class Ejemplo2 {
    public static void main(String[] args) {
        File fichero0 = new File("./tema1/Ejemplos/crearFichero.txt");
        File carpeta = new File("./tema1", "backup");
        carpeta.mkdirs();

        File destino = new File("./tema1/backup/fichero_movido.txt");
        if (fichero0.renameTo(destino)) {
            System.out.println("El fichero se ha movido correctamente");
        } else{
            System.out.println("El fichero no se ha podido mover");
        }
    }
}
