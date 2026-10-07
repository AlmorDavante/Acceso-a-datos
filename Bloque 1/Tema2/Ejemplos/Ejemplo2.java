import java.io.StreamTokenizer;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StringReader;

public class Ejemplo2 {
    public static void main(String[] args) {
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("./Tema2/Ejemplos/archivo.txt"));
            String linea;

            // Leemos línea por línea para capturar y poder imprimir el texto exacto
            while ((linea = lineNumberReader.readLine()) != null) {
                
                // Creamos un StreamTokenizer exclusivo para analizar la línea capturada
                StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(linea));
                int contadorPalabras = 0;
                int contadorNumeros = 0;

                // Contamos palabras y números de esta línea específica
                while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                    if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                        contadorPalabras++;
                    } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                        contadorNumeros++;
                    }
                }

                // Imprimimos el resultado exacto tal y como pide la consola
                System.out.println("------------- Línea nº" + lineNumberReader.getLineNumber() + " -------------");
                System.out.println(linea);
                System.out.println("- Palabras: " + contadorPalabras + ", Números: " + contadorNumeros);
                System.out.println();
            }
            
            lineNumberReader.close(); // Buena práctica: cerrar el archivo al terminar

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}