/*
Modifica el archivo XML ‘librería.xml’ añadiendo a cada libro una etiqueta <editorial>. 
Al usuario se le dirá el título del libro y él introducirá el nombre de la editorial. Guarda el archivo 
con el nombre ‘libreriaConEditorial.xml’ 

Fecha:09/05/2021
Alumno: Rafael Chamorro Maceiras
 */
package rcmt17;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author rchamac
 */
public class RCMt17e12 {

    static final float CM_PULG = 2.54f;
    static Scanner teclado;
    public static void main(String[] args) {
        teclado = new Scanner(System.in);

        File file = new File("Archivos" + File.separator + "libreria.xml");
        try ( FileInputStream fis = new FileInputStream(file);  InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = factory.newDocumentBuilder();
            Document doc = dB.parse(new InputSource(isr));


            NodeList lista = doc.getElementsByTagName("libro");
            for (int i = 0; i < lista.getLength(); i++) {
                Element libro = (Element) lista.item(i);
                Element editorial = doc.createElement("editorial");
                
                String titulo = libro.getElementsByTagName("titulo").item(0).getTextContent();
                System.out.println("Introduce editorial para el libro \""+titulo+"\"");
                String e = teclado.nextLine();
                
                editorial.appendChild(doc.createTextNode(e));
                libro.appendChild(editorial);
                

          }

            //Guardamos el archivo.
            File ficheroSalida = new File("Archivos" + File.separator + "libreriaConEditorial.xml");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(ficheroSalida));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
