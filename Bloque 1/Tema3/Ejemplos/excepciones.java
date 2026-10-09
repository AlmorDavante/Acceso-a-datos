package Ejemplos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class excepciones {
    public static void main(String[] args) {
            try {
                FileReader file = new FileReader("./Ejemplos/archivo.txt");
                int data;
                while((data= file.read()) != -1){
                    System.out.println((char)data);
                }
                file.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                System.out.println("Error FileNotFoundException " + e.getMessage()); 
            } catch (IOException e){
                e.printStackTrace();
            } finally{
                System.out.println("Esto se ejecuta siempre");
            }
    }
}
