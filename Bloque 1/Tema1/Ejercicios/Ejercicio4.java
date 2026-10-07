package Ejercicios;

public class Ejercicio4 {
    public static void main(String[] args) {
        try {
            java.io.BufferedInputStream foto = new java.io.BufferedInputStream(
                    new java.io.FileInputStream("foto.jpg"));
            java.io.BufferedOutputStream foto1 = new java.io.BufferedOutputStream(
                    new java.io.FileOutputStream("foto_copia_buffer.jpg"));
            byte[] buffer = new byte[1024];
            int bytesRead;
            int blockNumber = 0;

            while ((bytesRead = foto.read(buffer)) != -1) {
                blockNumber++;
                foto1.write(buffer, 0, bytesRead);
                System.out.println("Fin copia bloque " + blockNumber);
            }
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Copia finalizada correctamente. Se han leído " + blockNumber + " bloques de 1024 bytes.");
            foto.close();
            foto1.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("El fichero origen no existe: " + e.getMessage());
        } catch (java.io.IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
