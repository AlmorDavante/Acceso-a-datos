package Ejercicios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio5 {
    public static void main(String[] args) {
        try {
            long empezar = System.currentTimeMillis();
            FileInputStream foto = new java.io.FileInputStream("foto.jpg");
            FileOutputStream foto1 = new java.io.FileOutputStream("foto_copia_sin_buffer.jpg");
            int data;
            while ((data = foto.read()) != -1) {
                foto1.write(data);
            }
            long acabar = System.currentTimeMillis();
            long durationWithoutBuffer = acabar - empezar;
            System.out.println("Tiempo de copia sin buffer: " + durationWithoutBuffer + " ms");
            foto.close();
            foto1.close();

            empezar = System.currentTimeMillis();
            BufferedInputStream bufferedFoto = new java.io.BufferedInputStream(new java.io.FileInputStream("foto.jpg"));
            BufferedOutputStream bufferedFoto1 = new java.io.BufferedOutputStream(new java.io.FileOutputStream("foto_copia_con_buffer.jpg"));
            byte[] buffer = new byte[4096];
            int bytesLeidos;
            while ((bytesLeidos = bufferedFoto.read(buffer)) != -1) {
                bufferedFoto1.write(buffer, 0, bytesLeidos);
            }
            acabar = System.currentTimeMillis();
            long durationWithBuffer = acabar - empezar;
            System.out.println("Tiempo de copia con buffer: " + durationWithBuffer + " ms");
            bufferedFoto.close();
            bufferedFoto1.close();

        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }catch (Exception e) {
            System.out.println("El fichero origen no existe: " + e.getMessage());
        }
    }
}
