/*
Realiza un programa que muestre el título de todos los libros presentes en ‘librería.xml’ con 
su precio de aquellos libros que cuesten menos de 10 euros. 
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
public class RCMt17e05 {

    public static void main(String[] args) {

        File file = new File("Archivos"+File.separator+"libreria.xml");
        try ( FileInputStream fis = new FileInputStream(file);  InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = factory.newDocumentBuilder();
            Document doc = dB.parse(new InputSource(isr));
            
            
            
            NodeList lista = doc.getElementsByTagName("libro");
            String titulo, precio;
            float pvp;
            
            
            for (int i = 0; i<lista.getLength();i++){
                Element elemento = (Element) lista.item(i);
               
                precio = elemento.getElementsByTagName("precio").item(0).getTextContent();
                pvp = Float.parseFloat(precio);
                if (pvp < 10f){
                    titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();
                    System.out.println("titulo: "+titulo+ " precio: "+ pvp);
                }
                

            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
