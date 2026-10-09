import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(".\\fichero.xml");
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            NodeList libraryList = root.getElementsByTagName("library");

            for (int i = 0; i < libraryList.getLength(); i++) {
                Element libraryElement = (Element) libraryList.item(i);
                String libraryName = libraryElement.getElementsByTagName("name").item(0).getTextContent();
                String libraryLocation = libraryElement.getAttribute("location");
                System.out.println("Biblioteca: " + libraryName + " (" + libraryLocation + ")");

                NodeList bookList = libraryElement.getElementsByTagName("book");
                for (int j = 0; j < bookList.getLength(); j++) {
                    Element bookElement = (Element) bookList.item(j);
                    String bookTitle = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    String bookAuthor = bookElement.getElementsByTagName("author").item(0).getTextContent();
                    String bookYear = bookElement.getElementsByTagName("year").item(0).getTextContent();
                    System.out.println(" - " + bookTitle + " (" + bookAuthor + ", " + bookYear + ")");
                }
                System.out.println("Total de libros: " + bookList.getLength());
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
