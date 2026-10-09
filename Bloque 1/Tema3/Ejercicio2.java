import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(".\\futbol.xml");
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            NodeList teamList = root.getElementsByTagName("equipos");

            int totalPlayers = 0;

            for (int i = 0; i < teamList.getLength(); i++) {
                Element teamElement = (Element) teamList.item(i);
                String teamName = teamElement.getAttribute("location");
                System.out.println("Equipo: " + teamName);

                NodeList playerList = teamElement.getElementsByTagName("jugador");
                totalPlayers += playerList.getLength();

                for (int j = 0; j < playerList.getLength(); j++) {
                    Element playerElement = (Element) playerList.item(j);
                    String playerName = playerElement.getElementsByTagName("nombreJu").item(0).getTextContent();
                    String playerPosition = playerElement.getElementsByTagName("posicion").item(0).getTextContent();
                    String playerNumber = playerElement.getElementsByTagName("dorsal").item(0).getTextContent();
                    System.out.println(" - Jugador: " + playerName + " (" + playerPosition + ", Número: " + playerNumber + ")");
                }
                System.out.println("Total de jugadores en el equipo: " + playerList.getLength());
                System.out.println();
            }

            System.out.println("Total de jugadores en todos los equipos: " + totalPlayers);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
