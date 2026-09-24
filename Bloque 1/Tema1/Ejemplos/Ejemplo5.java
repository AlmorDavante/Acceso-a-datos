import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejemplo5 {
    public static void main(String[] args) {
        try {
            FileInputStream foto = new FileInputStream("./Tema1/Ejemplos/foto.png");
            int data;
            FileOutputStream foto1 = new FileOutputStream("./Tema1/Ejemplos/foto1.png");
            int num = 0;
            while ((data = foto.read()) != -1) {
                num++;
                foto1.write(data);
            }
            System.out.println(num);
            System.out.println("Imagen copiada perfesto");
            foto.close();
            foto1.close();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
}
