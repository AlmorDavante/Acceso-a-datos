import java.io.FileReader;
import java.io.FileWriter;

public class Ejemplo4 {
    public static void main(String[] args) {
        FileReader lector;
        try {
            lector = new FileReader("./Tema1/prueba.txt");
            int data;
            FileWriter fw = new FileWriter("./tema1/escritura.txt");
            
            while ((data = lector.read()) >= 0) {
                fw.write((char)data);
            }
            System.out.println("Texto copiado perfectamente");
            lector.close();
            fw.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
