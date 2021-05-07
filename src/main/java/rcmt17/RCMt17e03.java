/*
Realiza un programa que muestre el título de todos los libros presentes en ‘librería.xml’ con 
su precio. (Todos los libros tienen precio).
Fecha: 07/05/2021
Alumno: Rafael Chamorro Maceiras

 */
package rcmt17;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author rchamac
 */
public class RCMt17e03 {

    public static void main(String[] args) {

        File file = new File("Archivos"+File.separator+"libreria.xml");
        try ( FileInputStream fis = new FileInputStream(file);  InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = factory.newDocumentBuilder();
            Document doc = dB.parse(new InputSource(isr));
            
            
            
            NodeList lista = doc.getElementsByTagName("libro");
            
            for (int i = 0; i<lista.getLength();i++){
                Element elemento = (Element) lista.item(i);
                String titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();
                String precio = elemento.getElementsByTagName("precio").item(0).getTextContent();
                System.out.printf("%s: %s€ %n",titulo,precio);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
