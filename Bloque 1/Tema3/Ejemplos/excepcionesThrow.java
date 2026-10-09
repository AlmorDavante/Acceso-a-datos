package Ejemplos;

import java.io.FileReader;
import java.io.IOException;

public class excepcionesThrow {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("./Ejemplos/archivo.txt");
        int data;
        while ((data = file.read())!= -1){
            System.out.println((char)data);
        }
    }
}
