import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejemplo3 {
    public static void main(String[] args) {
        try{
            DataOutputStream dps = new DataOutputStream(new FileOutputStream(".\\salida.txt"));
            dps.writeInt(123);
            dps.writeInt(987);
            dps.writeFloat(123.45F);
            dps.writeLong(278937879);
            dps.writeDouble(9.3);
            dps.close();

            DataInputStream dis = new DataInputStream(new FileInputStream(".\\salida.txt"));
            int entero1 = dis.readInt();
            int entero2 = dis.readInt();
            float numerofloat = dis.readFloat();
            long numerolong = dis.readLong();
            double numerodouble = dis.readDouble();

            dis.close();

            System.out.println("El numero entero es " + entero1 + " y " + entero2);
            System.out.println("El numero float es " + numerofloat);
            System.out.println("El numero long es " + numerolong);
            System.out.println("El numero double es " + numerodouble);
        } catch (Exception e){
            
        }
    }
}
