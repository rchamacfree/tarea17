/*
Modifica el archivo XML ‘librería.xml’ pasando el precio a dólares (1 dólar= 0,91eur). 
Guárdalo con el nombre ‘libreriaDolar.xml’

Fecha:09/05/2021
Alumno: Rafael Chamorro Maceiras
 */
package rcmt17;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author rchamac
 */
public class RCMt17e10 {

    static final float CAMBIO = 0.91f;

    public static void main(String[] args) {

        File file = new File("Archivos" + File.separator + "libreria.xml");
        try ( FileInputStream fis = new FileInputStream(file);  InputStreamReader isr = new InputStreamReader(fis, "UTF-8")) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = factory.newDocumentBuilder();
            Document doc = dB.parse(new InputSource(isr));

            NodeList lista = doc.getElementsByTagName("precio");
            for (int i = 0; i < lista.getLength(); i++) {
                Node nodo = lista.item(i);
               // System.out.println("Precio euros: " + nodo.getTextContent());
                
                //obtenemos el valor de la etiqueta precio en formato float
                float euros = Float.parseFloat(nodo.getTextContent());
                //convertimos a dólares
                float dolar = euros * CAMBIO;
                //pasamos el resultado a String redondeando a 2 decimales
                String result = String.format("%.2f", Float.parseFloat(String.valueOf(dolar)));
                //establecemos el valor en la etiqueta precio
                nodo.setTextContent(result);
               // System.out.println("Precio dolar: " + nodo.getTextContent());

            }
            
            
            //Guardamos el archivo.
            File ficheroSalida = new File("Archivos" + File.separator + "libreriaDolar.xml");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(ficheroSalida));

      
        
        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
