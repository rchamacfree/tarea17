/*
Realiza un programa que muestre el nombre de todos los libros y su autor o autores. 
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
public class RCMt17e06 {

    public static void main(String[] args) {

        File file = new File("Archivos"+File.separator+"libreria.xml");
        try ( FileInputStream fis = new FileInputStream(file);  InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = factory.newDocumentBuilder();
            Document doc = dB.parse(new InputSource(isr));
            
            
            
            NodeList lista = doc.getElementsByTagName("libro");
            String titulo;
            float pvp;
            
            
            for (int i = 0; i<lista.getLength();i++){
                Element elemento = (Element) lista.item(i);
               
                titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();
                System.out.println("Titulo: "+titulo);
                System.out.println("Autores:");
                
                NodeList autores = elemento.getElementsByTagName("autor");
                for (int j = 0; j < autores.getLength();j++){
                    String autor = autores.item(j).getTextContent();
                    System.out.printf("\t %s~%n",autor);
                }
                System.out.println("");
                
                

            }//fin bucle for i
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
