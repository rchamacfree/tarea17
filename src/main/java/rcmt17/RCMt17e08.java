/*
Diseña una clase llamada Libro, que sea capaz de mantener para un libro su ISBN, nombre, 
precio y autores. Crea un programa que cargue en un ArrayList de ‘Libro’ la información 
correspondiente que viene en el archivo ‘libreria.xml’. A continuación, ordenará el ArrayList por 
título de libro y mostrará por pantalla el contenido completo de ese ArrayList. 

Fecha: 07/05/2021
Alumno: Rafael Chamorro Maceiras

 */
package rcmt17;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
public class RCMt17e08 {

    static ArrayList<Libro>listalibros;
    static ArrayList<String>listautores;
    public static void main(String[] args) {
        listalibros = new ArrayList<>();

        File file = new File("Archivos"+File.separator+"libreria.xml");
        try ( FileInputStream fis = new FileInputStream(file);  InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = factory.newDocumentBuilder();
            Document doc = dB.parse(new InputSource(isr));
            
            
            
            NodeList lista = doc.getElementsByTagName("libro");
            
            
            for (int i = 0; i<lista.getLength();i++){
                
                Element elemento = (Element) lista.item(i);
                String titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();
                String ISBN = elemento.getElementsByTagName("isbn").item(0).getTextContent();
                String precio = elemento.getElementsByTagName("precio").item(0).getTextContent();
               
                
                //lista de autores:
                NodeList aut = elemento.getElementsByTagName("autores");
                listautores = new ArrayList<>(); //instanciamos el ArrayList listautores
                for(int j = 0; j < aut.getLength();j++){
                    String a = aut.item(j).getTextContent();
                    listautores.add(a);
                }
                
                //Añadimoos el libro al ArrayList listalibros
                listalibros.add(new Libro(ISBN,titulo,precio,listautores));
                
            }//fin bucle for i

            ComparaNombre compNombre = new ComparaNombre();
            Collections.sort(listalibros,compNombre);
            
            for (Libro x: listalibros) System.out.println(x);

            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
