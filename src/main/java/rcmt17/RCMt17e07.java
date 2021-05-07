/*
Realiza un programa que muestre el nombre de todos los libros con su alto, ancho y número 
de páginas. (Algunos puede que no tengan toda o parte de esa información, mostrar una 
interrogación en sus valores, por ejemplo: “El perfume  Dimensiones ? cm x ? cm. ? páginas)

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
public class RCMt17e07 {

    public static void main(String[] args) {

        File file = new File("Archivos"+File.separator+"libreria.xml");
        try ( FileInputStream fis = new FileInputStream(file);  InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = factory.newDocumentBuilder();
            Document doc = dB.parse(new InputSource(isr));
            
            
            
            NodeList lista = doc.getElementsByTagName("libro");
            NodeList dim = doc.getElementsByTagName("dimensiones");
            String titulo,alto,ancho,paginas;
            
            
            for (int i = 0; i<lista.getLength();i++){
                Element elemento = (Element) lista.item(i);
               
                titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();
               // System.out.println("Titulo: "+titulo);
               
                Element dimensiones = (Element) dim.item(i);
                
                if (dimensiones.hasAttribute("alto")) alto = dimensiones.getAttribute("alto");
                else alto = "?";
               
                if (dimensiones.hasAttribute("ancho")) ancho = dimensiones.getAttribute("ancho");
                else ancho = "?";
               
                if (dimensiones.hasAttribute("paginas"))  paginas = dimensiones.getAttribute("paginas");
                else paginas = "?";
                
                  
               
                System.out.printf("%s -> alto: %s ancho:%s paginas:%s%n",titulo,alto,ancho,paginas);

            }//fin bucle for i
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
