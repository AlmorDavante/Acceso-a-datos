import java.io.File;

public class Ejemplo3 {
    public static void main(String[] args) {
        String nombreCarpeta = "Nueva Carpeta";
        File carpeta = new File("./tema1", nombreCarpeta);

        if (carpeta.exists()) {
            System.out.println("La carpeta " + nombreCarpeta + " ya existe");
        } else {
            carpeta.mkdirs();
            System.out.println("La carpeta " + carpeta.getName() + " se ha creado");
            System.out.println("Ruta absoluta " + carpeta.getAbsolutePath());
            System.out.println("Ruta relativa " + carpeta.getPath());
            System.out.println("Carpeta padre " + carpeta.getParent());
        }
    }
}
