package Ejercicios;

import java.io.RandomAccessFile;

public class Ejercicio3 {
    public static void main(String[] args) {
        try{
            RandomAccessFile fichero = new RandomAccessFile("abecedario.txt", "rw");
            fichero.seek(5);
            System.out.println("Puntero ANTES de leer: " + fichero.getFilePointer()); //escribira 5
            int unbyte = fichero.read();
            System.out.println("Puntero DESPUES de leer: " + fichero.getFilePointer()); //escribira 6
            System.out.println((char)unbyte);
            fichero.write('0');
            System.out.println("Puntero DESPUES de escribir: " + fichero.getFilePointer()); //escribira 7
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
