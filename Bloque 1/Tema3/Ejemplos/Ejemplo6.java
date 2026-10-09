package Ejemplos;
//Exception unchecked ('NullPointerException')
public class Ejemplo6 {
    public static void main(String[] args) {
            try {
            String texto = null;
            int longitud = texto.length();
            System.out.println(longitud);

        } catch (Exception e) {
            System.out.println("Excepcion controlada: " + e.getMessage());
            e.printStackTrace();
        } 
    }
}