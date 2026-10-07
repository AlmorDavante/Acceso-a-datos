import java.io.StreamTokenizer;
import java.io.FileReader;

public class Ejemplo1 {
    public static void main(String[] args) {
        try{
        StreamTokenizer streamTokenizer = new StreamTokenizer(new FileReader("./Tema2/Ejemplos/archivo.txt"));
        streamTokenizer.eolIsSignificant(true); // habilitar el reconocimiento de fin de línea

        int contadorPalabras = 0;
        int contadorNumeros = 0;

        while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                contadorPalabras++;
                System.out.println("Palabra: " + streamTokenizer.sval); // token de tipo palabra
            } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                contadorNumeros++;
                System.out.println("Número: " + streamTokenizer.nval); // token de tipo número
            } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                System.out.println("Fin de línea"); // fin de línea
            }
        }
        System.out.println("Total de palabras: " + contadorPalabras);
        System.out.println("Total de números: " + contadorNumeros);
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
 