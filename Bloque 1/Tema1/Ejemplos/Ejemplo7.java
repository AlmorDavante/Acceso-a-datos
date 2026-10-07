import java.io.RandomAccessFile;

public class Ejemplo7 {
    
    public static void main(String[] args) {
        
        try{
            RandomAccessFile file = new RandomAccessFile("abecedario.txt", "rw");

            file.seek(5);
            byte[] arraybytes = new byte[3];
            file.read(arraybytes, 0, 3);

            System.out.println("Bytes leidos: " + arraybytes.length);
            System.out.println("Puntero despues de read: " + file.getFilePointer());


            for (int i = 0; i < arraybytes.length; i++) {

                System.out.println("\n arraybytes[" + i + "] = " + arraybytes[i] + " -> '" + (char) arraybytes[i] + "'");
            }

        } catch(Exception e){

        }
    }
}
