/*
Modifica el archivo XML ‘librería.xml’ eliminando las etiquetas ‘isbn’, ‘dimensiones’, 
‘tematica’ y ‘precio’. Guárdalo con el nombre ‘libreriaResumen.xml’.

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
public class RCMt17e13 {

    public static void main(String[] args) {

        File file = new File("Archivos" + File.separator + "libreria.xml");
        try ( FileInputStream fis = new FileInputStream(file);  InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = factory.newDocumentBuilder();
            Document doc = dB.parse(new InputSource(isr));


            NodeList lista = doc.getElementsByTagName("libro");
            for (int i = 0; i < lista.getLength(); i++) {
                Element libro = (Element) lista.item(i);
                
                Element isbn;
                if (libro.getElementsByTagName("isbn").item(0) != null){
                                isbn = (Element) libro.getElementsByTagName("isbn").item(0);
                                libro.removeChild(isbn);
                }
                
                Element dimensiones;
                if (libro.getElementsByTagName("dimensiones").item(0) != null){
                                dimensiones = (Element) libro.getElementsByTagName("dimensiones").item(0);
                                libro.removeChild(dimensiones);
                }
                                
                Element tematica;
                if (libro.getElementsByTagName("tematica").item(0) != null){
                                tematica = (Element) libro.getElementsByTagName("tematica").item(0);
                                libro.removeChild(tematica);
                }
                
                              
               Element precio;
               if (libro.getElementsByTagName("precio").item(0) != null){
                                precio = (Element) libro.getElementsByTagName("precio").item(0);
                                libro.removeChild(precio);
                }
             
                
                
                
           }

            //Guardamos el archivo.
            File ficheroSalida = new File("Archivos" + File.separator + "libreriaResumen.xml");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(ficheroSalida));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
